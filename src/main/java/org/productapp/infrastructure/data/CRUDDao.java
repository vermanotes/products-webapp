package org.productapp.infrastructure.data;

import java.io.Serializable;

public interface CRUDDao<T, PK extends Serializable> {
    T get(PK id);

    T insert(T entity);

    T update(T entity);

    void delete(T entity);

    void delete(PK id);
}
