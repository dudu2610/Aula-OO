package com.ihammert.screens;

import com.ihammert.entities.CategoryEntity;
import com.ihammert.handlers.CreateCategoryHandler;
import com.ihammert.handlers.RemoveCategoryHandler;
import com.ihammert.handlers.UpdateCategotyHandler;
import com.ihammert.repositories.JSONCategoriesRepository;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class CategoryManagement extends JFrame implements ActionListener {
    private JTable categoryTable;
    private static DefaultTableModel categoryTableModel;
    private ProductRegistration productRegistration;

    public CategoryManagement(ProductRegistration productRegistration) {
        this.productRegistration = productRegistration;

        setTitle("iHammert");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());


        categoryTableModel = new DefaultTableModel();
        categoryTableModel.addColumn("Categoria");
        categoryTable = new JTable(categoryTableModel);
        JScrollPane scrollPane = new JScrollPane(categoryTable);
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

        JButton selectButton = new JButton("Selecionar");
        selectButton.addActionListener(this);
        buttonPanel.add(selectButton); 
        loadProducts();

        add(buttonPanel, BorderLayout.SOUTH);

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }
    
    public void loadProducts(){
        try{    
            categoryTableModel.setRowCount(0);
            
            JSONCategoriesRepository jSONCategoriesRepository = new JSONCategoriesRepository();
            List <CategoryEntity> categories = jSONCategoriesRepository.getAll();
            for(CategoryEntity category: categories){
                String name = category.getCategoryName();
                categoryTableModel.addRow(new Object[]{name});
            }
            
 
        }catch (Error e) {
            System.out.println("Erro ao carregar produtos do arquivo: " + e.getMessage());
        }
    }

    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();

        if (command.equals("Adicionar")) {
            String category = JOptionPane.showInputDialog(this, "Digite o nome da categoria:", "iHammert", JOptionPane.PLAIN_MESSAGE);
            if (category != null && !category.isEmpty()) {
                //categoryTableModel.addRow(new Object[]{category});
                CreateCategoryHandler.categoryHandle(category);
                loadProducts();
            }

        } else if (command.equals("Editar")) {
            int selectedRow = categoryTable.getSelectedRow();
            if (selectedRow != -1) {
                String category = (String) categoryTableModel.getValueAt(selectedRow, 0);
                String newCategory = JOptionPane.showInputDialog(this, "Editar categoria:", category);
                if (newCategory != null && !newCategory.isEmpty()) {
                    UpdateCategotyHandler.update(newCategory,category );
                    loadProducts();
                }
            } else {
                JOptionPane.showMessageDialog(null, "Selecione uma categoria para editar.", "iHammert", 2);
            }

        } else if (command.equals("Remover")) {
            int selectedRow = categoryTable.getSelectedRow();
            if (selectedRow != -1) {
                String category = (String) categoryTableModel.getValueAt(selectedRow,0);
                RemoveCategoryHandler.remove(category);
                loadProducts();
            } else {
                JOptionPane.showMessageDialog(null, "Selecione uma categoria para remover.", "iHammert", 2);
            }

        } else if (command.equals("Selecionar")) {
            int selectedRow = categoryTable.getSelectedRow();
            if (selectedRow != -1) {
                String selectedCategory = (String) categoryTableModel.getValueAt(selectedRow, 0);
                productRegistration.setSelectedCategory(selectedCategory);
                dispose();
            } else {
                JOptionPane.showMessageDialog(null, "Selecione uma categoria.", "iHammert", 2);
                requestFocusInWindow();
            }
        }
        requestFocusInWindow();
    }
}