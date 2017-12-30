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
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.print.PageLayout;
import javafx.print.PageOrientation;
import javafx.print.Paper;
import javafx.print.Printer;
import javafx.print.PrinterJob;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.transform.Scale;

public class Fee_printreceiptController implements Initializable {

    @FXML
    Label ReceiptNumber;
    @FXML
    Label date;
    @FXML
    Label time;
    @FXML
    TableView<stucture> table;
    @FXML
    TableColumn<stucture, String> details;
    @FXML
    TableColumn<stucture, String> amount;
    @FXML
    TableColumn<stucture, Integer> no;
    @FXML
    Label studentname;
    @FXML
    Label dd;
    @FXML
    Label total;
    @FXML
    Label fathername;
    @FXML
    Label branch;
    @FXML
    Label studentmobileno;
    @FXML
    AnchorPane anchormain;
    @FXML
    AnchorPane changesize;

    @FXML
    private void pay(KeyEvent event) {
        no.setCellValueFactory(new PropertyValueFactory<>("no"));
        details.setCellValueFactory(new PropertyValueFactory<>("details"));
        amount.setCellValueFactory(new PropertyValueFactory<>("amount"));
        if (event.getCode() == KeyCode.ENTER) {
            try {
                ServerConnection conn = new ServerConnection(Ape.ipAdress, Ape.port);
                Payfee p = new Payfee(null, "0203cs131044", "3", null, null, null);
                Response res = (Response) conn.read(new Request(null, null, p, RequestedType.GETRECIEPT));
                ArrayList<Object> list = (ArrayList<Object>) res.getRequestedObject();
                p = (Payfee) list.get(0);
                dd.setText(p.getDdNumber());
                ReceiptNumber.setText(p.getReceiptNumber());
                String[] aray = p.getDate().split(" ");
                date.setText(aray[0]);
                time.setText(aray[1]);
                StudentProfile profile = (StudentProfile) list.get(1);
                studentname.setText(profile.getSt_name());
                studentmobileno.setText(profile.getMobile());
                branch.setText(profile.getDepartment_id());
                fathername.setText(profile.getG_name());
                Tablevie t = new Tablevie(3);
                table.setItems(Tablevie.getStructure1());
                total.setText(Tablevie.getTotal().toString());

            } catch (IOException | NumberFormatException ex) {
                Logger.getLogger(Fee_payController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @FXML
    private void print(ActionEvent event) {
        Node node = changesize;
        PrinterJob job = PrinterJob.createPrinterJob();
        if (job != null && job.showPrintDialog(node.getScene().getWindow())) {
            boolean success = job.printPage(node);
            if (success) {
                job.endJob();
            }
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        anchormain.widthProperty().addListener((ObservableValue<? extends Number> observable, Number oldValue, Number newValue) -> {
            if (760.00 <= (double) newValue) {
                changesize.setPrefWidth(((double) newValue) - 6);
            }
        });
        anchormain.heightProperty().addListener((ObservableValue<? extends Number> observable, Number oldValue, Number newValue) -> {
            if (362.00 <= (double) newValue) {
                changesize.setPrefHeight(((double) newValue) - 7);
            }
        });
    }

}
