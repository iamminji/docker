package com.example.simpletokenreatelimitter;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class TokenRefiller {

    private final TokenBucket tokenBucket;

    public TokenRefiller(TokenBucket tokenBucket) {
        this.tokenBucket = tokenBucket;
    }

    @Scheduled(fixedRate = 2000)
    public void refill() {
        this.tokenBucket.refill();
    }
}
