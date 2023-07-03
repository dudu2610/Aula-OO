package com.ihammert.core;

public abstract class AbstractProductEntity {

    private static int globalId = 0;
    private int stockQuantity = 0;

    private int id;
    private String name;
    private int categoryId;
    protected double price;
    public String type;

    public double salePrice;

    public AbstractProductEntity(String name, double price, int stock) {
        this.id = this.globalId;
        this.name = name;
        this.price = price;
        this.categoryId = 0;//Posso remover depois
        this.stockQuantity = stock;
        this.globalId++;
    }

    public void setStockQuantity(int stock) {
        this.stockQuantity += stock;
    }

    public void updateStockQuantity(int stock) {
        this.stockQuantity = stock;
    }

    public int getStockQuantity() {
        return this.stockQuantity;
    }

    public int getProductId() {
        return this.id;
    }

    public String getProductName() {
        return this.name;
    }

    public void setProductName(String name) {
        this.name = name;
    }

    public double getProductPrice() {
        return this.price;
    }

    public void setProductPrice(double price) {
        this.price = price;
    }

    public int getProductCategoryId() {
        return this.categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public abstract double salePrice();

    public double getSalePrice() {
        return this.salePrice;
    }
    
    public void setsetType(String type){
        this.type = type;
    }
    
    public String getType(){
        return this.type;
    }

    public abstract String type();
}
