package com.github.barakb.queue;

import org.apache.log4j.BasicConfigurator;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

/**
 * Created by Barak Bar Orion
 * on 3/18/16.
 *
 * @since 11.0
 */
public class UnboundedBlockingQueueTest {
    private BlockingQueue<Long> blockingQueue;

    @Before
    public void setUp() throws Exception {
        blockingQueue = new UnboundedBlockingQueue<>();
    }

    @BeforeClass
    public static void setUpOnce() throws Exception {
        BasicConfigurator.resetConfiguration();
        BasicConfigurator.configure();
    }

    @Test(timeout = 1000)
    public void testPutGet() throws Exception {
        blockingQueue.put(1L);
        assertThat(blockingQueue.get(), equalTo(1L));
    }
}