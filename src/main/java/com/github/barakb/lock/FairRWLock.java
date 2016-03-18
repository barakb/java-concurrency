package com.github.barakb.lock;

/**
 * Created by Barak Bar Orion
 * on 3/18/16.
 *
 * @since 11.0
 */
@SuppressWarnings("unused")
public class FairRWLock implements RWLock {


    public synchronized void acquireRead() throws InterruptedException {
    }

    public synchronized void acquireWrite() throws InterruptedException {
    }

    public synchronized void releaseRead() {
    }

    public synchronized void releaseWrite() {
    }
}
