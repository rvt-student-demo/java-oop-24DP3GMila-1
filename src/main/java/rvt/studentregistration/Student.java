package rvt.studentregistration;

import java.time.LocalDateTime;
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
        this.registrationDate = LocalDateTime.now();
    }
    @Override
    public String toString() {
        return name + ','  + surname + ',' + email + ',' + personalIdentificationNumber + ',' + registrationDate;
    }
}
