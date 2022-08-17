package com.c4c.authn.core.repository.db.dao;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.UUID;

@Entity(name= "users")
@Data
public class UserDO {
    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false, columnDefinition="varchar(36) PRIMARY KEY")
    private UUID id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "email", unique = true, nullable = false)
    private String email;

    @Column(name = "mobile_no_with_country_code", nullable = true)
    private String mobileNoWithCountryCode;

    @Column(name = "password", length = 45, nullable = true)
    private String password;

    @Column(name = "enabled", nullable = true, columnDefinition="boolean default true")
    private boolean enabled = true;
}
