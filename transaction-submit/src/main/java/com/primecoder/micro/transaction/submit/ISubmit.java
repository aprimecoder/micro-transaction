package com.primecoder.micro.transaction.submit;

import com.primecoder.micro.transaction.util.database.type.DataBaseType;

/**
 * Created by primecoder on 2017/6/25.
 * E-mail : aprimecoder@gmail.com
 */
public interface ISubmit<T> {

    void submit(DataBaseType dataBaseType,boolean isEND,T entity);
}
