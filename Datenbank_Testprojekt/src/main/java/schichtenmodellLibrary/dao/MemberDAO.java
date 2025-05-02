package schichtenmodellLibrary.dao;

import schichtenmodellLibrary.modell.Member;

public interface MemberDAO {
    //CRUD = Create Read Update Delete

    //Create
    public Member createMember(); //idk if the member is being supposed to be returned after creation in the database.

    //Read
    public Member getmemberbyId(int id);
    public Member getMemberByName(String name);

    //Update
    public void renameMember(int id);

    //Delete
    public void deleteMember(int id);
}
