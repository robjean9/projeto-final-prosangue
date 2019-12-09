/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tela;

import dao.ExameDAO;
import dao.TipoExameDAO;
import java.net.URL;
import java.util.Observable;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;
import vo.Doacao;
import vo.Doador;
import vo.Exame;
import vo.TipoExame;

/**
 * FXML Controller class
 *
 * @author robson
 */
public class ExameController implements Initializable {

    @FXML
    private Button bSalvar;
    @FXML
    private ComboBox<TipoExame> cbTipoExame1;
    @FXML
    private TextArea taResultado1;
    @FXML
    private Label lNomePaciente1;
    
    private TipoExameDAO tipoExameDAO;
    
    private ObservableList<TipoExame> lTipoExame;
    
    private Doacao doacao;
    
    private Doador doador;
    
    private ExameDAO exameDAO;
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        tipoExameDAO = new TipoExameDAO();
        exameDAO = new ExameDAO();
        
        lTipoExame = FXCollections.observableArrayList(tipoExameDAO.pesquisa());
        
        cbTipoExame1.setItems(lTipoExame);
        
        
        
    }    

    @FXML
    private void salvar(ActionEvent event) {
        if(taResultado1.getText().trim().isEmpty()){
            //error
        }else{
            if(cbTipoExame1.getSelectionModel().getSelectedItem() != null){
                Exame exame = new Exame(0, cbTipoExame1.getSelectionModel().getSelectedItem().getId(), taResultado1.getText(), doacao.getId());
                exameDAO.insere(exame);
                 ((Stage)(((Button)event.getSource()).getScene().getWindow())).close();
            }else{
                //error
            }
        }
    }

    @FXML
    private void selectTipoExame(ActionEvent event) {
        
    }

    /**
     * @return the doacao
     */
    public Doacao getDoacao() {
        return doacao;
    }

    /**
     * @param doacao the doacao to set
     */
    public void setDoacao(Doacao doacao) {
        this.doacao = doacao;
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
    }
    
}
