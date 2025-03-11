package _20250311TaskManager;

public class Task {
    int id;
    String name;
    String description;
    int priority;
    boolean done; //isCompleted

    Task(int id, String name, String description, int priority) {
        if (priority < 0 || priority > 5) {
            throw new IllegalArgumentException("Priority must be between 0 and 5");
        }
        this.id = id;
        this.name = name;
        this.description = description;
        this.priority = priority;
        System.out.println("Task has been created");
    }

    void markAsDone() {
        if (done) {
            throw new IllegalArgumentException("Task is already done");
        }
        done = true;
    }

    void setPriority(int priority) {
        if (priority < 0 || priority > 5) {
            throw new IllegalArgumentException("Priority must be between 0 and 5");
        }
        this.priority = priority;
    }

}
