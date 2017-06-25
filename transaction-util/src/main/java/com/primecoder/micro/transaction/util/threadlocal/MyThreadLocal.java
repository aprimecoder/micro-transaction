package com.primecoder.micro.transaction.util.threadlocal;

/**
 * Created by primecoder on 2017/6/25.
 * E-mail : aprimecoder@gmail.com
 */
public class MyThreadLocal {

    public static final ThreadLocal<String> TransactionIdThreadLocal = new ThreadLocal();

}
