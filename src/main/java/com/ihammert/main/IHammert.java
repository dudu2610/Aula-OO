/*
Carlos Eduardo de Souza Duque - 202165502B
Felipe Bignoto Palácio - 202165174A
Gustavo Dias de Almeida - 202165571C
Victor de Oliveira Luciano - 202165142AC
 */
package com.ihammert.main;

import com.ihammert.core.AbstractDessertProductEntity;
import com.ihammert.core.AbstractFriedPastryProductEntity;
import com.ihammert.core.AbstractJuiceProductEntity;
import com.ihammert.entities.CandyDessertEntity;
import com.ihammert.entities.CategoryEntity;
import com.ihammert.entities.DefaultFriedPastryEntity;
import com.ihammert.entities.NaturalJuiceEntity;
import com.ihammert.handlers.AddItemToOrder;
import com.ihammert.handlers.ConsumeProduct;
import com.ihammert.handlers.CreateOrderHandler;
import com.ihammert.handlers.CreateProductHandler;
import com.ihammert.handlers.UpdateProduct;
import com.ihammert.handlers.RemoveProduct;
import com.ihammert.handlers.CreateCategoryHandler;
import com.ihammert.inMemoryDatabase.ProductInMemoryDataBase;
import com.ihammert.inMemoryDatabase.CategoryInMemoryDatabase;
import com.ihammert.handlers.FinishOrderHandler;
import java.util.ArrayList;
import com.ihammert.handlers.UpdateItemFromOrder;
import com.ihammert.handlers.RemoveItemFromOrder;
import com.ihammert.handlers.PrintProducts;
import com.ihammert.handlers.LoginUser;
import com.ihammert.handlers.CdUser;
import com.ihammert.handlers.PrintCategories;
import com.ihammert.handlers.RemoveCategoryHandler;
import com.ihammert.handlers.UpdateCategotyHandler;

public class IHammert {

    //public static ProductInMemoryDataBase productInMemoryDataBase = new ProductInMemoryDataBase();
    //public static CategoryInMemoryDatabase categoryInMemoryDatabase = new CategoryInMemoryDatabase();
    public static void main(String[] args) {

        //Cadastrando novo usuario
        //CdUser.Cadastro();
        //Fazendo login
        //if (LoginUser.Inicializa()) {
        if (true) {
            //categories();
            //products();
            //orders();

        } else {
            System.out.println("Usuario nao autorizado!");
        }
    }

    public static void categories() {

        //criando categorias
        //CreateCategoryHandler.categoryHandle("comida");
        //CreateCategoryHandler.categoryHandle("bebida");
        /*
        PrintCategories.handle();

        //Teste Edição de nome
        UpdateCategotyHandler.update("BEBIDA", "bebida");
        PrintCategories.handle();

        //Teste remoção de categoria por id
        RemoveCategoryHandler.remove(2);
        PrintCategories.handle();
         */
    }

    public static void products() {
        //Teste - produtos(Felipe)
        //////////////////
        /*
        CreateProductHandler.handle("Pastel Salgado", "pastel de bacon", 10, 5, "comida",false);
        CreateProductHandler.handle("Pastel Salgado", "pastel de carne", 20, 500, "comida",false);

        CreateProductHandler.handle("Pastel Doce", "pastel de chocolate", 10, 5, "comida 1",false);
        CreateProductHandler.handle("Pastel Doce", "pastel de brigadeiro", 20, 500, "comida 1",false);

        CreateProductHandler.handle("Suco Natural", "SN1", 200, 5004, "bebida",false);
        CreateProductHandler.handle("Suco Enlatado", "SE1", 2, 5, "bebida",false);

        CreateProductHandler.handle("Suco Natural", "SN2", 200, 5004, "bebida",false);
        CreateProductHandler.handle("Suco Enlatado", "SE2", 2, 5, "bebida",false);

        CreateProductHandler.handle("Chocolate", "chocolate1", 200, 5004, "sobremesa",false);
        CreateProductHandler.handle("Chocolate", "chocolate12", 2, 5, "sobremesa",false);

        CreateProductHandler.handle("Guloseimas", "Guloseimas", 200, 5004, "sobremesa",false);
        CreateProductHandler.handle("Guloseimas", "Guloseimas2", 2, 5, "sobremesa",false);

        CreateProductHandler.handle("Outro", "Outro", 200, 5004, "bebida",false);
        CreateProductHandler.handle("Outro", "Outro1", 2, 45, "bebida",false);
         */

        //UpdateCategotyHandler.update("S", "sobremesa");
        /*
        UpdateProduct.main("Pastel Salgado", "novo nome", 100000, 1000, "comida", 0);
        UpdateProduct.main("Pastel Doce", "11111e", 45, 45, "45", 2);
        UpdateProduct.main("Suco Natural", "kkkkkkkkk", 199, 9, "9999", 4);
        UpdateProduct.main("Suco Enlatado", "iiiiiii", 8888, 88, "8888", 5);
        UpdateProduct.main("Chocolate", "Chocolatef", 777, 77, "77", 8);
        UpdateProduct.main("Guloseimas", "Guloseimasggggg", 66, 66, "66", 10);
        UpdateProduct.main("Outro", "Outroffff", 55, 55, "55", 12);
         */
 /*
        //consumindo
        ConsumeProduct.main(0, 4);
        ConsumeProduct.main(1, 4);
        ConsumeProduct.main(2, 0);
        ConsumeProduct.main(3, 5);
        ConsumeProduct.main(4, 8);
        ConsumeProduct.main(5, 8);
         */
 /* Removendo(nome, false)
        RemoveProduct.main(0,false);
        RemoveProduct.main(1,false);
        RemoveCategoryHandler.remove(1,false);
        RemoveProduct.main(2,false);
        RemoveProduct.main(4,false);
        RemoveProduct.main(5,false);
        RemoveProduct.main(8,false);
        RemoveProduct.main(10,false);
        RemoveProduct.main(12);
         */
    }

    public static void orders() {
        //Teste - Pedidos (Gustavo)
        //////////////////
        //
        // [x] Criar Pedido
        //    CreateOrderHandler.handle("Gustavo", true);
        //    CreateOrderHandler.handle("Gustavo", false);
        //
        // [x] Listagem
        //     List<DeliveryOrderEntity> deliveryOrders = ListDeliveryOrderHandler.handle();        
        //     List<LocalOrderEntity> localOrders = ListLocalOrderHandler.handle();
        //
        // [x] Cancelar Pedido
        //     CancelOrder.handle("SunJun2513:34:59BRT2023Gustavolocal", true);
        //     CancelOrder.handle("SunJun2513:34:59BRT2023Gustavodelivery", false);
        //
        // [ ] Adicionar Item ao Pediddo
        //     AddItemToOrder.handle(1, 0, 2);
        //     AddItemToOrder.handle(1, 2, 3);
        //
        // [ ] Remover Produto do Pedido
        //     RemoveItemFromOrder.handle(1, 2);
        //     
        // [ ] Atualizar um Pedido
        //     UpdateItemFromOrder.handle(1, 0, 3);
        //
        // [ ] Concluir pedido e pagamento
        //     FinishOrderHandler.handle("cash", 1);
    }
}
