package rvt.studentregistration;

import java.util.Scanner;

public class UserInterface {
    private RegisterStudent registerStudent;
    private FileHandler fileHandler;
    private Scanner scanner;

    public UserInterface(Scanner scanner) {
        this.registerStudent = new RegisterStudent();
        this.fileHandler = new FileHandler();
        this.scanner = scanner;
    }

    public void start() {
        System.out.println("Student Registration System");
        System.out.println("Commands: register, list, delete, stop");

        while (true) {
            System.out.print("Command: ");
            String command = scanner.nextLine().trim().toLowerCase();

            switch (command) {
                case "register":
                    handleRegister();
                    break;
                case "list":
                    fileHandler.showContent();  // Assuming showContent is implemented to print the file
                    break;
                case "delete":
                    System.out.print("Enter personal ID to delete: ");
                    String id = scanner.nextLine();
                    fileHandler.deleteRow(id);
                    break;
                case "stop":
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Unknown command. Try: register, list, delete, stop");
            }
        }
    }

    private void handleRegister() {
        System.out.print("Name: ");
        String name = scanner.nextLine();
        System.out.print("Surname: ");
        String surname = scanner.nextLine();
        System.out.print("Email: ");
        String email = scanner.nextLine();
        System.out.print("Personal ID: ");
        String personalId = scanner.nextLine();

        boolean success = registerStudent.registerStudent(name, surname, email, personalId);
        if (success) {
            System.out.println("Student registered successfully.");
        } else {
            System.out.println("Registration failed. Check input formats.");
        }
    }
}