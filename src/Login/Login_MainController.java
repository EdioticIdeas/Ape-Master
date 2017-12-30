/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Login;

import LOGIN.UserLogin;
import Library.Library_dashController;
import SocketConnect.Request;
import SocketConnect.ServerConnection;
import static ape.ApeController.AdminLoginStage;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.Separator;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Mukul
 */
public class Login_MainController implements Initializable {

    @FXML
    private TextField Login_userName;

    @FXML
    private PasswordField Login_Password;

    @FXML
    private Button Button_Login;

    @FXML
    private Label login_forgot;

    @FXML
    private Label Login_signup;

    @FXML
    private ImageView login_imageView;

    @FXML
    private ImageView image_loginBg;

    @FXML
    private Separator seperatorUserId;

    @FXML
    private Separator seperatorPassword;

    @FXML
    private Label userId;

    @FXML
    private Label password;

    @FXML
    void ChangePasswordColour(MouseEvent event) {
        Login_Password.setStyle("-fx-background-color : #2A363B ; -fx-text-fill : #E84A5F ; ");
        //seperatorUserId.setStyle("-fx-background-color : #E84A5F");
        password.setStyle("-fx-text-fill : #E84A5F");
        userId.setStyle("-fx-text-fill : #99B898");
    }

    @FXML
    void ChangeUserNameColour(MouseEvent event) {
        Login_userName.setStyle("-fx-background-color : #2A363B ; -fx-text-fill : #E84A5F ;");
        //seperatorUserId.setStyle("-fx-background-color : #E84A5F");
        userId.setStyle("-fx-text-fill : #E84A5F");
        password.setStyle("-fx-text-fill : #99B898");
    }

    @FXML
    void commonLogin(ActionEvent event) throws IOException {
//        Request req = new Request("111", new UserLogin("Mukul", "sss"));
//        ServerConnection conn = new ServerConnection("192.168.15.28", 8189);
//         try {
//             
//             SocketConnect.Response res = (SocketConnect.Response)conn.read(req);
//             UserLogin user = (UserLogin) res.getRequestedObject();
//             System.out.println(user.getSession_id().toString());
//         } catch (Exception ex) {
//             Logger.getLogger(Library_dashController.class.getName()).log(Level.SEVERE, null, ex);
//         } 
        Parent AdminLoginParent = FXMLLoader.load(getClass().getResource("/ape/Ape.fxml"));
        Scene AdminLoginScene = new Scene(AdminLoginParent);
        AdminLoginStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        AdminLoginStage.setScene(AdminLoginScene);
        AdminLoginStage.show();
    }

    @FXML
    void forgotPassword(MouseEvent event) {

    }

    @FXML
    void signUp(MouseEvent event) {

    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
            Image image = new Image("/img/login.jpg");
            image_loginBg.setImage(image);

        login_forgot.setOnMouseEntered(e -> {
            login_forgot.setStyle("-fx-text-fill : #E84A5F");
        });

        login_forgot.setOnMouseExited(e -> {
            login_forgot.setStyle("-fx-text-fill : #99B898");
        });

        Login_signup.setOnMouseEntered(e -> {
            Login_signup.setStyle("-fx-text-fill : #E84A5F");
        });

        Login_signup.setOnMouseExited(e -> {
            Login_signup.setStyle("-fx-text-fill : #99B898");
        });
    }

}
