/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tela;

import dao.QuestionarioDAO;
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
import vo.Questao;

/**
 * FXML Controller class
 *
 * @author robson
 */
public class ListaQuestionarioController implements Initializable {

    @FXML
    private Button bInserir;
    @FXML
    private Button bExcluir;
    @FXML
    private Button bGravar;
    @FXML
    private Label lNovo;
    @FXML
    private TableColumn<Questao, String> tvFieldQuestao;
    @FXML
    private TableView<Questao> tvQuestoes;
    
    private ObservableList<Questao> lQuestoes;
    
    private QuestionarioDAO questaoDAO;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        questaoDAO = new QuestionarioDAO();
        
        tvFieldQuestao.setCellValueFactory(new PropertyValueFactory<>("questao"));
        tvFieldQuestao.setCellFactory(TextFieldTableCell.<Questao>forTableColumn());
        lQuestoes = FXCollections.observableArrayList(questaoDAO.pesquisa());
        tvQuestoes.setItems(lQuestoes);
    }    

    @FXML
    private void inserir(ActionEvent event) {
        lQuestoes.add(new Questao());
        tvQuestoes.edit(tvQuestoes.getItems().size(), tvFieldQuestao);
        this.bGravar.setDisable(false);
    }

    @FXML
    private void excluir(ActionEvent event) {
        Questao u = tvQuestoes.getSelectionModel().getSelectedItem();
        if(u.getId() != 0){
            questaoDAO.excluir(u.getId());
        }
        lQuestoes = FXCollections.observableArrayList(questaoDAO.pesquisa());
        tvQuestoes.setItems(lQuestoes);
    }

    @FXML
    private void gravar(ActionEvent event) {
        Questao u = tvQuestoes.getSelectionModel().getSelectedItem();
        if(u.getId() == 0){
             System.out.println(u);
            if(u.getQuestao().isEmpty()){
                System.out.println("ERRO");
            }else{
                questaoDAO.insere(u);
                lQuestoes = FXCollections.observableArrayList(questaoDAO.pesquisa());
                tvQuestoes.setItems(lQuestoes);
            }
        }else{
            questaoDAO.atualiza(u);
        }
    }

    @FXML
    private void editQuestao(TableColumn.CellEditEvent<Questao, String> event) {
        event.getTableView().getItems().get(event.getTablePosition().getRow()).setQuestao(event.getNewValue());
        if(event.getTableView().getItems().get(event.getTablePosition().getRow()).getId() != 0){
            questaoDAO.atualiza(event.getTableView().getItems().get(event.getTablePosition().getRow()));
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
