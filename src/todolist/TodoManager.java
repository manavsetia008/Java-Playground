//Console to-do list manager: add, view, complete and remove tasks.
//Tasks are saved to a file so they persist between runs.

package todolist;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class TodoManager {
    private static final String FILE_NAME = "tasks.txt";
    private static final ArrayList<Task> tasks = new ArrayList<>();
    private static final Scanner scanner = new Scanner(System.in);
    private static class Task {
        String title;
        boolean completed;
        Task(String title, boolean completed) {
            this.title = title;
            this.completed = completed;
        }
    }

    public static void main(String[] args) {
        loadTasks();
        int choice;

        do {
            System.out.println("\n------TO-DO LIST MANAGER------");
            System.out.println("1. Add Task");
            System.out.println("2. View Tasks");
            System.out.println("3. Mark Task as Complete");
            System.out.println("4. Remove Task");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    addTask();
                    break;
                case 2:
                    viewTasks();
                    break;
                case 3:
                    completeTask();
                    break;
                case 4:
                    removeTask();
                    break;
                case 5:
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please select 1-5.");
            }
        } while (choice != 5);
        scanner.close();
    }
    private static void addTask() {
        System.out.print("Enter task: ");
        String title = scanner.nextLine().trim();
        if (title.isEmpty()) {
            System.out.println("Task cannot be empty.");
            return;
        }
        tasks.add(new Task(title, false));
        saveTasks();
        System.out.println("Task added.");
    }

    private static void viewTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks yet.");
            return;
        }
        for (int i = 0; i < tasks.size(); i++) {
            Task task = tasks.get(i);
            String status = task.completed ? "[x]" : "[ ]";
            System.out.println((i + 1) + ". " + status + " " + task.title);
        }
    }

    private static void completeTask() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks yet.");
            return;
        }
        viewTasks();
        System.out.print("Enter task number to mark complete: ");
        int number = scanner.nextInt();
        scanner.nextLine();

        if (number < 1 || number > tasks.size()) {
            System.out.println("Invalid task number.");
            return;
        }

        tasks.get(number - 1).completed = true;
        saveTasks();
        System.out.println("Task marked as complete.");
    }

    private static void removeTask() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks yet.");
            return;
        }
        viewTasks();
        System.out.print("Enter task number to remove: ");
        int number = scanner.nextInt();
        scanner.nextLine();

        if (number < 1 || number > tasks.size()) {
            System.out.println("Invalid task number.");
            return;
        }

        tasks.remove(number - 1);
        saveTasks();
        System.out.println("Task removed.");
    }

    private static void loadTasks() {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("\\|", 2); // 0|title or 1|title
                if (parts.length == 2) {
                    tasks.add(new Task(parts[1], parts[0].equals("1")));
                }
            }
        } catch (IOException e) {
            // File does not exist on the first run
        }
    }

    private static void saveTasks() {
        try (PrintWriter writer = new PrintWriter(new FileWriter(FILE_NAME))) {
            for (Task task : tasks) {
                writer.println((task.completed ? "1" : "0") + "|" + task.title);
            }
        } catch (IOException e) {
            System.out.println("Error saving tasks: " + e.getMessage());
        }
    }
}