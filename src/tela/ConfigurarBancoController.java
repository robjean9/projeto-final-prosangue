package tela;

import components.LerScript;
import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Rafael Penczkoski
 */
public class ConfigurarBancoController implements Initializable {

    @FXML
    private ProgressBar progressBarStatus;
    @FXML
    private Button buttonComecar;
    @FXML
    private Button buttonOk;
    @FXML
    private Label labelStatus;
    private FileChooser fileChooser;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        fileChooser = new FileChooser();
        fileChooser.setInitialDirectory(new File(System.getProperty("user.home")));
    }

    @FXML
    private void onComecar(ActionEvent event) throws Exception {
        File f = fileChooser.showOpenDialog(null);
        if (f == null) {
            return;
        }
        buttonComecar.setDisable(true);
        buttonOk.setDisable(true);
        progressBarStatus.setProgress(ProgressBar.INDETERMINATE_PROGRESS);
        labelStatus.setText("Criando banco de dados...");
        try {
            LerScript ls = new LerScript();
            ls.runScript(f);
            labelStatus.setText("Banco de dados criado com sucesso!");
            buttonOk.setDisable(false);
            progressBarStatus.setProgress(100);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            labelStatus.setText("Não foi possível criar o banco de dados.");
            progressBarStatus.setProgress(0);
            buttonOk.setDisable(false);
            throw e;
        }
    }

    @FXML
    private void onOk(ActionEvent event) {
        Button b = (Button) event.getSource();
        Stage s = (Stage) b.getScene().getWindow();
        s.close();
    }

}
