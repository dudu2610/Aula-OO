package com.ihammert.entities;

import com.ihammert.core.AbstractDessertProductEntity;

public class ChocolateDessertEntity extends AbstractDessertProductEntity {

    public ChocolateDessertEntity(String name, double price, int stock) {
        super(name, price, stock);
        super.setType(type());

    }

    @Override
    protected double taxa() {
        return 1.2;
    }

    @Override
    public String type() {
        return "Chocolate";
    }

}
