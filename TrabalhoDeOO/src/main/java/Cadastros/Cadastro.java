/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Cadastros;

//Alunos:
//Carlos Eduardo de Souza Duque - Matrícula: 202165502B
//Carlos Gustavo Ferreira Rezende - Matrícula: 202065503B
//Pedro de Araújo Bhering Bittencourt - Matrícula: 202165114A
//Rayane Moraes da Silva - Matrícula: 201565565AC

import com.mycompany.trabalhodeoo.Cliente;
import com.mycompany.trabalhodeoo.Endereco;
import com.mycompany.trabalhodeoo.Estoque;
import com.mycompany.trabalhodeoo.Funcionario;
import com.mycompany.trabalhodeoo.Pedido;
import com.mycompany.trabalhodeoo.PessoaFis;
import com.mycompany.trabalhodeoo.PessoaJur;
import com.mycompany.trabalhodeoo.Produto;
import java.util.*;

/**
 *
 * @author carlo
 */
public class Cadastro { 

    public static boolean verificaNum(String numero) {

        if (numero == null || numero.length() == 0) {
            System.out.println("Vazio...");
            return false;
        }
        try {
            Double.parseDouble(numero);
            if(Double.parseDouble(numero) > 0) {
                return true;
            } else {
                return false;
            }
        } catch (NumberFormatException ex) {
            return false;
        }
    }

    public static boolean verificaSoLetra(String palavra) {
        if (palavra == null || palavra.length() == 0) {
            System.out.println("Vazio...");
            return false;
        }

        if (palavra.length() == 1) {
            return !verificaNum(palavra);
        }

        for (int i = 0; i < palavra.length(); i++) {
            if (verificaNum(palavra.substring(i, i + 1))) {
                return false;
            }
        }

        return true;

    }

    public static Produto cdProduto() {
        System.out.println("Registrando Produtos... ");
        Scanner teclado = new Scanner(System.in);
        List<Produto> produtos = new ArrayList<>();
        String idProduto, nomeProduto, preco, op;

        Produto produto;
        produto = new Produto();
        do {
            System.out.print("Digite o id do produto: ");
            idProduto = teclado.nextLine();
        } while (!verificaNum(idProduto));

        produto.setIdProduto(idProduto);

        do {
            System.out.print("Digite o nome do produto: ");
            nomeProduto = teclado.nextLine();
        } while (verificaNum(nomeProduto));

        produto.setNomeProduto(nomeProduto);

        do {
            System.out.print("Digite o preco: ");
            preco = teclado.nextLine();
        } while (!verificaNum(preco));

        produto.setPreco(preco);
        produtos.add(produto);

        return produto;
    }

    public static String defQuantidade(String nomeProduto) {
        Scanner teclado = new Scanner(System.in);
        String qtd;
        do {
            System.out.print("Digite a quantidade do produto (" + nomeProduto + "): ");
            qtd = teclado.nextLine();
        } while (!verificaNum(qtd));

        return qtd;
    }

    public static void cdEstoque() {
        System.out.println("");
        System.out.println("Acessando Estoque...");
        Scanner teclado = new Scanner(System.in);
        Estoque estoque = new Estoque();
        Produto produto;
        String op;

        do {
            produto = cdProduto();
            estoque.setListaDeProdutos(produto, defQuantidade(produto.getNomeProduto()));
            System.out.println("Deseja registrar outro produto? ");
            do {
                System.out.print("Digite 's' para sim ou 'n' para nao: ");
                op = teclado.nextLine();
            } while (!(op.equals("s") || op.equals("n")));
        } while (op.equals("s"));

        for (Produto product : estoque.getListaDeProdutos().keySet()) {
            System.out.println("Id: " + product.getIdProduto() + "\nNome: " + product.getNomeProduto()
                    + "\nPreco: R$" + product.getPreco() + "\nQuantidade: " + estoque.getListaDeProdutos().get(product));

        }
    }

