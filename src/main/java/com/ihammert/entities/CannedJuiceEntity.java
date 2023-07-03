package com.ihammert.entities;

import com.ihammert.core.AbstractJuiceProductEntity;

public class CannedJuiceEntity extends AbstractJuiceProductEntity {

    public CannedJuiceEntity(String name, double price, int stock) {
        super(name, price, stock);
        super.setTamanho("355ml");
        super.setType(type());

    }

    @Override
    public String type() {
        return "Suco Enlatado";
    }

}
