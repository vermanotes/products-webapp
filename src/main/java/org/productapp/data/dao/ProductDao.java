package org.productapp.data.dao;

import org.productapp.domain.Product;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public class ProductDao {

    @PersistenceContext(unitName = "productDB")
    EntityManager entityManager;

    public List<Product> getAll(){
        return entityManager.createNamedQuery("product.findAll",Product.class).getResultList();
    }

    public Product get(Long id){
        return entityManager.find(Product.class,id);
    }

    public void insert(Product product){
        entityManager.persist(product);
    }

    public Product update(Product product){
        return entityManager.merge(product);
    }

    public void delete(Long id){
        entityManager.remove(id);
    }
}
