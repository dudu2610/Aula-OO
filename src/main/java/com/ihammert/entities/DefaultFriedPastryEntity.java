package com.ihammert.entities;

import com.ihammert.core.AbstractFriedPastryProductEntity;

public class DefaultFriedPastryEntity extends AbstractFriedPastryProductEntity {

    public DefaultFriedPastryEntity(String name, double price, int stock) {
        super(name, price, stock);
        super.setTamanho("Grande");
        super.setType(type());

    }

    @Override
    public String type() {
        return "Pastel Salgado";
    }
}
