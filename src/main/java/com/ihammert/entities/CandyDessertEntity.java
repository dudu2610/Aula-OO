 package com.ihammert.entities;

import com.ihammert.core.AbstractDessertProductEntity;

public class CandyDessertEntity extends AbstractDessertProductEntity {

    public CandyDessertEntity(String name, double price, int stock) {
        super(name, price, stock);
        super.setType(type());
    }

    @Override
    protected double taxa() {
        return 1.1;
    }

    @Override
    public String type() {
        return "Guloseimas";
    }
    
}
