package com.example.demoscheduling.service;


import com.example.demoscheduling.entity.Task;
import com.example.demoscheduling.repository.TaskRepository;
import com.example.task.GetTaskResponse;
import com.example.task.TaskList;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    private List<Task> taskList;

    private GetTaskResponse getTaskResponse;

    private List<TaskList> list;

    public GetTaskResponse getAllTask() {
        list = new ArrayList<>();
        getTaskResponse = new GetTaskResponse();
        taskList = taskRepository.findAll();
        Collections.sort(taskList, new PrioritySort());
        for (Task task : taskList) {
            TaskList ob = new TaskList();
            BeanUtils.copyProperties(task, ob);
            list.add(ob);
        }
        getTaskResponse.getTaskList().addAll(list);
        return getTaskResponse;
    }


}
