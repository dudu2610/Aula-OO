package com.ihammert.core;

public abstract class AbstractJuiceProductEntity extends AbstractProductEntity {

    protected String tamanho;

    public AbstractJuiceProductEntity(String name, double price, int stock) {
        super(name, price, stock);
        salePrice();

    }

    @Override
    public double salePrice() {
        super.salePrice = super.price * 1.3;
        return (super.price * 1.3);
    }

    protected void setTamanho(String tamanho) {
        this.tamanho = tamanho;
    }
    
    public void setType(String type){
        super.type = type;
    }

}
