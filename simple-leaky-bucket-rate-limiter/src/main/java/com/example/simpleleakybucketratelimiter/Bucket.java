package com.example.simpleleakybucketratelimiter;

import org.springframework.stereotype.Component;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

@Component
public class Bucket {

    private final Queue<String> queue;

    public Bucket() {
        this.queue = new ArrayBlockingQueue<>(5);
    }

    public void add(String id) {
        queue.add(id);
    }

    public String pop() {
        return queue.poll();
    }

    public int size() {
        return queue.size();
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }
}
