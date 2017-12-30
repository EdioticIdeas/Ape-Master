/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Admin;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.StackedAreaChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author Shub
 */
public class Admin_dashController implements Initializable {
    
    
    @FXML
    private StackedAreaChart<?, ?> admin_chart;
    
    /**
     * Initializes the controller class.
     */
    @FXML
    Button b;
    @FXML
    VBox box;
    
   @FXML
   private void jd(ActionEvent actionEvent){
       if (box.isVisible()==true) {
          
           box.setVisible(false);
       }
       else{
            System.out.println("Admin.Admin_dashController.jd()"+box.getLayoutX()+"vndsjvn"+box.getLayoutY());
           box.setVisible(true);
       }
   }
     
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO

        XYChart.Series series = new XYChart.Series();
        series.getData().add(new XYChart.Data(1,24));
        series.getData().add(new XYChart.Data(2,34));
        series.getData().add(new XYChart.Data(3,12));
        series.getData().add(new XYChart.Data(4,56));
        series.getData().add(new XYChart.Data(5,84));
        series.getData().add(new XYChart.Data(6,92));
        series.getData().add(new XYChart.Data(7,2));
        
        admin_chart.getData().setAll(series);
        
      /**  final NumberAxis xAxis = new NumberAxis(1, 31, 1);
        final NumberAxis yAxis = new NumberAxis();
        final AreaChart<Number,Number> ac = 
            new AreaChart<Number,Number>(xAxis,yAxis);
        ac.setTitle("Temperature Monitoring (in Degrees C)");
 
        XYChart.Series seriesApril= new XYChart.Series();
        seriesApril.setName("April");
        seriesApril.getData().add(new XYChart.Data(1, 4));
        seriesApril.getData().add(new XYChart.Data(3, 10));
        seriesApril.getData().add(new XYChart.Data(6, 15));
        seriesApril.getData().add(new XYChart.Data(9, 8));
        seriesApril.getData().add(new XYChart.Data(12, 5));
        seriesApril.getData().add(new XYChart.Data(15, 18));
        seriesApril.getData().add(new XYChart.Data(18, 15));
        seriesApril.getData().add(new XYChart.Data(21, 13));
        seriesApril.getData().add(new XYChart.Data(24, 19));
        seriesApril.getData().add(new XYChart.Data(27, 21));
        seriesApril.getData().add(new XYChart.Data(30, 21));
        
        XYChart.Series seriesMay = new XYChart.Series();
        seriesMay.setName("May");
        seriesMay.getData().add(new XYChart.Data(1, 20));
        seriesMay.getData().add(new XYChart.Data(3, 15));
        seriesMay.getData().add(new XYChart.Data(6, 13));
        seriesMay.getData().add(new XYChart.Data(9, 12));
        seriesMay.getData().add(new XYChart.Data(12, 14));
        seriesMay.getData().add(new XYChart.Data(15, 18));
        seriesMay.getData().add(new XYChart.Data(18, 25));
        seriesMay.getData().add(new XYChart.Data(21, 25));
        seriesMay.getData().add(new XYChart.Data(24, 23));
        seriesMay.getData().add(new XYChart.Data(27, 26));
        seriesMay.getData().add(new XYChart.Data(31, 26));
        
        sss.getChildren().add(ac);
        ac.setMaxHeight(grid.getHeight()/3);
        ac.setMaxWidth(grid.getWidth()/2);        
        ac.getData().addAll(seriesApril, seriesMay); **/
    
        
    }    
    
}
