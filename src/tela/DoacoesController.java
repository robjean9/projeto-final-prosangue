package tela;

import dao.DoacaoDAO;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import static tela.Main.MAC;
import static tela.Main.WINDOWS;
import vo.Doacao;

/**
 * FXML Controller class
 *
 * @author robson
 */
public class DoacoesController implements Initializable {

    @FXML
    private Button bCriarNovo;
    @FXML
    private Button bEditar;
    @FXML
    private Button bExcluir;
    @FXML
    private Button bAtualizar;
    @FXML
    private TableView<Doacao> tvDoacoes;
    @FXML
    private TableColumn<Doacao, String> tvcNome;
    @FXML
    private TableColumn<Doacao, Date> tvcDataNasc;
    @FXML
    private TableColumn<Doacao, String> tvcCpf;
    @FXML
    private TableColumn<Doacao, Date> tvcDataDoacao;

    private ObservableList<Doacao> oListDoacoes;
    private DoacaoDAO doacaoDAO;
    private HashMap<String, FXMLLoader> loaders;
    private SimpleDateFormat dateFormat;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        doacaoDAO = new DoacaoDAO();
        loaders = new HashMap<>();
        dateFormat = new SimpleDateFormat("dd/MM/yyyy");

        tvcNome.setCellValueFactory(new PropertyValueFactory<>("nomeDoador"));
        tvcCpf.setCellValueFactory(new PropertyValueFactory<>("cpfDoador"));
        tvcDataNasc.setCellValueFactory(new PropertyValueFactory<>("dataNacDoador"));
        tvcDataNasc.setCellFactory(column -> {
            return new TableCell<Doacao, Date>() {
                @Override
                protected void updateItem(Date item, boolean empty) {
                    super.updateItem(item, empty);

                    if (item == null || empty) {
                        setText(null);
                    } else {
                        setText(dateFormat.format(item));
                    }
                }
            };
        });
        tvcDataDoacao.setCellValueFactory(new PropertyValueFactory<>("dataHora"));
        tvcDataDoacao.setCellFactory(column -> {
            return new TableCell<Doacao, Date>() {
                @Override
                protected void updateItem(Date item, boolean empty) {
                    super.updateItem(item, empty);

                    if (item == null || empty) {
                        setText(null);
                    } else {
                        setText(dateFormat.format(item));
                    }
                }
            };
        });

        try {
            atualizar(null);
        } catch (ParseException ex) {
            Logger.getLogger(DoacoesController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void novo(ActionEvent event) throws IOException {
        Pane root = returnPane("CadastroDoacao.fxml");
        Scene newScene = new Scene(root);

        CadastroDoacaoController tela = loaders.get("CadastroDoacao.fxml").getController();
        tela.setNovo(true);

        Stage window = new Stage();
        window.setScene(newScene);
        window.show();
    }

    @FXML
    private void editar(ActionEvent event) throws IOException, ParseException {
        Pane root = returnPane("CadastroDoacao.fxml");
        Scene newScene = new Scene(root);

        CadastroDoacaoController tela = loaders.get("CadastroDoacao.fxml").getController();
        tela.setNovo(false);
        tela.setDoacao(tvDoacoes.getSelectionModel().getSelectedItem());

        Stage window = new Stage();
        window.setScene(newScene);
        window.show();
    }

    @FXML
    private void excluir(ActionEvent event) throws ParseException {
        doacaoDAO.excluir(tvDoacoes.getSelectionModel().getSelectedItem().getId());
        this.atualizar(null);
    }

    @FXML
    private void atualizar(ActionEvent event) throws ParseException {
        oListDoacoes = FXCollections.observableArrayList(doacaoDAO.pesquisa());
        tvDoacoes.setItems(oListDoacoes);
    }

    private Pane returnPane(String name) throws IOException {
        Pane pane = null;
        FXMLLoader loader = null;
        switch (Main.getInstance().getPlatform()) {
            case WINDOWS:
                loader = new FXMLLoader(getClass().getResource(name));
                pane = loader.load();
                break;
            case MAC:
                loader = new FXMLLoader();
                FileInputStream fxmlStream = new FileInputStream("/Users/robson/NetBeansProjects/ProjetoFinal/src/tela/" + name);
                pane = loader.load(fxmlStream);
                break;
        }
        loaders.put(name, loader);
        return pane;
    }

}
