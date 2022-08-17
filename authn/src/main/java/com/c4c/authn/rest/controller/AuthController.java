package com.c4c.authn.rest.controller;

import com.c4c.authn.adapter.api.RestAdapterV1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController extends BaseController {
    @Autowired
    public AuthController(RestAdapterV1 restAdapterV1) {
        super(restAdapterV1);
    }

}
