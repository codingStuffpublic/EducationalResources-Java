package challenges;

import java.io.*;
import java.util.*;
import java.time.LocalDate;

public class TaskManagerApp {
    public static void main(String[] args) {
        TaskManager manager = new TaskManager();
        manager.loadTasksFromFile();
        
        manager.addTask(new Task("Buy Groceries", "Milk, Bread, Eggs", LocalDate.now().plusDays(1), "To Do"));
        manager.addTask(new Task("Java Project", "Finish Task Manager", LocalDate.now().plusDays(3), "In Progress"));
        
        manager.listTasks();
        manager.updateTaskStatus("Buy Groceries", "Done");
        manager.deleteTask("Java Project");
        manager.listTasks();
    }
}

class Task {
    private String title;
    private String description;
    private LocalDate dueDate;
    private String status;

    public Task(String title, String description, LocalDate dueDate, String status) {
        this.title = title;
        this.description = description;
        this.dueDate = dueDate;
        this.status = status;
    }

    public String getTitle() { return title; }
    public String getStatus() { return status; }
    public LocalDate getDueDate() { return dueDate; }

    public void setStatus(String status) { this.status = status; }

    @Override
    public String toString() {
        return title + " | " + description + " | " + dueDate + " | " + status;
    }
}

class TaskManager {
    private List<Task> tasks = new ArrayList<>();
    private final String FILE_NAME = "tasks.txt";

    public void addTask(Task task) {
        tasks.add(task);
        saveTasksToFile();
    }

    public void updateTaskStatus(String title, String newStatus) {
        for (Task task : tasks) {
            if (task.getTitle().equalsIgnoreCase(title)) {
                task.setStatus(newStatus);
                saveTasksToFile();
                return;
            }
        }
    }

    public void deleteTask(String title) {
        tasks.removeIf(task -> task.getTitle().equalsIgnoreCase(title));
        saveTasksToFile();
    }

    public void listTasks() {
        tasks.forEach(System.out::println);
    }

    public void loadTasksFromFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
            		String[] parts = line.split(" \\| ");
                if (parts.length == 4) {
                    tasks.add(new Task(parts[0], parts[1], LocalDate.parse(parts[2]), parts[3]));
                }
            }
        } catch (IOException e) {
            System.out.println("No previous tasks found.");
        }
    }

    private void saveTasksToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (Task task : tasks) {
                writer.write(task.toString());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error saving tasks.");
        }
    }
}


