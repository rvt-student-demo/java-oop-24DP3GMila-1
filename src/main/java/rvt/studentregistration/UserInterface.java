package rvt.studentregistration;

import java.util.Scanner;

public class UserInterface {    
    private Registration registration = new Registration();     
    private Scanner scanner;

    public UserInterface(Scanner scanner) {        
        this.scanner = scanner;
    }

    public void start() {
        System.out.println("Student Registration System");
        System.out.println("Commands: register, edit, list, delete, stop");

        while (true) {
            System.out.print("Command: ");
            String command = scanner.nextLine().trim().toLowerCase();

            switch (command) {
                case "register":                    
                    handleRegister();
                    break;
                case "edit":                                        
                    handleEdit();
                    break;
                case "list":
                    registration.list();  // Assuming showContent is implemented to print the file
                    break;
                case "delete":
                    handleDelete();
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

        // boolean success = registerStudent.registerStudent(name, surname, email, personalId);
        boolean success = registration.register(name, surname, email, personalId);
        if (success) {
            System.out.println("Student registered successfully.");
        } else {
            System.out.println("Registration failed. Check input formats.");
        }
    }


    private void handleEdit() {
        System.out.print("Enter Personal ID: ");
        String personalId = scanner.nextLine();        
        Student std = registration.findStudent(personalId);
        
        if (std != null) {
            System.out.println("Student found: " + std.toString());
        } else {
            System.out.println("Student not found.");
        }
        System.out.print("Name: ");
        String name = scanner.nextLine();
        System.out.print("Surname: ");
        String surname = scanner.nextLine();
        System.out.print("Email: ");
        String email = scanner.nextLine();        
                
        boolean success = registration.edit(personalId, name, surname, email);
        if (success) {
            System.out.println("Student changed successfully.");
        } else {
            System.out.println("Registration failed. Check input formats.");
        }
    }

    private void handleDelete(){
        
        System.out.print("Enter personal ID to delete: ");
        String personalId = scanner.nextLine(); 
        registration.delete(personalId);           
        
    }
    
}