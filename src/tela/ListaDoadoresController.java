package tela;

import dao.DoadorDAO;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
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
import vo.Doador;

/**
 * FXML Controller class
 *
 * @author robson
 */
public class ListaDoadoresController implements Initializable {

    @FXML
    private Button buttonCriarNovo;
    @FXML
    private Button buttonEditar;
    @FXML
    private Button buttonExcluir;
    @FXML
    private Button buttonAtualizar;
    @FXML
    private TableView<Doador> tableViewDoadores;
    @FXML
    private TableColumn<Doador, String> tableColumnNome;
    @FXML
    private TableColumn<Doador, String> tableColumnEndereco;
    @FXML
    private TableColumn<Doador, Date> tableColumnDataNasc;
    @FXML
    private TableColumn<Doador, String> tableColumnNomePai;
    @FXML
    private TableColumn<Doador, String> tableColumnNomeMae;
    @FXML
    private TableColumn<Doador, String> tableColumnCpf;

    private ObservableList<Doador> oListDoador;
    private DoadorDAO doadorDAO;
    private HashMap<String, FXMLLoader> loaders;
    private SimpleDateFormat dateFormat;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        loaders = new HashMap<>();
        doadorDAO = new DoadorDAO();
        dateFormat = new SimpleDateFormat("dd/MM/yyyy");

        tableColumnNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        tableColumnEndereco.setCellValueFactory(new PropertyValueFactory<>("endereco"));
        tableColumnDataNasc.setCellValueFactory(new PropertyValueFactory<>("dataNascimento"));
        tableColumnNomeMae.setCellValueFactory(new PropertyValueFactory<>("nomeMae"));
        tableColumnNomePai.setCellValueFactory(new PropertyValueFactory<>("nomePai"));
        tableColumnCpf.setCellValueFactory(new PropertyValueFactory<>("cpf"));

        tableColumnDataNasc.setCellFactory(column -> {
            return new TableCell<Doador, Date>() {
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
            this.atualizar();
        } catch (ParseException ex) {
            Logger.getLogger(ListaDoadoresController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @FXML
    private void atualizar() throws ParseException {
        oListDoador = FXCollections.observableArrayList(doadorDAO.pesquisa());
        tableViewDoadores.setItems(oListDoador);
    }

    @FXML
    private void novo(ActionEvent event) throws FileNotFoundException, IOException {
        Pane root = returnPane("CadastroDoador.fxml");
        Scene newScene = new Scene(root);

        CadastroDoadorController tela = loaders.get("CadastroDoador.fxml").getController();
        tela.setNovo(true);

        Stage window = new Stage();
        window.setScene(newScene);
        window.show();
    }

    @FXML
    private void editar(ActionEvent event) throws IOException {
        Pane root = returnPane("CadastroDoador.fxml");
        Scene newScene = new Scene(root);

        CadastroDoadorController tela = loaders.get("CadastroDoador.fxml").getController();
        tela.setNovo(false);
        tela.setDoador(tableViewDoadores.getSelectionModel().getSelectedItem());

        Stage window = new Stage();
        window.setScene(newScene);
        window.show();
    }

    @FXML
    private void excluir(ActionEvent event) throws ParseException {
        doadorDAO.excluir(tableViewDoadores.getSelectionModel().getSelectedItem().getId());
        this.atualizar();
    }

    private void atualizar(ActionEvent event) throws ParseException {
        this.atualizar();
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
