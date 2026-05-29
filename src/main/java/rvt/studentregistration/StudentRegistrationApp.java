package rvt.studentregistration;

import java.util.*;

public class StudentRegistrationApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        UserInterface ui = new UserInterface(scanner);
        ui.start();
    }
    
}