package com.ihammert.core;

public abstract class AbstractDessertProductEntity extends AbstractProductEntity {

    public AbstractDessertProductEntity(String name, double price, int stock) {
        super(name, price, stock);
        salePrice();
    }

    protected abstract double taxa();

    @Override
    public double salePrice() {
        super.salePrice = super.price * taxa(); 
        return (super.price * taxa());
    }
    
    public void setType(String type){
        super.type = type;
    }

}
