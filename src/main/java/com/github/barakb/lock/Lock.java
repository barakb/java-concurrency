package com.github.barakb.lock;

/**
 * Created by Barak Bar Orion
 * on 3/18/16.
 *
 * @since 11.0
 */
public interface Lock {
    void acquire() throws InterruptedException;
    void release();
}
