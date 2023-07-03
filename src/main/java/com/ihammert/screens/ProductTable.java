package com.ihammert.screens;

import com.ihammert.entities.CandyDessertEntity;
import com.ihammert.entities.DefaultFriedPastryEntity;
import com.ihammert.repositories.JSONCandyDessertRepository;
import com.ihammert.repositories.JSONCategoriesRepository;
import com.ihammert.repositories.JSONDefaultFriedPastryProductsRepository;
import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.List;

public class ProductTable {
    private static JTable productTable;
    protected static DefaultTableModel productTableModel;

    public ProductTable() {
        productTableModel = new DefaultTableModel();
        productTableModel.addColumn("Nome");
        productTableModel.addColumn("Categoria");
        productTableModel.addColumn("Tipo");
        productTableModel.addColumn("Quantidade");
        productTableModel.addColumn("Preço");
        productTableModel.addColumn("Preço Final");

        productTable = new JTable(productTableModel) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        productTable.getTableHeader().setReorderingAllowed(false);
        productTable.getTableHeader().setResizingAllowed(false);

        productTable.getColumnModel().getColumn(4).setCellRenderer(new PriceCellRenderer());
        productTable.getColumnModel().getColumn(5).setCellRenderer(new PriceCellRenderer());
        
    }
    
   

    public JTable getProductTable() {
        return productTable;
    }

    public DefaultTableModel getProductTableModel() {
        return productTableModel;
    }

    public static void addProduct(String nome, String categoria, int quantidade, double preco, String tipo, double precoFinal) {
        productTableModel.addRow(new Object[]{nome, categoria, tipo, quantidade, preco, precoFinal});
    }

    public void removeSelectedProduct() {
        int selectedRow = productTable.getSelectedRow();
        if (selectedRow != -1) {
            productTableModel.removeRow(selectedRow);
        }
    }

    public void editSelectedProduct(int row, String nome, String categoria, String tipo, int quantidade, double preco, double precoVenda) {
        productTableModel.setValueAt(nome, row, 0);
        productTableModel.setValueAt(categoria, row, 1);
        productTableModel.setValueAt(tipo, row, 2);
        productTableModel.setValueAt(quantidade, row, 3);
        productTableModel.setValueAt(preco, row, 4);
        productTableModel.setValueAt(precoVenda, row, 5);
    }

    private class PriceCellRenderer extends DefaultTableCellRenderer {
        private DecimalFormat decimalFormat;

        public PriceCellRenderer() {
            decimalFormat = new DecimalFormat("#,##0.00");
        }

        @Override
        protected void setValue(Object value) {
            if (value instanceof Double) {
                value = "R$" + decimalFormat.format(value);
            }
            super.setValue(value);
        }
    }
}

