package rvt.studentregistration;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.io.*;

public class FileHandler {
    private File studentsFile = new File("src\\main\\java\\rvt\\studentregistration\\students.csv");
    private File tempFile = new File("src\\main\\java\\rvt\\studentregistration\\students_temp.csv");

    public boolean addRow(String content) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(studentsFile,true))) {
            writer.write(content);
            writer.println();
            writer.close();
            return true;
        } catch (Exception e) {
            System.out.println("Error saving to the file: " + e.getMessage());
            return false;
        }

    }

    public void showContent() {
        try(BufferedReader reader = new BufferedReader(new FileReader(studentsFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
            
        } catch (Exception e) {
            System.out.println("Error reading the file: " + e.getMessage());            
        }
    }

    public boolean updateRow(String personalIdentificationNumber, String content) {
        try(BufferedReader reader = new BufferedReader(new FileReader(studentsFile));
            PrintWriter writer = new PrintWriter(new FileWriter(tempFile))) {
            
            String currentLine;

            while ((currentLine = reader.readLine()) != null) {
                // Process the line and update it as needed
                String[] columns = currentLine.split(",");
                if (columns.length > 0 && columns[3].equals(personalIdentificationNumber)) {
                    writer.println(content);
                } else{
                    writer.println(currentLine);
                }
            }
            
        } catch (Exception e) {
            System.out.println("Error updating the file: " + e.getMessage());
            return false;
        }
        if (studentsFile.delete()) {
            tempFile.renameTo(studentsFile);
            System.out.println("Updated successfully.");
        }
        return true;
    }

    public boolean deleteRow(String personalIdentificationNumber) {
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

    public String findByStr(String str){        
        try(BufferedReader reader = new BufferedReader(new FileReader(studentsFile))) {                   
            String currentLine;

            while ((currentLine = reader.readLine()) != null) {
                // Process the line and update it as needed
                String[] columns = currentLine.split(",");
                if (columns.length > 0 && columns[3].equals(str)) {                    
                    return currentLine;
                }                
            }
            
        } catch (Exception e) {
            System.out.println("Error updating the file: " + e.getMessage());
        }
        return null;
    }
}
