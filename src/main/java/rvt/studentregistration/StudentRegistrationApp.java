package rvt.studentregistration;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class StudentRegistrationApp {
    public static void main(String[] args) {
    Student std = new Student();
    std.setName("Alex");
    std.setSurname("Test");
    std.setEmail("test@test.com");
    std.setPersonalIdentificationNumber("12345-1234");    
    std.setRegitrationData();
    std.setName("Kirill");
    std.setSurname("Mil");
    std.setEmail("aaa@aaa.com");
    std.setPersonalIdentificationNumber("56780-4321");    
    std.setRegitrationData();
    /*System.out.println(std.getName());
    System.out.println(std.getSurname());
    System.out.println(std.getPersonalIdentificationNumber());
    System.out.println(std.getRegitrationData());*/
    System.out.println(std.toString());
    FileHandler fh = new FileHandler();
    fh.addRow(std.toString());
    fh.deleteRow("12345-1234");
    }
}