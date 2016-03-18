package com.github.barakb.lock;

/**
 * Created by Barak Bar Orion
 * on 3/18/16.
 *
 * @since 11.0
 */
@SuppressWarnings("WeakerAccess")
public interface RWLock {
    @SuppressWarnings("unused")
    void acquireRead() throws InterruptedException;
    @SuppressWarnings("unused")
    void acquireWrite() throws InterruptedException;
    @SuppressWarnings("unused")
    void releaseRead();
    @SuppressWarnings("unused")
    void releaseWrite();

}
