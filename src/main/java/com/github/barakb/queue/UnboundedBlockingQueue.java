package com.github.barakb.queue;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Barak Bar Orion
 * on 3/18/16.
 *
 * @since 11.0
 */
public class UnboundedBlockingQueue<T> implements BlockingQueue<T> {
    private final List<T> values;

    public UnboundedBlockingQueue() {
        values = new ArrayList<T>();
    }

    public synchronized T get() throws InterruptedException {
        while(values.isEmpty()){
            wait();
        }
        return values.remove(0);
    }

    public synchronized void put(T t) {
        values.add(t);
        notifyAll();
    }
}
