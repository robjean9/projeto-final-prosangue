/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tela;

import dao.DoacaoDAO;
import java.net.URL;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;

/**
 * FXML Controller class
 *
 * @author robson
 */
public class GraficosController implements Initializable {
    
    
    
    
    DoacaoDAO doacaoDAO;
    
    LinkedHashMap<String, Integer> data;
    @FXML
    private BorderPane mainPane;
    @FXML
    private Button bBarra;
    @FXML
    private Button bLinha;
    @FXML
    private Button bPizza;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        doacaoDAO = new DoacaoDAO();
        
        data = doacaoDAO.getChartData();
    }    
    
    private PieChart getPieChart(){
        ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList();
        for (String key : data.keySet()) {
            pieChartData.add(new PieChart.Data(key, data.get(key)));
        }
        PieChart chart = new PieChart(pieChartData);
        chart.setTitle("Doações por doador");
        return chart;
    }
    
    private BarChart<String, Integer> getBarChart() {
        CategoryAxis xAxis = new CategoryAxis();
        NumberAxis yAxis = new NumberAxis();

        BarChart<String, Integer> chart = new BarChart(xAxis, yAxis);
        chart.setTitle("Doações por doador");
        chart.setLegendVisible(false);

        XYChart.Series series = new XYChart.Series<>();

        for (String key : data.keySet()) {
            series.getData().add(new XYChart.Data<>(key, data.get(key)));
        }
        chart.getData().add(series);
        return chart;
    }
    
    private LineChart<String, Integer> getLineChart() {
        CategoryAxis xAxis = new CategoryAxis();
        NumberAxis yAxis = new NumberAxis();

        LineChart<String, Integer> chart = new LineChart(xAxis, yAxis);
        chart.setTitle("Doações por doador");

        XYChart.Series series = new XYChart.Series<>();

        for (String key : data.keySet()) {
            series.getData().add(new XYChart.Data<>(key, data.get(key)));
        }
        chart.getData().add(series);
        chart.setCreateSymbols(true);
        chart.setLegendVisible(false);
        return chart;
    }

    @FXML
    void onPizza(ActionEvent event) {
        mainPane.setCenter(getPieChart());
    }

    @FXML
    void onBarra(ActionEvent event) {
        mainPane.setCenter(getBarChart());
    }

    @FXML
    void onLInha(ActionEvent event) {
        mainPane.setCenter(getLineChart());
    }
    
    
}
