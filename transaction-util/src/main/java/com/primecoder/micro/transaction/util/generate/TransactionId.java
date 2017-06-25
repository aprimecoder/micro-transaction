package com.primecoder.micro.transaction.util.generate;

import java.util.UUID;

/**
 * Created by primecoder on 2017/6/25.
 * E-mail : aprimecoder@gmail.com
 */
public class TransactionId {

    public static String generate() {

        return UUID.randomUUID().toString();
    }
}
