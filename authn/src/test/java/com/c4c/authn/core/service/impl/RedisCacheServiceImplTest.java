package com.c4c.authn.core.service.impl;

import com.c4c.authn.BaseServiceTest;
import com.c4c.authn.core.repository.redis.dao.CacheItem;
import com.c4c.authn.core.service.api.CacheService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RedisCacheServiceImplTest extends BaseServiceTest {
    @Autowired
    private CacheService cacheService;

    @Test
    public void test_add_ok() throws InterruptedException {
        this.cacheService.add(new CacheItem(5L, "ID1"));
        assertTrue(this.cacheService.exists("ID1"));

        Thread.sleep(6000);

        assertFalse(this.cacheService.exists("ID1"));
    }
}
