package com.ihammert.entities;

import com.ihammert.core.AbstractFriedPastryProductEntity;

public class SweetFriedPastryEntity extends AbstractFriedPastryProductEntity {

    public SweetFriedPastryEntity(String name, double price, int stock) {
        super(name, price, stock);
        super.setTamanho("Pequeno");
        super.setType(type());

    }

    @Override
    public String type() {
        return "Pastel Doce";
    }
}
