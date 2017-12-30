package Admin.Employee;
import SocketConnect.Request;
import SocketConnect.Response;
import SocketConnect.ServerConnection;
import USER.Staff;
import Util.RequestedType;
import java.io.IOException;
import java.lang.reflect.Array;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.function.Predicate;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
public class Manage_EmployeesController implements Initializable {
    @FXML
    TableView<Manage> table;
    @FXML
    TableColumn<Manage, String> FirstName;
    @FXML
    TableColumn<Manage, String> MiddleName;
    @FXML
    TableColumn<Manage, Integer> id;
    @FXML
    TextField field;
    @FXML
    TextField field1;
        private void tblefilter(TextField text) {
            ObservableList structure= ManageTablevi.getStructure1() ;
            FilteredList<Manage> filter=new FilteredList<>(structure,e ->true);
            text.textProperty().addListener((ObservableValue<? extends String> observable, String oldValue, String newValue) -> {
                filter.setPredicate((Predicate<? super Manage>) manage->{
                    return false;
                });
           
            });
       
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
//        id.setCellValueFactory(new PropertyValueFactory<>("no"));
//        FirstName.setCellValueFactory(new PropertyValueFactory<>("details"));
//        MiddleName.setCellValueFactory(new PropertyValueFactory<>("amount"));
//        int a=0;
//        ManageTablevi t=new ManageTablevi(a);
//        table.setItems(ManageTablevi.getStructure1());
//        ObservableList structure= ManageTablevi.getStructure1() ;
//        FilteredList<Manage> filter=new FilteredList<>(structure,e ->true);       
//        
//        field.textProperty().addListener((ObservableValue<? extends String> observable, String oldValue, String newValue) -> {
//                filter.setPredicate((Predicate<? super Manage>) manage->{
//                    if(newValue==null|| newValue.isEmpty()){
//                        return true;
//                    }
//                    if(manage.getNo().toString().contains(newValue)){
//                        return true;
//                    }
//                    return false;
//                });
//            SortedList<Manage> sortedList =new SortedList<>(filter);
//            sortedList.comparatorProperty().bind(table.comparatorProperty());
//            table.setItems(sortedList);
//            });
            ServerConnection connection = new ServerConnection(ape.Ape.ipAdress, ape.Ape.port);
            Request req = new Request(null, null,null, RequestedType.FACULTYLIST);
        try {
            Response res =(Response) connection.read(req);
            ArrayList<Staff> s = (ArrayList<Staff>) res.getRequestedObject();
            for(Staff st: s ){
                System.out.println(st.getS_id()+st.getS_name()+st.getDepartment_id()+st.getS_designation());
            }
        } catch (IOException ex) {
            Logger.getLogger(Manage_EmployeesController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NumberFormatException ex) {
            Logger.getLogger(Manage_EmployeesController.class.getName()).log(Level.SEVERE, null, ex);
        }
            
       
    }    
    
}
