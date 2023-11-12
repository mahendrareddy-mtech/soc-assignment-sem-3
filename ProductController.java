package com.store.demo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    private ProductService service;

    @GetMapping("/getProduct/{id}")
    public ProductDTO getStudents(@PathVariable String id) {


        ProductDTO product;
        product =  service.getProductById(id);
        return product;
    }


    @PostMapping(path = "/addProduct", consumes = { "application/json" })
    public Product postProduct(@RequestBody Product prod) {

        return service.saveProduct(prod);

    }

    @DeleteMapping(path = "/deleteProduct/{id}")
    public  Product deleteProduct(@PathVariable("id") String id){
        service.deleteProductById(id);
        return new Product();
    }

    @PutMapping(path = "/updateProduct", consumes = { "application/json" })
    public Product updateProduct(@RequestBody Product prod) {

        return service.updateProduct(prod, prod.getProductId());

    }

    @GetMapping("/getProductsList")
    public List<Product> getAllProducts() {

       return service.fetchProducttList();

    }

}
