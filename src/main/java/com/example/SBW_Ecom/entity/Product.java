package com.example.SBW_Ecom.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="ecom_products")
public class Product { //table name
    //ORM - Object Relational Mapping

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id; //column name

    @Column(name = "product_name", length = 100)
    String name;

    @Column(nullable = false)
    float price;

    String category;

    String description;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
