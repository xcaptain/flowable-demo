package com.wanuq.flowabledemo.events;

import org.flowable.common.engine.api.delegate.event.FlowableEvent;
import org.flowable.common.engine.api.delegate.event.FlowableEntityEvent;
import org.flowable.task.api.Task;
// import org.springframework.stereotype.Component;

public class TaskAssignedEventHandler {
    protected final FlowableEvent event;

    public TaskAssignedEventHandler(FlowableEvent event) {
        this.event = event;
    }

    public void run() {
        System.out.println("running task assigned event handler...");
        Task task = (Task) ((FlowableEntityEvent) event).getEntity();
        System.out.println("task assigneed to: " + task.getAssignee());
    }
}
