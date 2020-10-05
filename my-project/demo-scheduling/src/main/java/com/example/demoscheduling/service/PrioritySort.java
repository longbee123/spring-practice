package com.example.demoscheduling.service;

import com.example.demoscheduling.entity.Task;

import java.util.Comparator;

public class PrioritySort implements Comparator<Task> {


    @Override
    public int compare(Task o1, Task o2) {

        return o2.getPriority() - o1.getPriority();
    }
}
