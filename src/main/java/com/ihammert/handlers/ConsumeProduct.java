/*
Carlos Eduardo de Souza Duque - 202165502B
Felipe Bignoto Palácio - 202165174A
Gustavo Dias de Almeida - 202165571C
Victor de Oliveira Luciano - 202165142AC
 */
package com.ihammert.handlers;

import com.ihammert.core.AbstractProductEntity;
import com.ihammert.entities.CandyDessertEntity;
import com.ihammert.entities.CannedJuiceEntity;
import com.ihammert.entities.ChocolateDessertEntity;
import com.ihammert.entities.DefaultFriedPastryEntity;
import com.ihammert.entities.NaturalJuiceEntity;
import com.ihammert.entities.ProductEntity;
import com.ihammert.entities.SweetFriedPastryEntity;
import com.ihammert.repositories.JSONCandyDessertRepository;
import com.ihammert.repositories.JSONCannedJuiceRepository;
import com.ihammert.repositories.JSONChocolateDessertRepository;
import com.ihammert.repositories.JSONDefaultFriedPastryProductsRepository;
import com.ihammert.repositories.JSONNaturalJuiceRepository;
import com.ihammert.repositories.JSONOtherProductRepository;
import com.ihammert.repositories.JSONProductRepository;
import com.ihammert.repositories.JSONSweetFriedPastryRepositoty;
import javax.swing.JOptionPane;

public class ConsumeProduct {

    public static void main(String name, int quantityToBeRemoved) {

        try {
            JSONProductRepository jSONProductRepository = new JSONProductRepository();
            int id = jSONProductRepository.getIdByName(name);
            AbstractProductEntity productToRemove = jSONProductRepository.getById(id);
            String type = productToRemove.getType();

            switch (type) {
                case "Pastel Salgado":
                    consumeDefaultFriedPastry(id, quantityToBeRemoved);
                    break;

                case "Pastel Doce":
                    consumeSweetFriedPastry(id, quantityToBeRemoved);
                    break;

                case "Suco Natural":
                    consumeNaturalJuice(id, quantityToBeRemoved);
                    break;

                case "Suco Enlatado":
                    consumeCannedJuice(id, quantityToBeRemoved);
                    break;

                case "Chocolate":
                    consumeChocolateDessert(id, quantityToBeRemoved);
                    break;

                case "Guloseimas":
                    consumeCandyDessert(id, quantityToBeRemoved);
                    break;

                case "Outro":
                    consumeOtherProduct(id, quantityToBeRemoved);
                    break;
                default:
                    //ERRO
                    break;

            }
        } catch (Exception err) {
            throw new Error("Erro");
        }
    }

    public static void consumeDefaultFriedPastry(int id, int quantityToBeRemoved) {

        try {
            JSONDefaultFriedPastryProductsRepository jSONDefaultFriedPastryProductsRepository = new JSONDefaultFriedPastryProductsRepository();

            if (jSONDefaultFriedPastryProductsRepository.checkIfExistsById(id)) {
                DefaultFriedPastryEntity product = jSONDefaultFriedPastryProductsRepository.getById(id);
                if (product.getStockQuantity() >= quantityToBeRemoved) {
                    DefaultFriedPastryEntity editedProduct = new DefaultFriedPastryEntity(product.getProductName(), product.getProductPrice(), product.getStockQuantity() - quantityToBeRemoved);
                    String name = product.getProductName();
                    RemoveProduct.main(name, false);
                    jSONDefaultFriedPastryProductsRepository.create(editedProduct);

                } else {

                   printinsufficientstock();
                }
            } else {
                printNonExistentProduct();
            }

        } catch (Error e) {
            throw new Error("erro");
        }
    }

    public static void consumeSweetFriedPastry(int id, int quantityToBeRemoved) {

        try {
            JSONSweetFriedPastryRepositoty jSONSweetFriedPastryRepositoty = new JSONSweetFriedPastryRepositoty();

            if (jSONSweetFriedPastryRepositoty.checkIfExistsById(id)) {
                SweetFriedPastryEntity product = jSONSweetFriedPastryRepositoty.getById(id);
                if (product.getStockQuantity() >= quantityToBeRemoved) {
                    SweetFriedPastryEntity editedProduct = new SweetFriedPastryEntity(product.getProductName(), product.getProductPrice(), product.getStockQuantity() - quantityToBeRemoved);
                    String name = product.getProductName();
                    RemoveProduct.main(name, false);
                    jSONSweetFriedPastryRepositoty.create(editedProduct);

                } else {

                    printinsufficientstock();
                }
            } else {
               printNonExistentProduct();
            }

        } catch (Error e) {
            throw new Error("erro");
        }
    }

