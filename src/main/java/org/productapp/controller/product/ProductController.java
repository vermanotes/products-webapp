package org.productapp.controller.product;

import org.productapp.data.dao.product.ProductDao;
import org.productapp.domain.Product;
import org.productapp.infrastructure.jaxb.GenericListElementWrapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/products")
public class ProductController {
    Logger logger = LoggerFactory.getLogger(ProductController.class);

    @Autowired
    ProductDao productDao;


    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView getAllProducts(){
        ModelAndView result = new ModelAndView("index");
        GenericListElementWrapper<Product> products = new GenericListElementWrapper<>();

        products.setList(productDao.getAll());
        ModelMap modelMap = new ModelMap();
        modelMap.addAttribute("products",products);
        result.addAllObjects(modelMap);
        return result;
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public Product insert(@RequestBody Product product){
        return productDao.insert(product);
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    @ResponseBody
    public Product getProduct(@PathVariable Long id){
        return productDao.get(id);
    }

    @RequestMapping(value="/{id}" ,method = RequestMethod.PUT)
    @ResponseBody
    public Product update(@PathVariable Long id, @RequestBody Product product){
        product.setId(id);
        return productDao.update(product);
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    @ResponseBody
    public void deleteProduct(@PathVariable Long id){
        productDao.delete(id);
    }
}
