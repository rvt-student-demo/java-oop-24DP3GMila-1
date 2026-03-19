package rvt.studentregistration;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.io.*;

public class FileHandler {
    private File studentsFile = new File("src\\main\\java\\rvt\\studentregistration\\students.csv");

    public boolean addRow(String content) {
        try (PrintWriter writer = new PrintWriter(studentsFile)) {
            writer.write(content);            
            return true;
        } catch (Exception e) {
            System.out.println("Error saving to the file: " + e.getMessage());
            return false;
        }

    }

    public void showContent() {

    }

    public void updateRow() {

    }

    public boolean deleteRow(String personalIdentificationNumber) {
        File tempFile = new File("src\\main\\java\\rvt\\studentregistration\\students_temp.csv");        
        try (BufferedReader reader = new BufferedReader(new FileReader(studentsFile));
                PrintWriter writer = new PrintWriter(new FileWriter(tempFile))) {

            String currentLine;

            while ((currentLine = reader.readLine()) != null) {
                String[] columns = currentLine.split(",");
                if (columns.length > 0 && !columns[3].equals(personalIdentificationNumber)) {
                    writer.println(currentLine);
                }
            }
            
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }

        if (studentsFile.delete()) {
            tempFile.renameTo(studentsFile);
            System.out.println("Row deleted successfully.");
        }
        return true;
    }
}
