package com.example.simpleleakybucketratelimiter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class BucketService {
    private final Logger logger = LoggerFactory.getLogger(BucketService.class);
    private final Bucket bucket;

    public BucketService(Bucket bucket) {
        this.bucket = bucket;
    }

    @Scheduled(fixedDelay = 2500)
    public void doSomething() {
        if (bucket.isEmpty()) {
            logger.info("bucket is empty.");
            return;
        }
        String id = bucket.pop();
        logger.info("id({}) do something, queue size={}", id, bucket.size());
    }
}
