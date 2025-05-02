package _20250311TaskManager;

public class Task {
    private int id;
    private String name;
    private String description;
    private int priority;
    private boolean done; //isCompleted

    Task(int id, String name, String description, int priority) {
        if (priority < 0 || priority > 5) {
            throw new IllegalArgumentException("Priority must be between 0 and 5");
        }
        this.id = id;
        this.name = name;
        this.description = description;
        this.priority = priority;
        System.out.println("Task has been created. ID: " + this.id);
    }

    Task(int id, String name, String description, int priority, boolean done) { //for recreation when loading
        this(id, name, description, priority);
        this.done = done;
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

    public int getPriority() {
        return priority;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isDone() {
        return done;
    }

    @Override
    public String toString() {
        return "\nTask " + id +
               "\nname='" + name + '\'' +
               "\ndescription='" + description + '\'' +
               "\npriority=" + priority +
               "\ndone=" + (done ? "yes" : "no");
    }
}
