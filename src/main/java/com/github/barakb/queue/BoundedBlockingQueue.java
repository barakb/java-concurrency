package com.github.barakb.queue;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Barak Bar Orion
 * on 3/18/16.
 *
 * @since 11.0
 */
@SuppressWarnings({"unused", "WeakerAccess"})
public class BoundedBlockingQueue<T> implements BlockingQueue<T> {
    private final List<T> values;
    private final int maxSize;

    @SuppressWarnings({"unused", "WeakerAccess"})
    public BoundedBlockingQueue(int maxSize) {
        this.maxSize = maxSize;
        values = new ArrayList<>();
    }

    public synchronized T get() throws InterruptedException {
        while(values.isEmpty()){
            wait();
        }
        notifyAll();
        return values.remove(0);
    }

    public synchronized void put(T t) throws InterruptedException {
        while(maxSize <= values.size()){
            wait();
        }
        values.add(t);
        notifyAll();
    }
}
