package schichtenmodellLibrary.modell;

public class Member {
    private int member_id;
    private String member_name;
    //Define the Member class with attributes such as memberId, name, email, membershipDate
    // --> In the given Database the members don't have Mail-addresses or membership Dates.

    public Member(int member_id, String member_name) {
        this.member_id = member_id;
        this.member_name = member_name;
    }

    public int getMember_id() {
        return member_id;
    }

    public String getMember_name() {
        return member_name;
    }


}
