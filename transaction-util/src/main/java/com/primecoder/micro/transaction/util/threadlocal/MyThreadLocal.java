package com.primecoder.micro.transaction.util.threadlocal;

/**
 * Created by primecoder on 2017/6/25.
 * E-mail : aprimecoder@gmail.com
 */
public class MyThreadLocal {

    public static final ThreadLocal threadLocal = new ThreadLocal();

    public static void set(Object value) {

        threadLocal.set(value);
    }

    public static void unset() {

        threadLocal.remove();
    }

    public static Object get() {

        return threadLocal.get();
    }
}
