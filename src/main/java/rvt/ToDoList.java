package rvt;

import java.util.ArrayList;
import java.util.Iterator;
import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.BufferedReader;
import java.nio.file.Files;
import java.util.regex.Pattern;
import java.io.BufferedWriter;

public class ToDoList {
    ArrayList<String> taskList = new ArrayList<String>();
    private final String filePath = "data/todo.csv";

    public ToDoList() {
        this.taskList = new ArrayList<>();
        loadFromFile();
        getLastId();
    }

    private void loadFromFile() {
        Path path = Paths.get(filePath);
        if (!Files.exists(path)) {
            return;
        }
        try (BufferedReader br = Files.newBufferedReader(path)) {
            String line;
            while ((line = br.readLine()) != null) {
                line = line.trim();
                if (line.isEmpty()) continue;
                taskList.add(line);
            }
        } catch (Exception e) {
            System.out.println("Error loading tasks from file: " + e.getMessage());
        }
    }

    public void add(String task) {
        if (!checkEventString(task)) {
            System.out.println("Invalid task format. Task should be in the format: id, description");
            return;
        }
        int newId = getLastId() + 1;
        taskList.add(newId + "," + task);
        updateFile();

    }

    public void print() {
        int index = 1;
        for (String s : taskList) {
            System.out.println(String.valueOf(index++) + ": " + s);
        }
    }

    public void remove(int id) {
        Iterator<String> iterator = taskList.iterator();
        while(iterator.hasNext()) {
            String task = iterator.next();
            String[] parts = task.split(",", 2);

            if (Integer.parseInt(parts[0]) == id) {
                iterator.remove();
                updateFile();
                return;
            }
        }
    }

    public int getLastId() {
        if (taskList.isEmpty()) {
            return 0;
        }
        String last = taskList.get(taskList.size() - 1);
        String[] parts = last.split(",", 2);
        if (parts.length == 0) {
            return 0;
        }
        try {
            return Integer.parseInt(parts[0].trim());
        } catch (NumberFormatException e) {
            return 0;
        }
    }

    private boolean updateFile() {
        try (BufferedWriter writer = Files.newBufferedWriter(Paths.get(filePath))) {

            writer.write("ID, Task");
            writer.newLine();

            for (String task : taskList) {
                writer.write(task.replace(",", ","));
                writer.newLine();
            }

            return true;

        } catch (Exception e) {
            System.out.println("Error updating file.");
            return false;
        }
    }

    public boolean checkEventString(String value) {
        return value != null &&
                Pattern.matches("^[a-zA-z 0-9]{3,}$", value);
    }
}
