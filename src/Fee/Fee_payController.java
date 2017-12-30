/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Fee;

import STUDENT.StudentProfile;
import SocketConnect.Request;
import SocketConnect.Response;
import SocketConnect.ServerConnection;
import USER.FEEPAY.Payfee;
import Util.RequestedType;
import ape.Ape;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

/**
 * FXML Controller class
 *
 * @author 17mri
 */
public class Fee_payController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    AnchorPane anchormain;
    @FXML
    AnchorPane changesize;
    @FXML
    TableView<stucture> table;
    @FXML
    TableColumn<stucture, String> details;
    @FXML
    TableColumn<stucture, String> amount;
    @FXML
    TableColumn<stucture, Integer> no;
    @FXML
    TextField enterstudentrollno;
    @FXML
    TextField demanddraft;
    @FXML
    Button pay;
    @FXML
    BorderPane q;
    @FXML
    Label studentname;
    @FXML
    Label studentrollno;
    @FXML
    Label fathername;
    @FXML
    Label branch;
    @FXML
    Label semester;
    @FXML
    Label total;
    @FXML
    Label studentmobileno;
    static Fee_mainController controller=new Fee_mainController();
    
    @FXML
    private void pay(ActionEvent actionEvent) {
        try {
            ServerConnection conn = new ServerConnection(Ape.ipAdress, Ape.port);
            Payfee p = new Payfee(null, "0203cs131044", "3", "27500", "12-12-12", "420");
            Response res = (Response) conn.read(new Request(null, null, p, RequestedType.PAYFEE));
            p = (Payfee) res.getRequestedObject();
            System.out.println(p.getDdNumber());
            
        } catch (IOException | NumberFormatException ex) {
            Logger.getLogger(Fee_payController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    @FXML
    private void submit(ActionEvent actionEvent)  {
        no.setCellValueFactory(new PropertyValueFactory<>("no"));
        details.setCellValueFactory(new PropertyValueFactory<>("details"));
        amount.setCellValueFactory(new PropertyValueFactory<>("amount"));
        if (!enterstudentrollno.getText().equals("")) {
            if (q.isVisible()) {
                try {
                    q.setVisible(false);
                    demanddraft.requestFocus();
                    ServerConnection connection=new ServerConnection(Ape.ipAdress, Ape.port);
                    StudentProfile prof= new StudentProfile(enterstudentrollno.getText(), null , null,null,null, null,null, null, null, null, null, null);
                    Request req = new Request(null, null, prof, RequestedType.GETSTUDETAILS);
                    Response res = (Response) connection.read(req);
                    StudentProfile profile = (StudentProfile) res.getRequestedObject();
                    studentrollno.setText(profile.getRollno());
                    studentname.setText(profile.getSt_name());
                    fathername.setText(profile.getG_name());
                    branch.setText(profile.getDepartment_id());
                    semester.setText(profile.getAddmission_date());
                    studentmobileno.setText(profile.getMobile());
                    Tablevie t=new Tablevie(2);
                table.setItems(Tablevie.getStructure1());
               total.setText(Tablevie.getTotal().toString());
                    
                } catch (IOException | NumberFormatException ex) {
                    Logger.getLogger(Fee_payController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } 
    }

    @FXML
    private void enterddno(KeyEvent event) {
        if (event.getCode() == KeyCode.ENTER) {
            pay.requestFocus();
        }
    }

    @FXML
    private void enterstudentroll(KeyEvent event) {
        no.setCellValueFactory(new PropertyValueFactory<>("no"));
        details.setCellValueFactory(new PropertyValueFactory<>("details"));
        amount.setCellValueFactory(new PropertyValueFactory<>("amount"));
        if (event.getCode() == KeyCode.ENTER) {
            if (!enterstudentrollno.getText().equals("")) {
                if (q.isVisible()) {
                    try {
                    q.setVisible(false);
                    demanddraft.requestFocus();
                    ServerConnection connection=new ServerConnection(Ape.ipAdress, Ape.port);
                    StudentProfile prof= new StudentProfile(enterstudentrollno.getText(), null , null,null,null, null,null, null, null, null, null, null);
                    Request req = new Request(null, null, prof, RequestedType.GETSTUDETAILS);
                    Response res = (Response) connection.read(req);
                    StudentProfile profile = (StudentProfile) res.getRequestedObject();
                    studentrollno.setText(profile.getRollno());
                    studentname.setText(profile.getSt_name());
                    fathername.setText(profile.getG_name());
                    branch.setText(profile.getDepartment_id());
                    semester.setText(profile.getAddmission_date());
                    studentmobileno.setText(profile.getMobile());
                    Tablevie t=new Tablevie(2);
                table.setItems(Tablevie.getStructure1());
                total.setText(Tablevie.getTotal().toString());
                    
                } catch (IOException | NumberFormatException ex) {
                    Logger.getLogger(Fee_payController.class.getName()).log(Level.SEVERE, null, ex);
                }
                }
            } else {

            }
            demanddraft.requestFocus();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        details.setCellValueFactory(new PropertyValueFactory<>("details"));
        amount.setCellValueFactory(new PropertyValueFactory<>("amount"));
       // table.setItems(Fee_mainController.first);
        
    //get main anchor width and height
        anchormain.widthProperty().addListener((ObservableValue<? extends Number> observable, Number oldValue, Number newValue) -> {
            if(760.00<=(double)newValue)
                changesize.setPrefWidth(((double)newValue)-6);
            
        });
         anchormain.heightProperty().addListener((ObservableValue<? extends Number> observable, Number oldValue, Number newValue) -> {
             if(362.00<=(double)newValue)
                 changesize.setPrefHeight(((double)newValue)-7);
        });
        
    }
    
}
