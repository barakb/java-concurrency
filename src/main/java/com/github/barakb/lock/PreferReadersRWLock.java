package com.github.barakb.lock;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Barak Bar Orion
 * on 3/18/16.
 *
 * @since 11.0
 */
public class PreferReadersRWLock implements RWLock {

    public synchronized void acquireRead() throws InterruptedException {
    }

    public synchronized  void acquireWrite() throws InterruptedException {

    }

    public synchronized void releaseRead() {
    }

    public synchronized  void releaseWrite() {
    }
}
