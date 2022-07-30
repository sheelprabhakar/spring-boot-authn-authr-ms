package com.c4c.authn.core.service.api;

import com.c4c.authn.core.repository.dao.UserDO;

import java.util.List;

public interface UserService {
    List<UserDO> getAllUsers();
}
