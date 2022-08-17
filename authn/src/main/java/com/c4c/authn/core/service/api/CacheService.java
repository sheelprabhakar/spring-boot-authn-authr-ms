package com.c4c.authn.core.service.api;

import com.c4c.authn.core.repository.redis.dao.CacheItem;

public interface CacheService {
    void add(CacheItem response);

    boolean exists(String id);
}
