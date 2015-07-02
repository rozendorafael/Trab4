/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package UI.TelaCadastroProduto;

import UI.ConexaoCliente.ConexaoCliente;
import static UI.ConexaoCliente.FXMLDocumentController.conexao;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import mercadoclientegerenciador.MercadoClienteGerenciador;

/**
 * FXML Controller class
 *
 * @author Rafael
 */
public class CadastroProdutoController implements Initializable {
    MercadoClienteGerenciador mcg = new MercadoClienteGerenciador();

    @FXML
    private Button btnok;
     
    @FXML
    private TextField txtnome;

    @FXML
    private TextField txtpreco;

    @FXML
    private TextField txtquantidade;
    
    @FXML
    private void EnviaCadastroProduto(ActionEvent event) throws IOException {
    String nome, preco, quantidade;
    
    nome = txtnome.getText();
    preco = txtpreco.getText();
    quantidade = txtquantidade.getText();
    mcg.CadastrarProdutos(conexao, nome, quantidade, preco);   
    Parent root = FXMLLoader.load(getClass().getResource("/UI/TelaMenu/FXMLDocument2.fxml"));
    ConexaoCliente.SCENE.setRoot(root);

    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
