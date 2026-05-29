package rvt.studentregistration;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Registration {
    private FileHandler fileHandler = new FileHandler();
    
    public boolean register(String name, String surname, String email, String personalIdentificationNumber) {
                
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

    public boolean delete(String personalIdentificationNumber){
        
        fileHandler.deleteRow(personalIdentificationNumber);
        return true;

    }

    public Student findStudent(String personalIdentificationNumber){

        String studentData = fileHandler.findByStr(personalIdentificationNumber);

        Student student = new Student();
        String[] columns = studentData.split(","); 

        student.setName(columns[0]);
        student.setSurname(columns[1]);
        student.setEmail(columns[2]);
        student.setPersonalIdentificationNumber(columns[3]);

        String dateString = columns[4];        
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");        
        LocalDateTime dateTime = LocalDateTime.parse(dateString, formatter);
        student.setRegitrationData(dateTime);

        return student;
    }


    public boolean edit(String personalIdentificationNumber, String name, String surname, String email){

        Student student = findStudent(personalIdentificationNumber);
        if(name != null && Regex.checkName(name)){
            student.setName(name);            
        }
        if (surname != null && Regex.checkSurname(surname)) {
            student.setSurname(surname);
        } 
        if (email != null && Regex.checkEmail(email)) {
            student.setEmail(email);
        }
        return fileHandler.updateRow(personalIdentificationNumber,student.toString());        
    }

    public boolean list(){
        fileHandler.showContent();
        return true;
    }
    

}
