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
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.AnchorPane;
/**
 * FXML Controller class
 *
 * @author 17mri
 */
public class Fee_dashController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    private int i=0;
    @FXML
    private BarChart lib_barchart;
    @FXML
    AnchorPane anchorPane;
    @FXML
    AnchorPane anchorPane1;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    anchorPane.widthProperty().addListener((ObservableValue<? extends Number> observable, Number oldValue, Number newValue) -> {
        anchorPane1.setPrefWidth(((double)newValue)-5);
    });
    anchorPane.heightProperty().addListener((ObservableValue<? extends Number> observable, Number oldValue, Number newValue) -> {
        anchorPane1.setPrefHeight(((double)newValue)-5);
    });
        Integer[] barchart=new Integer[Tablevie.a.length];
        for (String a : Tablevie.a) {
            barchart[i]=Integer.parseInt(a.trim());
            i++;
        }
        XYChart.Series series = new XYChart.Series();
        series.getData().add(new XYChart.Data("January",barchart[0]));
        series.getData().add(new XYChart.Data("February",barchart[1]));
        series.getData().add(new XYChart.Data("March",barchart[2]));
        series.getData().add(new XYChart.Data("April",barchart[3]));
        series.getData().add(new XYChart.Data("May",0));
        series.getData().add(new XYChart.Data("June",0));
        series.getData().add(new XYChart.Data("July",0));
        series.getData().add(new XYChart.Data("August",0));
        series.getData().add(new XYChart.Data("September",0));
        series.getData().add(new XYChart.Data("October",0));
        series.getData().add(new XYChart.Data("November",0));
        series.getData().add(new XYChart.Data("December",0));
        lib_barchart.getData().setAll(series);
    }

}
