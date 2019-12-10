package tela;

import dao.DoadorDAO;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.ZoneId;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import vo.Doador;

/**
 * FXML Controller class
 *
 * @author robson
 * @author Rafael
 */
public class CadastroDoadorController implements Initializable {

    @FXML
    private TextField textFieldNome;
    @FXML
    private TextField textFieldEndereco;
    @FXML
    private DatePicker datePickerData;
    @FXML
    private TextField textFieldPai;
    @FXML
    private TextField textFieldMae;
    @FXML
    private TextField textFieldCpf;
    @FXML
    private Button buttonSalvar;
    @FXML
    private Button buttonCancelar;

    private boolean novo = true;
    private Doador doador;
    private DoadorDAO doadorDAO;
    private SimpleDateFormat dateFormat;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        doadorDAO = new DoadorDAO();
        doador = new Doador();
        dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    }

    /**
     * @return the novo
     */
    public boolean isNovo() {
        return novo;
    }

    /**
     * @param novo the novo to set
     */
    public void setNovo(boolean novo) {
        this.novo = novo;
    }

    /**
     * @return the doador
     */
    public Doador getDoador() {
        return doador;
    }

    /**
     * @param doador the doador to set
     */
    public void setDoador(Doador doador) {
        this.doador = doador;
        loadDataToView();
    }

    @FXML
    private void handleCpfFormatter(KeyEvent event) {

    }

    @FXML
    private void salvar(ActionEvent event) throws ParseException {
        doador.setNome(textFieldNome.getText());
        doador.setEndereco(textFieldEndereco.getText());
        doador.setNomeMae(textFieldMae.getText());
        doador.setNomePai(textFieldPai.getText());
        doador.setCpf(textFieldCpf.getText());
        doador.setDataNascimento(dateFormat.parse(datePickerData.getValue().toString()));
        if (isNovo()) {
            this.doadorDAO.insere(doador);

        } else {
            this.doadorDAO.atualiza(doador);
        }
        ((Stage) (((Button) event.getSource()).getScene().getWindow())).close();
    }

    private void loadDataToView() {
        textFieldNome.setText(doador.getNome());
        textFieldEndereco.setText(doador.getEndereco());
        textFieldMae.setText(doador.getNomeMae());
        textFieldPai.setText(doador.getNomePai());
        textFieldCpf.setText(doador.getCpf());
        datePickerData.setValue(doador.getDataNascimento().toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDate());
    }

    @FXML
    private void onCancelar(ActionEvent event) {
        Button b = (Button) event.getSource();
        Stage s = (Stage) b.getScene().getWindow();
        s.close();
    }

}
