package dingeTesten_LABOCHAD;

public class StudentNotInitialized {
    String sName;
    char grade;

    public static void main(String[] args) {
        StudentNotInitialized s = new StudentNotInitialized();
        System.out.println("[" + s.sName + ":" + s.grade + "]");
    }
}