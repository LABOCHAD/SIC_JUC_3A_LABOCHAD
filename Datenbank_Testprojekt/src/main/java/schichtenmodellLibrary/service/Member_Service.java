package schichtenmodellLibrary.service;

import schichtenmodellLibrary.dao.MemberDAOImpl;
import schichtenmodellLibrary.modell.Member;

public class Member_Service {
    private MemberDAOImpl memberDAO = new MemberDAOImpl();

    public static void main(String[] args) {
        Member_Service service = new Member_Service();
        service.showAllMembers();
        service.createMember();
        service.getMemberById(1);
        service.getMemberByName("Bob");
        service.renameMember(3);
        service.deleteMember(4); //beware lucian might be doubled
        service.showAllMembers();
    }

    public Member createMember() {
        return memberDAO.createMember();
        //in case the newly created member is wanted to be used directly. otherwise could be void as well. (See DAO)
    }

    public Member getMemberById(int id) {
        return memberDAO.getmemberbyId(id);
    }

    public Member getMemberByName(String name) {
        return memberDAO.getMemberByName(name);
    }

    public void renameMember(int id) {
        memberDAO.renameMember(id);
    }

    public void deleteMember(int id) {
        memberDAO.deleteMember(id);
    }

    public void showAllMembers(){
        final String separationLines = "-----------------------------";
        System.out.println("\nAll Members:"); //could be done with joining author, but this will do for now
        //member_id(7) name(15)
        System.out.println(separationLines);
        System.out.printf("| %-9s | %-13s |%n", "Member_ID", "Member's Name");
        for (Member m : memberDAO.getAllMembers()) {
            System.out.println(separationLines);
            System.out.printf("| %-9s | %-13s |%n",
                    m.getMember_id(), m.getMember_name());
        }
        System.out.println(separationLines+"\n");

    }

}
