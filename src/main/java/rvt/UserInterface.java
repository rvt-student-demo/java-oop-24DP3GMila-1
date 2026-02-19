package rvt;

import java.util.Scanner;

public class UserInterface {
    private ToDoList list;
    private Scanner scanner;

    public UserInterface(ToDoList list, Scanner scanner) {
        this.list = list;
        this.scanner = scanner;
    }

    public void start() {
        while (true) {
            System.out.print("Command: ");
            String command = scanner.nextLine();

            switch (command) {
                case "stop":
                    return;
                case "add":
                    System.out.print("To add: ");
                    list.add(scanner.nextLine());
                    break;
                case "list":
                    list.print();
                    break;
                case "remove":
                    System.out.print("Which one is removed? ");
                    try {
                        int id = Integer.parseInt(scanner.nextLine());
                        list.remove(id);
                    } catch (Exception e) {
                        System.out.println("Invalid number.");
                    }
                    break;
                default:
                    System.out.println("Unknown command");
            }
        }
    }
}