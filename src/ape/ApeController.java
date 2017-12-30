/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ape;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

/**
 *
 * @author 17mri
 */
public class ApeController implements Initializable {

    @FXML
    private Label label;

    @FXML
    private Button toLib;

    @FXML
    private Button admin;

    @FXML
    private Button login;

    public static Stage AdminLoginStage;
    
    Stage s = Ape.getPrimaryStage();
    @FXML
    private void handleButtonAction(ActionEvent event) throws IOException {
        
        Parent AdminLoginParent = FXMLLoader.load(getClass().getResource("/Fee/Fee_main.fxml"));
        Scene AdminLoginScene = new Scene(AdminLoginParent);
        AdminLoginStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        AdminLoginStage.setScene(AdminLoginScene);
        AdminLoginStage.setMaximized(true);
        AdminLoginStage.show();
    }

    @FXML
    void toLibrary(ActionEvent event) throws IOException {

        Parent AdminLoginParent = FXMLLoader.load(getClass().getResource("/Library/Library_main.fxml"));
        Scene AdminLoginScene = new Scene(AdminLoginParent);
        AdminLoginStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        AdminLoginStage.setScene(AdminLoginScene);
        AdminLoginStage.show();
    }

    @FXML
    void toAdmin(ActionEvent event) throws IOException {
        Parent AdminLoginParent = FXMLLoader.load(getClass().getResource("/Admin/Admin_main.fxml"));
        Scene AdminLoginScene = new Scene(AdminLoginParent);
        AdminLoginStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        AdminLoginStage.setScene(AdminLoginScene);
        AdminLoginStage.show();
    }

    @FXML
    void to_login(ActionEvent event) throws IOException {
        Parent AdminLoginParent = FXMLLoader.load(getClass().getResource("/Login/Login_Main.fxml"));
        Scene AdminLoginScene = new Scene(AdminLoginParent);
        AdminLoginStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        AdminLoginStage.setScene(AdminLoginScene);
        AdminLoginStage.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

}
