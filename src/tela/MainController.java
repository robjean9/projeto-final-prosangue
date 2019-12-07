/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tela;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author robson
 */
public class MainController implements Initializable {

    @FXML
    private MenuItem miUsuarios;
    @FXML
    private MenuItem miDoadores;
    @FXML
    private MenuItem miExames;
    @FXML
    private MenuItem miQuestionario;
    @FXML
    private MenuItem miNovaDoacao;
    @FXML
    private MenuItem miListDoacao;
    @FXML
    private MenuItem miSair;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void openUsuarios(ActionEvent event) throws FileNotFoundException, IOException {
        FXMLLoader loader = new FXMLLoader();
        
        FileInputStream fxmlStream = new FileInputStream("/Users/robson/NetBeansProjects/ProjetoFinal/src/tela/Usuarios.fxml");
        Pane root = (Pane) loader.load(fxmlStream);
        Scene newScene = new Scene(root);
        Stage window = new Stage();
        window.setScene(newScene);
        window.show();
    }

    @FXML
    private void openDoadores(ActionEvent event) throws IOException {
         FXMLLoader loader = new FXMLLoader();
        
        FileInputStream fxmlStream = new FileInputStream("/Users/robson/NetBeansProjects/ProjetoFinal/src/tela/ListaDoadores.fxml");
        Pane root = (Pane) loader.load(fxmlStream);
        Scene newScene = new Scene(root);
        Stage window = new Stage();
        window.setScene(newScene);
        window.show();
    }

    @FXML
    private void openExames(ActionEvent event) throws IOException {
         FXMLLoader loader = new FXMLLoader();
        
        FileInputStream fxmlStream = new FileInputStream("/Users/robson/NetBeansProjects/ProjetoFinal/src/tela/TipoExame.fxml");
        Pane root = (Pane) loader.load(fxmlStream);
        Scene newScene = new Scene(root);
        Stage window = new Stage();
        window.setScene(newScene);
        window.show();
    }

    @FXML
    private void openQuestionario(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        
        FileInputStream fxmlStream = new FileInputStream("/Users/robson/NetBeansProjects/ProjetoFinal/src/tela/ListaQuestionario.fxml");
        Pane root = (Pane) loader.load(fxmlStream);
        Scene newScene = new Scene(root);
        Stage window = new Stage();
        window.setScene(newScene);
        window.show();
    }

    @FXML
    private void openNewDoacao(ActionEvent event) throws IOException {
         
    }

    @FXML
    private void openDoacoes(ActionEvent event) {
    }

    @FXML
    private void sair(ActionEvent event) {
        Platform.exit();
    }
    
}
