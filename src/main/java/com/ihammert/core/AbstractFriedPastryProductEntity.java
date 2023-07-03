package com.ihammert.core;

public abstract class AbstractFriedPastryProductEntity extends AbstractProductEntity{
    
    protected String tamanho;
    
    public AbstractFriedPastryProductEntity(String name, double price, int stock){
        super(name,price,stock);
        salePrice();
    }
    
    protected void setTamanho(String tamanho){
        this.tamanho = tamanho;
    }

    @Override
    public double salePrice() {
        super.salePrice = super.price *1.5;
        return (super.price * 1.5);
    }
    
    public void setType(String type){
        super.type = type;
    }
    
}
