package com.wanuq.flowabledemo;

import org.flowable.idm.api.IdmIdentityService;
import org.flowable.idm.api.Privilege;
import org.flowable.idm.api.User;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class UserCreatorCommandLineRunner implements CommandLineRunner {

    protected final IdmIdentityService idmIdentityService;

    public UserCreatorCommandLineRunner(IdmIdentityService idmIdentityService) {
        this.idmIdentityService = idmIdentityService;
    }

    @Override
    public void run(String... args) {
        createUserIfNotExists("flowfest");
        createUserIfNotExists("flowfest-actuator");
        createUserIfNotExists("flowfest-rest");

        if (idmIdentityService.createPrivilegeQuery().privilegeName("access-rest-api").count() == 0) {
            Privilege restPrivilege = idmIdentityService.createPrivilege("access-rest-api");
            idmIdentityService.addUserPrivilegeMapping(restPrivilege.getId(), "flowfest-rest");
        }

        if (idmIdentityService.createPrivilegeQuery().privilegeName("ROLE_ACTUATOR").count() == 0) {
            Privilege restPrivilege = idmIdentityService.createPrivilege("ROLE_ACTUATOR");
            idmIdentityService.addUserPrivilegeMapping(restPrivilege.getId(), "flowfest-actuator");
        }
    }

    protected void createUserIfNotExists(String username) {
        if (idmIdentityService.createUserQuery().userId(username).count() == 0) {
            User user = idmIdentityService.newUser(username);
            user.setPassword("test");
            idmIdentityService.saveUser(user);
        }
    }
}
