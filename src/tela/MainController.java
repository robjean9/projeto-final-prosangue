package tela;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import static tela.Main.MAC;
import static tela.Main.WINDOWS;

/**
 * FXML Controller class
 *
 * @author robson
 * @author Rafael
 */
public class MainController implements Initializable {

    @FXML
    private MenuItem menuItemUsuarios;
    @FXML
    private MenuItem menuItemDoadores;
    @FXML
    private MenuItem menuItemQuestionario;
    @FXML
    private MenuItem menuItemNovaDoacao;
    @FXML
    private MenuItem menuItemListDoacao;
    @FXML
    private MenuItem menuItemSair;
    @FXML
    private MenuItem menuItemCriarBanco;
    @FXML
    private MenuItem menuItemTipoExames;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void openUsuarios(ActionEvent event) throws FileNotFoundException, IOException {
        openWindow(returnPane("Usuarios.fxml"));
    }

    @FXML
    private void openDoadores(ActionEvent event) throws IOException {
        openWindow(returnPane("ListaDoadores.fxml"));
    }

    @FXML
    private void openTipoExames(ActionEvent event) throws IOException {
        openWindow(returnPane("TipoExame.fxml"));
    }

    @FXML
    private void openQuestionario(ActionEvent event) throws IOException {
        openWindow(returnPane("ListaQuestionario.fxml"));
    }

    @FXML
    private void openNewDoacao(ActionEvent event) throws IOException {
        openWindow(returnPane("CadastroDoacao.fxml"));
    }

    @FXML
    private void openDoacoes(ActionEvent event) throws IOException {
        openWindow(returnPane("Doacoes.fxml"));
    }

    @FXML
    private void sair(ActionEvent event) {
        Platform.exit();
    }

    @FXML
    private void onCriarBanco(ActionEvent event) throws IOException {
        openWindow(returnPane("ConfigurarBanco.fxml"));
    }

    @FXML
    private void onSobre(ActionEvent event) {

    }

    private void openWindow(Pane root) {
        Scene newScene = new Scene(root);
        Stage window = new Stage();
        window.setScene(newScene);
        window.show();
    }

    private Pane returnPane(String name) throws IOException {
        Pane pane = null;
        switch (Main.getInstance().getPlatform()) {
            case WINDOWS:
                pane = FXMLLoader.load(getClass().getResource(name));
                break;
            case MAC:
                FXMLLoader loader = new FXMLLoader();
                FileInputStream fxmlStream = new FileInputStream("/Users/robson/NetBeansProjects/ProjetoFinal/src/tela/" + name);
                pane = loader.load(fxmlStream);
                break;
        }
        return pane;
    }

}
