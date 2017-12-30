/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Admin.Employee;

import SocketConnect.Request;
import SocketConnect.Response;
import SocketConnect.ServerConnection;
import USER.Staff;
import Util.RequestedType;
import ape.Ape;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author 17mri
 */
    
public class Add_EmployeeController implements Initializable {
    protected ObservableList<String> title = FXCollections.observableArrayList("CS", "IT", "EC", "EE", "CE", "ME");
    protected ObservableList<String> gender = FXCollections.observableArrayList("Male","Female","Other");
    protected ObservableList<String> department = FXCollections.observableArrayList("CS", "IT", "EC", "EE", "CE", "ME","Management","Accountant","Library");
    protected ObservableList<String> designation = FXCollections.observableArrayList("chairman", "director","principal","vice principal","accountant","librariyan","teacher");
    @FXML
    private ComboBox titl;
    @FXML
    private ComboBox gen;
    @FXML
    private ComboBox depart;
    @FXML
    private ComboBox desig;
    @FXML
    AnchorPane anchormain;
    @FXML
    AnchorPane changesize;
    @FXML
    TextField fname;
    @FXML
    TextField mname;
    @FXML
    TextField lname;
    @FXML
    TextField password;
    @FXML
    TextField Emailid;
    @FXML
    TextField managid;
    @FXML
    TextField address;
    @FXML
    TextField gtype;
    @FXML
    TextField gfield;
    @FXML
    TextField gcomyear;
    @FXML
    TextField ptype;
    @FXML
    TextField pfield;
    @FXML
    TextField pcomyear;
//    @FXML
//    TextField phdtype;
//    @FXML
//    TextField phdfield;
//    @FXML
//    TextField phdcomyear;
   @FXML
   private void cancle(ActionEvent event){
       
   }
    @FXML
    private void create(ActionEvent event) {
        try {
            ServerConnection con = new ServerConnection(Ape.ipAdress, Ape.port);
            
            Staff s = new Staff(null, fname.getText()+" "+mname.getText()+" "+lname.getText(), Emailid.getText(), address.getText(),"'"
                    + gtype.getText()
                    + "','"
                    + gfield.getText()
                    + "',"
                    + gcomyear.getText()
                    ,
                    "'"
                    + ptype.getText()
                    + "','"
                    + pfield.getText()
                    + "',"
                    + pcomyear.getText(), null, gen.getSelectionModel().getSelectedItem().toString(),desig.getSelectionModel().getSelectedItem().toString()
                    , depart.getSelectionModel().getSelectedItem().toString(), "123456", managid.getText());
            Request req = new Request(null, null, s, RequestedType.ADDEMPLOYEE);
            Response res = (Response)con.read(req);
            Staff s1 = (Staff) res.getRequestedObject();
            System.out.print(s1.getS_id());
        } catch (IOException | NumberFormatException ex) {
            Logger.getLogger(Add_EmployeeController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        titl.setItems(title);
        gen.setItems(gender);
        depart.setItems(department);
        desig.setItems(designation);
       anchormain.widthProperty().addListener((ObservableValue<? extends Number> observable, Number oldValue, Number newValue) -> {
            if (760.00 <= (double) newValue) {
                changesize.setPrefWidth(((double) newValue) - 20);
            }
        });
        anchormain.heightProperty().addListener((ObservableValue<? extends Number> observable, Number oldValue, Number newValue) -> {
            if (362.00 <= (double) newValue) {
                changesize.setPrefHeight(((double) newValue) - 15);
            }
        });
    }    
    
}
