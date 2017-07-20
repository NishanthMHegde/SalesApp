package application;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.PieChart.Data;
import javafx.scene.chart.XYChart;
import javafx.scene.control.TextField;

public class StatisticsController  {

	/*
	@FXML
	public BarChart barquantity;
	@FXML
	public BarChart barprofit;
	*/
	@FXML
	public PieChart pcquantity;
	@FXML
	public LineChart<String,Number> yearlysales;
	@FXML 
	LineChart<String,Number> production;
	@FXML 
	LineChart<String,Number> profit;
	

	
	
	
	
	
	
	
	public void generatePieChart(ActionEvent event){
		
		
		ObservableList<Data> list = FXCollections.observableArrayList(
				
				new PieChart.Data("ShaktiPlus",ClientC.fsp),
				new PieChart.Data("Ox",ClientC.fox),
				new PieChart.Data("Six Wheeler",ClientC.fsw),
				new PieChart.Data("Eight Wheeler",ClientC.few)
				
				
				);
		pcquantity.setData(list);
		
	}
	
	public void generateLineChart(ActionEvent event){
		yearlysales.getData().clear();
		XYChart.Series<String,Number> series1 = new XYChart.Series<String,Number>();
		
		series1.getData().add(new XYChart.Data<String,Number>("2015",ClientC.lcsp2015));
		series1.getData().add(new XYChart.Data<String,Number>("2016",ClientC.lcsp2016));
		series1.getData().add(new XYChart.Data<String,Number>("2017",ClientC.lcsp2017));
		series1.setName("ShaktiPlus");
		
XYChart.Series<String,Number> series2 = new XYChart.Series<String,Number>();
		
		series2.getData().add(new XYChart.Data<String,Number>("2015",ClientC.lcox2015));
		series2.getData().add(new XYChart.Data<String,Number>("2016",ClientC.lcox2016));
		series2.getData().add(new XYChart.Data<String,Number>("2017",ClientC.lcox2017));
		series2.setName("Ox");
		
XYChart.Series<String,Number> series3 = new XYChart.Series<String,Number>();
		
		series3.getData().add(new XYChart.Data<String,Number>("2015",ClientC.lcsw2015));
		series3.getData().add(new XYChart.Data<String,Number>("2016",ClientC.lcsw2016));
		series3.getData().add(new XYChart.Data<String,Number>("2017",ClientC.lcsw2017));
		series3.setName("Six Wheeler");
		
XYChart.Series<String,Number> series4 = new XYChart.Series<String,Number>();
		
		series4.getData().add(new XYChart.Data<String,Number>("2015",ClientC.lcew2015));
		series4.getData().add(new XYChart.Data<String,Number>("2016",ClientC.lcew2016));
		series4.getData().add(new XYChart.Data<String,Number>("2017",ClientC.lcew2017));
		series4.setName("Eight Wheeler");
		yearlysales.getData().addAll(series1,series2,series3,series4);
		
		
	}
	
	public void generateProduction(ActionEvent event){
XYChart.Series<String,Number> prodseries1 = new XYChart.Series<String,Number>();
		
		prodseries1.getData().add(new XYChart.Data<String,Number>("2015",ClientC.prod2015));
		prodseries1.getData().add(new XYChart.Data<String,Number>("2016",ClientC.prod2016));
		prodseries1.getData().add(new XYChart.Data<String,Number>("2017",ClientC.prod2017));
		prodseries1.setName("Units Delivered");
		production.getData().addAll(prodseries1);
		
	}
	
	public void generateProfit(ActionEvent event){
XYChart.Series<String,Number> profitseries1 = new XYChart.Series<String,Number>();
		
profitseries1.getData().add(new XYChart.Data<String,Number>("2015",ClientC.profit2015));
profitseries1.getData().add(new XYChart.Data<String,Number>("2016",ClientC.profit2016));
profitseries1.getData().add(new XYChart.Data<String,Number>("2017",ClientC.profit2017));
profitseries1.setName("Profit Variation");
		profit.getData().addAll(profitseries1);
		
	}
	
	public void generateReport(ActionEvent event) throws IOException{
		
		String rep = "\t\t\t\tBMSCE TILLERS AND TRACTORS LTD\r\n\r\n\r\n\r\n";
		
		
		FileOutputStream fo = new FileOutputStream("report.txt");
		rep+= "\t\t\tReport for the Year 2015\r\n\r\n";
		rep+= "Total units sold in 2015 is: " + ClientC.prod2015 + "\r\n\r\n";
		rep+= "Number of Shakti Plus Units sold: " + ClientC.lcsp2015 + "\r\n\r\n";
		rep+= "Number of Ox Units sold: " + ClientC.lcox2015 + "\r\n\r\n";
		rep+= "Number of Six Wheelers Units sold: " + ClientC.lcsw2015 + "\r\n\r\n";
		rep+= "Number of Eight Wheelers Units sold: " + ClientC.lcew2015 + "\r\n\r\n";
		rep+= "Profit Generated for the year 2015 is : " + ClientC.profit2015 + "\r\n\r\n\n";
		
		//details for the year 2016 
		
		rep+= "\t\t\tReport for the Year 2016\r\n\r\n";
		rep+= "Total units sold in 2016 is: " + ClientC.prod2016 + "\r\n\r\n";
		rep+= "Number of Shakti Plus Units sold: " + ClientC.lcsp2016 + "\r\n\r\n";
		rep+= "Number of Ox Units sold: " + ClientC.lcox2016 + "\r\n\r\n";
		rep+= "Number of Six Wheelers Units sold: " + ClientC.lcsw2016 + "\r\n\r\n";
		rep+= "Number of Eight Wheelers Units sold: " + ClientC.lcew2016 + "\r\n\r\n";
		rep+= "Profit Generated for the year 2016 is : " + ClientC.profit2016 + "\r\n\r\n\r\n";
		
		//details for the year 2017
		
		rep+= "\t\t\tReport for the Year 2017\r\n\r\n";
		rep+= "Total units sold in 2017 is: " + ClientC.prod2017 + "\r\n\r\n";
		rep+= "Number of Shakti Plus Units sold: " + ClientC.lcsp2017 + "\r\n\r\n";
		rep+= "Number of Ox Units sold: " + ClientC.lcox2017 + "\r\n\r\n";
		rep+= "Number of Six Wheelers Units sold: " + ClientC.lcsw2017 + "\r\n\r\n";
		rep+= "Number of Eight Wheelers Units sold: " + ClientC.lcew2017 + "\r\n\r\n";
		rep+= "Profit Generated for the year 2017 is : " + ClientC.profit2017 + "\r\n\r\n\r\n";
		rep+= "End of Report ";
		byte b[] = rep.getBytes();
		fo.write(b);
		fo.close();
		
	
		
	}
	public void exitStats(ActionEvent event){
		
		Platform.exit();
	}
	
}
