package com.ihammert.screens;

import com.ihammert.entities.CandyDessertEntity;
import com.ihammert.entities.CannedJuiceEntity;
import com.ihammert.entities.ChocolateDessertEntity;
import com.ihammert.entities.DefaultFriedPastryEntity;
import com.ihammert.entities.NaturalJuiceEntity;
import com.ihammert.entities.ProductEntity;
import com.ihammert.entities.SweetFriedPastryEntity;
import com.ihammert.repositories.JSONCandyDessertRepository;
import com.ihammert.repositories.JSONCannedJuiceRepository;
import com.ihammert.repositories.JSONCategoriesRepository;
import com.ihammert.repositories.JSONChocolateDessertRepository;
import com.ihammert.repositories.JSONDefaultFriedPastryProductsRepository;
import com.ihammert.repositories.JSONNaturalJuiceRepository;
import com.ihammert.repositories.JSONOtherProductRepository;
import com.ihammert.repositories.JSONSweetFriedPastryRepositoty;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.text.DecimalFormat;

public class MenuInterface extends JFrame {

    private ServiceAdminInterface serviceInterface;
    private JTable menuTable;
    private DefaultTableModel menuTableModel;
    private JButton addButton;
    private DefaultTableModel produtoTableModel;
    private JLabel totalLabel;

    private Comanda currentComanda;

