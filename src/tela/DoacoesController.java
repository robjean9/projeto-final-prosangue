/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tela;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
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
    private TableColumn<Doacao, String> tvcDataNasc1;
    @FXML
    private TableColumn<Doacao, String> tvcDataNasc;
    @FXML
    private TableColumn<Doacao, String> tvcCpf;
    @FXML
    private TableColumn<Doacao, String> tvcDataDoacao;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        
        
        
    }    

    @FXML
    private void novo(ActionEvent event) {
    }

    @FXML
    private void editar(ActionEvent event) {
    }

    @FXML
    private void excluir(ActionEvent event) {
    }

    @FXML
    private void atualizar(ActionEvent event) {
    }
    
}
