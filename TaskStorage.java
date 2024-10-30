import java.io.*;
import java.nio.file.*;
import java.util.*;
import java.util.stream.Collectors;

public class TaskStorage {
    private static final String FILE_PATH = "tasks.txt";

    public static void saveTasks(List<Task> tasks) {
        try (BufferedWriter writer = Files.newBufferedWriter(Paths.get(FILE_PATH))) {
            for (Task task : tasks) {
                writer.write(task.toFileFormat());
                writer.newLine();
            }
        } catch (IOException e) {
            System.err.println("Error saving tasks: " + e.getMessage());
        }
    }

    public static List<Task> loadTasks() {
        List<Task> tasks = new ArrayList<>();
        if (Files.exists(Paths.get(FILE_PATH))) {
            try (BufferedReader reader = Files.newBufferedReader(Paths.get(FILE_PATH))) {
                tasks = reader.lines().map(Task::fromFileFormat).collect(Collectors.toList());
            } catch (IOException e) {
                System.err.println("Error loading tasks: " + e.getMessage());
            }
        }
        return tasks;
    }
}
