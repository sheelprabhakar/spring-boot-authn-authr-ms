package com.c4c.authn.rest.controller;

import com.c4c.authn.adapter.api.RestAdapterV1;
import org.springframework.web.bind.annotation.RestController;

public class BaseController {
    final RestAdapterV1 restAdapterV1;
    final static String BASE_URL ="/auth/api/V1/";

    public BaseController(final RestAdapterV1 restAdapterV1) {

        this.restAdapterV1 = restAdapterV1;
    }
}
