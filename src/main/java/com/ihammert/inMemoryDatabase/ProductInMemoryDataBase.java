/*
Carlos Eduardo de Souza Duque - 202165502B
Felipe Bignoto Palácio - 202165174A
Gustavo Dias de Almeida - 202165571C
Victor de Oliveira Luciano - 202165142AC
*/

package com.ihammert.inMemoryDatabase;

import java.util.ArrayList;
import com.ihammert.core.AbstractProductEntity;

public class ProductInMemoryDataBase {
/*
    public static ArrayList<AbstractProductEntity> products = new ArrayList<>();
    
    public ArrayList<AbstractProductEntity> getAll() {
        return products;
    }

    public void addStockQuantity(int stock, String name) {
        for (AbstractProductEntity product : products) {
            if (product.getProductName().equals(name)) {
                product.setStockQuantity(stock);
            }
        }
    }

    public int getStockQuantityById(int productId) {
        int quantity = 0;
        
        for (AbstractProductEntity product : products) {
            if (product.getProductId() == productId) {
               quantity = product.getStockQuantity();
            }
        }
        return quantity;
    }
    
    public double getPriceById(int productId) {        
        for (AbstractProductEntity product : products) {
            if (product.getProductId() == productId) {
               return product.getProductPrice();
            }
        }
        return 0;
    }

    public AbstractProductEntity getByName(String name) {
        for (AbstractProductEntity product : products) {
            if (product.getProductName().equals(name)) {
                return product;
            }
        }
        return null;
    }

    public AbstractProductEntity getById(int id) {
        for (AbstractProductEntity product : products) {
            if (product.getProductId() == id) {
                return product;
            }
        }
        return null;
    }
    
     public String getNameById(int id) {
        for (AbstractProductEntity product : products) {
            if (product.getProductId() == id) {
                return product.getProductName();
            }
        }
        return null;
    }
    
    public boolean getByIdCategory(int id) {
        for (AbstractProductEntity product : products) {
            if (product.getProductCategoryId()== id) {
                return true;
            }
        }
        return false;
    }

    public void print() {
        System.out.println("->Lista do estoque:");
        for (AbstractProductEntity product : products) {
            System.out.println("    Nome:" + product.getProductName() + "| Preco:" + product.getProductPrice() + "| Id:" + product.getProductId() + " | Quantidade:" + product.getStockQuantity() + " | Id da categoria:" + product.getProductCategoryId());
        }
    }

    public boolean checkIfExists(int id) {
        for (AbstractProductEntity product : products) {
            if (product.getProductId() == id) {
                return true;
            }
        }

        return false;
    }
    */
}

/*
 public void editProductById(int opcaoEscolhida, int id){
        
        AbstractProductEntity product =  getById(id);
        Scanner teclado = new Scanner(System.in);
        switch (opcaoEscolhida) {
                case 1:
                    System.out.println("Digite o novo nome do " + product.getProductName() + ":");
                    String name = teclado.nextLine();
                    product.setProductName(name);
                    break;
                case 2:
                    System.out.println("Digite o novo preco do " + product.getProductName() + ":");
                    double price = teclado.nextDouble();
                    product.setProductPrice(price);
                    break;
                    
                case 3:
                    System.out.println("Digite a nova quantidade do " + product.getProductName() + ":");
                    int stockQuantity = teclado.nextInt();
                    product.updateStockQuantity(stockQuantity);
                    break;
                    
                default:
                    System.out.println("Entrada inválida.");
            }
    }
*/

/*

  public void subStockQuantity(int quantityToBeRemoved, int id) {
        for (AbstractProductEntity product : products) {
            if (product.getProductId() == id) {
                if(product.getStockQuantity() >= quantityToBeRemoved){
                    product.setStockQuantity(-quantityToBeRemoved);
                }
                else{
                    product.updateStockQuantity(0);
                    //System.out.println("Foram removidos " + (stockAntigo) + " itens do produto " + product.getProductName() + ".");
                } 
            }
        }
    }
*/
