package com.github.barakb.queue;

/**
 * Created by Barak Bar Orion
 * on 3/18/16.
 *
 * @since 11.0
 */
interface BlockingQueue<T> {
    T get() throws InterruptedException;
    void put(T t) throws InterruptedException;
}
