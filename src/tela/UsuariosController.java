/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tela;

import components.PasswordFieldCell;
import dao.UsuarioDAO;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.Timer;
import java.util.TimerTask;
import javafx.beans.value.ObservableValue;
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
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.util.Callback;
import vo.Usuario;

/**
 * FXML Controller class
 *
 * @author robson
 */
public class UsuariosController implements Initializable {

    @FXML
    private Button bInserir;
    @FXML
    private Button bExcluir;
    @FXML
    private TableView<Usuario> tvUsuarios;
    @FXML
    private TableColumn<Usuario, String> tvFieldNome;
    @FXML
    private TableColumn<Usuario, String> tvFieldEmail;
    @FXML
    private TableColumn<Usuario, String> tvFieldSenha;
    
    
    private ObservableList<Usuario> lUsuarios;
    @FXML
    private Button bGravar;
    
    private UsuarioDAO usuarioDAO;
    
    @FXML
    private Label lNovo;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    
        usuarioDAO = new UsuarioDAO();
        
    
    tvFieldNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
    tvFieldNome.setCellFactory(TextFieldTableCell.<Usuario>forTableColumn());
    tvFieldEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
    tvFieldEmail.setCellFactory(TextFieldTableCell.<Usuario>forTableColumn());
    tvFieldSenha.setCellValueFactory(new PropertyValueFactory<>("senha"));
     tvFieldSenha.setCellFactory(TextFieldTableCell.<Usuario>forTableColumn());
//    tvFieldSenha.setCellFactory(new Callback<TableColumn<Usuario, String>, TableCell<Usuario, String>>() {
//        @Override
//        public TableCell<Usuario, String> call(TableColumn<Usuario, String> cell){ 
//            return new PasswordFieldCell();
//        }
//    });
    lUsuarios = FXCollections.observableArrayList(usuarioDAO.pesquisa());
    tvUsuarios.setItems(lUsuarios);
    }    

    @FXML
    private void inserir(ActionEvent event) {
        lUsuarios.add(new Usuario());
        tvUsuarios.edit(tvUsuarios.getItems().size(), tvFieldNome);
        this.bGravar.setDisable(false);
    }


    @FXML
    private void excluir(ActionEvent event) {
        Usuario u = tvUsuarios.getSelectionModel().getSelectedItem();
        if(u.getId() != 0){
            usuarioDAO.excluir(u.getId());
        }
        lUsuarios = FXCollections.observableArrayList(usuarioDAO.pesquisa());
        tvUsuarios.setItems(lUsuarios);
    }

    @FXML
    private void gravar(ActionEvent event) {
        Usuario u = tvUsuarios.getSelectionModel().getSelectedItem();
        if(u.getId() == 0){
             System.out.println(u);
            if(u.getNome().isEmpty() || u.getEmail().isEmpty() || u.getSenha().isEmpty()){
                System.out.println("ERRO");
            }else{
                usuarioDAO.insere(u);
                lUsuarios = FXCollections.observableArrayList(usuarioDAO.pesquisa());
                tvUsuarios.setItems(lUsuarios);
            }
        }else{
            usuarioDAO.atualiza(u);
        }
       
    }

    @FXML
    private void editNome(TableColumn.CellEditEvent<Usuario, String> event) {
        
        event.getTableView().getItems().get(event.getTablePosition().getRow()).setNome(event.getNewValue());
        if(event.getTableView().getItems().get(event.getTablePosition().getRow()).getId() != 0){
            usuarioDAO.atualiza(event.getTableView().getItems().get(event.getTablePosition().getRow()));
            this.lNovo.setVisible(true);
            alterarMensagem();
        }
    }

    @FXML
    private void editEmail(TableColumn.CellEditEvent<Usuario, String> event) {
        
        event.getTableView().getItems().get(event.getTablePosition().getRow()).setEmail(event.getNewValue());
         if(event.getTableView().getItems().get(event.getTablePosition().getRow()).getId() != 0){
            usuarioDAO.atualiza(event.getTableView().getItems().get(event.getTablePosition().getRow()));
            this.lNovo.setVisible(true);
            alterarMensagem();
        }
    }

    @FXML
    private void editSenha(TableColumn.CellEditEvent<Usuario, String> event) {
        
        event.getTableView().getItems().get(event.getTablePosition().getRow()).setSenha(event.getNewValue());
         if(event.getTableView().getItems().get(event.getTablePosition().getRow()).getId() != 0){
            usuarioDAO.atualiza(event.getTableView().getItems().get(event.getTablePosition().getRow()));
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
