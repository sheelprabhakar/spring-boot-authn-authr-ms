package com.c4c.authn.rest.resource;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserResource {
    private UUID id;
    @NotNull
    private String name;
    @NotNull
    private String email;
    private boolean enabled;
    private String password;
}
