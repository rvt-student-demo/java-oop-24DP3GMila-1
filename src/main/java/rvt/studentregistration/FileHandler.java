package rvt.studentregistration;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import rvt.utils.ConsoleColors;

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
        String[] headers = {"Name", "Surname", "Email", "Personal ID", "Registration Date"};
        int[] widths = new int[headers.length];
        for (int i = 0; i < headers.length; i++) {
            widths[i] = headers[i].length();
        }

        List<String[]> rows = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(studentsFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] columns = line.split(",");
                if (columns.length < headers.length) {
                    continue; // skip malformed rows
                }
                for (int i = 0; i < headers.length; i++) {
                    columns[i] = columns[i].trim();
                    widths[i] = Math.max(widths[i], columns[i].length());
                }
                rows.add(new String[]{columns[0], columns[1], columns[2], columns[3], columns[4]});
            }
        } catch (Exception e) {
            System.out.println("Error reading the file: " + e.getMessage());
            return;
        }

        if (rows.isEmpty()) {
            System.out.println("No student records found.");
            return;
        }

        String border = buildBorder(widths);
        System.out.println(ConsoleColors.BLUE.code + border + ConsoleColors.RESET.code);
        System.out.println(ConsoleColors.GREEN.code + buildRow(headers, widths) + ConsoleColors.RESET.code);
        System.out.println(ConsoleColors.BLUE.code + border + ConsoleColors.RESET.code);
        for (String[] row : rows) {
            System.out.println(buildRow(row, widths));
        }
        System.out.println(ConsoleColors.BLUE.code + border + ConsoleColors.RESET.code);
    }

    private String buildBorder(int[] widths) {
        StringBuilder border = new StringBuilder("+");
        for (int width : widths) {
            border.append("-");
            for (int i = 0; i < width; i++) {
                border.append("-");
            }
            border.append("-+");
        }
        return border.toString();
    }

    private String buildRow(String[] columns, int[] widths) {
        StringBuilder row = new StringBuilder("|");
        for (int i = 0; i < widths.length; i++) {
            String value = i < columns.length ? columns[i] : "";
            row.append(" ");
            row.append(String.format("%-" + widths[i] + "s", value));
            row.append(" |");
        }
        return row.toString();
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
