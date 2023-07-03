package com.ihammert.screens;

import com.ihammert.entities.CandyDessertEntity;
import com.ihammert.entities.CannedJuiceEntity;
import com.ihammert.entities.ChocolateDessertEntity;
import com.ihammert.entities.DefaultFriedPastryEntity;
import com.ihammert.entities.NaturalJuiceEntity;
import com.ihammert.entities.ProductEntity;
import com.ihammert.entities.SweetFriedPastryEntity;
import com.ihammert.handlers.CreateProductHandler;
import com.ihammert.handlers.UpdateProduct;
import com.ihammert.repositories.JSONCandyDessertRepository;
import com.ihammert.repositories.JSONCannedJuiceRepository;
import com.ihammert.repositories.JSONCategoriesRepository;
import com.ihammert.repositories.JSONChocolateDessertRepository;
import com.ihammert.repositories.JSONDefaultFriedPastryProductsRepository;
import com.ihammert.repositories.JSONNaturalJuiceRepository;
import com.ihammert.repositories.JSONOtherProductRepository;
import com.ihammert.repositories.JSONSweetFriedPastryRepositoty;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.AbstractDocument;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;
import javax.swing.text.AttributeSet;
import java.util.List;

public class ProductRegistration extends JFrame {
    private JTextField txtNome;
    private JTextField txtCategoria;
    private JComboBox<String> cmbTipo;
    private JTextField txtQuantidade;
    private JTextField txtPreco;
    private JButton btnSave;
    private JButton btnCancel;
    private DefaultTableModel produtosTableModel;
    private int rowIndex;
    private static String selectedCategory;

    public ProductRegistration(DefaultTableModel produtosTableModel, int rowIndex) {
        super();
        this.produtosTableModel = produtosTableModel;
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

        JLabel lblCategoria = new JLabel("Categoria:");
        constraints.gridx = 0;
        constraints.gridy = 1;
        mainPanel.add(lblCategoria, constraints);

        txtCategoria = new JTextField(20);
        txtCategoria.setFocusable(false);
        txtCategoria.setEditable(false);

        JButton btnSelectCategoria = new JButton("Selecionar");

        JPanel categoriaPanel = new JPanel(new BorderLayout());
        categoriaPanel.add(txtCategoria, BorderLayout.CENTER);
        categoriaPanel.add(btnSelectCategoria, BorderLayout.EAST);
        constraints.gridx = 1;
        constraints.gridy = 1;
        mainPanel.add(categoriaPanel, constraints);

        JLabel lblTipo = new JLabel("Tipo:");
        constraints.gridx = 0;
        constraints.gridy = 2;
        mainPanel.add(lblTipo, constraints);

        cmbTipo = new JComboBox<>();  
        cmbTipo.addItem("Pastel Salgado");
        cmbTipo.addItem("Pastel Doce");
        cmbTipo.addItem("Suco Natural");
        cmbTipo.addItem("Suco Enlatado");
        cmbTipo.addItem("Guloseimas");
        cmbTipo.addItem("Chocolate");
        cmbTipo.addItem("Outro");
        constraints.gridx = 1;
        constraints.gridy = 2;
        mainPanel.add(cmbTipo, constraints);

        JLabel lblQuantidade = new JLabel("Quantidade:");
        constraints.gridx = 0;
        constraints.gridy = 3;
        mainPanel.add(lblQuantidade, constraints);

        txtQuantidade = new JTextField(20);
        constraints.gridx = 1;
        constraints.gridy = 3;
        mainPanel.add(txtQuantidade, constraints);

        JLabel lblPreco = new JLabel("Preço:"); 
        constraints.gridx = 0;
        constraints.gridy = 4;
        mainPanel.add(lblPreco, constraints);

        txtPreco = new JTextField(20);
        BigsFault();
        constraints.gridx = 1;
        constraints.gridy = 4;
        mainPanel.add(txtPreco, constraints);

        btnSave = new JButton("Salvar");
        btnSave.setPreferredSize(new Dimension(100, 25));
        btnCancel = new JButton("Cancelar");
        btnCancel.setPreferredSize(new Dimension(100, 25));

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        buttonPanel.add(btnSave);
        buttonPanel.add(btnCancel);
        constraints.gridx = 1;
        constraints.gridy = 5;
        constraints.gridwidth = 2;
        mainPanel.add(buttonPanel, constraints);

        setContentPane(mainPanel);
        pack();
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);

