package org.productapp.data.dao;

import org.productapp.domain.Product;
import org.productapp.infrastructure.data.CRUDDao;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: shiraaz
 * Date: 2013/07/28
 * Time: 9:44 AM
 * To change this template use File | Settings | File Templates.
 */
public interface ProductDao extends CRUDDao<Product,Long> {
    public List<Product> getAll();
}