    public MenuInterface(JFrame parentFrame, Comanda comanda, DefaultTableModel produtoTableModel, JLabel totalLabel) {
        this.serviceInterface = serviceInterface;
        this.produtoTableModel = produtoTableModel;
        this.totalLabel = totalLabel;
        currentComanda = comanda;

        menuTableModel = new DefaultTableModel();

        menuTableModel.addColumn("Nome");
        menuTableModel.addColumn("Preço");
        menuTableModel.addColumn("Quantidade Restante");

        menuTable = new JTable(menuTableModel);
        menuTable.getTableHeader().setReorderingAllowed(false);
        menuTable.setDefaultEditor(Object.class, null);
        menuTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        menuTable.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                updateAddButtonEnabled();
            }
        });

        JScrollPane menuScrollPane = new JScrollPane(menuTable);

        addButton = new JButton("Adicionar");
        addButton.setEnabled(false);
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showQuantityDialog();
            }
        });

        JPanel panel = new JPanel(new BorderLayout());
        panel.add(menuScrollPane, BorderLayout.CENTER);
        panel.add(addButton, BorderLayout.SOUTH);

        add(panel);
        setTitle("iHammert");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void updateMenu(List<Produto> produtos) {
        menuTableModel.setRowCount(0);
        for (Produto produto : produtos) {
            menuTableModel.addRow(new Object[]{produto.getNome(), produto.getPreco(), produto.getQuantidade()});
        }
    }

    private void updateAddButtonEnabled() {
        addButton.setEnabled(menuTable.getSelectedRow() != -1);
    }

    public void loadProducts() {
        menuTableModel.setRowCount(0);

        //Default Fried Pastry
        JSONDefaultFriedPastryProductsRepository jSONDefaultFriedPastryProductsRepository = new JSONDefaultFriedPastryProductsRepository();
        List<DefaultFriedPastryEntity> pasteisSalgados = jSONDefaultFriedPastryProductsRepository.getAll();
        JSONCategoriesRepository jSONCategoriesRepository = new JSONCategoriesRepository();
        for (DefaultFriedPastryEntity products : pasteisSalgados) {
            String name = products.getProductName();
            int quantidade = products.getStockQuantity();
            double precoFinal = products.getSalePrice();
            menuTableModel.addRow(new Object[]{name, precoFinal, quantidade});
        }

        //Sweet Fried Pastry
        JSONSweetFriedPastryRepositoty jSONSweetFriedPastryRepositoty = new JSONSweetFriedPastryRepositoty();
        List<SweetFriedPastryEntity> pasteisDoces = jSONSweetFriedPastryRepositoty.getAll();
        for (SweetFriedPastryEntity products : pasteisDoces) {
            String name = products.getProductName();
            int quantidade = products.getStockQuantity();
            double precoFinal = products.getSalePrice();
            menuTableModel.addRow(new Object[]{name, precoFinal, quantidade});
        }

        //Natural Juice
        JSONNaturalJuiceRepository jSONNaturalJuiceRepository = new JSONNaturalJuiceRepository();
        List<NaturalJuiceEntity> sucosNaturais = jSONNaturalJuiceRepository.getAll();
        for (NaturalJuiceEntity products : sucosNaturais) {
            String name = products.getProductName();
            int quantidade = products.getStockQuantity();
            double precoFinal = products.getSalePrice();
            menuTableModel.addRow(new Object[]{name, precoFinal, quantidade});
        }

        //Canned Juice
        JSONCannedJuiceRepository jSONCannedJuiceRepository = new JSONCannedJuiceRepository();
        List<CannedJuiceEntity> sucosEnlatados = jSONCannedJuiceRepository.getAll();
        for (CannedJuiceEntity products : sucosEnlatados) {
            String name = products.getProductName();
            int quantidade = products.getStockQuantity();
            double precoFinal = products.getSalePrice();
            menuTableModel.addRow(new Object[]{name, precoFinal, quantidade});
        }

        //Candy Dessert
        JSONCandyDessertRepository jSONCandyDessertRepository = new JSONCandyDessertRepository();
        List<CandyDessertEntity> guloseimas = jSONCandyDessertRepository.getAll();
        for (CandyDessertEntity products : guloseimas) {
            String name = products.getProductName();
            int quantidade = products.getStockQuantity();
            double precoFinal = products.getSalePrice();
            menuTableModel.addRow(new Object[]{name, precoFinal, quantidade});
        }

        //Chocolate Dessert
        JSONChocolateDessertRepository jSONChocolateDessertRepository = new JSONChocolateDessertRepository();
        List<ChocolateDessertEntity> chocolates = jSONChocolateDessertRepository.getAll();
        for (ChocolateDessertEntity products : chocolates) {
            String name = products.getProductName();
            int quantidade = products.getStockQuantity();
            double precoFinal = products.getSalePrice();
            menuTableModel.addRow(new Object[]{name, precoFinal, quantidade});
        }

        //Other products
        JSONOtherProductRepository jSONOtherProductRepository = new JSONOtherProductRepository();
        List<ProductEntity> otherProducts = jSONOtherProductRepository.getAll();
        for (ProductEntity products : otherProducts) {
            String name = products.getProductName();
            int quantidade = products.getStockQuantity();
            double precoFinal = products.getSalePrice();
            menuTableModel.addRow(new Object[]{name, precoFinal, quantidade});
        }
    }

    private void showQuantityDialog() {
        int selectedRow = menuTable.getSelectedRow();
        if (selectedRow != -1) {
            String nome = menuTableModel.getValueAt(selectedRow, 0).toString();
            double preco = Double.parseDouble(menuTableModel.getValueAt(selectedRow, 1).toString());

            String quantidadeStr = JOptionPane.showInputDialog(this, "Quantidade:", "Adicionar Produto", JOptionPane.QUESTION_MESSAGE);
            if (quantidadeStr != null && !quantidadeStr.isEmpty()) {
                try {
                    int quantidade = Integer.parseInt(quantidadeStr);
                    if (quantidade > 0) {
                        Produto produtoSelecionado = new Produto(nome, preco);
                        produtoSelecionado.setQuantidade(quantidade);

                        currentComanda.adicionarProduto(produtoSelecionado);
                        produtoTableModel.addRow(new Object[]{produtoSelecionado.getNome(), produtoSelecionado.getQuantidade(), produtoSelecionado.getPreco()});
                        
                        double total = currentComanda.getTotal();
                        updateTotalLabel(currentComanda.getTotal());

                        JOptionPane.showMessageDialog(this, "Produto(s) adicionado(s) à comanda.","iHammert",2);

                        dispose();
                    } else {
                        JOptionPane.showMessageDialog(this, "A quantidade deve ser um valor positivo.", "iHammert",2);
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(this, "A quantidade deve ser um número válido.","iHammert",3);
                }
            }
        }
    }
    private void updateTotalLabel(double total) {
        DecimalFormat decimalFormat = new DecimalFormat("#.00");
        String formattedTotal = decimalFormat.format(total);
        totalLabel.setText("Total: R$ " + formattedTotal);
    }

}
