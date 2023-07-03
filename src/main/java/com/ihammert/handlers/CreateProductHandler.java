/*
Carlos Eduardo de Souza Duque - 202165502B
Felipe Bignoto Palácio - 202165174A
Gustavo Dias de Almeida - 202165571C
Victor de Oliveira Luciano - 202165142AC
 */
package com.ihammert.handlers;

import com.ihammert.entities.CandyDessertEntity;
import com.ihammert.entities.CannedJuiceEntity;
import com.ihammert.entities.ProductEntity;
import com.ihammert.entities.CategoryEntity;
import com.ihammert.entities.ChocolateDessertEntity;
import com.ihammert.entities.DefaultFriedPastryEntity;
import com.ihammert.entities.NaturalJuiceEntity;
import com.ihammert.entities.SweetFriedPastryEntity;
import com.ihammert.repositories.JSONCandyDessertRepository;
import com.ihammert.repositories.JSONCannedJuiceRepository;
import com.ihammert.repositories.JSONCategoriesRepository;
import com.ihammert.repositories.JSONChocolateDessertRepository;
import com.ihammert.repositories.JSONDefaultFriedPastryProductsRepository;
import com.ihammert.repositories.JSONNaturalJuiceRepository;
import com.ihammert.repositories.JSONOtherProductRepository;
import com.ihammert.repositories.JSONSweetFriedPastryRepositoty;
import java.util.List;
import javax.swing.JOptionPane;

public class CreateProductHandler {

    public static void handle(String type, String nameProduct, double price, int stock, String category, boolean print) {

        try {

            switch (type) {
                case "Pastel Salgado":
                    createDefaultFriedPastry(nameProduct, price, stock, category, print);
                    break;

                case "Pastel Doce":
                    createSweetFriedPastry(nameProduct, price, stock, category, print);
                    break;

                case "Suco Natural":
                    createNaturalJuice(nameProduct, price, stock, category, print);
                    break;

                case "Suco Enlatado":
                    createCannedJuice(nameProduct, price, stock, category, print);
                    break;

                case "Chocolate":
                    createChocolateDessert(nameProduct, price, stock, category, print);
                    break;

                case "Guloseimas":
                    createCandyDessert(nameProduct, price, stock, category, print);
                    break;

                case "Outro":
                    createOtherProduct(nameProduct, price, stock, category, print);
                    break;
                default:
                    //ERRO
                    break;
            }

        } catch (Exception err) {
            System.out.println("Erro: " + err.getMessage());
        }

    }

    public static void createSweetFriedPastry(String nameProduct, double price, int stock, String category, boolean print) {

        try {
            JSONSweetFriedPastryRepositoty jSONSweetFriedPastryRepositoty = new JSONSweetFriedPastryRepositoty();
            boolean productIsRegistered = jSONSweetFriedPastryRepositoty.checkIfExistsByName(nameProduct);

            if (productIsRegistered == true) {//PRODUTO JA ESTA CADASTRADO
                printProductExists();

            } else {//NOVO PRODUTO
                SweetFriedPastryEntity newProduct = new SweetFriedPastryEntity(nameProduct, price, stock);

                JSONCategoriesRepository jSONCategoriesRepository = new JSONCategoriesRepository();
                List<CategoryEntity> categories = jSONCategoriesRepository.getAll();

                if (!(jSONCategoriesRepository.checkIfExistsByName(category))) {//categoria não existe
                    CreateCategoryHandler.categoryHandle(category);
                    int novoId;
                    if (categories.isEmpty()) {
                        novoId = 1;
                    } else {
                        jSONCategoriesRepository = new JSONCategoriesRepository();
                        novoId = jSONCategoriesRepository.getIdByName(category);
                    }
                    newProduct.setCategoryId(novoId);
                } else {

                    int categoryId = jSONCategoriesRepository.getIdByName(category);
                    newProduct.setCategoryId(categoryId);
                }

                jSONSweetFriedPastryRepositoty.create(newProduct);
                printSucess(print);
            }
        } catch (Exception err) {
            System.out.println("Erro: " + err.getMessage());
        }

    }

