package com.ihammert.screens;

import com.ihammert.handlers.RemoveProduct;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StorageProductEmployee extends JFrame implements ActionListener {
    private ProductTable productTable;

    public StorageProductEmployee() {
        setTitle("iHammer");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        productTable = new ProductTable();

        JScrollPane scrollPane = new JScrollPane(productTable.getProductTable());
        add(scrollPane, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        JButton addButton = new JButton("Adicionar");
        addButton.addActionListener(this);
        buttonPanel.add(addButton);

        JButton editButton = new JButton("Editar");
        editButton.addActionListener(this);
        buttonPanel.add(editButton);

        JButton removeButton = new JButton("Remover");
        removeButton.addActionListener(this);
        buttonPanel.add(removeButton);

        JButton logoutButton = new JButton("Sair");
        logoutButton.addActionListener(this);
        buttonPanel.add(logoutButton);

        add(buttonPanel, BorderLayout.SOUTH);

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        if (command.equals("Adicionar")) {
            showProductRegistrationDialog(-1);
        } else if (command.equals("Editar")) {
            int selectedRow = productTable.getProductTable().getSelectedRow();
            if (selectedRow != -1) {
                showProductRegistrationDialog(selectedRow);
            } else {
                JOptionPane.showMessageDialog(this, "Selecione um produto para editar","iHammert",2);
            }
        } else if (command.equals("Remover")) {
            int selectedRow = productTable.getProductTable().getSelectedRow();
            if (selectedRow != -1) {
                
                String teste = (String) productTable.getProductTableModel().getValueAt(selectedRow, 0);
                //productTable.removeSelectedProduct();
                RemoveProduct.main(teste,true);
                ProductRegistration.loadProducts();
            } else {
                JOptionPane.showMessageDialog(this, "Selecione um produto para remover","iHammert",2);
            }
        }else if(command.equals("Sair")){
            // substituir para chamar a tela de login
            JOptionPane.showMessageDialog(this, "Deslogado","iHammert",2);
            //dispose();
        }

        requestFocusInWindow();
    }


    private void showProductRegistrationDialog(int rowIndex) {
        ProductRegistration registrationDialog = new ProductRegistration(productTable.getProductTableModel(), rowIndex);
        registrationDialog.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosed(java.awt.event.WindowEvent windowEvent) {
                productTable.getProductTable().clearSelection();
            }
            
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new StorageProductEmployee();
                ProductRegistration.loadProducts();
            }
        });
    }

}
