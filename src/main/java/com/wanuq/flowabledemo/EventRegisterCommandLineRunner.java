package com.wanuq.flowabledemo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.flowable.engine.RuntimeService;

@Component
class EventRegisterCommandLineRunner implements CommandLineRunner {

    protected final RuntimeService runtimeService;

    public EventRegisterCommandLineRunner(RuntimeService runtimeService) {
        this.runtimeService = runtimeService;
    }

    @Override
    public void run(String... args) {
        System.out.println("register flowable event listener...");
        MyEventListener e = new MyEventListener();
        runtimeService.addEventListener(e);
    }
}
