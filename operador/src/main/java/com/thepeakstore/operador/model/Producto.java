package com.thepeakstore.operador.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "products")
public class Producto {

    @Id
    private int id;
    private String name;
    private double price;
    private String brand;
    private String category;
    private String description;
    private String image;
    private boolean visible;

    public Producto() {}

    public Producto(int id, String name, double price, String brand, String category, String description, String image, boolean visible) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.brand = brand;
        this.category = category;
        this.description = description;
        this.image = image;
        this.visible = visible;
    }

    // GETTERS
    public int getId() { return id; }
    public String getName() { return name; }
    public double getPrice() { return price; }
    public String getBrand() { return brand; }
    public String getCategory() { return category; }
    public String getDescription() { return description; }
    public String getImage() { return image; }
    public boolean isVisible() { return visible; }

    // SETTERS
    public void setId(int id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setPrice(double price) { this.price = price; }
    public void setBrand(String brand) { this.brand = brand; }
    public void setCategory(String category) { this.category = category; }
    public void setDescription(String description) { this.description = description; }
    public void setImage(String image) { this.image = image; }
    public void setVisible(boolean visible) { this.visible = visible; }
}