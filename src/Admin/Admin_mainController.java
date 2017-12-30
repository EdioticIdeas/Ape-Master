/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Admin;

import Library.Library_mainController;
import USER.FEEPAY.FeeStructure;
import USER.FEEPAY.PayementDashboard;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;

/**
 * FXML Controller class
 *
 * @author 17mri
 */
public class Admin_mainController implements Initializable  {
    private static AnchorPane anchorPane,anchorPane1;
     protected static ArrayList<FeeStructure> feeStruc;
    protected static HashMap<String,String> barchart;
    protected static PayementDashboard pay;
    @FXML
    AnchorPane anchorMain;
    @FXML
    public AnchorPane button;
   @Override
   
    public void initialize(URL url, ResourceBundle rb) {
       yy(anchorMain, button);
        try {
            GridPane dash1 = FXMLLoader.load(getClass().getResource("/Admin/Sidebutton.fxml"));
            button.getChildren().setAll(dash1);
            
            
             
        } catch (IOException ex) {
            Logger.getLogger(Library_mainController.class.getName()).log(Level.SEVERE, null, ex);
        }
      
    }
    public static AnchorPane getAnchorPane() {
        return anchorPane;
    }

    public static AnchorPane getAnchorPane1() {
        return anchorPane1;
    }

    public void yy(AnchorPane anchorPane, AnchorPane anchorPane1) {
        Admin_mainController.anchorPane = anchorPane;
        Admin_mainController.anchorPane1 = anchorPane1;
    }
}
