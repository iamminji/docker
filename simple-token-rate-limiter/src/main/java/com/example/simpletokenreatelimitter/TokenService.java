package com.example.simpletokenreatelimitter;

import org.springframework.stereotype.Service;

@Service
public class TokenService {

    private final TokenBucket tokenBucket;

    public TokenService(TokenBucket tokenBucket) {
        this.tokenBucket = tokenBucket;
    }

    public void take() {
        tokenBucket.take();
    }
}
