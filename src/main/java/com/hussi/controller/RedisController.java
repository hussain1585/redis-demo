package com.hussi.controller;

import com.hussi.service.RedisService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.JedisPool;

@RestController
@RequestMapping("/redis")
@RequiredArgsConstructor
public class RedisController {


    private final RedisService redisService;

    @PostMapping("/set")
    public String setKey(@RequestParam String key, @RequestParam String value) {

        redisService.write(key, value);
        return "Key-Value pair set successfully!";
    }

    @GetMapping("/get")
    public String getKey(@RequestParam String key) {
        return redisService.read(key);
    }
}