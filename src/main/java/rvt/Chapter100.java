package rvt;

import java.util.*;

public class Chapter100{

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numerator = 0, divisor = 0;
        boolean goodData = false;
        while (!goodData) {
            try {
                System.out.print("Enter the numerator: ");
                numerator = scanner.nextInt();
                System.out.print("Enter the divisor: ");
                divisor = scanner.nextInt();
                System.out.println(numerator + " / " + divisor + "is " + (numerator/divisor));
            } catch (ArithmeticException ex) {
                System.out.println("You can't divide " + numerator + "by " + divisor);
            } catch (InputMismatchException ex) {
                System.out.println("You entered bad data.");
                System.out.println("Please try again.");
                scanner.nextLine();
            }
        }
    }
}