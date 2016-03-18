package com.github.barakb.lock;

/**
 * Created by Barak Bar Orion
 * on 3/18/16.
 *
 * @since 11.0
 */
@SuppressWarnings("WeakerAccess")
public interface Lock {
    @SuppressWarnings("unused")
    void acquire() throws InterruptedException;
    @SuppressWarnings("unused")
    void release();
}
