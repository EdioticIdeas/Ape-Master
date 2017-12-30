/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Library;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Mukul
 */
public class Library_issueController implements Initializable {

     @FXML
    private Button button_lib_issue;

    @FXML
    private TextField textField_lib_id;

    @FXML
    private TextField textField_lib_b1;

    @FXML
    private TextField textField_lib_b2;

    @FXML
    private TextField textField_lib_b3;

    @FXML
    private TextField textField_lib_b4;

    @FXML
    void issueBooks(ActionEvent event) {

    }

    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
