/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ape;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author 17mri
 */
public class Ape extends Application {
    
    public static String ipAdress = "122.170.200.174";
    public static int port = 8189;

    private static Stage primaryStage;

    private void setPrimaryStage(Stage stage) {
        Ape.primaryStage = stage;
    }

    static public Stage getPrimaryStage() {
        return Ape.primaryStage;
    }

    @Override
    public void start(Stage stage) throws Exception {
        setPrimaryStage(stage);
        Parent root = FXMLLoader.load(getClass().getResource("/Login/Login_Main.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);

    }

}
