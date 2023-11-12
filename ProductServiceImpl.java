package com.store.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    private ProductRepository productRepository;
    @Override
    public Product saveProduct(Product prod) {
        return productRepository.save(prod);
    }

    @Override
    public List<Product> fetchProducttList() {
        return productRepository.findAll();
    }

    @Override
    public Product updateProduct(Product product, String id) {
        return productRepository.save(product);
    }

    @Override
    public void deleteProductById(String id) {
        productRepository.deleteById(id);

    }

    @Override
    public ProductDTO getProductById(String id) {
        Product product =  productRepository.getById(id);
        System.out.println("testing::"+product.getProductId()+"::"+product.getDescription());
        return new ProductDTO(product.getProductId(),product.getName(),product.getDescription(), product.getPrice(), product.getCategory());
    }

}
