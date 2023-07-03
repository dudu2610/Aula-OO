/*
Carlos Eduardo de Souza Duque - 202165502B
Felipe Bignoto Palácio - 202165174A
Gustavo Dias de Almeida - 202165571C
Victor de Oliveira Luciano - 202165142AC
 */
package com.ihammert.handlers;


import com.ihammert.repositories.JSONProductRepository;

import javax.swing.JOptionPane;

public class UpdateProduct {

    public static void main(String type, String nameProduct, double price, int stock, String category, String oldName) {

        try {
            switch (type) {

                case "Pastel Salgado":
                    updateDefaultFriedPastry(nameProduct, price, stock, category, oldName);
                    break;

                case "Pastel Doce":
                    updateSweetFriedPastry(nameProduct, price, stock, category, oldName);
                    break;

                case "Suco Natural":
                    updateNaturalJuice(nameProduct, price, stock, category, oldName);
                    break;

                case "Suco Enlatado":
                    updateCannedJuice(nameProduct, price, stock, category, oldName);
                    break;

                case "Chocolate":
                    updateChocolateDessert(nameProduct, price, stock, category, oldName);
                    break;

                case "Guloseimas":
                    updateCandyDessert(nameProduct, price, stock, category, oldName);
                    break;

                case "Outro":
                    updateOtherProduct(nameProduct, price, stock, category, oldName);
                    break;
                default:
                    //ERRO
                    break;
            }

        } catch (Exception err) {
            System.out.println("Erro: " + err.getMessage());
        }

    }

    public static void updateDefaultFriedPastry(String nameProduct, double price, int stock, String category, String oldName) {

        try {
            JSONProductRepository jSONProductRepository = new JSONProductRepository();
            if (jSONProductRepository.getIdByName(oldName) != -1) {
                RemoveProduct.main(oldName, false);
                CreateProductHandler.createDefaultFriedPastry(nameProduct, price, stock, category,false);
            } else {
                JOptionPane.showMessageDialog(null, "Impossível atualizar. Produto não está cadastrado!", null, 0);
            }

        } catch (Exception err) {
            System.out.println("Erro: " + err.getMessage());
        }

    }

    public static void updateSweetFriedPastry(String nameProduct, double price, int stock, String category, String oldName) {

        try {
            JSONProductRepository jSONProductRepository = new JSONProductRepository();
            if (jSONProductRepository.getIdByName(oldName) != -1) {
                RemoveProduct.main(oldName, false);
                CreateProductHandler.createSweetFriedPastry(nameProduct, price, stock, category,false);

            } else {
                JOptionPane.showMessageDialog(null, "Impossível atualizar. Produto não está cadastrado!", null, 0);
            }

        } catch (Exception err) {
            System.out.println("Erro: " + err.getMessage());
        }

    }

    public static void updateNaturalJuice(String nameProduct, double price, int stock, String category, String oldName) {

        try {
            JSONProductRepository jSONProductRepository = new JSONProductRepository();
            if (jSONProductRepository.getIdByName(oldName) != -1) {
                RemoveProduct.main(oldName, false);
                CreateProductHandler.createNaturalJuice(nameProduct, price, stock, category,false);

            } else {
                JOptionPane.showMessageDialog(null, "Impossível atualizar. Produto não está cadastrado!", null, 0);
            }
        } catch (Exception err) {
            System.out.println("Erro: " + err.getMessage());
        }

    }

    public static void updateCannedJuice(String nameProduct, double price, int stock, String category, String oldName) {

        try {
            JSONProductRepository jSONProductRepository = new JSONProductRepository();
            if (jSONProductRepository.getIdByName(oldName) != -1) {
                RemoveProduct.main(oldName, false);
                CreateProductHandler.createCannedJuice(nameProduct, price, stock, category,false);

            } else {
                JOptionPane.showMessageDialog(null, "Impossível atualizar. Produto não está cadastrado!", null, 0);
            }

        } catch (Exception err) {
            System.out.println("Erro: " + err.getMessage());
        }

    }

    public static void updateCandyDessert(String nameProduct, double price, int stock, String category, String oldName) {

        try {
            JSONProductRepository jSONProductRepository = new JSONProductRepository();
            if (jSONProductRepository.getIdByName(oldName) != -1) {
                RemoveProduct.main(oldName, false);
                CreateProductHandler.createCandyDessert(nameProduct, price, stock, category,false);

            } else {
                JOptionPane.showMessageDialog(null, "Impossível atualizar. Produto não está cadastrado!", null, 0);
            }

        } catch (Exception err) {
            System.out.println("Erro: " + err.getMessage());
        }

    }

    public static void updateChocolateDessert(String nameProduct, double price, int stock, String category, String oldName) {

        try {
            JSONProductRepository jSONProductRepository = new JSONProductRepository();
            if (jSONProductRepository.getIdByName(oldName) != -1) {
                RemoveProduct.main(oldName, false);
                CreateProductHandler.createChocolateDessert(nameProduct, price, stock, category,false);

            } else {
                JOptionPane.showMessageDialog(null, "Impossível atualizar. Produto não está cadastrado!", null, 0);
            }

        } catch (Exception err) {
            System.out.println("Erro: " + err.getMessage());
        }

    }

    public static void updateOtherProduct(String nameProduct, double price, int stock, String category, String oldName) {

        try {
            JSONProductRepository jSONProductRepository = new JSONProductRepository();
            if (jSONProductRepository.getIdByName(oldName) != -1) {
                CreateProductHandler.createOtherProduct(nameProduct, price, stock, category,false);
                RemoveProduct.main(oldName, false);
            } else {
                JOptionPane.showMessageDialog(null, "Impossível atualizar. Produto não está cadastrado!", null, 0);
            }

        } catch (Exception err) {
            System.out.println("Erro: " + err.getMessage());
        }

    }

}
