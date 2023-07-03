package com.ihammert.screens;

import com.ihammert.core.AbstractUserEntity;
import com.ihammert.handlers.CreateUserHandler;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
//import java.awt.*;
import com.ihammert.repositories.JSONUsersRepository;
import java.util.*;

public class EmployeeTable {
    private JTable employeeTable;
    private DefaultTableModel employeeTableModel;
    
    public EmployeeTable() {
        employeeTableModel = new DefaultTableModel();
        employeeTableModel.addColumn("Nome");
        employeeTableModel.addColumn("Telefone");
        employeeTableModel.addColumn("CPF");
        employeeTableModel.addColumn("Cargo");
        employeeTableModel.addColumn("Email");
        employeeTableModel.addColumn("Login");
        employeeTableModel.addColumn("Senha");

        employeeTable = new JTable(employeeTableModel) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        employeeTable.getTableHeader().setReorderingAllowed(false);
        employeeTable.getTableHeader().setResizingAllowed(false);
    }

    public JTable getEmployeeTable() {
        return employeeTable;
    }

    public DefaultTableModel getEmployeeTableModel() {
        return employeeTableModel;
    }

    public void addEmployee(String nome, String telefone, String cpf, String email, String cargo, String login, String senha) {
        employeeTableModel.addRow(new Object[]{nome, telefone, cpf, cargo, email, login, senha});
    }

    public void removeSelectedEmployee() {
        int selectedRow = employeeTable.getSelectedRow();
        if (selectedRow != -1) {
            String cpf = (String) employeeTableModel.getValueAt(selectedRow, 2);
            JSONUsersRepository jSONUsersRepository = new JSONUsersRepository();
            AbstractUserEntity user = jSONUsersRepository.getBycpf(cpf);
            jSONUsersRepository.delete(user);
            employeeTableModel.removeRow(selectedRow);
        }
    }

    public void editSelectedEmployee(int row, String nome, String telefone, String cpf, String email, String cargo, String login, String senha) {
        int selectedRow = employeeTable.getSelectedRow();
        
        String cpf1 = (String) employeeTableModel.getValueAt(selectedRow, 2);
        JSONUsersRepository jSONUsersRepository = new JSONUsersRepository();
        AbstractUserEntity user = jSONUsersRepository.getBycpf(cpf);
        
        user.setNome(nome);
        user.setTelefone(telefone);
        user.setCpf(cpf);
        user.setCargo(cargo);
        user.setEmail(email);
        user.setLogin(login);
        user.setSenha(senha);
        
        employeeTableModel.setValueAt(nome, row, 0);
        employeeTableModel.setValueAt(telefone, row, 1);
        employeeTableModel.setValueAt(cpf, row, 2);
        employeeTableModel.setValueAt(cargo, row, 3);
        employeeTableModel.setValueAt(email, row, 4);
        employeeTableModel.setValueAt(login, row, 5);
        employeeTableModel.setValueAt(senha, row, 6);
    }
    public  void  carregarUsers () {
        

        JSONUsersRepository jSONUsersRepository = new JSONUsersRepository();
        List<AbstractUserEntity> users = jSONUsersRepository.getAll();
        if(users!=null){
            employeeTableModel.setRowCount( 0 );
            for ( AbstractUserEntity user  : users ) {
                String nome = user.getNome();
                String telefone = user.getTelefone();
                String cpf = user.getCpf();
                String email = user.getEmail();
                String cargo = user.getCargo();
                String login = user.getLogin();
                String senha = user.getSenha();
                employeeTableModel.addRow(new Object[]{nome, telefone, cpf, cargo, email, login, senha});
        }}
}
}