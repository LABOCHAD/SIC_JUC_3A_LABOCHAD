package _20250206MitarbeiterAufgabe;

public class Intern extends Employee{
    private int trainingYear;

    Intern(String name, double salary, String department,int trainingYear) {
        super(name, salary, department);
        this.trainingYear = trainingYear;
    }

    @Override
    public void work() {
        System.out.println("\nIntern is learning new tasks.");
    }

    @Override
    public void display(boolean detailed) {
        super.display(detailed);
        System.out.printf("%nTraining year: %d", trainingYear);
    }

    public void learn(){
        System.out.println("\nIntern is attending a seminar.");
    }
}
