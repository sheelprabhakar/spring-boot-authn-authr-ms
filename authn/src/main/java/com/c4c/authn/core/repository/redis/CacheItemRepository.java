

package com.c4c.authn.core.repository.redis;

import com.c4c.authn.core.repository.redis.dao.CacheItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CacheItemRepository extends JpaRepository<CacheItem, String> {
}
