package org.productapp.data.dao.product;

import org.productapp.domain.Product;
import org.productapp.infrastructure.jpa.AbstractCRUDDao;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductDaoImpl extends AbstractCRUDDao<Product,Long> implements ProductDao {
    public List<Product> getAll(){
        return entityManager.createNamedQuery("product.findAll").getResultList();
    }
}
