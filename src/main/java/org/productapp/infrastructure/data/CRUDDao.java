package org.productapp.infrastructure.data;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: shiraaz
 * Date: 2013/07/28
 * Time: 9:16 AM
 * To change this template use File | Settings | File Templates.
 */
public interface CRUDDao<T, PK extends Serializable> {
    T get(PK id);

    T insert(T entity);

    T update(T entity);

    void delete(T entity);

    void delete(PK id);
}
