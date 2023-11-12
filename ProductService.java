package com.store.demo;

import java.util.List;



public interface ProductService {
    Product saveProduct(Product product);

    // Read operation
    List<Product> fetchProducttList();

    // Update operation
    Product updateProduct(Product product,
                                String id);


    void deleteProductById(String id);

    ProductDTO getProductById(String id);
}
