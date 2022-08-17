package com.c4c.authn.core.repository.redis.dao;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.TimeToLive;

import javax.persistence.Id;
import java.util.concurrent.TimeUnit;

@RedisHash(value = "cache_item", timeToLive = 600000 )
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CacheItem {

    @TimeToLive(unit = TimeUnit.SECONDS )
    private Long ttl;

    @NotNull
    @Id
    private String id;
}

