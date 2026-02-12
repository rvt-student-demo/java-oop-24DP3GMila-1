package rvt;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class App {
    public static void main(String[] args) {
        File file = new File("data/todo.csv");
        try {
            Scanner reader = new Scanner(file);
            System.out.println(reader.nextLine());
            while (reader.hasNextLine()) {
                System.out.println(reader.nextLine());
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
