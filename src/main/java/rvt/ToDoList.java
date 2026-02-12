package rvt;

import java.util.ArrayList;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.BufferedReader;
import java.nio.file.Files;

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
        taskList.add(task);
    }

    public void print() {
        int index = 1;
        for (String s : taskList) {
            System.out.println(String.valueOf(index++) + ": " + s);
        }
    }

    public void remove(int taskIndex) {
        taskList.remove(taskIndex-1);
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
}
