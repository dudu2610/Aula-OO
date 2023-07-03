package com.ihammert.entities;

import com.ihammert.core.AbstractJuiceProductEntity;

public class NaturalJuiceEntity extends AbstractJuiceProductEntity {

    public NaturalJuiceEntity(String name, double price, int stock) {
        super(name, price, stock);
        super.setTamanho("500ml");
        super.setType(type());

    }

    @Override
    public String type() {
        return "Suco Natural";
    }
}
