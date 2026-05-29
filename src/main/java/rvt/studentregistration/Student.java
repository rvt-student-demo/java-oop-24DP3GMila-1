package rvt.studentregistration;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Student {
    private String name;
    private String surname;
    private String email;
    private String personalIdentificationNumber;
    private LocalDateTime registrationDate;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPersonalIdentificationNumber() {
        return personalIdentificationNumber;
    }

    public void setPersonalIdentificationNumber(String personalIdentificationNumber) {
        this.personalIdentificationNumber = personalIdentificationNumber;
    }

    public LocalDateTime getRegitrationData() {
        return registrationDate;
    }

    public void setRegitrationData() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        String formattedDateTime = now.format(formatter);
        this.registrationDate = LocalDateTime.parse(formattedDateTime, formatter);
    }

    public void setRegitrationData(LocalDateTime localDt) {        
        this.registrationDate = localDt;
    }

    @Override
    public String toString() {
        return name + ','  + surname + ',' + email + ',' + personalIdentificationNumber + ',' + registrationDate;
    }
    
}
