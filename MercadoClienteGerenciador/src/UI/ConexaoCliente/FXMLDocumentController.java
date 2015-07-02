package UI.ConexaoCliente;

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

/**
 *
 * @author Rafael
 */
public class FXMLDocumentController implements Initializable {
    public static ClienteConexao conexao;

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
        conexao = new ClienteConexao(ip,port); 
        Parent root = FXMLLoader.load(getClass().getResource("/UI/TelaMenu/FXMLDocument2.fxml"));
        
        ConexaoCliente.SCENE.setRoot(root);

        

    }


    @Override
    public void initialize(URL url, ResourceBundle rb) {

       
    }

}
