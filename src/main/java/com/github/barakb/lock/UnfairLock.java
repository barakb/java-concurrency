package com.github.barakb.lock;

/**
 * Created by Barak Bar Orion
 * on 3/18/16.
 *
 * @since 11.0
 */
@SuppressWarnings("unused")
public class UnfairLock implements Lock{
    private Thread lockOwner;

    public synchronized void acquire() throws InterruptedException {
        while(lockOwner != null){
            wait();
        }
        lockOwner = Thread.currentThread();
    }

    public synchronized void release() {
        if(lockOwner == Thread.currentThread()){
            lockOwner = null;
            notifyAll();
        }else{
            throw new IllegalStateException("try to release lock not owned, thread: " + Thread.currentThread());
        }

    }
}
