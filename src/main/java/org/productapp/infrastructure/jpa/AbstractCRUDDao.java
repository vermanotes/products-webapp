package org.productapp.infrastructure.jpa;

import org.productapp.infrastructure.data.CRUDDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;

public abstract class AbstractCRUDDao<T, PK extends Serializable> implements CRUDDao<T,PK> {

    private Logger logger = LoggerFactory.getLogger(AbstractCRUDDao.class);

    @PersistenceContext
    protected EntityManager entityManager;

    protected Class<T> entityClass;

    public AbstractCRUDDao(){
        ParameterizedType genericSuperClass = (ParameterizedType)
                getClass().getGenericSuperclass();
        entityClass = (Class<T>) genericSuperClass.getActualTypeArguments()[0];
    }

    @Override
    @Transactional
    public T get(PK id){
        logger.debug("Obtaining entity from database");
        return entityManager.find(entityClass, id);
    }

    @Override
    @Transactional
    public T insert(T entity){
        logger.debug("Inserting entity into database");
        entityManager.persist(entity);
        return entity;
    }

    @Override
    @Transactional
    public T update(T entity){
        logger.debug("Updating existing database entity");
        entityManager.merge(entity);
        return entity;
    }

    @Override
    @Transactional
    public void delete(T entity){
        logger.debug("Removing entity from database");
        entityManager.remove(entity);
    }

    @Override
    @Transactional
    public void delete(PK id){
        logger.debug("Removing entity from database using ID" + id.toString());
        T entity = get(id);
        entityManager.remove(entity);
    }
}
