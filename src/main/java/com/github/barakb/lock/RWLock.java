package com.github.barakb.lock;

/**
 * Created by Barak Bar Orion
 * on 3/18/16.
 *
 * @since 11.0
 */
public interface RWLock {
    void acquireRead() throws InterruptedException;
    void acquireWrite() throws InterruptedException;
    void releaseRead();
    void releaseWrite();

}
