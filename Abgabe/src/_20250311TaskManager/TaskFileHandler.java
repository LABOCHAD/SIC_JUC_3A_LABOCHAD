package _20250311TaskManager;

import myTools.Color;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

class TaskFileHandler {
    private static final String DELIMITER = " ~ ";
    private static final String FILE_NAME = "Abgabe/src/_20250311TaskManager/tasks.txt";


    public static void saveTasksToFile(List<Task> tasks) {
        if (!new File(FILE_NAME).exists())
            System.out.println("No task file found. Creating a new one.");
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (Task task : tasks) {
                writer.write(
                        task.getId() + DELIMITER +
                        task.getName() + DELIMITER +
                        task.getDescription() + DELIMITER +
                        task.getPriority() + DELIMITER +
                        task.isDone()
                );
                writer.newLine();
            }

            System.out.println("Tasks saved to " + FILE_NAME);
        } catch (IOException e) {
            System.out.println("Failed saving to file: " + e.getMessage());
        }
    }


    // Für jede Zeile in der Datei soll nach dem Sonderzeichen getrennt werden.
    // Nutze die split(String s)-Methode.
    // Dein String Array beinhaltet einzelne Elemente eines Tasks.
    // Füge diese einem Konstruktor hinzu.
    // Speichere den neuen Task in einer Liste.
    public static List<Task> loadTasksFromFile() {
        List<Task> tasks = new ArrayList<>();
        if (new File(FILE_NAME).exists()) {
            System.out.println("Task file found. Try loading it...");
        }
        else {
            System.out.println("Task file not found. Remember saving changes!");
            return tasks; //return an empty list, as it would be anyway without loading.
        }
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                try {
                    String[] part = line.split(DELIMITER);
                    int id = Integer.parseInt(part[0]);
                    String name = part[1];
                    String description = part[2];
                    int priority = Integer.parseInt(part[3]);
                    boolean done = Boolean.parseBoolean(part[4]);
                    tasks.add(new Task(id, name, description, priority, done));
                } catch (IllegalArgumentException e) {
                    System.out.println(Color.RED);
                    System.out.println("Failed to load a task: " + e.getMessage());
                    System.out.println("Corrupted line in file: " + line);
                    System.out.println("Skipping line and trying next, if existent. ");
                    System.out.println(Color.RESET);
                }
            }
            System.out.println("Finished loading from file: " + FILE_NAME);
            System.out.println("Tasks loaded from file: " + tasks.size());
        } catch (IOException e) {
            System.err.println("\nFailed loading task file: " + e.getMessage());
        }
        return tasks;
    }
}
