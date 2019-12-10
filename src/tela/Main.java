package tela;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author robson
 */
public class Main extends Application {

    public static final int WINDOWS = 0, MAC = 1;
    private int platform;
    private static Main instance;

    public Main() {
        instance = this;
    }

    @Override
    public void start(Stage primaryStage) throws FileNotFoundException, IOException {
        // DEFINA A PLATAFORMA AQUI
        setPlatform(WINDOWS);

        Parent root = null;
        switch (getPlatform()) {
            case WINDOWS:
                root = FXMLLoader.load(getClass().getResource("Main.fxml"));
                break;
            case MAC:
                FXMLLoader loader = new FXMLLoader();
                FileInputStream fxmlStream = new FileInputStream("/Users/robson/NetBeansProjects/ProjetoFinal/src/tela/Main.fxml");
                root = loader.load(fxmlStream);
                break;
        }

        Scene scene = new Scene(root);

        primaryStage.setTitle(".:  FUNDAÇÃO PRO SANGUE  :.");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    public static Main getInstance() {
        return instance;
    }

    public void setPlatform(int platform) {
        this.platform = platform;
    }

    public int getPlatform() {
        return platform;
    }

}
