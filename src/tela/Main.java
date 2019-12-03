/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tela;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author robson
 */
public class Main extends Application {
    
    @Override
    public void start(Stage primaryStage) throws FileNotFoundException, IOException {
       FXMLLoader loader = new FXMLLoader();
        
        FileInputStream fxmlStream = new FileInputStream("/Users/robson/NetBeansProjects/ProjetoFinal/src/tela/Usuarios.fxml");
        Parent root = loader.load(fxmlStream);
        
        Scene scene = new Scene(root);
        
        primaryStage.setTitle("Controle de Usuários!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
