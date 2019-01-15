package com.wanuq.flowabledemo;

import java.util.List;
import java.util.stream.Collectors;

import org.flowable.engine.TaskService;
import org.flowable.task.api.Task;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TaskController {

    protected final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping("/tasks/")
    public List<Task> getTaskList() {
        // return repositoryService.createProcessDefinitionQuery()
        //     .latestVersion()
        //     .list()
        //     .stream()
        //     .map(ProcessDefinition::getKey)
        //     .collect(Collectors.toList());

        return taskService.createTaskQuery().taskAssignee("9527").list().stream().collect(Collectors.toList());
    }

}
