/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mercadoclientegerenciador;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 *
 * @author Rafael
 */
public class ClienteConexao {
    public Socket socket;

    public BufferedReader in;
    public PrintWriter out;
    String ip; 
    int port;

    public ClienteConexao(String ip, int port ) throws IOException {
        this.ip = ip;
        this.port = port;
        socket = new Socket(ip,port);
        AbrirStream();
    }
    
    //Realiza abertura do stream a transferência de informações
    protected void AbrirStream() throws IOException {
        in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        out = new PrintWriter(socket.getOutputStream(),true);
    }
    
    public String getIp() {
        return ip;
    }

    public int getPort() {
        return port;
    }
    
}
