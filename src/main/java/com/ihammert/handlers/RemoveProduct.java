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

public class RemoveProduct {

    public static void main(String name, boolean c) {
        try {
            JSONProductRepository jSONProductRepository = new JSONProductRepository();
            int id = jSONProductRepository.getIdByName(name);
            AbstractProductEntity productToRemove = jSONProductRepository.getById(id);
            String type = productToRemove.getType();

            switch (type) {
                case "Pastel Salgado":
                    removeDefaultFriedPastry(id, c);
                    break;

                case "Pastel Doce":
                    removeSweetFriedPastry(id, c);
                    break;

                case "Suco Natural":
                    removeNaturalJuice(id, c);
                    break;

                case "Suco Enlatado":
                    removeCannedJuice(id, c);
                    break;

                case "Chocolate":
                    removeChocolateDessert(id, c);
                    break;

                case "Guloseimas":
                    removeCandyDessert(id, c);
                    break;

                case "Outro":
                    removeOtherProduct(id, c);
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Impossível remover. Produto não está cadastrado!", null, 0);
                    break;
            }

        } catch (Exception err) {
            System.out.println("Erro: " + err.getMessage());
        }
    }

    public static void removeDefaultFriedPastry(int id, boolean c) {

        JSONDefaultFriedPastryProductsRepository jSONDefaultFriedPastryProductsRepository = new JSONDefaultFriedPastryProductsRepository();
        DefaultFriedPastryEntity productToRemove = jSONDefaultFriedPastryProductsRepository.getById(id);
        jSONDefaultFriedPastryProductsRepository.delete(productToRemove);
        printSucess(c);
    }

    public static void removeSweetFriedPastry(int id, boolean c) {

        JSONSweetFriedPastryRepositoty jSONSweetFriedPastryRepositoty = new JSONSweetFriedPastryRepositoty();
        SweetFriedPastryEntity productToRemove = jSONSweetFriedPastryRepositoty.getById(id);
        jSONSweetFriedPastryRepositoty.delete(productToRemove);
        printSucess(c);

    }

    public static void removeNaturalJuice(int id, boolean c) {

        JSONNaturalJuiceRepository jSONNaturalJuiceRepository = new JSONNaturalJuiceRepository();
        NaturalJuiceEntity productToRemove = jSONNaturalJuiceRepository.getById(id);
        jSONNaturalJuiceRepository.delete(productToRemove);
        printSucess(c);

    }

    public static void removeCannedJuice(int id, boolean c) {

        JSONCannedJuiceRepository jSONCannedJuiceRepository = new JSONCannedJuiceRepository();
        CannedJuiceEntity productToRemove = jSONCannedJuiceRepository.getById(id);
        jSONCannedJuiceRepository.delete(productToRemove);
        printSucess(c);

    }

    public static void removeCandyDessert(int id, boolean c) {

        JSONCandyDessertRepository jSONCandyDessertRepository = new JSONCandyDessertRepository();
        CandyDessertEntity productToRemove = jSONCandyDessertRepository.getById(id);
        jSONCandyDessertRepository.delete(productToRemove);
        printSucess(c);

    }

    public static void removeChocolateDessert(int id, boolean c) {

        JSONChocolateDessertRepository jSONChocolateDessertRepository = new JSONChocolateDessertRepository();
        ChocolateDessertEntity productToRemove = jSONChocolateDessertRepository.getById(id);
        jSONChocolateDessertRepository.delete(productToRemove);
        printSucess(c);

    }

    public static void removeOtherProduct(int id, boolean c) {

        JSONOtherProductRepository jSONOtherProductRepository = new JSONOtherProductRepository();
        ProductEntity productToRemove = jSONOtherProductRepository.getById(id);
        jSONOtherProductRepository.delete(productToRemove);
        printSucess(c);

    }

    public static void printSucess(boolean condicional) {
        if (condicional) {
            JOptionPane.showMessageDialog(null, "Produto Removido!", null, 0);
        }
    }
}
