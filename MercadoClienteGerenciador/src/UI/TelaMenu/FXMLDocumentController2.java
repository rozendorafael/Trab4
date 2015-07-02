package UI.TelaMenu;

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
import mercadoclientegerenciador.ClienteConexao;
import mercadoclientegerenciador.MercadoClienteGerenciador;

/**
 *
 * @author Rafael
 */
public class FXMLDocumentController2 implements Initializable {

    MercadoClienteGerenciador mercado = new MercadoClienteGerenciador();
    
    @FXML
    private Button ok;

    @FXML
    private TextField txtip;

    @FXML
    private TextField txtport;

  

    @FXML
    private void EstabeleceConexao(ActionEvent event) throws IOException {
        String ip = txtip.getText();
        int port;
        port = (Integer.parseInt(txtport.getText()));
        ClienteConexao conexao = new ClienteConexao(ip,port);
        

    }

     @FXML
    private void CadastrarPessoa(ActionEvent event2) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/UI/TelaCadastro/FXMLCadastroPessoa.fxml"));
        ConexaoCliente.SCENE.setRoot(root);
      
    }
    
     @FXML
    private void CadastrarProduto(ActionEvent event0) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/UI/TelaCadastroProduto/CadastroProduto.fxml"));
        ConexaoCliente.SCENE.setRoot(root);
      
    }
    
    
     @FXML
    private void ListaProdutos(ActionEvent event2) throws IOException {
        mercado.VisualizarProdutos(conexao);
         
    }
    
     @FXML
    private void RealizaLogin(ActionEvent event7) throws IOException {
        mercado.Login(conexao);
    }

    
    
    
    
    
   

    @Override
    public void initialize(URL url, ResourceBundle rb) {

       
    }

}