    public static void cdEndereco(Endereco endereco) {
        Scanner teclado = new Scanner(System.in);
        String aux;
        System.out.print("-----Digite o endereco-----");
        System.out.println("");
        do {
            System.out.print("Digite a Rua: ");
            aux = teclado.nextLine();
        } while (!verificaSoLetra(aux));

        endereco.setRua(aux);

        do {
            System.out.print("Digite o bairro: ");
            aux = teclado.nextLine();
        } while (!verificaSoLetra(aux));

        endereco.setBairro(aux);

        do {
            System.out.print("Digite o numero: ");
            aux = teclado.nextLine();
        } while (!verificaNum(aux));

        endereco.setNumero(aux);

        do {
            System.out.print("Digite a cidade: ");
            aux = teclado.nextLine();
            verificaSoLetra(aux);
        } while (!verificaSoLetra(aux));

        endereco.setCidade(aux);

        do {
            System.out.print("Digite o estado: ");
            aux = teclado.nextLine();
        } while (!verificaSoLetra(aux));

        endereco.setEstado(aux);
    }

    public static PessoaFis cdPessoaFis(String cpfCnpj) {
        System.out.println("-----Cadastrando Pessoa Fisica-----");
        Scanner teclado = new Scanner(System.in);
        String nome, telefone;

        Endereco endereco = new Endereco();

        do {
            System.out.print("Digite o nome da pessoa: ");
            nome = teclado.nextLine();
        } while (!verificaSoLetra(nome));

        do {
            System.out.print("Digite o telefone da pessoa: ");
            telefone = teclado.nextLine();
        } while (!verificaNum(telefone));

        PessoaFis pessoaFis = new PessoaFis(nome, telefone, new Endereco());
        pessoaFis.setCpf(cpfCnpj);
        pessoaFis.setNome(nome);
        pessoaFis.setTelefone(telefone);
        cdEndereco(endereco);
        pessoaFis.setEndereco(endereco);
        return pessoaFis;
    }

    public static PessoaJur cdPessoaJur(String cpfCnpj) {
        System.out.println("-----Cadastrando Pessoa Juridica-----");
        Scanner teclado = new Scanner(System.in);
        String nome, telefone;
        Endereco endereco = new Endereco();

        do {
            System.out.print("Digite o nome da pessoa: ");
            nome = teclado.nextLine();
        } while (!verificaSoLetra(nome));

        do {
            System.out.print("Digite o telefone da pessoa: ");
            telefone = teclado.nextLine();
        } while (!verificaNum(telefone));

        PessoaJur pessoaJur = new PessoaJur(nome, telefone, new Endereco());
        pessoaJur.setCnpj(cpfCnpj);
        pessoaJur.setNome(nome);
        pessoaJur.setTelefone(telefone);
        cdEndereco(endereco);
        pessoaJur.setEndereco(endereco);
        return pessoaJur;
    }

    public static boolean verifTipoPessoa(String cpfCnpj) {
        Scanner teclado = new Scanner(System.in);

        if (cpfCnpj.length() == 11) {
            if (verificaNum(cpfCnpj)) {
                return true;
            }
        } else if (cpfCnpj.length() == 14) {
            if (verificaNum(cpfCnpj)) {
                return false;
            }
        }

        while (cpfCnpj.length() != 11 || cpfCnpj.length() != 14) {
            System.out.println("CPF ou CNPJ invalido...");
            System.out.print("Digite o cpf ou cnpj: ");
            cpfCnpj = teclado.nextLine();
            if (cpfCnpj.length() == 11) {
                if (verificaNum(cpfCnpj)) {
                    return true;
                }
            } else if (cpfCnpj.length() == 14) {
                if (verificaNum(cpfCnpj)) {
                    return false;
                }
            }
        }
        return false;
    }

