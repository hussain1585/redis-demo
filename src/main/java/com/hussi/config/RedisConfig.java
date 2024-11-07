package com.hussi.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.HostAndPort;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Configuration
public class RedisConfig {

//    @Value("${redis.cluster.nodes}")
    @Value("${spring.redis.cluster.nodes}")
    private String clusterNodes;

    @Bean
    public JedisCluster jedisCluster() {
        Set<HostAndPort> nodeSet = Arrays.stream(clusterNodes.split(","))
                .map(node -> {
                    String[] parts = node.split(":");
                    String host = parts[0];
                    int port = Integer.parseInt(parts[1]);
                    return new HostAndPort(host, port);
                })
                .collect(Collectors.toSet());

        return new JedisCluster(nodeSet);
    }

}