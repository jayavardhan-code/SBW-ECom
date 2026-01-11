package com.example.SBW_Ecom.repository;

import com.example.SBW_Ecom.entity.Product;
import com.example.SBW_Ecom.projection.ProductView;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

    //List<Product> findByCategory(String category);
    //JPA Will create the implementation for this method based on the method name
    // JPA will generate the query SELEC * FROM ecom_products WHERE category=""
    // exected when the method is called
    // returs data as List<Product?
    // JPA -> Hiberanete -> JDBC -> SQL

    //List<ProductView> findByCategory(String category);

    //List<Product> findByCategory(String category);
    // Select * from ecom_products where category = 'category'

    Product findByName(String name);
    // select * from ecom_products where product_name = 'name';

    //List<Product> findByCategory(String category);

    List<ProductView> findByCategory(String category);
    // select name, price from ecom_products where category = 'category'
    //select p1_0.product_name,p1_0.price from ecom_products p1_0 where p1_0.category=?

    List<ProductView> findByCategoryOrderByPriceAsc(String category);
}
