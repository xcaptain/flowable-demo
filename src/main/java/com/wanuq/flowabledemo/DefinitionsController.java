package com.wanuq.flowabledemo;

import java.util.List;
import java.util.stream.Collectors;

import org.flowable.engine.RepositoryService;
import org.flowable.engine.repository.ProcessDefinition;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DefinitionsController {

    protected final RepositoryService repositoryService;

    public DefinitionsController(RepositoryService repositoryService) {
        this.repositoryService = repositoryService;
    }

    @GetMapping("/latest-definitions")
    public List<String> latestDefinitions() {
        return repositoryService.createProcessDefinitionQuery()
            .latestVersion()
            .list()
            .stream()
            .map(ProcessDefinition::getId)
            .collect(Collectors.toList());
    }

}