    public static void createDefaultFriedPastry(String nameProduct, double price, int stock, String category, boolean print) {
        try {

            JSONDefaultFriedPastryProductsRepository jSONDefaultFriedPastryProductsRepository = new JSONDefaultFriedPastryProductsRepository();
            boolean productIsRegistered = jSONDefaultFriedPastryProductsRepository.checkIfExistsByName(nameProduct);

            if (productIsRegistered == true) {//PRODUTO JA ESTA CADASTRADO
               printProductExists();

            } else {//NOVO PRODUTO
                DefaultFriedPastryEntity newProduct = new DefaultFriedPastryEntity(nameProduct, price, stock);

                JSONCategoriesRepository jSONCategoriesRepository = new JSONCategoriesRepository();
                List<CategoryEntity> categories = jSONCategoriesRepository.getAll();

                if (!(jSONCategoriesRepository.checkIfExistsByName(category))) {//categoria não existe
                    CreateCategoryHandler.categoryHandle(category);
                    int novoId;
                    if (categories.isEmpty()) {
                        novoId = 1;
                    } else {
                        jSONCategoriesRepository = new JSONCategoriesRepository();
                        novoId = jSONCategoriesRepository.getIdByName(category);
                    }
                    newProduct.setCategoryId(novoId);
                } else {

                    int categoryId = jSONCategoriesRepository.getIdByName(category);
                    newProduct.setCategoryId(categoryId);
                }

                jSONDefaultFriedPastryProductsRepository.create(newProduct);
                printSucess(print);
            }
        } catch (Exception err) {
            System.out.println("Erro: " + err.getMessage());
        }
    }

    public static void createNaturalJuice(String nameProduct, double price, int stock, String category, boolean print) {
        try {
            JSONNaturalJuiceRepository jSONNaturalJuiceRepository = new JSONNaturalJuiceRepository();
            boolean productIsRegistered = jSONNaturalJuiceRepository.checkIfExistsByName(nameProduct);

            if (productIsRegistered == true) {//PRODUTO JA ESTA CADASTRADO
                printProductExists();

            } else {//NOVO PRODUTO
                NaturalJuiceEntity newProduct = new NaturalJuiceEntity(nameProduct, price, stock);

                JSONCategoriesRepository jSONCategoriesRepository = new JSONCategoriesRepository();
                List<CategoryEntity> categories = jSONCategoriesRepository.getAll();

                if (!(jSONCategoriesRepository.checkIfExistsByName(category))) {//categoria não existe
                    CreateCategoryHandler.categoryHandle(category);
                    int novoId;
                    if (categories.isEmpty()) {
                        novoId = 1;
                    } else {
                        jSONCategoriesRepository = new JSONCategoriesRepository();
                        novoId = jSONCategoriesRepository.getIdByName(category);
                    }
                    newProduct.setCategoryId(novoId);
                } else {

                    int categoryId = jSONCategoriesRepository.getIdByName(category);
                    newProduct.setCategoryId(categoryId);
                }

                jSONNaturalJuiceRepository.create(newProduct);
                printSucess(print);
            }
        } catch (Exception err) {
            System.out.println("Erro: " + err.getMessage());
        }
    }

    public static void createCannedJuice(String nameProduct, double price, int stock, String category, boolean print) {
        try {
            JSONCannedJuiceRepository jSONCannedJuiceRepository = new JSONCannedJuiceRepository();
            boolean productIsRegistered = jSONCannedJuiceRepository.checkIfExistsByName(nameProduct);

            if (productIsRegistered == true) {//PRODUTO JA ESTA CADASTRADO
                printProductExists();

            } else {//NOVO PRODUTO
                CannedJuiceEntity newProduct = new CannedJuiceEntity(nameProduct, price, stock);

                JSONCategoriesRepository jSONCategoriesRepository = new JSONCategoriesRepository();
                List<CategoryEntity> categories = jSONCategoriesRepository.getAll();

                if (!(jSONCategoriesRepository.checkIfExistsByName(category))) {//categoria não existe
                    CreateCategoryHandler.categoryHandle(category);
                    int novoId;
                    if (categories.isEmpty()) {
                        novoId = 1;
                    } else {
                        jSONCategoriesRepository = new JSONCategoriesRepository();
                        novoId = jSONCategoriesRepository.getIdByName(category);
                    }
                    newProduct.setCategoryId(novoId);
                } else {

                    int categoryId = jSONCategoriesRepository.getIdByName(category);
                    newProduct.setCategoryId(categoryId);
                }

                jSONCannedJuiceRepository.create(newProduct);
                printSucess(print);
            }
        } catch (Exception err) {
            System.out.println("Erro: " + err.getMessage());
        }
    }

