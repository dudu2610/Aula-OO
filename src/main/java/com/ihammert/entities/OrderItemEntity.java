/*
Carlos Eduardo de Souza Duque - 202165502B
Felipe Bignoto Palácio - 202165174A
Gustavo Dias de Almeida - 202165571C
Victor de Oliveira Luciano - 202165142AC
*/

package com.ihammert.entities;

import com.ihammert.core.AbstractProductEntity;
import com.ihammert.entities.ProductEntity;
import com.ihammert.inMemoryDatabase.ProductInMemoryDataBase;
import com.ihammert.repositories.JSONProductRepository;
import java.text.DecimalFormat;

public class OrderItemEntity {
    private int productId;
    private int quantity;

    public OrderItemEntity(int productId, int quantity) {
        this.productId = productId;
        this.quantity = quantity;
    }

    public int getProductId() {
        return this.productId;
    }
    
    public double getTotalValue() {
        JSONProductRepository jsonProductRepository = new JSONProductRepository();        
        double total = jsonProductRepository.getById(this.productId).getSalePrice();
        
        return total;
    }
    
    public int getQuantity() {
        return this.quantity;
    }
    
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
