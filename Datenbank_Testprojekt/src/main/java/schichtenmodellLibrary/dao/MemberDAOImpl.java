package schichtenmodellLibrary.dao;

import auxilliary.DBCreatorLibrary;
import schichtenmodellLibrary.modell.Member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MemberDAOImpl implements MemberDAO {
    private final Connection connection;
    private Scanner scanner = new Scanner(System.in);

    public MemberDAOImpl() {
        this.connection = DBCreatorLibrary.getConnection();
        resetAutoIncrement(); //done with AI
        //https://g.co/gemini/share/c2bb54bd0546
    }

    @Override
    public Member createMember() {
        Member member = null;
        final String sql = "INSERT INTO members (name) VALUES (?)";

        String name = "";
        while (name.isEmpty()) {
            System.out.println("Enter the new member's name: ");
            name = scanner.nextLine();
        }

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, name);
            if (preparedStatement.executeUpdate() == 1) {
                System.out.println("Member " + name + " was successfully created");
                member = getMemberByName(name);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return member;
    }

    private Member buildMemberByResultSet(ResultSet resultSet) throws SQLException {
        int member_id = resultSet.getInt("member_id");
        String name = resultSet.getString("name");
        return new Member(member_id, name);
    }

    @Override
    public Member getmemberbyId(int id) {
        Member member = null;
        final String sql = "SELECT * FROM members WHERE member_id = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next())
                // Jump to the first entry of data set
                // If not nexted here, sub method will fail.
                // It could be done there, but then a while-loop won't work anymore, in case it will be necessary.
                member = buildMemberByResultSet(resultSet);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return member;
    }

    @Override
    public Member getMemberByName(String name) {
        Member member = null;
        final String sql = "SELECT * FROM members WHERE name = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, name);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next())
                member = buildMemberByResultSet(resultSet);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return member;
    }

    @Override
    public void renameMember(int id) {
        String tmp_name = getMembersNameBeforeChange(id);
        final String sql = "update members set name = ? where member_id = ?";

        String newName = "";
        while (newName.isEmpty()) {
            System.out.println("Enter the new name for " + tmp_name + ": ");
            newName = scanner.nextLine();
        }

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, newName);
            preparedStatement.setInt(2, id);

            int rows = preparedStatement.executeUpdate();
            if (rows == 1)
                System.out.println("Member " + tmp_name + " was successfully renamed to " + newName);
            else
                System.out.println("Renaming member failed");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteMember(int id) {
        String tmp_name = getMembersNameBeforeChange(id);
        final String sqlDelete = "DELETE FROM members WHERE member_id = ?";
        try {
            PreparedStatement psForDeletion = connection.prepareStatement(sqlDelete);
            psForDeletion.setInt(1, id);
            int rows = psForDeletion.executeUpdate();
            if (rows == 1)
                System.out.println("Member " + tmp_name + " was successfully deleted");
            else
                System.out.println("Deleting member failed");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Member> getAllMembers() {
        List<Member> members = new ArrayList<Member>();
        final String sql = "SELECT * FROM members";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                members.add(buildMemberByResultSet(resultSet));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return members;
    }

    private String getMembersNameBeforeChange(int id) {
        Member tmp_member = getmemberbyId(id);
        String tmp_name = "";
        if (tmp_member != null) //for avoiding a NullPointerException in case the id has no valid member in the database
            tmp_name = getmemberbyId(id).getMember_name();
        return tmp_name;
    }

    //if you want to know why, ask me about it or read in the link given in constructor
    private void resetAutoIncrement() {
        String setSql = "SET @sql = CONCAT('ALTER TABLE members AUTO_INCREMENT = ', (SELECT IFNULL(MAX(member_id), 0) + 1 FROM members))";
        String prepareStmt = "PREPARE stmt FROM @sql";
        String executeStmt = "EXECUTE stmt";
        String deallocateStmt = "DEALLOCATE PREPARE stmt";

        try {
            // SET @sql
            PreparedStatement setSqlStatement = connection.prepareStatement(setSql);
            setSqlStatement.executeUpdate();

            // PREPARE stmt
            PreparedStatement prepareStatement = connection.prepareStatement(prepareStmt);
            prepareStatement.executeUpdate();

            // EXECUTE stmt
            PreparedStatement executeStatement = connection.prepareStatement(executeStmt);
            executeStatement.executeUpdate();

            // DEALLOCATE PREPARE stmt
            PreparedStatement deallocateStatement = connection.prepareStatement(deallocateStmt);
            deallocateStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
