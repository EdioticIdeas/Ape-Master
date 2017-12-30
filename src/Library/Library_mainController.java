/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Library;

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
import javafx.scene.layout.StackPane;

/**
 * FXML Controller class
 *
 * @author Mukul
 */
public class Library_mainController implements Initializable {

    @FXML
    private Button button_lib_dash;

    @FXML
    private Button button_lib_inventory;

    @FXML
    private Button button_lib_members;

    @FXML
    private Button button_lib_issue;

    @FXML
    private Button button_lib_return;

    @FXML
    private Button button_lib_reissue;

    @FXML
    private AnchorPane lib_anchorMain;

    @FXML
    void loadDashboard(ActionEvent event) throws IOException {
        GridPane dash = FXMLLoader.load(getClass().getResource("/Library/Library_dash.fxml"));
        lib_anchorMain.getChildren().setAll(dash);

    }

    @FXML
    void load_inventory(ActionEvent event) throws IOException {
        GridPane inven = FXMLLoader.load(getClass().getResource("/Library/Library_inventory.fxml"));
        lib_anchorMain.getChildren().setAll(inven);
         AnchorPane.setBottomAnchor(inven, 0.0);
             AnchorPane.setTopAnchor(inven, 0.0);
             AnchorPane.setRightAnchor(inven,0.0);
             AnchorPane.setLeftAnchor(inven, 0.0);
    }

    @FXML
    void load_issue(ActionEvent event) throws IOException {
        GridPane dash = FXMLLoader.load(getClass().getResource("/Library/Library_issue.fxml"));
        lib_anchorMain.getChildren().setAll(dash);
    }

    @FXML
    void load_members(ActionEvent event) {

    }

    @FXML
    void load_reissue(ActionEvent event) throws IOException {
        GridPane dash = FXMLLoader.load(getClass().getResource("/Library/Library_reissue.fxml"));
        lib_anchorMain.getChildren().setAll(dash);
    }

    @FXML
    void load_return(ActionEvent event) throws IOException {
        GridPane dash = FXMLLoader.load(getClass().getResource("/Library/Library_return.fxml"));
        lib_anchorMain.getChildren().setAll(dash);
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        GridPane dash;
        try {
            dash = FXMLLoader.load(getClass().getResource("/Library/Library_dash.fxml"));
            lib_anchorMain.getChildren().setAll(dash);
        } catch (IOException ex) {
            Logger.getLogger(Library_mainController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
