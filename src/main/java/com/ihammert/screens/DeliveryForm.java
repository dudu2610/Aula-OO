package com.ihammert.screens;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DeliveryForm extends JFrame {
    private JTextField customerNameField;
    private JTextField neighborhoodField;
    private JTextField streetField;
    private JTextField residenceNumberField;
    private JTextField complementField;
    private JTextField distanceField;
    private JButton btnSave;
    private JButton btnCancel;

    public DeliveryForm() {
        initializeUI();
        setupSubmitButtonAction();
        setupCancelButtonAction();
    }

    private void initializeUI() {
        setTitle("iHammert");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(7, 2, 10, 10));

        JLabel customerNameLabel = new JLabel("Nome do Cliente:");
        customerNameField = new JTextField();
        JLabel neighborhoodLabel = new JLabel("Bairro:");
        neighborhoodField = new JTextField();
        JLabel streetLabel = new JLabel("Rua:");
        streetField = new JTextField();
        JLabel residenceNumberLabel = new JLabel("Número da Residência:");
        residenceNumberField = new JTextField();
        JLabel complementLabel = new JLabel("Complemento:");
        complementField = new JTextField();
        JLabel distanceLabel = new JLabel("Distância em Metros:");
        distanceField = new JTextField();
        btnSave = new JButton("Salvar");
        btnCancel = new JButton("Cancelar");

        panel.add(customerNameLabel);
        panel.add(customerNameField);
        panel.add(neighborhoodLabel);
        panel.add(neighborhoodField);
        panel.add(streetLabel);
        panel.add(streetField);
        panel.add(residenceNumberLabel);
        panel.add(residenceNumberField);
        panel.add(complementLabel);
        panel.add(complementField);
        panel.add(distanceLabel);
        panel.add(distanceField);
        panel.add(btnSave);
        panel.add(btnCancel);

        add(panel);
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void setupSubmitButtonAction() {
        btnSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String customerName = customerNameField.getText();
                String neighborhood = neighborhoodField.getText();
                String street = streetField.getText();
                int residenceNumber = Integer.parseInt(residenceNumberField.getText());
                String complement = complementField.getText();
                int distanceInMeters = Integer.parseInt(distanceField.getText());

                JOptionPane.showMessageDialog(DeliveryForm.this, "Pedido realizado com sucesso","iHammert",2);

                clearFields();
            }
        });
    }

    private void setupCancelButtonAction() {
        btnCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
    }

    private void clearFields() {
        customerNameField.setText("");
        neighborhoodField.setText("");
        streetField.setText("");
        residenceNumberField.setText("");
        complementField.setText("");
        distanceField.setText("");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new DeliveryForm();
            }
        });
    }
}
