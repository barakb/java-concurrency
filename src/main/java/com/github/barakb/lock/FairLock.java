package com.github.barakb.lock;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Barak Bar Orion
 * on 3/18/16.
 *
 * @since 11.0
 */
@SuppressWarnings("unused")
public class FairLock implements Lock {
    private List<Thread> waitingList;

    private Thread lockOwner;

    @SuppressWarnings("unused")
    public FairLock() {
        waitingList = new ArrayList<>();
    }

    public synchronized void acquire() throws InterruptedException {
        waitingList.add(Thread.currentThread());

        while ((lockOwner != null) || (waitingList.get(0) != Thread.currentThread())) {
            wait();
        }
        lockOwner = waitingList.remove(0);
    }

    public synchronized void release() {
        if (lockOwner == Thread.currentThread()) {
            lockOwner = null;
            notifyAll();
        } else {
            throw new IllegalStateException("try to release lock not owned, thread: " + Thread.currentThread());
        }

    }
}