    public static void consumeNaturalJuice(int id, int quantityToBeRemoved) {

        try {
            JSONNaturalJuiceRepository jSONNaturalJuiceRepository = new JSONNaturalJuiceRepository();

            if (jSONNaturalJuiceRepository.checkIfExistsById(id)) {
                NaturalJuiceEntity product = jSONNaturalJuiceRepository.getById(id);
                if (product.getStockQuantity() >= quantityToBeRemoved) {
                    NaturalJuiceEntity editedProduct = new NaturalJuiceEntity(product.getProductName(), product.getProductPrice(), product.getStockQuantity() - quantityToBeRemoved);
                    String name = product.getProductName();
                    RemoveProduct.main(name, false);
                    jSONNaturalJuiceRepository.create(editedProduct);

                } else {

                   printinsufficientstock();
                }
            } else {
                printNonExistentProduct();
            }

        } catch (Error e) {
            throw new Error("erro");
        }
    }

    public static void consumeCannedJuice(int id, int quantityToBeRemoved) {

        try {
            JSONCannedJuiceRepository jSONCannedJuiceRepository = new JSONCannedJuiceRepository();

            if (jSONCannedJuiceRepository.checkIfExistsById(id)) {
                CannedJuiceEntity product = jSONCannedJuiceRepository.getById(id);
                if (product.getStockQuantity() >= quantityToBeRemoved) {
                    CannedJuiceEntity editedProduct = new CannedJuiceEntity(product.getProductName(), product.getProductPrice(), product.getStockQuantity() - quantityToBeRemoved);
                    String name = product.getProductName();
                    RemoveProduct.main(name, false);
                    jSONCannedJuiceRepository.create(editedProduct);

                } else {

                    printinsufficientstock();
                }
            } else {
                printNonExistentProduct();
            }

        } catch (Error e) {
            throw new Error("erro");
        }
    }

    public static void consumeCandyDessert(int id, int quantityToBeRemoved) {

        try {
            JSONCandyDessertRepository jSONCandyDessertRepository = new JSONCandyDessertRepository();

            if (jSONCandyDessertRepository.checkIfExistsById(id)) {
                CandyDessertEntity product = jSONCandyDessertRepository.getById(id);
                if (product.getStockQuantity() >= quantityToBeRemoved) {
                    CandyDessertEntity editedProduct = new CandyDessertEntity(product.getProductName(), product.getProductPrice(), product.getStockQuantity() - quantityToBeRemoved);
                    String name = product.getProductName();
                    RemoveProduct.main(name, false);
                    jSONCandyDessertRepository.create(editedProduct);

                } else {

                    printinsufficientstock();
                }
            } else {
                printNonExistentProduct();
            }

        } catch (Error e) {
            throw new Error("erro");
        }
    }

    public static void consumeChocolateDessert(int id, int quantityToBeRemoved) {

        try {
            JSONChocolateDessertRepository jSONChocolateDessertRepository = new JSONChocolateDessertRepository();

            if (jSONChocolateDessertRepository.checkIfExistsById(id)) {
                ChocolateDessertEntity product = jSONChocolateDessertRepository.getById(id);
                if (product.getStockQuantity() >= quantityToBeRemoved) {
                    ChocolateDessertEntity editedProduct = new ChocolateDessertEntity(product.getProductName(), product.getProductPrice(), product.getStockQuantity() - quantityToBeRemoved);
                    String name = product.getProductName();
                    RemoveProduct.main(name, false);
                    jSONChocolateDessertRepository.create(editedProduct);

                } else {

                    printinsufficientstock();
                }
            } else {
                printNonExistentProduct();
            }

        } catch (Error e) {
            throw new Error("erro");
        }
    }

    public static void consumeOtherProduct(int id, int quantityToBeRemoved) {

        try {
            JSONOtherProductRepository jSONOtherProductRepository = new JSONOtherProductRepository();

            if (jSONOtherProductRepository.checkIfExistsById(id)) {
                ProductEntity product = jSONOtherProductRepository.getById(id);
                if (product.getStockQuantity() >= quantityToBeRemoved) {
                    ProductEntity editedProduct = new ProductEntity(product.getProductName(), product.getProductPrice(), product.getStockQuantity() - quantityToBeRemoved);
                    String name = product.getProductName();
                    RemoveProduct.main(name, false);
                    jSONOtherProductRepository.create(editedProduct);

                } else {

                    //Mensagem de estoque insuficiente
                }
            } else {
                //mensagem de Produto não existe
            }

        } catch (Error e) {
            throw new Error("erro");
        }
    }

    public static void printinsufficientstock () {
        JOptionPane.showMessageDialog(null, "Estoque insuficiente!", "iHammert", 0);
    }
    
    public static void printNonExistentProduct () {
        JOptionPane.showMessageDialog(null, "Produto não está cadastrado!", "iHammert", 0);
    }

}
