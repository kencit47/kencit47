package com.wtf.springbootone.redis;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/redis")
@RequiredArgsConstructor
class RedisController {
    private final RedisRepository redisRepository;


    @PostMapping
    public RedisEntity save(@RequestBody final RedisEntity redis) {
        return redisRepository.save(redis);
    }

    @GetMapping
    public List findAll() {
        return redisRepository.findAll();
    }
}
