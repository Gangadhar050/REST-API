package com.example.E_Commerce.Repository;

import com.example.E_Commerce.Entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.NativeQuery;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {


    List<Product> findByName(String name);

    List<Product> findByPriceGreaterThan(float price);

    List<Product> findByNameAndPrice(String name, float price);

    List<Product> findByNameAndDescription(String name, String description);


    // JPQL
    @Query("SELECT p FROM Product p WHERE p.name > :name") //select * from ecom_products where name=?
    List<Product> findProductByNameJPQL(@Param("name") String name);

    //Native Query by JPQL
    //@Query(value = "SELECT * FROM ecom_product WHERE product_name > :name", nativeQuery = true)

    //                    OR
    @NativeQuery(value = "SELECT * FROM ecom_product WHERE product_name > :name")
    List<Product>findProductByNameNativeQuery(@Param("name") String name);


}