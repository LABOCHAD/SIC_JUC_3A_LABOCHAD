package _20250228SingeltonsAndEnums;

public class Employee {
    String name;

    Employee(String name) {
        this.name = name;
    }

    void print(int pages) {
        Printer.getInstance().print(pages);
    }

    public static void main(String[] args) {
        Employee employee_Dominik = new Employee("Dominik");
        employee_Dominik.print(5);
        employee_Dominik.print(5);

    }
}
