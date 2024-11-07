package com.hussi.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import redis.clients.jedis.JedisCluster;

@Service
@RequiredArgsConstructor
public class RedisService {

    private final JedisCluster jedisCluster;

    public void write(String key, String value) {
        jedisCluster.set(key, value);
    }

    public String read(String key) {
        return jedisCluster.get(key);
    }
}
