package com.example.E_Commerce.Controller;

import com.example.E_Commerce.Entity.Product;
import com.example.E_Commerce.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController // vs Controller
@RequestMapping("/api/v1")
public class ProductController {

    List<String>products = new ArrayList<>();

    @Autowired
   private ProductService productService;


    @PostMapping("/products")
    public String createProduct(@RequestBody Product product){
     return productService.createProduct(product);
    }

    @GetMapping("/getProducts")
    public  List<Product>getProducts(){
        return productService.getAllProducts();
    }


    @DeleteMapping("/deleteproducts/{id}")
    public void deleteProductById(@RequestParam Long id){
        productService.deleteProductById(id);
    }

   @GetMapping("/products/search")
   public List<Product> searchProducts(@RequestParam String name,@RequestParam float price){
       return productService.findByNameAndPrice(name, price);
   }
    @GetMapping("/products/search/jpql")
    public List<Product> searchProductByNameJPQL(@RequestParam String name){
        return productService.findProductByNameJPQL(name);
    }



    @PutMapping("/products/{id}")
    public String updateProduct(@PathVariable int id){
        if(id>=0 && id<products.size()){
            products.set(id,"updated product");
            return "product updated";
        }
        return "product not found";
    }

    @ExceptionHandler(Exception.class)
    public String handelException(Exception e){
        return "An error occurred: " + e.getMessage();
    }
}
