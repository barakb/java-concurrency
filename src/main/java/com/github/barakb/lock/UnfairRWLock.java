package com.github.barakb.lock;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Barak Bar Orion
 * on 3/18/16.
 *
 * @since 11.0
 */
@SuppressWarnings("unused")
public class UnfairRWLock implements RWLock {
    private Set<Thread> owners;
    private int readers;
    private int writers;

    public UnfairRWLock() {
        owners = new HashSet<>();
    }

    public synchronized void acquireRead() throws InterruptedException {
        while(0 < writers){
            wait();
        }
        owners.add(Thread.currentThread());
        readers += 1;
    }

    public synchronized  void acquireWrite() throws InterruptedException {
        while(0 < writers || 0 < readers){
            wait();
        }
        owners.add(Thread.currentThread());
        writers += 1;

    }

    public synchronized void releaseRead() {
        if(!owners.remove(Thread.currentThread())){
            throw new IllegalStateException("try to release unfair lock by thread that does not own the lock" + Thread.currentThread());
        }
        readers -= 1;
        notifyAll();
    }

    public synchronized  void releaseWrite() {
        if(!owners.remove(Thread.currentThread())){
            throw new IllegalStateException("try to release unfair lock by thread that does not own the lock" + Thread.currentThread());
        }
        writers -= 1;
        notifyAll();
    }
}
