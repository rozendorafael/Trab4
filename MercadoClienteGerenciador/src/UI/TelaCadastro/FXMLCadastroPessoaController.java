/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package UI.TelaCadastro;

import static UI.ConexaoCliente.FXMLDocumentController.conexao;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import mercadoclientegerenciador.MercadoClienteGerenciador;

/**
 * FXML Controller class
 *
 * @author Rafael
 */
public class FXMLCadastroPessoaController implements Initializable {
    
    MercadoClienteGerenciador mcg = new MercadoClienteGerenciador();
    
    @FXML
    private Button btnok;

    @FXML
    private TextField txtemail;

    @FXML
    private TextField txtend;

    @FXML
    private TextField txtid;

    @FXML
    private TextField txtnome;

    @FXML
    private TextField txtsenha;

    @FXML
    private TextField txttel;
    
@FXML
    private void EnviaDadosCadastro(ActionEvent event) throws IOException {
    String nome, end,  tel,  email,  id,  senha;
    nome = txtnome.getText();
    end = txtend.getText();
    tel = txttel.getText();
    email = txtemail.getText();
    id = txtid.getText();
    senha = txtsenha.getText();
    System.out.println(conexao.getIp() + " " + conexao.getPort());
    mcg.CadastrarUsuario(conexao, nome, end, tel, email, id, senha);

        

    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
