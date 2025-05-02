package _20250324Aufgaben;

import java.sql.*;

/*
DONE  1. Show how many books each member has borrowed. //what is the difference to task3 ???
DONE  2. Show all members who have not borrowed a book.
DONE  3. Count how many books each member has borrowed. //1 or 3 might be wrong, IDK
DONE  4. Show all books that were published before 1950 and were borrowed by more than one member.
DONE  5. Show all authors who have more than one book in the library.
DONE  6. Show all books that have been borrowed by more than one member.
TODO  7. Count how many books each member has borrowed after March 1, 2024.
*/

public class DatabaseConnectionLibraryExcercises {
    private static final String URL = "jdbc:mysql://localhost:3306/library";
    private static final String USER = "root";
    private static final String PASSWORD = "dominik-labocha";

    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException ex) {
            System.out.println("Verbindung konnte nicht hergestellt werden");
        }
        return null;
    }

    public static void main(String[] args) {
        one_BooksPerMember();
        two_MembersWithNoBooks();
        three_booksEachMember();
        four_booksOlder1950BorrowedMoreThanOnce();
        five_authorsWithMoreThanOneBook();
        six_BorrowedByMoreThanOneMember();
        seven_HowManyBooksEachMemberBorrowedAfter2024_05_01();
    }

    //1. Show how many books each member has borrowed.
    static void one_BooksPerMember() {
        System.out.println("\n1. Show how many books each member has borrowed:");
        final String query = """
                SELECT m.name AS Membername, COUNT(bb.book_id) AS 'count of borrowed books'
                FROM borrowedbooks bb
                JOIN members m ON m.member_id = bb.member_id
                GROUP BY bb.member_id;
                """;
        try (Connection c = getConnection()) {
            if (c != null) {
                PreparedStatement p = c.prepareStatement(query);
                ResultSet resultSet = p.executeQuery();
                System.out.println("Membername\tcount of borrowed books");
                while (resultSet.next()) {
                    System.out.print(resultSet.getString("Membername") + "\t\t");
                    System.out.print(resultSet.getString("count of borrowed books") + "\n");
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    //2. Show all members who have not borrowed a book.
    static void two_MembersWithNoBooks() {
        System.out.println("\n2. Show all members who have not borrowed a book:");
        final String query = """
                SELECT m.name AS 'Members with no books'
                FROM members m
                left JOIN borrowedbooks bb ON m.member_id = bb.member_id
                group by m.name
                having COUNT(bb.book_id) = 0;
                """;
        try (Connection c = getConnection()) {
            if (c != null) {
                PreparedStatement p = c.prepareStatement(query);
                ResultSet resultSet = p.executeQuery();
                System.out.println("Members with no books");
                while (resultSet.next()) {
                    System.out.println(resultSet.getString("Members with no books"));
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    //3. Count how many books each member has borrowed.
    static void three_booksEachMember() {
        System.out.println("\n3. Count how many books each member has borrowed");
        final String query = """
                select m.name as Membername, count(bb.book_id) as borrowed_books
                from borrowedbooks bb
                right join members m
                ON m.member_id = bb.member_id
                group by m.name;
                """;
        try (Connection c = getConnection()) {
            if (c != null) {
                PreparedStatement p = c.prepareStatement(query);
                ResultSet resultSet = p.executeQuery();
                System.out.println("Membername\tborrowed_books");
                while (resultSet.next()) {
                    System.out.print(resultSet.getString("Membername") + "\t\t");
                    System.out.print(resultSet.getString("borrowed_books") + "\n");
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    //4. Show all books that were published before 1950 and were borrowed by more than one member.
    static void four_booksOlder1950BorrowedMoreThanOnce() {
        System.out.println("\n4. Books older 1950 and borrowed more than once:");
        final String query = """
                select title as Buchtitel, count(bb.book_id) as Anzahl_Ausleihen, b.publication_year as erschienen
                from books b
                join borrowedbooks bb
                on b.book_id = bb.book_id
                where publication_year < 1950
                group by bb.book_id
                having count(bb.book_id) > 1;
                """;
        try (Connection c = getConnection()) {
            if (c != null) {
                PreparedStatement p = c.prepareStatement(query);
                ResultSet resultSet = p.executeQuery();
                System.out.println("Buchtitel\tAnzahl_Ausleihen\terschienen");
                while (resultSet.next()) {
                    System.out.print(resultSet.getString("Buchtitel") + "\t\t");
                    System.out.print(resultSet.getString("Anzahl_Ausleihen") + "\t\t");
                    System.out.print(resultSet.getString("erschienen") + "\n");
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    //5. Show all authors who have more than one book in the library.
    static void five_authorsWithMoreThanOneBook() {
        System.out.println("\n5. Show all authors who have more than one book in the library:");
        final String query = """
                select a.name as Autorenname, count(b.book_id) as Anzahl_Bücher
                from authors a
                join books b
                on b.author_id = a.author_id
                group by a.author_id
                having count(b.book_id) > 1;
                """;
        try (Connection c = getConnection()) {
            if (c != null) {
                PreparedStatement p = c.prepareStatement(query);
                ResultSet resultSet = p.executeQuery();
                System.out.println("Autorenname\tAnzahl_Bücher");
                while (resultSet.next()) {
                    System.out.print(resultSet.getString("Autorenname") + "\t\t");
                    System.out.print(resultSet.getString("Anzahl_Bücher") + "\n");
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    //6. Show all books that have been borrowed by more than one member.
    static void six_BorrowedByMoreThanOneMember() {
        System.out.println("\n6. Show all books that have been borrowed by more than one member.:");
        final String query = """
                select title as Buchtitel, count(bb.book_id) as Anzahl_Ausleihen
                from books b
                join borrowedbooks bb
                on b.book_id = bb.book_id
                group by bb.book_id
                having count(bb.book_id) > 1;
                """;
        try (Connection c = getConnection()) {
            if (c != null) {
                PreparedStatement p = c.prepareStatement(query);
                ResultSet resultSet = p.executeQuery();
                System.out.println("Buchtitel\tAnzahl_Ausleihen");
                while (resultSet.next()) {
                    System.out.print(resultSet.getString("Buchtitel") + "\t\t");
                    System.out.print(resultSet.getString("Anzahl_Ausleihen") + "\n");
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    //7. Count how many books each member has borrowed after March 1, 2024.
    static void seven_HowManyBooksEachMemberBorrowedAfter2024_05_01(){
        //still under construction
        System.out.println("\n7. Count how many books each member has borrowed after March 1, 2024.:");
        final String query = """
                select m.name as Mitglied, count(bb.book_id) as geliehene_Bücher
                from members m
                left join borrowedbooks bb
                on bb.member_id = m.member_id
                where bb.borrow_date > "2024-05-01"
                group by m.name;\s
                """;
        try (Connection c = getConnection()) {
            if (c != null) {
                PreparedStatement p = c.prepareStatement(query);
                ResultSet resultSet = p.executeQuery();
                System.out.println("Mitglied\tgeliehene_Bücher");
                while (resultSet.next()) {
                    System.out.print(resultSet.getString("Mitglied") + "\t\t");
                    System.out.print(resultSet.getString("geliehene_Bücher") + "\n");
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    static void example() {
        try (Connection c = getConnection()) {
            if (c != null) {
                PreparedStatement p = c.prepareStatement("SELECT * FROM Books");
                ResultSet resultSet = p.executeQuery();
                while (resultSet.next()) {
                    System.out.println(resultSet.getString("title"));
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    // It seems not to be allowed to use a ResultSet after the connection, you got it with, is closed
/*    static void showResultExample() throws SQLException {
        String query = "SELECT * FROM Books";
        ResultSet resultSet = getResultFromQuery(query);
        while (resultSet.next()) { //could have not null assertion (IDE suggests), but I don't fully understand it, yet.
            System.out.println(resultSet.getString("title"));
        }
    }

    static ResultSet getResultFromQuery(String query) {
        try (Connection c = getConnection()) {
            if (c != null) {
                PreparedStatement p = c.prepareStatement(query); //just because of tasks redundancy
                return p.executeQuery();

            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }*/
}
