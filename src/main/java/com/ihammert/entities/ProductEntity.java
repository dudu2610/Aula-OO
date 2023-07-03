/*
Carlos Eduardo de Souza Duque - 202165502B
Felipe Bignoto Palácio - 202165174A
Gustavo Dias de Almeida - 202165571C
Victor de Oliveira Luciano - 202165142AC
 */
package com.ihammert.entities;

import com.ihammert.core.AbstractProductEntity;

public class ProductEntity extends AbstractProductEntity {

    public ProductEntity(String name, double price, int stock) {
        super(name, price, stock);
        salePrice();
        super.setsetType(type());

    }

    @Override
    public double salePrice() {
        super.salePrice = super.price * 2;
        return (super.price * 2);
    }

    @Override
    public String type() {
        return "Outro";
    }

}
