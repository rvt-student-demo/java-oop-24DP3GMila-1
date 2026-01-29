package rvt;

import java.util.ArrayList;

public class ToDoList {
    ArrayList<String> taskList = new ArrayList<String>();

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
}
