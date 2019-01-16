package com.wanuq.flowabledemo.events;

import org.flowable.common.engine.api.delegate.event.FlowableEvent;
import org.flowable.common.engine.api.delegate.event.FlowableEntityEvent;
import org.flowable.engine.runtime.ProcessInstance;

public class ProcessStartedEventHandler {
    protected final FlowableEvent event;

    public ProcessStartedEventHandler(FlowableEvent event) {
        this.event = event;
    }

    public void run() {
        System.out.println("running task assigned event handler...");
        ProcessInstance process = (ProcessInstance) ((FlowableEntityEvent) event).getEntity();
        System.out.println("process name is: " + process.getName());
    }
}
