package mercadoclientegerenciador;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;
import mercadoclientegerenciador.ClienteConexao;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Rafael
 */
public class MercadoClienteGerenciador {
    Scanner sc = new Scanner(System.in);
    String outInfo;

    public void CadastrarUsuario(ClienteConexao conexao, String nome, String end, String tel, String email, String id, String senha) throws UnknownHostException, IOException {
        conexao.out.println("CadastrarUsuario"); 
        conexao.out.println(nome);
        conexao.out.println(end);
        conexao.out.println(tel);
        conexao.out.println(email);
        conexao.out.println(id);
        conexao.out.println(senha);

    }

    public boolean Login(ClienteConexao conexao) throws UnknownHostException, IOException {
        String senha, ID, nome;
        conexao.out.println("Login"); //2
        System.out.println("Digite o ID");
        ID = sc.nextLine();
        System.out.println("Digite a senha (sensitive case)");
        senha = sc.nextLine();
        conexao.out.println(ID);
        conexao.out.println(senha);
        //System.out.println("Aguardando resposta...");
        while ((outInfo = conexao.in.readLine()) != null) {
            System.out.println(outInfo);
            break;
        }
        return outInfo.equals("Credenciais validas!");
    }

    public void VisualizarProdutos(ClienteConexao conexao) throws UnknownHostException, IOException {
        String nome, fornecedor, aux, endereco, email, telefone, tamLista, escolha, quantidade, preco;
        conexao.out.println("VisualizarProdutos"); 
        
        
        //O servidor envia o tamanho da lista de produtos
        while ((tamLista = conexao.in.readLine()) != null) {            
            break;
        }
        tamLista = conexao.in.readLine();
        System.out.println("O tamanho da lista é " + tamLista + " FIM");
        
        
        for (int i = 0; i < Integer.parseInt(tamLista); i++) {
            System.out.println("---------------------------");
            System.out.println("Produto " + (i + 1) + ": ");
            while ((nome = conexao.in.readLine()) != null) {
                System.out.println("Nome: " + nome);
                break;
            }
            while ((fornecedor = conexao.in.readLine()) != null) {
                System.out.println("Fornecedor: " + fornecedor);
                break;
            }
            while ((preco = conexao.in.readLine()) != null) {
                System.out.println("Preço: " + preco);
                break;
            }
            while ((quantidade = conexao.in.readLine()) != null) {
                System.out.println("Quantidade: " + quantidade);
                break;
            }
           
        }
        
    }

    public void CadastrarProdutos(ClienteConexao conexao, String nome, String quantidade, String preco) throws UnknownHostException, IOException {
        conexao.out.println("CadastrarProdutos"); 
        conexao.out.println(nome);
        conexao.out.println(preco);
        conexao.out.println(quantidade);
    }

    public void deslogar(Socket s, PrintWriter out, BufferedReader in) throws UnknownHostException, IOException {
        out.println("Deslogar");
    }
}
