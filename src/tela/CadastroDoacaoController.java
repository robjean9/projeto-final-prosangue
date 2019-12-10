package tela;

import dao.DoacaoDAO;
import dao.DoadorDAO;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.ZoneId;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.stage.Stage;
import vo.Doacao;
import vo.Doador;

/**
 * FXML Controller class
 *
 * @author robson
 * @author Rafael
 */
public class CadastroDoacaoController implements Initializable {

    private boolean novo = true;
    private Doacao doacao;
    @FXML
    private ComboBox<Doador> cbDoador;
    @FXML
    private DatePicker dpDataHora;
    private DoadorDAO doadorDAO;
    private DoacaoDAO doacaoDAO;
    private SimpleDateFormat dateFormat;
    private ObservableList<Doador> oListDoador;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        doacao = new Doacao();
        doadorDAO = new DoadorDAO();
        doacaoDAO = new DoacaoDAO();
        dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            oListDoador = FXCollections.observableArrayList(doadorDAO.pesquisa());
            cbDoador.setItems(oListDoador);
        } catch (ParseException ex) {
            Logger.getLogger(CadastroDoacaoController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public boolean isNovo() {
        return novo;
    }

    public void setNovo(boolean novo) {
        this.novo = novo;
    }

    public void setDoacao(Doacao doacao) throws ParseException {
        this.doacao = doacao;
        loadDataToView();
    }

    @FXML
    private void onSalvar(ActionEvent event) throws ParseException {
        doacao.setDoadorId(cbDoador.getSelectionModel().getSelectedItem().getId());
        doacao.setDataHora(dateFormat.parse(dpDataHora.getValue().toString()));

        if (isNovo()) {
            this.doacaoDAO.insere(doacao);

        } else {
            this.doacaoDAO.atualiza(doacao);
        }
        ((Stage) (((Button) event.getSource()).getScene().getWindow())).close();
    }

    @FXML
    private void onCancelar(ActionEvent event) {
        Button b = (Button) event.getSource();
        Stage s = (Stage) b.getScene().getWindow();
        s.close();
    }

    private void loadDataToView() throws ParseException {
        Doador d = doadorDAO.localiza(doacao.getDoadorId());
        cbDoador.getSelectionModel().select(d);
        dpDataHora.setValue(doacao.getDataHora().toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDate());
    }

}
