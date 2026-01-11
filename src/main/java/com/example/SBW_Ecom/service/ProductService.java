package com.example.SBW_Ecom.service;

import com.example.SBW_Ecom.entity.Product;
import com.example.SBW_Ecom.projection.ProductView;
import com.example.SBW_Ecom.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    // 3 was to implement dependency injection
    // 1.Filed Injection 2. Constructor Injection 3.Setter Injection

    //@Autowired //Field Injection
    private ProductRepository productRepository; //

    public ProductService(ProductRepository repository){
        this.productRepository = repository;
    }

    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }

    public String addProducts(List<Product> products) {
        for(Product p : products){
            productRepository.save(p);
        }
        return "Product added successfully";
    }

    public List<Product> getProductsByPagination(int pageNumber, int pageSize) {
        Pageable pageable = Pageable.ofSize(pageSize).withPage(pageNumber);

        Page<Product> p = productRepository.findAll(pageable);
        //select * from ecom_products limit pageSize offset (pageNumber*pageSize)
        return p.getContent();
    }

    public List<ProductView> getProductByCategory(String name) {
        return productRepository.findByCategory(name);
    }
}
