package com.productapp.data;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.productapp.data.dao.product.ProductDao;
import org.productapp.domain.Product;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/spring/product-servlet.xml")
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
@Transactional
public class ProductDaoImplTest {

    private Logger logger = LoggerFactory.getLogger(ProductDaoImplTest.class);
    @Autowired
    private ProductDao productDao;

    @Test
    public void testInsert() throws Exception {
        Product product = new Product();
        product.setName("Shoes");
        product.setDescription("A pair of shoes");
        Product result = productDao.insert(product);
        assertTrue(result.getId() != null);
    }

    @Test
    public void testGet() throws Exception{
        Product product = productDao.get(1L);
        assertTrue(product != null);
    }

    @Test
    public void testDelete() throws Exception{
        productDao.delete(1L);
        assertNull(productDao.get(1L));
    }

    @Test
    public void testUpdate() throws Exception {
        Product product = productDao.get(1L);
        product.setName("NEW NAME");
        product.setDescription("NEW DESCRIPTION");
        Product result = productDao.update(product);
        assertEquals("NEW NAME",result.getName());
        assertEquals("NEW DESCRIPTION",result.getDescription());
        result = productDao.get(1L);
        assertEquals("NEW NAME",result.getName());
        assertEquals("NEW DESCRIPTION",result.getDescription());
    }
}