        btnSelectCategoria.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CategoryManagement categoryManagement = new CategoryManagement(ProductRegistration.this);
                mainPanel.requestFocusInWindow();
            }
        });

        if (rowIndex != -1) {
            getFields(rowIndex);

        }

        btnSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                registrarProduto();
                loadProducts();
                requestFocusInWindow();
               
            }
        });

        btnCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
    }


     private void registrarProduto() {
        String nome = txtNome.getText();
        String categoria = txtCategoria.getText();
        String tipo = cmbTipo.getSelectedItem().toString();
        int quantidade = Integer.parseInt(txtQuantidade.getText());
        double preco = Double.parseDouble(txtPreco.getText().replace("R$", "").replace(",", ""));    
                
        if (rowIndex != -1) {
            attProduct(nome, categoria, tipo, quantidade, preco);
        } else {
            addProduct(nome, categoria, tipo, quantidade, preco);
        }

        dispose();
    }
     
      public static void loadProducts(){
        try{    
            ProductTable.productTableModel.setRowCount(0);
            
            //Default Fried Pastry
            JSONDefaultFriedPastryProductsRepository jSONDefaultFriedPastryProductsRepository = new JSONDefaultFriedPastryProductsRepository();
            List<DefaultFriedPastryEntity> pasteisSalgados = jSONDefaultFriedPastryProductsRepository.getAll();
            JSONCategoriesRepository jSONCategoriesRepository = new JSONCategoriesRepository();
            for(DefaultFriedPastryEntity products: pasteisSalgados){
                String name = products.getProductName();
                String category = jSONCategoriesRepository.getById(products.getProductCategoryId()).getCategoryName();
                String type = products.getType();
                int quantidade = products.getStockQuantity();
                double preco = products.getProductPrice();
                double precoFinal = products.getSalePrice();
                ProductTable.addProduct(name, category, quantidade, preco, type,precoFinal);
            }
            
            //Sweet Fried Pastry
            JSONSweetFriedPastryRepositoty jSONSweetFriedPastryRepositoty = new JSONSweetFriedPastryRepositoty();
            List<SweetFriedPastryEntity> pasteisDoces = jSONSweetFriedPastryRepositoty.getAll();
            for(SweetFriedPastryEntity products: pasteisDoces){
                String name = products.getProductName();
                String category = jSONCategoriesRepository.getById(products.getProductCategoryId()).getCategoryName();
                String type = products.getType();
                int quantidade = products.getStockQuantity();
                double preco = products.getProductPrice();
                double precoFinal = products.getSalePrice();
                ProductTable.addProduct(name, category, quantidade, preco, type,precoFinal);
            }
            
            //Natural Juice
            JSONNaturalJuiceRepository jSONNaturalJuiceRepository = new JSONNaturalJuiceRepository();
            List<NaturalJuiceEntity> sucosNaturais = jSONNaturalJuiceRepository.getAll();
            for(NaturalJuiceEntity products: sucosNaturais){
                String name = products.getProductName();
                String category = jSONCategoriesRepository.getById(products.getProductCategoryId()).getCategoryName();
                String type = products.getType();
                int quantidade = products.getStockQuantity();
                double preco = products.getProductPrice();
                double precoFinal = products.getSalePrice();
                ProductTable.addProduct(name, category, quantidade, preco, type,precoFinal);
            }
            
            //Canned Juice
            JSONCannedJuiceRepository jSONCannedJuiceRepository = new JSONCannedJuiceRepository();
            List<CannedJuiceEntity> sucosEnlatados = jSONCannedJuiceRepository.getAll();
            for(CannedJuiceEntity products: sucosEnlatados){
                String name = products.getProductName();
                String category = jSONCategoriesRepository.getById(products.getProductCategoryId()).getCategoryName();
                String type = products.getType();
                int quantidade = products.getStockQuantity();
                double preco = products.getProductPrice();
                double precoFinal = products.getSalePrice();
                ProductTable.addProduct(name, category, quantidade, preco, type,precoFinal);
            }
            
            //Candy Dessert
            JSONCandyDessertRepository jSONCandyDessertRepository = new JSONCandyDessertRepository();
            List<CandyDessertEntity> guloseimas = jSONCandyDessertRepository.getAll();
            for(CandyDessertEntity products: guloseimas){
                String name = products.getProductName();
                String category = jSONCategoriesRepository.getById(products.getProductCategoryId()).getCategoryName();
                String type = products.getType();
                int quantidade = products.getStockQuantity();
                double preco = products.getProductPrice();
                double precoFinal = products.getSalePrice();
                ProductTable.addProduct(name, category, quantidade, preco, type,precoFinal);
            }
            
            //Chocolate Dessert
            JSONChocolateDessertRepository jSONChocolateDessertRepository = new JSONChocolateDessertRepository();
            List<ChocolateDessertEntity> chocolates = jSONChocolateDessertRepository.getAll();
            for(ChocolateDessertEntity products: chocolates){
                String name = products.getProductName();
                String category = jSONCategoriesRepository.getById(products.getProductCategoryId()).getCategoryName();
                String type = products.getType();
                int quantidade = products.getStockQuantity();
                double preco = products.getProductPrice();
                double precoFinal = products.getSalePrice();
                ProductTable.addProduct(name, category, quantidade, preco, type,precoFinal);
            }
            
            //Other products
            JSONOtherProductRepository jSONOtherProductRepository = new JSONOtherProductRepository();
            List<ProductEntity> otherProducts = jSONOtherProductRepository.getAll();
            for(ProductEntity products: otherProducts){
                String name = products.getProductName();
                String category = jSONCategoriesRepository.getById(products.getProductCategoryId()).getCategoryName();
                String type = products.getType();
                int quantidade = products.getStockQuantity();
                double preco = products.getProductPrice();
                double precoFinal = products.getSalePrice();
                ProductTable.addProduct(name, category, quantidade, preco, type,precoFinal);
            }
 
        }catch (Error e) {
            System.out.println("Erro ao carregar produtos do arquivo: " + e.getMessage());
        }
    }

    public void setSelectedCategory(String category) {
        selectedCategory = category;
        txtCategoria.setText(selectedCategory);
    }

    public String getSelectedCategory() {
        return selectedCategory;
    }
    private void addProduct(String nome, String categoria, String tipo, int quantidade, double preco) {
        Object[] rowData = {nome, categoria, tipo, quantidade, preco};
        CreateProductHandler.handle(tipo, nome, preco, quantidade, categoria,true);
    }
    private void attProduct(String nome, String categoria, String tipo, int quantidade, double preco){
        
        String oldName = (String) produtosTableModel.getValueAt(rowIndex, 0);
        UpdateProduct.main(tipo, nome, preco, quantidade, categoria,oldName);
        JOptionPane.showMessageDialog(this, "Produto atualizado com sucesso!", "iHammert",2);
        loadProducts();
    }
    
    private void getFields(int rowIndex){        
            String nome = (String) produtosTableModel.getValueAt(rowIndex, 0);
            String categoria = (String) produtosTableModel.getValueAt(rowIndex, 1);
            String tipo = (String) produtosTableModel.getValueAt(rowIndex, 2);
            int quantidade = (int) produtosTableModel.getValueAt(rowIndex, 3);
            double preco = (double) produtosTableModel.getValueAt(rowIndex, 4);

            txtNome.setText(nome);
            txtCategoria.setText(categoria);
            cmbTipo.setSelectedItem(tipo);
            txtQuantidade.setText(Integer.toString(quantidade));
            txtPreco.setText(String.format("R$%.2f", preco));
    }
    
    public void BigsFault() {
        AbstractDocument document = (AbstractDocument) txtPreco.getDocument();
        document.setDocumentFilter(new DocumentFilter() {
            private final String regex = "\\d*(\\.\\d{0,2})?";

            public void insertString(FilterBypass fb, int offset, String string, AttributeSet attr)
                    throws BadLocationException {
                StringBuilder builder = new StringBuilder(fb.getDocument().getText(0, fb.getDocument().getLength()));
                builder.insert(offset, string);

                if (builder.toString().matches(regex)) {
                    super.insertString(fb, offset, string, attr);
                }
            }


            public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs)
                    throws BadLocationException {
                StringBuilder builder = new StringBuilder(fb.getDocument().getText(0, fb.getDocument().getLength()));
                builder.replace(offset, offset + length, text);

                if (builder.toString().matches(regex)) {
                    super.replace(fb, offset, length, text, attrs);
                }
            }
        });

        AbstractDocument quantidadeDocument = (AbstractDocument) txtQuantidade.getDocument();
        quantidadeDocument.setDocumentFilter(new DocumentFilter() {
            private final String regex = "\\d+";


            public void insertString(FilterBypass fb, int offset, String string, AttributeSet attr)
                    throws BadLocationException {
                StringBuilder builder = new StringBuilder(fb.getDocument().getText(0, fb.getDocument().getLength()));
                builder.insert(offset, string);

                if (builder.toString().matches(regex)) {
                    super.insertString(fb, offset, string, attr);
                }
            }

            public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs)
                    throws BadLocationException {
                StringBuilder builder = new StringBuilder(fb.getDocument().getText(0, fb.getDocument().getLength()));
                builder.replace(offset, offset + length, text);

                if (builder.toString().matches(regex)) {
                    super.replace(fb, offset, length, text, attrs);
                }
            }
        });

    }
    
}   
