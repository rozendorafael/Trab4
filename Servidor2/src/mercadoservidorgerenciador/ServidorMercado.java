/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mercadoservidorgerenciador;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author Rafael
 */
public class ServidorMercado {
    
    public static void main(String[] args) {
        final int porta = 6565;
        MercadoServidorGerenciador mercado = new MercadoServidorGerenciador();
        mercado.recuperarDados();
        ServerSocket ss;
        try {
            ss = new ServerSocket(porta);
            while (true) {

                try {
                    System.out.println("Esperando por conexoes..");
                    Socket s = ss.accept();
                    System.out.println("Um cliente foi conectado ao servidor!!");
                    Thread t = new Thread(() -> {
                        System.out.println("Criando thread..");
                        try {
                            String opcao;
                            PrintWriter out = new PrintWriter(s.getOutputStream(), true);
                            BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
                            System.out.println("Mandando resposta para o cliente");
                            out.println("Voce está conectado ao servidor!"); 
                            while (true) {
                                while ((opcao = in.readLine()) != null) {
                                    if ("Login".equals(opcao)) {
                                        System.out.println("Fazendo login no servidor..");
                                        if (mercado.Login(s, out, in)) {
                                            out.println("Credenciais validas!"); 
                                            out.println(mercado.retornaStr());
                                        } else {
                                            out.println("Credenciais invalidas!");
                                        }
                                    } else if ("CadastrarUsuario".equals(opcao)) {
                                        System.out.println("Cadastrando no servidor..");
                                        if (mercado.CadastrarUsuario(s, out, in)) {
                                            out.println("ok");
                                        } else {
                                            out.println("erro");
                                        }
                                    } else if ("VisualizarProdutos".equals(opcao)) {
                                        System.out.println("Produtos...");
                                        
                                    } else if ("CadastrarProdutos".equals(opcao)) {
                                        System.out.println("Cadastro...");
                                        mercado.CadastrarProdutos(s, out, in);
                                    } 
                                    break;
                                }
                                mercado.salvarDados();
                            }
                        } catch (Exception e) {
                            
                        }
                    });
                    t.start();
                } catch (Exception e) {
                    System.out.println("Erro ao conectar cliente: " + e);
                }
            }

        } catch (Exception e) {
            System.out.println("Erro no servidor: " + e);
        }

    }
    
}
