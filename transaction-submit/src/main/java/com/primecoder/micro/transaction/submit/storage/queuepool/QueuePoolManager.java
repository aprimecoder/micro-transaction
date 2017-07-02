package com.primecoder.micro.transaction.submit.storage.queuepool;

import org.apache.commons.pool2.impl.GenericObjectPool;

import java.util.Queue;

/**
 * Created by primecoder on 2017/7/1.
 * E-mail : aprimecoder@gmail.com
 */
public class QueuePoolManager {


    public static final QueuePoolManager instance = new QueuePoolManager();

    private GenericObjectPool<Queue<Object>> genericObjectPool;

    private QueuePoolManager() {

        QueuePoolFactory queuePoolFactory = new QueuePoolFactory();
        genericObjectPool = new GenericObjectPool<Queue<Object>>(queuePoolFactory);
    }

    public static synchronized QueuePoolManager getInstance() {

        return instance;
    }

    public Queue<Object> getQueue() throws Exception {

        return genericObjectPool.borrowObject();
    }

    public void returnQueue(Queue<Object> queue) {

        genericObjectPool.returnObject(queue);
    }

}
