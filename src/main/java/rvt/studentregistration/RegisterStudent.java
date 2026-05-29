package rvt.studentregistration;

import java.io.*;

public class RegisterStudent {
    private FileHandler fileHandler;

    public RegisterStudent() {
        this.fileHandler = new FileHandler();
    }

    public boolean registerStudent(String name, String surname, String email, String personalIdentificationNumber){
        if (!Regex.checkName(name)) {
            System.out.println("Invalid name format.");
            return false;
        }
        if (!Regex.checkSurname(surname)) {
            System.out.println("Invalid surname format.");
            return false;
        }
        if (!Regex.checkEmail(email)) {
            System.out.println("Invalid email format.");
            return false;
        }
        if (!Regex.checkPersonalIdentificationNumber(personalIdentificationNumber)) {
            System.out.println("Invalid personal identification number format.");
            return false;
        }

        Student student = new Student();
        student.setName(name);
        student.setSurname(surname);
        student.setEmail(email);
        student.setPersonalIdentificationNumber(personalIdentificationNumber);
        student.setRegitrationData();

        return fileHandler.addRow(student.toString());
    }
    
}
