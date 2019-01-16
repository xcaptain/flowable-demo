package com.wanuq.flowabledemo;

import org.flowable.common.engine.api.delegate.event.FlowableEngineEventType;
import org.flowable.common.engine.api.delegate.event.FlowableEvent;
import org.flowable.common.engine.api.delegate.event.FlowableEventListener;
import org.springframework.stereotype.Component;

import com.wanuq.flowabledemo.events.ProcessStartedEventHandler;
import com.wanuq.flowabledemo.events.TaskAssignedEventHandler;

@Component
public class MyEventListener implements FlowableEventListener {

    @Override
    public void onEvent(FlowableEvent event) {
  
      if(event.getType() == FlowableEngineEventType.PROCESS_CREATED) {
        System.out.println("A process created");
      } else if (event.getType() == FlowableEngineEventType.PROCESS_STARTED) {
        System.out.println("A process started...");
        ProcessStartedEventHandler handler = new ProcessStartedEventHandler(event);
        handler.run();
      } else if (event.getType() == FlowableEngineEventType.TASK_CREATED) {
        System.out.println("A task created...");
      } else if (event.getType() == FlowableEngineEventType.TASK_ASSIGNED) {
        System.out.println("A task assigned...");
        TaskAssignedEventHandler handler = new TaskAssignedEventHandler(event);
        handler.run();
      } else if (event.getType() == FlowableEngineEventType.TASK_COMPLETED) {
        System.out.println("A task completed...");
      } else {
        System.out.println("Event received: " + event.getType());
      }
    }
  
    @Override
    public boolean isFailOnException() {
      // The logic in the onEvent method of this listener is not critical, exceptions
      // can be ignored if logging fails...
      return false;
    }
  
    @Override
    public boolean isFireOnTransactionLifecycleEvent() {
      return false;
    }
  
    @Override
    public String getOnTransaction() {
      return null;
    }
  }
