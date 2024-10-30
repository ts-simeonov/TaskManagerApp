import java.time.LocalDate;

public class Task {
    private String title;
    private String description;
    private LocalDate dueDate;
    private boolean isComplete;
    private int priority;

    public Task(String title, String description, LocalDate dueDate, int priority) {
        this.title = title;
        this.description = description;
        this.dueDate = dueDate;
        this.priority = priority;
        this.isComplete = false;
    }

    public String getTitle() { return title; }
    public String getDescription() { return description; }
    public LocalDate getDueDate() { return dueDate; }
    public int getPriority() { return priority; }
    public boolean isComplete() { return isComplete; }

    public void markComplete() {
        this.isComplete = true;
    }

    @Override
    public String toString() {
        return "[Title: " + title + ", Description: " + description + ", Due: " + dueDate +
                ", Priority: " + priority + ", Status: " + (isComplete ? "Complete" : "Incomplete") + "]";
    }

    public String toFileFormat() {
        return title + "|" + description + "|" + dueDate + "|" + priority + "|" + isComplete;
    }

    public static Task fromFileFormat(String fileLine) {
        String[] parts = fileLine.split("\\|");
        Task task = new Task(parts[0], parts[1], LocalDate.parse(parts[2]), Integer.parseInt(parts[3]));
        if (Boolean.parseBoolean(parts[4])) task.markComplete();
        return task;
    }
}