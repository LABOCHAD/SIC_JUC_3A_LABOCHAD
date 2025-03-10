package _20250206MitarbeiterAufgabe;

public class Manager extends Employee {
    private double budget;

    //Consideration: if name from Emplyee-Class was

    Manager(String name, double salary, String department, double budget) {
        super(name, salary, department);
        this.budget = budget;
    }

    @Override
    public void work() {
        System.out.printf("%nManager manages a budget of %.2f EUR.%n", budget); //instead of XYZ
    }

    @Override
    public void display(boolean detailed) {
        super.display(detailed);
        System.out.printf("%nSalary:        %.2f.%n", budget);
    }

    public void calcPaycheck(Employee e) {
        System.out.printf(
                "%nCalculating salary:" +
                "%nSalary:         %.2f" +
                "%nName:           %s",
                e.salary, e.name);
                //or also via (without instance of)
                //Job title = e.getClass().getName.split("\\.")[1] //because getName returns packageName.Classname

        if (e instanceof Manager)
            System.out.printf("\nJob title:      Manager\n");
        if (e instanceof Developer)
            System.out.printf("\nJob title:      Developer\n");
        if (e instanceof Intern)
            System.out.printf("\nJob title:      Intern\n");
    }

}
