package com.example.simpleleakybucketratelimiter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SimpleController {

    private final Logger logger = LoggerFactory.getLogger(SimpleController.class);

    private final Bucket bucket;

    public SimpleController(Bucket bucket) {
        this.bucket = bucket;
    }

    @GetMapping("/take/{id}")
    public ResponseEntity<String> take(@PathVariable String id) {
        try {
            bucket.add(id);
            return ResponseEntity.ok().body("success");
        } catch (IllegalStateException ignore) {
            logger.warn("Bucket size is full. ignore {}", id);
            return ResponseEntity.status(HttpStatus.TOO_MANY_REQUESTS).body("too many requests");
        }
    }
}
