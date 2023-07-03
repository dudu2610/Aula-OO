package com.ihammert.screens;

import com.ihammert.handlers.CreateUserHandler;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.text.MaskFormatter;
import javax.swing.table.DefaultTableModel;

public class EmployeeRegistration extends JFrame {
    private JTextField txtNome;
    private JTextField txtLogin;
    private JTextField txtSenha;
    private JFormattedTextField txtTelefone;
    private JFormattedTextField txtCPF;
    private JComboBox<String> cmbCargo;
    private JButton btnSave;
    private JButton btnCancel;
    private JTextField txtEmail;
    private DefaultTableModel funcionariosTableModel;
    private int rowIndex;

    public EmployeeRegistration(DefaultTableModel funcionariosTableModel, int rowIndex) {
        super();
        this.funcionariosTableModel = funcionariosTableModel;
        this.rowIndex = rowIndex;
        
        setTitle("iHammert");


        JPanel mainPanel = new JPanel(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.insets = new Insets(5, 5, 5, 5);

        JLabel lblNome = new JLabel("Nome:");
        constraints.gridx = 0;
        constraints.gridy = 0;
        mainPanel.add(lblNome, constraints);

        txtNome = new JTextField(20);
        constraints.gridx = 1;
        constraints.gridy = 0;
        mainPanel.add(txtNome, constraints);

        JLabel lblTelefone = new JLabel("Telefone:");
        constraints.gridx = 0;
        constraints.gridy = 1;
        mainPanel.add(lblTelefone, constraints);

        try {
            MaskFormatter telefoneFormatter = new MaskFormatter("(##) #####-####");
            txtTelefone = new JFormattedTextField(telefoneFormatter);
        } catch (Exception e) {
            txtTelefone = new JFormattedTextField();
        }
        constraints.gridx = 1;
        constraints.gridy = 1;
        mainPanel.add(txtTelefone, constraints);

        JLabel lblCPF = new JLabel("CPF:");
        constraints.gridx = 0;
        constraints.gridy = 2;
        mainPanel.add(lblCPF, constraints);

        try {
            MaskFormatter cpfFormatter = new MaskFormatter("###.###.###-##");
            txtCPF = new JFormattedTextField(cpfFormatter);
        } catch (Exception e) {
            txtCPF = new JFormattedTextField();
        }
        constraints.gridx = 1;
        constraints.gridy = 2;
        mainPanel.add(txtCPF, constraints);

        JLabel lblLogin = new JLabel("Login:");
        constraints.gridx = 0;
        constraints.gridy = 5;
        mainPanel.add(lblLogin, constraints);

        txtLogin = new JTextField(30);
        constraints.gridx = 1;
        constraints.gridy = 5;
        mainPanel.add(txtLogin, constraints);

        JLabel lblSenha = new JLabel("Senha:");
        constraints.gridx = 0;
        constraints.gridy = 6;
        mainPanel.add(lblSenha, constraints);

        txtSenha = new JTextField(30);
        constraints.gridx = 1;
        constraints.gridy = 6;
        mainPanel.add(txtSenha, constraints);

        JLabel lblEmail = new JLabel("Email:");
        constraints.gridx = 0;
        constraints.gridy = 4;
        mainPanel.add(lblEmail, constraints);

        txtEmail = new JTextField(30);
        constraints.gridx = 1;
        constraints.gridy = 4;
        mainPanel.add(txtEmail, constraints);

        JLabel lblCargo = new JLabel("Cargo:");
        constraints.gridx = 0;
        constraints.gridy = 3;
        mainPanel.add(lblCargo, constraints);

        cmbCargo = new JComboBox<>();
        cmbCargo.addItem("Gerente");
        cmbCargo.addItem("Atendente");
        cmbCargo.addItem("Estoquista");
        constraints.gridx = 1;
        constraints.gridy = 3;
        mainPanel.add(cmbCargo, constraints);

        btnSave = new JButton("Salvar");
        btnSave.setPreferredSize(new Dimension(100, 25));
        btnCancel = new JButton("Cancelar");
        btnCancel.setPreferredSize(new Dimension(100, 25));

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        buttonPanel.add(btnSave);
        buttonPanel.add(btnCancel);
        constraints.gridx = 1;
        constraints.gridy = 8;
        constraints.gridwidth = 2;
        mainPanel.add(buttonPanel, constraints);

        setContentPane(mainPanel);
        pack();
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);

        if (rowIndex != -1) {
            // Preencher campos com dados do funcionário a ser editado
            getFields(rowIndex);
        }

        btnSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                registrarFuncionario();                
            }
        });

        btnCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
    }

    private void registrarFuncionario() {
        String nome = txtNome.getText();
        String telefone = txtTelefone.getText();
        String cpf = txtCPF.getText();
        String email = txtEmail.getText();
        String cargo = cmbCargo.getSelectedItem().toString();
        String login = txtLogin.getText();
        String senha = txtSenha.getText();

        if (rowIndex != -1) {
            // Atualizar dados do funcionário na tabela
            attEmployee(nome, telefone, cpf, cargo, email, login, senha);
        } else {
            addEmployee(nome, telefone, cpf, cargo, email, login, senha);
        }

        dispose();
    }

    private void getFields(int rowIndex) {
        String nome = (String) funcionariosTableModel.getValueAt(rowIndex, 0);
        String telefone = (String) funcionariosTableModel.getValueAt(rowIndex, 1);
        String cpf = (String) funcionariosTableModel.getValueAt(rowIndex, 2);
        String cargo = (String) funcionariosTableModel.getValueAt(rowIndex, 3);
        String email = (String) funcionariosTableModel.getValueAt(rowIndex, 4);
        String login = (String) funcionariosTableModel.getValueAt(rowIndex, 5);
        String senha = (String) funcionariosTableModel.getValueAt(rowIndex, 6);

        txtNome.setText(nome);
        txtTelefone.setText(telefone);
        txtCPF.setText(cpf);
        txtEmail.setText(email);
        cmbCargo.setSelectedItem(cargo);
        txtLogin.setText(login);
        txtSenha.setText(senha);
    }

    private void attEmployee(String nome, String telefone, String cpf, String cargo, String email, String login, String senha) {
        funcionariosTableModel.setValueAt(nome, rowIndex, 0);
        funcionariosTableModel.setValueAt(telefone, rowIndex, 1);
        funcionariosTableModel.setValueAt(cpf, rowIndex, 2);
        funcionariosTableModel.setValueAt(cargo, rowIndex, 3);
        funcionariosTableModel.setValueAt(email, rowIndex, 4);
        funcionariosTableModel.setValueAt(login, rowIndex, 5);
        funcionariosTableModel.setValueAt(senha, rowIndex, 6);
        JOptionPane.showMessageDialog(this, "Funcionário atualizado com sucesso!","iHammert",1);
    }

    private void addEmployee(String nome, String telefone, String cpf, String cargo, String email, String login, String senha) {
        Object[] rowData = {nome, telefone, cpf, cargo, email, login, senha};
        funcionariosTableModel.addRow(rowData);
        if(cargo == "Gerente")
        CreateUserHandler.handleAdm(nome, telefone, cpf, cargo, email, login, senha);
        
        if(cargo == "Estoquista")
        CreateUserHandler.handleEstoquista(nome, telefone, cpf, cargo, email, login, senha);
        
        if(cargo == "Atendente")
            CreateUserHandler.handleAtendente(nome, telefone, cpf, cargo, email, login, senha);
         
        JOptionPane.showMessageDialog(this, "Funcionário registrado com sucesso!","iHammert",1);
    }

}