import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        TodoList todoList = new TodoList();
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\nВыберите действие:");
            System.out.println("1. Добавить задачу");
            System.out.println("2. Отметить задачу как выполненную");
            System.out.println("3. Удалить задачу");
            System.out.println("4. Показать все задачи");
            System.out.println("5. Показать задачи по категориям");
            System.out.println("6. Поиск задачи по ключевому слову");
            System.out.println("7. Показать статистику по задачам");
            System.out.println("0. Выход");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Введите ID задачи: ");
                    int id = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Введите описание задачи: ");
                    String description = scanner.nextLine();
                    System.out.print("Введите категорию задачи: ");
                    String category = scanner.nextLine();
                    todoList.addTask(new Task(id, description, category));
                    break;
                case 2:
                    System.out.print("Введите ID задачи, которую хотите отметить как выполненную: ");
                    int doneId = scanner.nextInt();
                    todoList.markTaskAsDone(doneId);
                    break;
                case 3:
                    System.out.print("Введите ID задачи, которую хотите удалить: ");
                    int deleteId = scanner.nextInt();
                    todoList.removeTask(deleteId);
                    break;
                case 4:
                    todoList.displayAllTasks();
                    break;
                case 5:
                    todoList.displayTasksByCategory();
                    break;
                case 6:
                    System.out.print("Введите ключевое слово для поиска: ");
                    String keyword = scanner.nextLine();
                    todoList.searchTasks(keyword);
                    break;
                case 7:
                    todoList.displayStatistics();
                    break;
                case 0:
                    running = false;
                    System.out.println("Программа завершена.");
                    break;
                default:
                    System.out.println("Неверный выбор. Попробуйте снова.");
                    break;
            }
        }

        scanner.close();
    }
}
