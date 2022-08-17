package com.c4c.authn.core.service.impl;

import com.c4c.authn.core.repository.redis.CacheItemRepository;
import com.c4c.authn.core.repository.redis.dao.CacheItem;
import com.c4c.authn.core.service.api.CacheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RedisCacheServiceImpl implements CacheService {

    @Autowired
    private CacheItemRepository brandRepository;

    @Override
    public void add(CacheItem response){
        this.brandRepository.save(response);
    }

    @Override
    public boolean exists(String id){
        return !this.brandRepository.findById(id).isEmpty();
    }
}
