package org.productapp.data.dao.product;

import org.productapp.domain.Product;
import org.productapp.infrastructure.data.CRUDDao;

import java.util.List;

public interface ProductDao extends CRUDDao<Product,Long> {
    public List<Product> getAll();
}
