package com.productapp.data;

import com.productapp.test.common.JPABaseTestCase;
import org.junit.Test;
import org.productapp.data.dao.ProductDao;
import org.productapp.domain.Product;

public class ProductDaoTest extends JPABaseTestCase{

    private ProductDao productDao;
    @Test
    public void testInsert() throws Exception {
        Product product = new Product();
        product.setName("Shoes");
        product.setDescription("A pair of shoes");
        productDao.insert(product);
    }
}
