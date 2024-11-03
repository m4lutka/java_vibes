// Kibitkin Ilya IT3-2307

import java.util.ArrayList;
import java.util.Scanner;

public class App {
    private static ArrayList<String> groceryList = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\nAvailable actions:");
            System.out.println("0 - to shutdown");
            System.out.println("1 - add items to list");
            System.out.println("2 - remove any items");
            System.out.print("\nEnter a number for which action you want to do: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 0:
                    running = false;
                    System.out.println("Shutting down...");
                    break;
                case 1:
                    addItem(scanner);
                    printList();
                    break;
                case 2:
                    removeItem(scanner);
                    printList();
                    break;
                default:
                    System.out.println("Invalid choice. Please enter 0, 1, or 2.");
            }
        }
    }

    private static void addItem(Scanner scanner) {
        System.out.print("Enter item to add: ");
        String item = scanner.nextLine().trim();
        if (item.isEmpty()) {
            System.out.println("Item cannot be empty.");
        } else if (groceryList.contains(item.toLowerCase())) {
            System.out.println("Item already exists in the list.");
        } else {
            groceryList.add(item.toLowerCase());
            System.out.println("Item added: " + item);
        }
    }

    private static void removeItem(Scanner scanner) {
        System.out.print("Enter item to remove: ");
        String item = scanner.nextLine().trim();
        if (groceryList.remove(item.toLowerCase())) {
            System.out.println("Item removed: " + item);
        } else {
            System.out.println("Item not found in the list.");
        }
    }

    private static void printList() {
        if (groceryList.isEmpty()) {
            System.out.println("The grocery list is currently empty.");
        } else {
            sortList(groceryList);
            System.out.println("Grocery list (sorted):");
            for (String item : groceryList) {
                System.out.println("- " + item);
            }
        }
    }

    private static void sortList(ArrayList<String> list) {
        for (int i = 0; i < list.size() - 1; i++) {
            for (int j = 0; j < list.size() - 1 - i; j++) {
                if (list.get(j).compareTo(list.get(j + 1)) > 0) {
                    String temp = list.get(j);
                    list.set(j, list.get(j + 1));
                    list.set(j + 1, temp);
                }
            }
        }
    }
}
