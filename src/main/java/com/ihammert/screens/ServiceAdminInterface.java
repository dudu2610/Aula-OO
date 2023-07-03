package com.ihammert.screens;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.text.DecimalFormat;

public class ServiceAdminInterface extends JFrame {
    private List<Comanda> comandas;
    private JPanel mesaPanel;
    private DefaultTableModel produtoTableModel;
    private JLabel ordemLabel;
    private JTable produtoTable;
    private Comanda currentComanda;
    private JLabel totalLabel;

    public ServiceAdminInterface() {
        comandas = new ArrayList<>();
        produtoTableModel = new DefaultTableModel(new String[]{"Produto", "Quantidade", "Valor"}, 0);

        mesaPanel = new JPanel();
        mesaPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
        

        JButton novaComandaButton = new JButton("  Local  ");

        novaComandaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                abrirNovaComanda();
            }
        });
        novaComandaButton.setFocusable(false);

        JButton deliveryButton = new JButton("Delivery");

        
        deliveryButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                abrirNovaComandaDelivery();
            }
        });
        deliveryButton.setFocusable(false);

        JPanel buttonPanel = new JPanel(new GridBagLayout());
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));
        buttonPanel.add(novaComandaButton, BorderLayout.NORTH);
        buttonPanel.add(deliveryButton, BorderLayout.SOUTH);

        JScrollPane mesaScrollPane = new JScrollPane(mesaPanel);

        JPanel leftPanel = new JPanel(new BorderLayout());
        leftPanel.setPreferredSize(new Dimension(leftPanel.getPreferredSize().width, 70));
        leftPanel.add(mesaScrollPane, BorderLayout.CENTER);
        leftPanel.add(buttonPanel, BorderLayout.WEST);

        JPanel rightPanel = new JPanel(new BorderLayout());
        ordemLabel = new JLabel("");
        rightPanel.add(ordemLabel, BorderLayout.NORTH);
        produtoTable = new JTable(produtoTableModel) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        produtoTable.getTableHeader().setReorderingAllowed(false);
        produtoTable.getTableHeader().setResizingAllowed(false);

        produtoTable.setShowGrid(false); // Remove as linhas horizontais da tabela
        JScrollPane produtoScrollPane = new JScrollPane(produtoTable);
        rightPanel.add(produtoScrollPane, BorderLayout.CENTER);

        JPanel buttonPanelRight = new JPanel();
        buttonPanelRight.setLayout(new FlowLayout(FlowLayout.RIGHT));

        JButton adicionarButton = new JButton("Adicionar");
        adicionarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Comanda comandaAtual = getCurrentComanda(); // Obtenha a comanda atual da ServiceInterface

                if (comandaAtual == null) {
                    JOptionPane.showMessageDialog(ServiceAdminInterface.this,
                            "Selecione uma comanda antes de adicionar um produto.", "iHammert", JOptionPane.ERROR_MESSAGE);
                    return; // Retorna imediatamente, evitando a abertura da interface sem uma comanda
                }

                // Abrir a interface MenuInterface
                MenuInterface menuInterface = new MenuInterface(ServiceAdminInterface.this, currentComanda, produtoTableModel, totalLabel);
                menuInterface.setVisible(true);
                menuInterface.loadProducts();
            }
        });

        JButton btnEdit = new JButton("Editar");
        btnEdit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        btnEdit.setFocusable(false);

        JButton btnRemove = new JButton("Remover");
        btnRemove.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                removerProduto();
            }
        });
        btnRemove.setFocusable(false);

        JButton btnBack = new JButton("Voltar");
        btnBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        JButton btnFinalize = new JButton("Finalizar");
        btnFinalize.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Lógica para finalizar a comanda aqui

            }
        });
        btnFinalize.setFocusable(false);

        buttonPanelRight.add(adicionarButton);
        buttonPanelRight.add(btnEdit);
        buttonPanelRight.add(btnRemove);
        buttonPanelRight.add(btnFinalize);
        buttonPanelRight.add(btnBack);

        JPanel rightBottomPanel = new JPanel(new BorderLayout());
        JPanel totalPanel = new JPanel(new BorderLayout());
        totalLabel = new JLabel("Total: R$ 0.00");
        totalPanel.add(totalLabel, BorderLayout.EAST);
        rightBottomPanel.add(totalPanel, BorderLayout.NORTH);
        rightBottomPanel.add(buttonPanelRight, BorderLayout.CENTER);

        rightPanel.add(rightBottomPanel, BorderLayout.SOUTH);

        add(leftPanel, BorderLayout.NORTH);
        add(rightPanel, BorderLayout.CENTER);

        setResizable(true);

        setTitle("iHammert");
        setSize(800, 600);

        leftPanel.requestFocusInWindow();
        //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void abrirNovaComanda() {
        int novaMesa = comandas.size() + 1;
        Comanda comanda = new Comanda(novaMesa);
        comandas.add(comanda);

        String numeroMesa = String.format("%02d", novaMesa);

        JButton mesaButton = new JButton("Mesa " + numeroMesa);
        mesaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentComanda = comanda; // Atualizar a comanda atual ao selecionar uma mesa
                exibirComanda(currentComanda, "Mesa " + numeroMesa);
            }
        });

        mesaButton.setPreferredSize(new Dimension(100, 30));
        mesaButton.setMargin(new Insets(5, 19, 5, 19));
        mesaButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        mesaPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));
        

        // Remova as linhas abaixo que adicionam espaço vertical (Box.createVerticalStrut)
        mesaPanel.add(mesaButton);
        mesaPanel.revalidate();
    }

    private void abrirNovaComandaDelivery() {
            int novaComanda = comandas.size() + 1;
            Comanda comanda = new Comanda(novaComanda);
            comandas.add(comanda);

            String numeroComanda = String.format("%02d", novaComanda);

            JButton comandaButton = new JButton("Delivery " + numeroComanda);
            comandaButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    currentComanda = comanda;
                    exibirComanda(currentComanda, "Delivery " + numeroComanda);
                }
            });

            comandaButton.setPreferredSize(new Dimension(100, 30));
            comandaButton.setMargin(new Insets(5, 15, 5, 10));
            comandaButton.setAlignmentX(Component.CENTER_ALIGNMENT);
            mesaPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));

            // Remova as linhas abaixo que adicionam espaço vertical (Box.createVerticalStrut)
            mesaPanel.add(comandaButton);
            mesaPanel.revalidate();
    }

    private void exibirComanda(Comanda comanda, String ordem) {
        currentComanda = comanda;

        if (currentComanda != null) {
            produtoTableModel.setRowCount(0); // Limpa as linhas existentes na tabela
            for (Produto produto : comanda.getProdutos()) {
                produtoTableModel.addRow(new Object[]{produto.getNome(), produto.getQuantidade(), produto.getPreco()});
            }
            ordemLabel.setText(ordem);
            totalLabel.setText("Total: R$ " + comanda.getTotal());
        } else {
            produtoTableModel.setRowCount(0);
            ordemLabel.setText("");
            totalLabel.setText("Total: R$ 0.00");
        }
    }

    private void removerProduto() {
        int selectedRow = produtoTable.getSelectedRow();

        if (selectedRow != -1) {
            int confirm = JOptionPane.showConfirmDialog(ServiceAdminInterface.this,
                    "Deseja remover o produto selecionado?", "Remover Produto", JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
                Produto produto = currentComanda.getProdutos().get(selectedRow);
                currentComanda.removerProduto(produto); // Remover o produto da comanda
                produtoTableModel.removeRow(selectedRow); // Remover a linha da tabela
                totalLabel.setText("Total: R$ " + currentComanda.getTotal()); // Atualizar o valor total
            }
        } else {
            JOptionPane.showMessageDialog(ServiceAdminInterface.this,
                    "Selecione um produto para remover.", "iHammert", JOptionPane.ERROR_MESSAGE);
        }
    }

    private Comanda getCurrentComanda() {
        return currentComanda;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new ServiceAdminInterface();
            }
        });
    }
}
