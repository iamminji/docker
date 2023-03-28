package com.example.simpletokenreatelimitter;

import org.springframework.stereotype.Component;

@Component
public class TokenBucket {
    private final int MAX_TOKEN_SIZE = 4;
    private int currentTokenSize = 4;

    public void refill() {
        if (currentTokenSize < MAX_TOKEN_SIZE) {
            System.out.println("Add token to buckets, current bucketSize=" + currentTokenSize);
            currentTokenSize++;
        }
    }

    public void take() {
        if (currentTokenSize <= 0) {
            throw new EmptyTokenBucketException();
        }
        currentTokenSize--;
        System.out.println("Take token from buckets, current bucketSize=" + currentTokenSize);
    }
}
