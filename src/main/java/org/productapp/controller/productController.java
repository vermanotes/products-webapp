package org.productapp.controller;

import org.productapp.data.dao.ProductDao;
import org.productapp.domain.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/products")
public class ProductController {

    @Autowired
    ProductDao productDao;

    @RequestMapping(method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<Product> getAllProducts(){
        return productDao.getAll();
    }

    @RequestMapping(method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Product insert(@RequestBody Product product){
        return productDao.insert(product);
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Product getProduct(@PathVariable Long id){
        return productDao.get(id);
    }

    @RequestMapping(value="/{id}" ,method = RequestMethod.PUT,consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Product update(@PathVariable Long id, @RequestBody Product product){
        product.setId(id);
        return productDao.update(product);
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE,produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void deleteProduct(@PathVariable Long id){
        productDao.delete(id);
    }
}
