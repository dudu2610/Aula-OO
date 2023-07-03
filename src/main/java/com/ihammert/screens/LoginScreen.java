package com.ihammert.screens;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import com.ihammert.handlers.LoginUser;

public class LoginScreen extends JFrame implements ActionListener, KeyListener {
    private static JLabel directionLabel = new JLabel("Login: ");
    private static JTextField usernameField = new JTextField(10);
    private static JLabel passwordLabel = new JLabel("Senha: ");
    private static JPasswordField passwordField = new JPasswordField(10);
    private static JButton loginButton = new JButton("Login");
    private boolean loginSuccessful;

    public LoginScreen() {
        setTitle("iHammert");
        ImageIcon icon = new ImageIcon("../images/icon2.jpg");
        setIconImage(icon.getImage());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setupUI();


        setVisible(true);

        passwordField.addKeyListener(this);
        loginButton.addActionListener(this);
    }

    private void setupUI() {
        JPanel mainPanel = new JPanel(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.insets = new Insets(5, 5, 5, 5);

        constraints.gridx = 0;
        constraints.gridy = 0;
        mainPanel.add(directionLabel, constraints);

        constraints.gridx = 1;
        constraints.gridy = 0;
        mainPanel.add(usernameField, constraints);

        constraints.gridx = 0;
        constraints.gridy = 1;
        mainPanel.add(passwordLabel, constraints);

        constraints.gridx = 1;
        constraints.gridy = 1;
        mainPanel.add(passwordField, constraints);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        buttonPanel.add(loginButton);

        constraints.gridx = 1;
        constraints.gridy = 2;
        constraints.anchor = GridBagConstraints.SOUTHEAST;
        constraints.weightx = 1.0;
        constraints.weighty = 1.0;
        mainPanel.add(buttonPanel, constraints);

        setContentPane(mainPanel);
        setSize(250, 150);
        setResizable(false);
        setLocationRelativeTo(null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String username = usernameField.getText();
        String password = new String(passwordField.getPassword());
        //Arrumar aqui a verificação de login
        if ((username.equals("admin") && password.equals("senha")) || LoginUser.Inicializa(username,password)) {
            loginSuccessful = true;
            dispose();
            DashboardAdmin telaMenu = new DashboardAdmin();
        } 
        else {
            loginSuccessful = false;
            JOptionPane.showMessageDialog(null,"Nome de usuário ou senha incorretos.",null,0);
            resetFields();   
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            actionPerformed(new ActionEvent(loginButton, ActionEvent.ACTION_PERFORMED, null));
        }
    }

    // Métodos não utilizados neste contexto
    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    public boolean isLoginSuccessful() {
        return loginSuccessful;
    }

    public void resetFields() {
        usernameField.setText("");
        passwordField.setText("");
    }
}
