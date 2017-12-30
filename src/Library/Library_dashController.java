/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Library;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;

/**
 * FXML Controller class
 *
 * @author Mukul
 */
public class Library_dashController implements Initializable {

    
     @FXML
    private PieChart pie_lib;
     
     @FXML
    private LineChart<?,?> lib_barchart;
     
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
      /**  Request req = new Request("123","12",null, RequestedType.LIBRARYDASHBOARD);
        ServerConnection conn = new ServerConnection("192.168.15.28", 8189);
         try {
             
             Response res = (Response)conn.ab(req);
             LibraryDashBoard dash = (LibraryDashBoard)res.getRequestedObject();
             System.out.println(dash.getIssuedBooks());
             
             
         } catch (IOException ex) {
             Logger.getLogger(Library_dashController.class.getName()).log(Level.SEVERE, null, ex);
         } catch (NumberFormatException ex) {
             Logger.getLogger(Library_dashController.class.getName()).log(Level.SEVERE, null, ex);
         } **/
        
        ObservableList<PieChart.Data> pieList = FXCollections.observableArrayList();
        pieList.addAll(new PieChart.Data("Issued Books", 30), new PieChart.Data("Available Books", 70));
        pie_lib.setData(pieList);
        
        XYChart.Series series = new XYChart.Series();
        series.getData().add(new XYChart.Data("Mon",24));
        series.getData().add(new XYChart.Data("Tue",34));
        series.getData().add(new XYChart.Data("Wed",12));
        series.getData().add(new XYChart.Data("Thu",56));
        series.getData().add(new XYChart.Data("Fri",84));
        series.getData().add(new XYChart.Data("Sat",92));
        series.getData().add(new XYChart.Data("Sun",2));
        
        lib_barchart.getData().setAll(series);
    }
    
}
