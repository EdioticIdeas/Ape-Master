/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Fee;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author 17mri
 */
public class Fee_viewreportController implements Initializable {
    @FXML
    AnchorPane anchormain;
    @FXML
    AnchorPane changesize;
    Fee_structureController fc = new Fee_structureController();
    @FXML
    ComboBox branch;
    @FXML
    ComboBox semester;

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
        branch.setItems(fc.branc);
        semester.setItems(fc.sem);
    
    }

}
