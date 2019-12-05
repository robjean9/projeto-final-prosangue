/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tela;

import dao.DoadorDAO;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
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
import javafx.stage.WindowEvent;
import vo.Doador;

/**
 * FXML Controller class
 *
 * @author robson
 */
public class ListaDoadoresController implements Initializable {

    @FXML
    private Button bCriarNovo;
    @FXML
    private Button bEditar;
    @FXML
    private Button bExcluir;
    @FXML
    private Button bAtualizar;
    @FXML
    private TableView<Doador> tvDoadores;
    @FXML
    private TableColumn<Doador, String> tvcNome;
    @FXML
    private TableColumn<Doador, String> tvcEndereco;
    @FXML
    private TableColumn<Doador, Date> tvcDataNasc;
    @FXML
    private TableColumn<Doador, String> tvcNomePai;
    @FXML
    private TableColumn<Doador, String> tvcNomeMae;
    @FXML
    private TableColumn<Doador, String> tvcCpf;
    
    private ObservableList<Doador> lDoador;
    
    private DoadorDAO doadorDAO;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        doadorDAO = new DoadorDAO();
        
        
        
         tvcNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
         tvcEndereco.setCellValueFactory(new PropertyValueFactory<>("endereco"));
         tvcDataNasc.setCellValueFactory(new PropertyValueFactory<>("dataNascimento"));
         tvcNomeMae.setCellValueFactory(new PropertyValueFactory<>("nomeMae"));
         tvcNomePai.setCellValueFactory(new PropertyValueFactory<>("nomePai"));
         tvcCpf.setCellValueFactory(new PropertyValueFactory<>("cpf"));
         DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
 
         tvcDataNasc.setCellFactory(column -> {
            return new TableCell<Doador, Date>() {
                @Override
                protected void updateItem(Date item, boolean empty) {
                    super.updateItem(item, empty); 
                    
                    if(item == null || empty){
                        setText(null);
                    }else{
                        setText(formatter.format(item.toInstant().atZone(ZoneId.systemDefault()).toLocalDate()));
                    }
                }
            };
         });
         this.atualizar();
         
        
    }    
    
    private void atualizar(){
        lDoador = FXCollections.observableArrayList(doadorDAO.pesquisa());
        tvDoadores.setItems(lDoador);
    }

    @FXML
    private void novo(ActionEvent event) throws FileNotFoundException, IOException {
        
        FXMLLoader loader = new FXMLLoader();
        
        FileInputStream fxmlStream = new FileInputStream("/Users/robson/NetBeansProjects/ProjetoFinal/src/tela/CadastroDoador.fxml");
        Pane root = (Pane) loader.load(fxmlStream);
        Scene newScene = new Scene(root);
        
        CadastroDoadorController tela = loader.getController();
        tela.setNovo(true);
        
        
        Stage window = new Stage();
        window.setScene(newScene);
        window.show();
    }

    @FXML
    private void editar(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        
        FileInputStream fxmlStream = new FileInputStream("/Users/robson/NetBeansProjects/ProjetoFinal/src/tela/CadastroDoador.fxml");
        Pane root = (Pane) loader.load(fxmlStream);
        Scene newScene = new Scene(root);
        
        CadastroDoadorController tela = loader.getController();
        tela.setNovo(false);
        tela.setDoador(tvDoadores.getSelectionModel().getSelectedItem());        
        
        Stage window = new Stage();
        window.setScene(newScene);
        window.show();
    }

    @FXML
    private void excluir(ActionEvent event) {
    }

    @FXML
    private void atualizar(ActionEvent event) {
        this.atualizar();
    }
    
}
