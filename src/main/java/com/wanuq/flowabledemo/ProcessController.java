package com.wanuq.flowabledemo;

import org.flowable.engine.RuntimeService;
import org.flowable.engine.runtime.ProcessInstance;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProcessController {

    protected final RuntimeService runtimeService;

    public ProcessController(RuntimeService runtimeService) {
        this.runtimeService = runtimeService;
    }

    @PostMapping("/process/")
    public void createProcess() {
        // return repositoryService.createProcessDefinitionQuery()
        // .latestVersion()
        // .list()
        // .stream()
        // .map(ProcessDefinition::getKey)
        // .collect(Collectors.toList());

        ProcessInstance process = runtimeService.startProcessInstanceById("invoice_approval_flow:52:bf19d6c9-17e2-11e9-936f-0242ac110002");
        // String instanceID = processService.startProcessInstanceByKey("invoice_approval_flow",
        //         "invoice_approval_flow:52:bf19d6c9-17e2-11e9-936f-0242ac110002", null, true, null);
        System.out.println("process started success: " + process);
    }

}