    public static void cdPedido() {
        System.out.println("");
        System.out.println("Registrando pedido...");
        Pedido pedido = new Pedido();
        Scanner teclado = new Scanner(System.in);
        System.out.print("Digite o id do Pedido: ");
        pedido.setIdPedido(teclado.nextLine());
        Produto produto;
        String aux;

        do {
            produto = cdProduto();
            pedido.setListaProdComprados(produto, defQuantidade(produto.getNomeProduto()));
            System.out.println("Deseja registrar outro produto? ");
            do {
                System.out.print("Digite 's' para sim ou 'n' para nao: ");
                aux = teclado.nextLine();
            } while (!(aux.equals("s") || aux.equals("n")));
        } while (aux.equals("s"));

        pedido.setValorTotal();
        System.out.println("Valor total do Pedido: R$" + pedido.getValorTotal());
        pedido.FormaPgto();

        System.out.print("Digite a forma de pagamento: ");
        aux = "";
        aux = teclado.nextLine();

        while (!aux.equals("1") && !aux.equals("2") && !aux.equals("3")) {
            System.out.println("Opcao invalida...");
            System.out.print("Digite a forma de pagamento: ");
            aux = teclado.nextLine();
        }

        pedido.setFormaPgto(aux);

        System.out.println("-----Nota Fiscal-----");
        System.out.println("Id do pedido: " + pedido.getIdPedido());
        System.out.println("Forma de pagamento: " + pedido.getFormaPgto());
        System.out.println("Valor Total: R$" + pedido.getValorTotal());
    }

    public static String tipoFunc() {
        Scanner teclado = new Scanner(System.in);
        System.out.print("Digite o tipo do funcionario: ");
        String tipoFunc = teclado.nextLine();

        while (!verificaSoLetra(tipoFunc)) {
            System.out.println("Tipo invalido...");
            System.out.print("Digite o tipo do funcionario: ");
            tipoFunc = teclado.nextLine();
        }

        return tipoFunc;
    }

    public static void cdFuncionario() {
        Endereco endereco = new Endereco();
        Funcionario funcionarios = new Funcionario("", "", endereco);
        System.out.println("Cadastrando Funcionarios... ");
        Scanner teclado = new Scanner(System.in);
        String op = "";
        String cpfCnpj;

        do {
            System.out.print("Digite o cpf ou cnpj: ");
            cpfCnpj = teclado.nextLine();
            if (verifTipoPessoa(cpfCnpj)) {
                funcionarios.setListaFuncsPessoasFisicas(cdPessoaFis(cpfCnpj), tipoFunc());
            } else {
                funcionarios.setListaFuncsPessoasJuridicas(cdPessoaJur(cpfCnpj), tipoFunc());
            }

            System.out.println("Deseja cadastrar mais um funcionario? ");
            do {
                System.out.print("Digite 's' para sim ou 'n' para nao: ");
                op = teclado.nextLine();
            } while (!(op.equals("s") || op.equals("n")));
        } while (op.equals("s"));

        System.out.println("");
        System.out.println("Funcionarios de pessoas fisicas: ");
        System.out.println("");

        for (PessoaFis personFis : funcionarios.getListaFuncsPessoasFisicas().keySet()) {
            System.out.println("CPF: " + personFis.getCpf());
            System.out.println("Nome: " + personFis.getNome());
            System.out.println("Telefone: " + personFis.getTelefone());
            endereco = personFis.getEndereco();
            System.out.println("Endereco: \n" + "Rua: " + endereco.getRua()
                    + "\nBairro: " + endereco.getBairro() + "\nNumero: " + endereco.getNumero()
                    + "\nCidade: " + endereco.getCidade() + "\nEstado: " + endereco.getEstado()
                    + "\nTipo: " + funcionarios.getListaFuncsPessoasFisicas().get(personFis) + "\n");
        }

        System.out.println("");
        System.out.println("Funcionarios de pessoas juridicas: ");
        System.out.println("");

        for (PessoaJur personJur : funcionarios.getListaFuncsPessoasJuridicas().keySet()) {
            System.out.println("CNPJ: " + personJur.getCnpj());
            System.out.println("Nome: " + personJur.getNome());
            System.out.println("Telefone: " + personJur.getTelefone());
            endereco = personJur.getEndereco();
            System.out.println("Endereco: \n" + "Rua: " + endereco.getRua()
                    + "\nBairro: " + endereco.getBairro() + "\nNumero: " + endereco.getNumero()
                    + "\nCidade: " + endereco.getCidade() + "\nEstado: " + endereco.getEstado()
                    + "\nTipo: " + funcionarios.getListaFuncsPessoasJuridicas().get(personJur) + "\n");
        }
    }

