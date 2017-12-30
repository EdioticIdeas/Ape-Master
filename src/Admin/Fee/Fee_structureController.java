/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Admin.Fee;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

/**
 * FXML Controller class
 *
 * @author 17mri
 */
public class Fee_structureController implements Initializable {

    protected ObservableList<String> branc = FXCollections.observableArrayList("CS", "IT", "EC", "EE", "CE", "ME");
    protected ObservableList<String> sem = FXCollections.observableArrayList("1", "2", "3", "4", "5", "6", "7", "8");
    String sems;
    @FXML
    AnchorPane anchormain;
    @FXML
    AnchorPane changesize;
    @FXML
    Text total;
    @FXML
    Button b;
    @FXML
    private ComboBox branch;
    @FXML
    private ComboBox semester;
    @FXML
    TableView<Stuctur> table;
    @FXML
    TableColumn<Stuctur, String> details;
    @FXML
    TableColumn<Stuctur, String> amount;
    @FXML
    TableColumn<Stuctur, Integer> noo;
    @FXML
    public void changeAmount(CellEditEvent edittedCell)
    {
        Stuctur personSelected =  table.getSelectionModel().getSelectedItem();
        personSelected.setamout(edittedCell.getNewValue().toString());
    }
    @FXML
    private void branch(ActionEvent event) {
        if (semester.getSelectionModel().getSelectedItem() == null) {
            semester.requestFocus();
        } else {
            b.requestFocus();
        }
    }
    
  
    @FXML
    private void semester(ActionEvent event) {

        if (branch.getSelectionModel().getSelectedItem() == null) {
            branch.requestFocus();
        } else {
            b.requestFocus();
        }

    }

    @FXML
    private void submit(ActionEvent event) {
        noo.setCellValueFactory(new PropertyValueFactory<>("no"));
        details.setCellValueFactory(new PropertyValueFactory<>("details"));
        amount.setCellValueFactory(new PropertyValueFactory<>("amount"));

        if (branch.getSelectionModel().getSelectedItem() == null) {
            branch.requestFocus();
        } else {
            if (semester.getSelectionModel().getSelectedItem() == null) {
                semester.requestFocus();
            } else {
                sems = semester.getSelectionModel().getSelectedItem().toString();
                int a=Integer.parseInt(sems)-1;
                Tablevi t=new Tablevi(a);
                table.setItems(Tablevi.getStructure1());
                total.setText(Tablevi.getTotal().toString());
              
            }
        }
    }

    @FXML
    private void buttonent(KeyEvent event) {

        if (event.getCode() == KeyCode.ENTER) {
            noo.setCellValueFactory(new PropertyValueFactory<>("no"));
            details.setCellValueFactory(new PropertyValueFactory<>("details"));
            amount.setCellValueFactory(new PropertyValueFactory<>("amount"));

            if (branch.getSelectionModel().getSelectedItem() == null) {
                branch.requestFocus();
            } else {
                if (semester.getSelectionModel().getSelectedItem() == null) {
                    semester.requestFocus();
                } else {
                    sems = semester.getSelectionModel().getSelectedItem().toString();
                    int a=Integer.parseInt(sems)-1;
                    Tablevi t=new Tablevi(a);
                    table.setItems(Tablevi.getStructure1());
                    total.setText(Tablevi.getTotal().toString());
                }
            }
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        amount.setCellValueFactory(new PropertyValueFactory<>("amount"));
        branch.setItems(branc);
        semester.setItems(sem);
        //get main anchor width and height
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
         amount.setCellFactory(TextFieldTableCell.forTableColumn());
         
    }

}
