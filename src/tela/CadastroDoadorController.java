/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tela;

import dao.DoadorDAO;
import java.net.URL;
import java.time.ZoneId;
import java.util.Date;
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
 */
public class CadastroDoadorController implements Initializable {
    
    
    private boolean novo;
    private Doador doador;
    private DoadorDAO doadorDAO;
    @FXML
    private TextField tNome;
    @FXML
    private TextField tEndereco;
    @FXML
    private DatePicker tData;
    @FXML
    private TextField tPai;
    @FXML
    private TextField tMae;
    @FXML
    private TextField tCpf;
    @FXML
    private Button bSalvar;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        doadorDAO = new DoadorDAO();
        doador = new Doador();
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
    private void salvar(ActionEvent event) {
        doador.setNome(tNome.getText());
        doador.setEndereco(tEndereco.getText());
        doador.setNomeMae(tMae.getText());
        doador.setNomePai(tPai.getText());
        doador.setCpf(tCpf.getText());
        doador.setDataNascimento(Date.from(tData.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant()));
        
        if(isNovo()){
            this.doadorDAO.insere(doador);
             
        }else{
            this.doadorDAO.atualiza(doador);
        }
        ((Stage)(((Button)event.getSource()).getScene().getWindow())).close();
        
    }
    
    
    private void loadDataToView(){
        tNome.setText(doador.getNome());
        tEndereco.setText(doador.getEndereco());
        tMae.setText(doador.getNomeMae());
        tPai.setText(doador.getNomePai());
        tCpf.setText(doador.getCpf());
        tData.setValue(doador.getDataNascimento().toInstant()
      .atZone(ZoneId.systemDefault())
      .toLocalDate());
    }
    
    
    
    
}
