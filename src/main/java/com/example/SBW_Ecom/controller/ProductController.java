package com.example.SBW_Ecom.controller;

import com.example.SBW_Ecom.entity.Product;
import com.example.SBW_Ecom.projection.ProductView;
import com.example.SBW_Ecom.service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    private ProductService service;

    public ProductController(ProductService service) {
        this.service = service;
    }

    @GetMapping("/products")
    public List<Product> getProducts() {
        return service.getAllProducts();
    }

    @PostMapping("/products")
    public String addProducts(@RequestBody List<Product> products) {
        return service.addProducts(products);
    }

    @GetMapping("/products/page/{pageNumber}/size/{pageSize}")
    public List<Product> getProductsByPagination(@PathVariable int pageNumber,
                                                 @PathVariable int pageSize) {
        return service.getProductsByPagination(pageNumber, pageSize);
    }

    @GetMapping("/products/category/{categoryName}")
    public List<ProductView> getProductsByCategory(@PathVariable String categoryName) {
        return service.getProductByCategory(categoryName);
    }
}
