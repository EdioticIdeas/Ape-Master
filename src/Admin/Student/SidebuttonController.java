/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Admin.Student;

import Admin.*;
import SocketConnect.Request;
import SocketConnect.Response;
import SocketConnect.ServerConnection;
import USER.FEEPAY.FeeStructure;
import USER.FEEPAY.PayementDashboard;
import Util.RequestedType;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
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
    protected static ArrayList<FeeStructure> feeStru;
    protected static HashMap<String,String> barchart;
    protected static PayementDashboard pay;
    
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
    @FXML
    private void removeemp(ActionEvent event) throws IOException {
        dash = FXMLLoader.load(getClass().getResource("/Admin/Employee/Manage_Employees.fxml"));
        anchorPane.getChildren().setAll(dash);

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ServerConnection conn = new ServerConnection("localhost", 8189);
        SocketConnect.Request req = new Request("111", "aaa", null, RequestedType.PAYMENTDASHBOARD);
        try {
            Response res = (Response) conn.read(req);
            pay = (PayementDashboard) res.getRequestedObject();
            feeStru = pay.getFeeStruct();
        } catch (IOException | NumberFormatException ex) {
            Logger.getLogger(Fee.Fee_dashController.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            dash = FXMLLoader.load(getClass().getResource("/Admin/Employee/Manage_Employees.fxml"));
            anchorPane.getChildren().setAll(dash);
            anchorPane.requestFocus();
        } catch (IOException ex) {
            Logger.getLogger(SidebuttonController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    
    
}
