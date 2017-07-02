package com.primecoder.micro.transaction.submit.storage.queuepool;

import org.apache.commons.pool2.PooledObject;
import org.apache.commons.pool2.PooledObjectFactory;
import org.apache.commons.pool2.impl.DefaultPooledObject;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by primecoder on 2017/7/1.
 * E-mail : aprimecoder@gmail.com
 */
public class QueuePoolFactory implements PooledObjectFactory<Queue<Object>> {


    public PooledObject<Queue<Object>> makeObject() throws Exception {

        Queue<Object> queue = new LinkedList<Object>();

        return new DefaultPooledObject<Queue<Object>>(queue);
    }

    public void destroyObject(PooledObject<Queue<Object>> pooledObject) throws Exception {

        Queue<Object> queue = pooledObject.getObject();

        queue = null;

    }

    public boolean validateObject(PooledObject<Queue<Object>> pooledObject) {
        return true;
    }

    public void activateObject(PooledObject<Queue<Object>> pooledObject) throws Exception {

        System.out.println("activate!");
    }

    public void passivateObject(PooledObject<Queue<Object>> pooledObject) throws Exception {

        pooledObject.getObject().clear();

        System.out.println("passivate Object");
    }
}