    public static void createCandyDessert(String nameProduct, double price, int stock, String category, boolean print) {
        try {
            JSONCandyDessertRepository jSONCandyDessertRepository = new JSONCandyDessertRepository();
            boolean productIsRegistered = jSONCandyDessertRepository.checkIfExistsByName(nameProduct);

            if (productIsRegistered == true) {//PRODUTO JA ESTA CADASTRADO
                printProductExists();

            } else {//NOVO PRODUTO
                CandyDessertEntity newProduct = new CandyDessertEntity(nameProduct, price, stock);

                JSONCategoriesRepository jSONCategoriesRepository = new JSONCategoriesRepository();
                List<CategoryEntity> categories = jSONCategoriesRepository.getAll();

                if (!(jSONCategoriesRepository.checkIfExistsByName(category))) {//categoria não existe
                    CreateCategoryHandler.categoryHandle(category);
                    int novoId;
                    if (categories.isEmpty()) {
                        novoId = 1;
                    } else {
                        jSONCategoriesRepository = new JSONCategoriesRepository();
                        novoId = jSONCategoriesRepository.getIdByName(category);
                    }
                    newProduct.setCategoryId(novoId);
                } else {

                    int categoryId = jSONCategoriesRepository.getIdByName(category);
                    newProduct.setCategoryId(categoryId);
                }

                jSONCandyDessertRepository.create(newProduct);
                printSucess(print);
            }
        } catch (Exception err) {
            System.out.println("Erro: " + err.getMessage());
        }
    }

    public static void createChocolateDessert(String nameProduct, double price, int stock, String category, boolean print) {
        try {
            JSONChocolateDessertRepository jSONChocolateDessertRepository = new JSONChocolateDessertRepository();
            boolean productIsRegistered = jSONChocolateDessertRepository.checkIfExistsByName(nameProduct);

            if (productIsRegistered == true) {//PRODUTO JA ESTA CADASTRADO
                printProductExists();

            } else {//NOVO PRODUTO
                ChocolateDessertEntity newProduct = new ChocolateDessertEntity(nameProduct, price, stock);

                JSONCategoriesRepository jSONCategoriesRepository = new JSONCategoriesRepository();
                List<CategoryEntity> categories = jSONCategoriesRepository.getAll();

                if (!(jSONCategoriesRepository.checkIfExistsByName(category))) {//categoria não existe
                    CreateCategoryHandler.categoryHandle(category);
                    int novoId;
                    if (categories.isEmpty()) {
                        novoId = 1;
                    } else {
                        jSONCategoriesRepository = new JSONCategoriesRepository();
                        novoId = jSONCategoriesRepository.getIdByName(category);
                    }
                    newProduct.setCategoryId(novoId);
                } else {

                    int categoryId = jSONCategoriesRepository.getIdByName(category);
                    newProduct.setCategoryId(categoryId);
                }

                jSONChocolateDessertRepository.create(newProduct);
                printSucess(print);
            }
        } catch (Exception err) {
            System.out.println("Erro: " + err.getMessage());
        }
    }

    public static void createOtherProduct(String nameProduct, double price, int stock, String category, boolean print) {
        try {
            JSONOtherProductRepository jSONOtherProductRepository = new JSONOtherProductRepository();
            boolean productIsRegistered = jSONOtherProductRepository.checkIfExistsByName(nameProduct);

            if (productIsRegistered == true) {//PRODUTO JA ESTA CADASTRADO
                printProductExists();

            } else {//NOVO PRODUTO
                ProductEntity newProduct = new ProductEntity(nameProduct, price, stock);

                JSONCategoriesRepository jSONCategoriesRepository = new JSONCategoriesRepository();
                List<CategoryEntity> categories = jSONCategoriesRepository.getAll();

                if (!(jSONCategoriesRepository.checkIfExistsByName(category))) {//categoria não existe
                    CreateCategoryHandler.categoryHandle(category);
                    int novoId;
                    if (categories.isEmpty()) {
                        novoId = 1;
                    } else {
                        jSONCategoriesRepository = new JSONCategoriesRepository();
                        novoId = jSONCategoriesRepository.getIdByName(category);
                        //jSONCategoriesRepository.getIdByName(categories.get(categories.size() - 1).getCategoryName());
                    }
                    newProduct.setCategoryId(novoId);
                } else {

                    int categoryId = jSONCategoriesRepository.getIdByName(category);
                    newProduct.setCategoryId(categoryId);
                }

                jSONOtherProductRepository.create(newProduct);
                printSucess(print);
            }
        } catch (Exception err) {
            System.out.println("Erro: " + err.getMessage());
        }
    }

    public static void printSucess(boolean condicional) {
        if (condicional) {
            JOptionPane.showMessageDialog(null, "Produto registrado com sucesso!", "iHammert", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
    public static void printProductExists(){
         JOptionPane.showMessageDialog(null, "Produto já está cadastrado!", null, 0);
    }

}
