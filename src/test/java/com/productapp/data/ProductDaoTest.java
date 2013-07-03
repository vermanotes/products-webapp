package com.productapp.data;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.productapp.data.dao.ProductDao;
import org.productapp.domain.Product;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/spring/product-servlet.xml")
public class ProductDaoTest {

    private Logger logger = LoggerFactory.getLogger(ProductDaoTest.class);
    @Autowired
    private ProductDao productDao;

    @Test
    public void testInsert() throws Exception {
        Product product = new Product();
        product.setName("Shoes");
        product.setDescription("A pair of shoes");
        productDao.insert(product);
        logger.info(product.toString());
    }
}
