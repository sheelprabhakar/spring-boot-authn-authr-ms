package com.c4c.authn.adapter.api;

import com.c4c.authn.rest.resource.UserResource;

import java.util.List;

public interface RestAdapterV1 {
    List<UserResource> getAllUsers();
}
