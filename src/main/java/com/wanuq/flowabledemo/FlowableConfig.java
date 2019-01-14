package com.wanuq.flowabledemo;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
@ImportResource({"classpath*:flowable.cfg.xml"})
public class FlowableConfig {
}
