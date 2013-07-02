package com.productapp.test.common;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPABaseTestCase {
    protected static EntityManagerFactory entityManagerFactory;
    protected EntityManager entityManager;

    @BeforeClass
    public static void bootstrapEntityManagerFactory(){
        entityManagerFactory = Persistence.createEntityManagerFactory("productDB");
    }

    @AfterClass
    public static void destroyEntityManagerFactory(){
        entityManagerFactory.close();
    }

    @Before
    public void beginTransaction(){
        entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
    }

    @After
    public void rollbackTransaction(){
        if (entityManager.getTransaction().isActive()){
            entityManager.getTransaction().rollback();
        }

        if(entityManager.isOpen()){
            entityManager.close();
        }
    }

}
