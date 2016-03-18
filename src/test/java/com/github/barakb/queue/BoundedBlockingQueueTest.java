package com.github.barakb.queue;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;

/**
 * Created by Barak Bar Orion
 * on 3/18/16.
 *
 * @since 11.0
 */
public class BoundedBlockingQueueTest {
    private static final Logger logger = Logger.getLogger(BoundedBlockingQueueTest.class);

    private BlockingQueue<Long> blockingQueue;
    private ExecutorService executor;

    @Before
    public void setUp() throws Exception {
        blockingQueue = new BoundedBlockingQueue<>(1);
        executor = Executors.newSingleThreadExecutor();
    }

    @After
    public void tearDown() throws Exception {
        executor.shutdown();
    }

    @BeforeClass
    public static void setUpOnce() throws Exception {
        BasicConfigurator.resetConfiguration();
        BasicConfigurator.configure();
    }

    @Test(timeout = 1000)
    public void testPutGet() throws Exception {
        blockingQueue.put(1L);

        final AtomicBoolean done = new AtomicBoolean(false);
        final CyclicBarrier barrier = new CyclicBarrier(2);
        executor.execute(() -> {
            try {
                barrier.await();
                blockingQueue.put(2L);
                done.set(true);
                barrier.await();
            } catch (Throwable t) {
                logger.error(t, t);
            }
        });
        barrier.await();
        assertThat(done.get(), is(false));
        assertThat(blockingQueue.get(), equalTo(1L));
        barrier.await();
        assertThat(blockingQueue.get(), equalTo(2L));
        assertThat(done.get(), is(true));
    }
}