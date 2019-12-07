/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tela;

import dao.TipoExameDAO;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.concurrent.WorkerStateEvent;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import vo.TipoExame;

/**
 * FXML Controller class
 *
 * @author robson
 */
public class TipoExameController implements Initializable {

    @FXML
    private Button bInserir;
    @FXML
    private Button bExcluir;
    @FXML
    private Button bGravar;
    @FXML
    private Label lNovo;
    @FXML
    private TableView<TipoExame> tvTipoExame;
    @FXML
    private TableColumn<TipoExame, String> tvFieldTipoExame;
    
    
    private ObservableList<TipoExame> lTipoExame;
    
    private TipoExameDAO tipoExameDAO;


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
         tipoExameDAO = new TipoExameDAO();
        
        tvFieldTipoExame.setCellValueFactory(new PropertyValueFactory<>("tipo"));
        tvFieldTipoExame.setCellFactory(TextFieldTableCell.<TipoExame>forTableColumn());
        lTipoExame = FXCollections.observableArrayList(tipoExameDAO.pesquisa());
        tvTipoExame.setItems(lTipoExame);
        // TODO
    }    

    @FXML
    private void inserir(ActionEvent event) {
        lTipoExame.add(new TipoExame());
        tvTipoExame.edit(tvTipoExame.getItems().size(), tvFieldTipoExame);
        this.bGravar.setDisable(false);
    }

    @FXML
    private void excluir(ActionEvent event) {
        TipoExame u = tvTipoExame.getSelectionModel().getSelectedItem();
        if(u.getId() != 0){
            tipoExameDAO.excluir(u.getId());
        }
        lTipoExame = FXCollections.observableArrayList(tipoExameDAO.pesquisa());
        tvTipoExame.setItems(lTipoExame);
    }

    @FXML
    private void gravar(ActionEvent event) {
        TipoExame u = tvTipoExame.getSelectionModel().getSelectedItem();
        if(u.getId() == 0){
             System.out.println(u);
            if(u.getTipo().isEmpty()){
                System.out.println("ERRO");
            }else{
                tipoExameDAO.insere(u);
                lTipoExame = FXCollections.observableArrayList(tipoExameDAO.pesquisa());
                tvTipoExame.setItems(lTipoExame);
            }
        }else{
            tipoExameDAO.atualiza(u);
        }
    }

    @FXML
    private void editQuestao(TableColumn.CellEditEvent<TipoExame, String> event) {
        event.getTableView().getItems().get(event.getTablePosition().getRow()).setTipo(event.getNewValue());
        if(event.getTableView().getItems().get(event.getTablePosition().getRow()).getId() != 0){
            tipoExameDAO.atualiza(event.getTableView().getItems().get(event.getTablePosition().getRow()));
            this.lNovo.setVisible(true);
            alterarMensagem();
        }
    }
    
    private void alterarMensagem(){
        Task<Void> sleeper = new Task<Void>() {
            @Override
            protected Void call() throws Exception {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                }
                return null;
            }
        };
        sleeper.setOnSucceeded(new EventHandler<WorkerStateEvent>() {
            @Override
            public void handle(WorkerStateEvent event) {
                lNovo.setVisible(false);
            }
        });
        new Thread(sleeper).start();
    }
    
}
