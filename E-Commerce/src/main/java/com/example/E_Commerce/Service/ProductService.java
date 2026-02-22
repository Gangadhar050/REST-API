package com.example.E_Commerce.Service;

import com.example.E_Commerce.Entity.Product;
import com.example.E_Commerce.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.plaf.PanelUI;
import java.security.PublicKey;
import java.util.List;

@Service
public class ProductService {

    // 1. FIeld Injection
    @Autowired
    private ProductRepository productRepository;

    // 2. Constructor Injection
//    private  ProductRepository productRepository2;
//    public ProductService(ProductRepository productRepository){
//        this.productRepository2=productRepository;
//    }

    // 3. Setter Injection


    public String createProduct(Product product){
        productRepository.save(product);
        return "Product saved successfully"+product;

    }

    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }

    public Product deleteProductById(Long id){
        Product product=productRepository.findById(id)
                .orElseThrow(()->new RuntimeException("Product not found with id: "+id));

        return product;
    }

    public List<Product>findByNameAndPrice(String name,float price){
      return   productRepository.findByNameAndPrice(name, price);

    }


    public List<Product> findProductByNameJPQL(String name) {
        return productRepository.findProductByNameJPQL(name);
    }
}
