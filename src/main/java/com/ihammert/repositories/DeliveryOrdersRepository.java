/*
Carlos Eduardo de Souza Duque - 202165502B
Felipe Bignoto Palácio - 202165174A
Gustavo Dias de Almeida - 202165571C
Victor de Oliveira Luciano - 202165142AC
 */
package com.ihammert.repositories;

import java.util.List;

public interface DeliveryOrdersRepository <T> {
    String DIRECTORY = "data";
        
    // GET 
    public List<T> getAll();
    public T getByUserId(String id);
    public T getItemByProductId(String id);
    public T getById(String id);
    public boolean checkIfExistsById(String id); 
    
    // POST
    public void create(T order);
    public void addProductToOrder(String orderId, int productId, int quantity);
    
    // PUT
    public void updateAProductFromOrder(String orderId, int productId, int newQuantity);
    
    // DELETE
    public void removeProductOrder(String orderId, int productId);
    public void delete(T order);
}
