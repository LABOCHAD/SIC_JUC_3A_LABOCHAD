package _20250206MitarbeiterAufgabe;

public class Developer extends Employee {
    private String programmingLanguage;

    Developer(String name, double salary, String department, String programmingLanguage) {
        super(name, salary, department);
        this.programmingLanguage = programmingLanguage;
    }

    @Override
    public void work() {
        System.out.printf("%nDeveloper is coding in %s.%n", programmingLanguage);
    }

    @Override
    public void display(boolean detailed) {
        super.display(detailed);
        System.out.printf("%nProgramming Language: %s%n", programmingLanguage);
    }

    public void debug(String project){
        System.out.printf("%nDeveloper is debugging project %s.%n", project);
    }
}
