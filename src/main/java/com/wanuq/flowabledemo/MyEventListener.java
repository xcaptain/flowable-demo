package com.wanuq.flowabledemo;

import org.flowable.common.engine.api.delegate.event.FlowableEngineEventType;
import org.flowable.common.engine.api.delegate.event.FlowableEvent;
import org.flowable.common.engine.api.delegate.event.FlowableEventListener;

public class MyEventListener implements FlowableEventListener {

    @Override
    public void onEvent(FlowableEvent event) {
  
      if(event.getType() == FlowableEngineEventType.PROCESS_CREATED) {
        System.out.println("A process created");
      } else if (event.getType() == FlowableEngineEventType.PROCESS_STARTED) {
        System.out.println("A process started...");
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
