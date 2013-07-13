package org.productapp.data.dao;

import org.productapp.domain.Product;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class ProductDao {

    @PersistenceContext
    EntityManager entityManager;

    @Transactional
    public List<Product> getAll(){
        return entityManager.createNamedQuery("product.findAll",Product.class).getResultList();
    }

    @Transactional
    public Product get(Long id){
        return entityManager.find(Product.class,id);
    }

    @Transactional
    public Product insert(Product product){
        entityManager.persist(product);
        return product;
    }

    @Transactional
    public Product update(Product product){
        return entityManager.merge(product);
    }

    @Transactional
    public void delete(Long id){
        Product product = get(id);
        entityManager.remove(product);
    }
}
