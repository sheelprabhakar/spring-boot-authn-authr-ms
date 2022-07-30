package com.c4c.authn.rest.controller;

import com.c4c.authn.adapter.api.RestAdapterV1;
import com.c4c.authn.rest.resource.UserResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.c4c.authn.rest.controller.BaseController.BASE_URL;

@RestController
@RequestMapping(BASE_URL + "users/")
public class UserController extends BaseController{

    @Autowired
    public UserController(RestAdapterV1 restAdapterV1) {
        super(restAdapterV1);
    }

    @GetMapping (produces = "application/json")
    public ResponseEntity<List<UserResource>> getAll(){
        return ResponseEntity.ok().body(this.restAdapterV1.getAllUsers());
    }
}
