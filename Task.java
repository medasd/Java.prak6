import java.time.LocalDate;

public class Task {
    private int id;
    private String description;
    private String category;
    private boolean isDone;
    private LocalDate creationDate;

    public Task(int id, String description, String category) {
        this.id = id;
        this.description = description;
        this.category = category;
        this.isDone = false;
        this.creationDate = LocalDate.now();
    }

    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public String getCategory() {
        return category;
    }

    public boolean isDone() {
        return isDone;
    }

    public void markAsDone() {
        this.isDone = true;
    }

    @Override
    public String toString() {
        return id + ". " + description + " (Категория: " + category + ", Статус: " + (isDone ? "Выполнено" : "Не выполнено") + ", Дата создания: " + creationDate + ")";    }
}
