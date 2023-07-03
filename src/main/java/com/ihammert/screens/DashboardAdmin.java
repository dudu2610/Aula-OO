package com.ihammert.screens;

import com.ihammert.handlers.RemoveProduct;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DashboardAdmin extends JFrame implements ActionListener {

    private JButton btnEmployee;
    private JButton btnStorage;
    private JButton btnService;
    private JButton btnLogout;
    private JButton btnAddEmployee, btnRemoveEmployee, btnEditEmployee;
    private JButton btnAddProduct, btnRemoveProduct, btnEditProduct;

    private JPanel mainPanel;
    private EmployeeTable employeeTable;
    private ProductTable productTable;

    public DashboardAdmin() {
        setTitle("iHammert");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        initComponents();
        setupLayout();
        setVisible(true);
        mainPanel.requestFocusInWindow();
    }

    private void initComponents() {
        btnEmployee = new JButton("Funcionários");
        btnEmployee.setPreferredSize(new Dimension(150, 30));
        btnEmployee.addActionListener(this);

        btnStorage = new JButton("Estoque");
        btnStorage.setPreferredSize(new Dimension(150, 30));
        btnStorage.addActionListener(this);

        btnService = new JButton("Atendimento");
        btnService.setPreferredSize(new Dimension(150, 30));
        btnService.addActionListener(this);

        btnLogout = new JButton("Sair");
        btnLogout.setPreferredSize(new Dimension(150, 30));
        btnLogout.addActionListener(this);

        mainPanel = new JPanel(new GridBagLayout());
        employeeTable = new EmployeeTable();
        productTable = new ProductTable();
        setupEmployeePanel();
    }

    private void setupLayout() {
        JPanel sidePanel = new JPanel(new GridBagLayout());
        GridBagConstraints sideConstraints = new GridBagConstraints();
        sideConstraints.fill = GridBagConstraints.VERTICAL;
        sideConstraints.insets = new Insets(5, 5, 5, 5);

        sideConstraints.gridx = 0;
        sideConstraints.gridy = 0;
        sidePanel.add(btnEmployee, sideConstraints);

        sideConstraints.gridx = 0;
        sideConstraints.gridy = 1;
        sidePanel.add(btnStorage, sideConstraints);

        sideConstraints.gridx = 0;
        sideConstraints.gridy = 2;
        sidePanel.add(btnService, sideConstraints);

        sideConstraints.gridx = 0;
        sideConstraints.gridy = 3;
        sidePanel.add(btnLogout, sideConstraints);

        sideConstraints.gridx = 0;
        sideConstraints.gridy = 4;
        sideConstraints.weighty = 1.0;
        sidePanel.add(new JPanel(), sideConstraints);

        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(sidePanel, BorderLayout.WEST);
        getContentPane().add(mainPanel, BorderLayout.CENTER);
        pack();

        setMinimumSize(new Dimension(800, 300));
        setResizable(true);
        setLocationRelativeTo(null);
    }

    private void setupEmployeePanel() {
        mainPanel.removeAll();
        GridBagConstraints mainConstraints = new GridBagConstraints();
        mainConstraints.fill = GridBagConstraints.BOTH;
        mainConstraints.weightx = 1.0;
        mainConstraints.weighty = 1.0;

        JPanel employeePanel = new JPanel(new BorderLayout());
        mainConstraints.gridx = 0;
        mainConstraints.gridy = 0;
        mainConstraints.gridwidth = 1;
        mainConstraints.gridheight = 1;
        mainPanel.add(employeePanel, mainConstraints);

        JScrollPane scrollPane = new JScrollPane(employeeTable.getEmployeeTable());
        employeePanel.add(scrollPane, BorderLayout.CENTER);

        JPanel buttonsPanel = new JPanel(new FlowLayout());
        btnAddEmployee = new JButton("Adicionar");
        btnAddEmployee.setPreferredSize(new Dimension(100, 30));
        btnAddEmployee.addActionListener(this);
        buttonsPanel.add(btnAddEmployee);

        btnEditEmployee = new JButton("Editar");
        btnEditEmployee.setPreferredSize(new Dimension(100, 30));
        btnEditEmployee.addActionListener(this);
        buttonsPanel.add(btnEditEmployee);

        btnRemoveEmployee = new JButton("Remover");
        btnRemoveEmployee.setPreferredSize(new Dimension(100, 30));
        btnRemoveEmployee.addActionListener(this);
        buttonsPanel.add(btnRemoveEmployee);

        employeePanel.add(buttonsPanel, BorderLayout.SOUTH);

        mainPanel.revalidate();
        mainPanel.repaint();
        mainPanel.requestFocusInWindow();
    }

    private void setupProductPanel() {
        mainPanel.removeAll();
        GridBagConstraints mainConstraints = new GridBagConstraints();
        mainConstraints.fill = GridBagConstraints.BOTH;
        mainConstraints.weightx = 1.0;
        mainConstraints.weighty = 1.0;

        JPanel productPanel = new JPanel(new BorderLayout());
        mainConstraints.gridx = 0;
        mainConstraints.gridy = 0;
        mainConstraints.gridwidth = 1;
        mainConstraints.gridheight = 1;
        mainPanel.add(productPanel, mainConstraints);

        JScrollPane scrollPane = new JScrollPane(productTable.getProductTable());
        productPanel.add(scrollPane, BorderLayout.CENTER);

        JPanel buttonsPanel = new JPanel(new FlowLayout());
        btnAddProduct = new JButton("Adicionar");
        btnAddProduct.setPreferredSize(new Dimension(100, 30));
        btnAddProduct.addActionListener(this);
        buttonsPanel.add(btnAddProduct);

        btnEditProduct = new JButton("Editar");
        btnEditProduct.setPreferredSize(new Dimension(100, 30));
        btnEditProduct.addActionListener(this);
        buttonsPanel.add(btnEditProduct);

        btnRemoveProduct = new JButton("Remover");
        btnRemoveProduct.setPreferredSize(new Dimension(100, 30));
        btnRemoveProduct.addActionListener(this);
        buttonsPanel.add(btnRemoveProduct);

        productPanel.add(buttonsPanel, BorderLayout.SOUTH);

        mainPanel.revalidate();
        mainPanel.repaint();
        mainPanel.requestFocusInWindow();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnEmployee) {
            setupEmployeePanel();
         
        } else if (e.getSource() == btnAddEmployee) {
            EmployeeRegistration employeeRegistration = new EmployeeRegistration(employeeTable.getEmployeeTableModel(),
                    -1);
            mainPanel.requestFocusInWindow();
        } else if (e.getSource() == btnRemoveEmployee) {
            if (employeeTable.getEmployeeTable().getSelectedRow() == -1) {
                JOptionPane.showMessageDialog(this, "Selecione um funcionário para remover.", "iHammert", 2);
            } else {
                employeeTable.removeSelectedEmployee();
            }
            mainPanel.requestFocusInWindow();
        } else if (e.getSource() == btnEditEmployee) {
            int selectedRow = employeeTable.getEmployeeTable().getSelectedRow();
            if (selectedRow == -1) {
                JOptionPane.showMessageDialog(this, "Selecione um funcionário para editar.", "iHammert", 2);
            } else {
                EmployeeRegistration employeeRegistration = new EmployeeRegistration(
                        employeeTable.getEmployeeTableModel(), selectedRow);
            }
            mainPanel.requestFocusInWindow();
        } else if (e.getSource() == btnStorage) {
            setupProductPanel();
            ProductRegistration.loadProducts();
            mainPanel.requestFocusInWindow();
        } else if (e.getSource() == btnAddProduct) {
            ProductRegistration productRegistration = new ProductRegistration(productTable.getProductTableModel(), -1);
            //Cria produto
            mainPanel.requestFocusInWindow();
        } else if (e.getSource() == btnRemoveProduct) {
            if (productTable.getProductTable().getSelectedRow() == -1) {
                JOptionPane.showMessageDialog(this, "Selecione um produto para remover.", "iHammert", 2);
            } else { //Remove produto
                int selectedRow = productTable.getProductTable().getSelectedRow();
                String nome = (String) productTable.getProductTableModel().getValueAt(selectedRow, 0);
                RemoveProduct.main(nome, true);
                ProductRegistration.loadProducts();
                //productTable.removeSelectedProduct();
                 
            }
            mainPanel.requestFocusInWindow();
        } else if (e.getSource() == btnEditProduct) {
            int selectedRow = productTable.getProductTable().getSelectedRow();
            if (selectedRow == -1) {
                JOptionPane.showMessageDialog(this, "Selecione um produto para editar.", "iHammert", 2);
            } else {
                ProductRegistration productRegistration = new ProductRegistration(productTable.getProductTableModel(),
                        selectedRow);
                //Editar produto
            }
            mainPanel.requestFocusInWindow();
        } else if (e.getSource() == btnLogout) {
            int option = JOptionPane.showConfirmDialog(this, "Deseja realmente sair?", "Sair",
                    JOptionPane.YES_NO_OPTION);
            if (option == JOptionPane.YES_OPTION) {
                LoginScreen telaLogin = new LoginScreen();
                telaLogin.resetFields();
                dispose();
            }
            mainPanel.requestFocusInWindow();
        } else if (e.getSource() == btnService) {
            ProductRegistration.loadProducts();
            ServiceAdminInterface teste = new ServiceAdminInterface();
            mainPanel.requestFocusInWindow();
        }
    }
}
