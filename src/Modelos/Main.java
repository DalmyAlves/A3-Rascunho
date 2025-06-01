package Modelos;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Classe principal que inicializa e executa a aplicação JavaFX de estatísticas do campeonato.
 */
public class Main extends Application {

    /**
     * Inicializa a janela principal da aplicação JavaFX.
     * @param primaryStage o palco principal da aplicação.
     */
    @Override
    public void start(Stage primaryStage) {
        try {

            Parent root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));

            Scene scene = new Scene(root);
            primaryStage.setTitle("Estatísticas do Campeonato");
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Método principal para execução da aplicação.
     * @param args argumentos de linha de comando.
     */
    public static void main(String[] args) {
        launch(args);
    }
}