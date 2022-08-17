package com.c4c.authn.adapter.impl;

import com.c4c.authn.adapter.api.RestAdapterV1;
import com.c4c.authn.core.repository.db.dao.UserDO;
import com.c4c.authn.core.service.api.UserService;
import com.c4c.authn.rest.resource.UserResource;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class RestAdapterV1Impl implements RestAdapterV1 {

    private final UserService userService;
    public RestAdapterV1Impl(final UserService userService) {
        this.userService = userService;
    }

    @Override
    public List<UserResource> getAllUsers() {
        List<UserResource> userResources = new ArrayList<>();
        List<UserDO> userDOList = this.userService.getAllUsers();
        userDOList.forEach(userDO -> {
            userResources.add(new UserResource(userDO.getId(), userDO.getName(), userDO.getEmail(), userDO.isEnabled(), null));
        });
        return userResources;
    }
}
