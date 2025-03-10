package _20250206MitarbeiterAufgabe;

public abstract class Employee {
    protected String name;
    protected double salary;
    protected String department;

    Employee(String name, double salary, String department) {
        this.name = name;
        this.salary = salary;
        this.department = department;
    }

    public void display() {
        System.out.printf("%nGeneral Info:" +
                          "%nName: %s", name);
    }

    public abstract void work();

    public void display(boolean detailed) {
        if (!detailed)
            display();
        else
            System.out.printf("%n%nDetailed Info:" +
                              "%nName:          %s" +
                              "%nSalary:        %.2f" +
                              "%nDepartment:    %s",
                    name, salary, department);
    }

}
