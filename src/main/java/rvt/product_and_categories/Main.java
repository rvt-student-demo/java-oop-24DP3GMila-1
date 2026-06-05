package rvt.product_and_categories;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        DatabaseConnection db = new DatabaseConnection();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            printMenu();
            String choice = scanner.nextLine().trim();

            switch (choice) {
                case "1" -> db.addCategory();
                case "2" -> db.addProduct();
                case "3" -> db.showCategories();
                case "4" -> db.showProducts();
                case "5" -> db.Exit();
                default -> System.out.println("Unknown option, please choose 1-5.");
            }
        }
    }

    private static void printMenu() {
        System.out.println();
        System.out.println("=== Product and Category Manager ===");
        System.out.println("1. Add category");
        System.out.println("2. Add product");
        System.out.println("3. Show categories");
        System.out.println("4. Show products");
        System.out.println("5. Exit");
        System.out.println("===================================");
        System.out.print("Choose an option: ");
    }
}

