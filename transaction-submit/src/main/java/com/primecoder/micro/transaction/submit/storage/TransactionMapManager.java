package com.primecoder.micro.transaction.submit.storage;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Queue;

/**
 * Created by primecoder on 2017/7/1.
 * E-mail : aprimecoder@gmail.com
 */
public class TransactionMapManager {


    private Map<String,Queue<Object>> commitedMap;

    private Map<String,Queue<Object>> uncommitedMap;

    private static final TransactionMapManager instance = new TransactionMapManager();

    private TransactionMapManager() {

        commitedMap = new HashMap<String, Queue<Object>>();

        uncommitedMap = new HashMap<String, Queue<Object>>();
    }

    public static synchronized TransactionMapManager getInstance() {

        return instance;
    }

    public void put(String transactionId,Object entity,boolean commited) {

        if (commited) {

            Queue<Object> queue = commitedMap.get(transactionId);
            queue.add(entity);

        } else {

            Queue<Object> queue = uncommitedMap.get(transactionId);
            queue.add(entity);
        }
    }

    public void rollback(String transactionId) {

        Queue<Object> queue = commitedMap.get(transactionId);
        Iterator<Object> iter = queue.iterator();
        while(iter.hasNext()) {
            Object obj = iter.next();
        }
    }

    public void commit(String transactionId) {

        Queue<Object> queue = uncommitedMap.get(transactionId);
        Object obj = queue.poll();
        while (obj != null) {
            //commit transaction
            commitedMap.get(transactionId).add(obj);
            obj = queue.poll();
        }
    }
}
