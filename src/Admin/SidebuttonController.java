/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Admin;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;

/**
 * FXML Controller class
 *
 * @author 17mri
 */
public class SidebuttonController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    Button aa;
    GridPane gp;
    AnchorPane dash;
    AnchorPane anchorPane=Admin_mainController.getAnchorPane();
    AnchorPane siAnchorPane =Admin_mainController.getAnchorPane1();
     @FXML
    private void dashboard(ActionEvent event) throws IOException {
        
        gp = FXMLLoader.load(getClass().getResource("/Admin/Sidebutton.fxml"));
        siAnchorPane.getChildren().setAll(gp);
    }

    @FXML
    private void emp(ActionEvent event) throws IOException {
       
        gp = FXMLLoader.load(getClass().getResource("/Admin/Employee/EmpSidebutton.fxml"));
        siAnchorPane.getChildren().setAll(gp);

    }

    @FXML
    private void student(ActionEvent event) throws IOException {
        
       gp = FXMLLoader.load(getClass().getResource("/Admin/Student/Sidebutton.fxml"));
       siAnchorPane.getChildren().setAll(gp);

    }

    @FXML
    private void Accountsection(ActionEvent event) throws IOException {
        gp = FXMLLoader.load(getClass().getResource("/Admin/Fee/Fee_main.fxml"));
        siAnchorPane.getChildren().setAll(gp);

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            dash = FXMLLoader.load(getClass().getResource("/Admin/Admin_dash.fxml"));
            anchorPane.getChildren().setAll(dash);
        } catch (IOException ex) {
            Logger.getLogger(SidebuttonController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    
    
}
