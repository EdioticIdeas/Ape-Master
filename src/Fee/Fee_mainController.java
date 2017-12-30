/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Fee;

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
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author 17mri
 */
public class Fee_mainController implements Initializable  {
    protected static ArrayList<FeeStructure> feeStruc;
    protected static HashMap<String,String> barchart;
    protected static PayementDashboard pay;
    @FXML
    AnchorPane anchorMain;
    @FXML
    Label title;
    @FXML
    Label name;
    @FXML
    Label id;
    AnchorPane dash;
    @FXML
    private void loadDashboard(ActionEvent event) throws IOException {
         title.setText("Dashboard");
        dash = FXMLLoader.load(getClass().getResource("/Fee/Fee_dash.fxml"));
        anchorMain.getChildren().setAll(dash);
        
    }

    @FXML
    private void pay(ActionEvent event) throws IOException {
        title.setText("PayFee");
        dash = FXMLLoader.load(getClass().getResource("/Fee/Fee_pay.fxml"));
        anchorMain.getChildren().setAll(dash);

    }

    @FXML
    private void viewreport(ActionEvent event) throws IOException {
        title.setText("ViewReport");
        dash = FXMLLoader.load(getClass().getResource("/Fee/Fee_viewreport.fxml"));
        anchorMain.getChildren().setAll(dash);

    }

    @FXML
    private void printreceipt(ActionEvent event) throws IOException {
        title.setText("PrintReceipt");
        dash = FXMLLoader.load(getClass().getResource("/Fee/Fee_printreceipt.fxml"));
        anchorMain.getChildren().setAll(dash);

    }

    @FXML
    private void feestructure(ActionEvent event) throws IOException {
        title.setText("Feestructure");
        dash = FXMLLoader.load(getClass().getResource("/Fee/Fee_structure.fxml"));
        anchorMain.getChildren().setAll(dash);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ServerConnection conn = new ServerConnection(ape.Ape.ipAdress, ape.Ape.port);
        SocketConnect.Request req = new Request("111", "aaa", null, RequestedType.PAYMENTDASHBOARD);
        try {
            Response res = (Response) conn.read(req);
            pay = (PayementDashboard) res.getRequestedObject();
            barchart=pay.getFeepay();
            Tablevie t=new Tablevie(barchart);
            feeStruc = pay.getFeeStruct();
            //  emailid.setText(pay.getEmail());
            name.setText(pay.getName());
            id.setText(pay.getId());
        } catch (IOException | NumberFormatException ex) {
            Logger.getLogger(Fee_dashController.class.getName()).log(Level.SEVERE, null, ex);
        }
         try {           
            dash = FXMLLoader.load(getClass().getResource("/Fee/Fee_dash.fxml"));
            anchorMain.getChildren().setAll(dash);
        } catch (IOException ex) {
            Logger.getLogger(Fee_mainController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
