package com.c4c.authn.core.repository;

import com.c4c.authn.core.repository.dao.UserDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends JpaRepository<UserDO, Integer> {
}
