package rvt.studentregistration;

public class Regex {
    
    public static boolean checkName(String name) {
        return name.matches("^[A-Za-z]{3,}");
    }

    public static boolean checkSurname(String surname) {
        return surname.matches("^[A-Za-z]{3,}");
    }

    public static boolean checkEmail(String email) {
        return email.matches("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$");
    }

    public static boolean checkPersonalIdentificationNumber(String personalIdentificationNumber) {
        return personalIdentificationNumber.matches("^[0-9]{6}-[0-9]{5}$");
    }
}
