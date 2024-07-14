package com.example.pubsub;

import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class PublishController {

    private final RedisTemplate<String, String > redistemplate;

    @PostMapping("events/users/deregister")
    void publishUserDeregisterEvent() {
        redistemplate.convertAndSend("users:unregister", "500");
    }
}