    public static String tipoCliente() {
        Scanner teclado = new Scanner(System.in);
        System.out.print("Digite o tipo do cliente: ");
        String tipoCliente = teclado.nextLine();

        while (!verificaSoLetra(tipoCliente)) {
            System.out.println("Tipo invalido...");
            System.out.print("Digite o tipo do cliente: ");
            tipoCliente = teclado.nextLine();
        }

        return tipoCliente;
    }
    
    public static void cdCliente() {
        Endereco endereco = new Endereco();
        Cliente clientes = new Cliente("", "", endereco);
        System.out.println("Cadastrando Clientes... ");
        Scanner teclado = new Scanner(System.in);
        String op = "";
        String cpfCnpj;

        do {
            System.out.print("Digite o cpf ou cnpj: ");
            cpfCnpj = teclado.nextLine();
            if (verifTipoPessoa(cpfCnpj)) {
                clientes.setListaClientesPessoasFisicas(cdPessoaFis(cpfCnpj), tipoCliente());
            } else {
                clientes.setListaClientesPessoasJuridicas(cdPessoaJur(cpfCnpj), tipoCliente());
            }

            System.out.println("Deseja cadastrar mais um cliente? ");
            do {
                System.out.print("Digite 's' para sim ou 'n' para nao: ");
                op = teclado.nextLine();
            } while (!(op.equals("s") || op.equals("n")));
        } while (op.equals("s"));

        System.out.println("");
        System.out.println("Clientes de pessoas fisicas: ");
        System.out.println("");

        for (PessoaFis personFis : clientes.getListaClientesPessoasFisicas().keySet()) {
            System.out.println("CPF: " + personFis.getCpf());
            System.out.println("Nome: " + personFis.getNome());
            System.out.println("Telefone: " + personFis.getTelefone());
            endereco = personFis.getEndereco();
            System.out.println("Endereco: \n" + "Rua: " + endereco.getRua()
                    + "\nBairro: " + endereco.getBairro() + "\nNumero: " + endereco.getNumero()
                    + "\nCidade: " + endereco.getCidade() + "\nEstado: " + endereco.getEstado()
                    + "\nTipo: " + clientes.getListaClientesPessoasFisicas().get(personFis) + "\n");
        }

        System.out.println("");
        System.out.println("Clientes de pessoas juridicas: ");
        System.out.println("");

        for (PessoaJur personJur : clientes.getListaClientesPessoasJuridicas().keySet()) {
            System.out.println("CNPJ: " + personJur.getCnpj());
            System.out.println("Nome: " + personJur.getNome());
            System.out.println("Telefone: " + personJur.getTelefone());
            endereco = personJur.getEndereco();
            System.out.println("Endereco: \n" + "Rua: " + endereco.getRua()
                    + "\nBairro: " + endereco.getBairro() + "\nNumero: " + endereco.getNumero()
                    + "\nCidade: " + endereco.getCidade() + "\nEstado: " + endereco.getEstado()
                    + "\nTipo: " + clientes.getListaClientesPessoasJuridicas().get(personJur) + "\n");
        }
    }
    
}
