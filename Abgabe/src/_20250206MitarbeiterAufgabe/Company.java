package _20250206MitarbeiterAufgabe;

public class Company {
    public static void main(String[] args) {
        Employee[] employees = new Employee[3]; //could also be an ArrayList<Employee>
        Manager manager = new Manager("Manager", 100_000, "Java Development", 1_000_000);
        Developer developer = new Developer("Dominik", 50_000, "Java Development", "Java");
        Intern intern = new Intern("Mike Oxlong", 25_000, "Java Development", 20); //:D

        employees[0] = manager;
        employees[1] = developer;
        employees[2] = intern;

        for (Employee e : employees) {
            System.out.println("_____________________________________________");
            System.out.println("\nOutput display and and work for: " + e.getClass().getName().split("\\.")[1]);
            e.display();
            e.display(true); //testing the overload
            e.work();

            if (e instanceof Manager)
                ((Manager) e).calcPaycheck(e); //is himself in this case, but can any visible in this scope, see the next loop

            if (e instanceof Developer)
                ((Developer) e).debug("Employee Management System");

            if (e instanceof Intern)
                ((Intern) e).learn();
        }

        for(Employee e : employees){
            System.out.println("_____________________________________________");
            System.out.println("\nManager calculates paycheck for: " + e.getClass().getName().split("\\.")[1]);
            manager.calcPaycheck(e);
        }

    }
}
