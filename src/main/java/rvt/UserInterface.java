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
            if (command.equals("stop")) {  // if command == "stop"
            break;
            } else if (command.equals("add")) {  // if command == "add" 
                System.out.print("To add: ");
                String task = scanner.nextLine();
                list.add(task);
            } else if (command.equals("list")) {  // if command == "list"
                list.print();
            } else if (command.equals("remove")){  // if command == "remove"
                System.out.print("Which one is removed? ");
                int id = Integer.valueOf(scanner.nextLine());
                list.remove(id);
            }
        }
    }
}
