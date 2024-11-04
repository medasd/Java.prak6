import java.util.*;

public class TodoList {
    private ArrayList<Task> tasks = new ArrayList<>();
    private HashSet<String> categories = new HashSet<>();
    private HashMap<String, List<Task>> tasksByCategory = new HashMap<>();

    public void addTask(Task task) {
        tasks.add(task);
        categories.add(task.getCategory());

        tasksByCategory.computeIfAbsent(task.getCategory(), _ -> new ArrayList<>()).add(task);
        System.out.println("Задача \"" + task.getDescription() + "\" добавлена.");
    }

    public void removeTask(int id) {
        Task taskToRemove = findTaskById(id);
        if (taskToRemove != null) {
            tasks.remove(taskToRemove);
            tasksByCategory.get(taskToRemove.getCategory()).remove(taskToRemove);
            System.out.println("Задача \"" + taskToRemove.getDescription() + "\" удалена.");
        } else {
            System.out.println("Задача с ID " + id + " не найдена.");
        }
    }

    public void markTaskAsDone(int id) {
        Task task = findTaskById(id);
        if (task != null) {
            task.markAsDone();
            System.out.println("Задача \"" + task.getDescription() + "\" отмечена как выполненная.");
        } else {
            System.out.println("Задача с ID " + id + " не найдена.");
        }
    }

    public void displayAllTasks() {
        System.out.println("=== Список всех задач ===");
        for (Task task : tasks) {
            System.out.println(task);
        }
    }

    public void displayTasksByCategory() {
        System.out.println("=== Список задач по категориям ===");
        for (String category : tasksByCategory.keySet()) {
            System.out.println("Категория: " + category);
            for (Task task : tasksByCategory.get(category)) {
                System.out.println("- " + task);
            }
        }
    }

    public void searchTasks(String keyword) {
        System.out.println("=== Поиск задач по ключевому слову \"" + keyword + "\" ===");
        boolean found = false;
        for (Task task : tasks) {
            if (task.getDescription().toLowerCase().contains(keyword.toLowerCase())) {
                System.out.println(task);
                found = true;
            }
        }
        if (!found) {
            System.out.println("Задачи, содержащие \"" + keyword + "\", не найдены.");
        }
    }

    public void displayStatistics() {
        long doneCount = tasks.stream().filter(Task::isDone).count();
        long notDoneCount = tasks.size() - doneCount;
        System.out.println("=== Статистика ===");
        System.out.println("Всего задач: " + tasks.size());
        System.out.println("Выполнено: " + doneCount);
        System.out.println("Не выполнено: " + notDoneCount);
    }

    private Task findTaskById(int id) {
        return tasks.stream().filter(task -> task.getId() == id).findFirst().orElse(null);
    }
}
