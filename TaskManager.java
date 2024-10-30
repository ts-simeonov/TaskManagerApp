import java.util.*;
import java.time.LocalDate;

public class TaskManager {
    private static List<Task> tasks = TaskStorage.loadTasks();

    public static void main(String[] args) {
        System.out.println("Welcome to Task Manager!");

        while (true) {
            displayMenu();
            int choice = Utils.promptInt("Choose an option");

            switch (choice) {
                case 1 -> addTask();
                case 2 -> viewTasks();
                case 3 -> markTaskComplete();
                case 4 -> deleteTask();
                case 5 -> {
                    TaskStorage.saveTasks(tasks);
                    System.out.println("Tasks saved. Exiting...");
                    return;
                }
                default -> System.out.println("Invalid option. Try again.");
            }
        }
    }

    private static void displayMenu() {
        System.out.println("\nMenu:");
        System.out.println("1. Add Task");
        System.out.println("2. View Tasks");
        System.out.println("3. Mark Task as Complete");
        System.out.println("4. Delete Task");
        System.out.println("5. Exit");
    }

    private static void addTask() {
        System.out.println("\nAdd New Task");
        String title = Utils.promptString("Enter title");
        String description = Utils.promptString("Enter description");
        LocalDate dueDate = Utils.promptDate("Enter due date");
        int priority = Utils.promptInt("Enter priority (1-5)");
        tasks.add(new Task(title, description, dueDate, priority));
        System.out.println("Task added!");
    }

    private static void viewTasks() {
        System.out.println("\nTasks:");
        for (int i = 0; i < tasks.size(); i++) {
            System.out.println((i + 1) + ". " + tasks.get(i));
        }
    }

    private static void markTaskComplete() {
        viewTasks();
        int index = Utils.promptInt("Enter task number to mark complete") - 1;
        if (index >= 0 && index < tasks.size()) {
            tasks.get(index).markComplete();
            System.out.println("Task marked as complete.");
        } else {
            System.out.println("Invalid task number.");
        }
    }

    private static void deleteTask() {
        viewTasks();
        int index = Utils.promptInt("Enter task number to delete") - 1;
        if (index >= 0 && index < tasks.size()) {
            tasks.remove(index);
            System.out.println("Task deleted.");
        } else {
            System.out.println("Invalid task number.");
        }
    }
}
