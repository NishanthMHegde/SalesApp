package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.PieChart.Data;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class ClientC extends EmployeeController implements Initializable{
	@FXML
	public TextField CID;
	@FXML
	public TextField CName;
    @FXML
    public ComboBox YEAR; 
	@FXML
	public TextField SPQ;
	@FXML
	public TextField OQ;
	@FXML
	public TextField SW;
	@FXML
	public TextField EW;
	@FXML
	public TextField PAY;
	@FXML
	public TextField TOTALPAY;
	@FXML
	public TextField TSP;
	@FXML
	public TextField TOX;
	@FXML
	public TextField TSW;
	@FXML
	public TextField TEW;
	
	//final textfields
	
	@FXML
	public TextField sp2015;
	@FXML
	public TextField sp2016;
	@FXML
	public TextField sp2017;
	
	@FXML
	public TextField fpay2015;
	@FXML
	public TextField fpay2016;
	@FXML
	public TextField fpay2017;
	
	
	
	@FXML
	public TextField ox2015;
	@FXML
	public TextField ox2016;
	@FXML
	public TextField ox2017;
	
	@FXML
	public TextField sw2015;
	@FXML
	public TextField sw2016;
	@FXML
	public TextField sw2017;
	
	@FXML
	public TextField ew2015;
	@FXML
	public TextField ew2016;
	@FXML
	public TextField ew2017;
	
	@FXML
	public TextField final2015;
	@FXML
	public TextField final2016;
	@FXML
	public TextField final2017;
	
	@FXML
	public ListView cid;
	
	@FXML
	public ListView pay;
	@FXML
	public ListView cname;
	@FXML
	public ListView year;
	@FXML
	public ListView spq;
	@FXML
	public ListView oq;
	@FXML
	public ListView sw;
	@FXML
	public ListView ew;
	
	
	
	public static double fsp = 0;
	public static double fox = 0;
	public static double few = 0;
	public static double fsw = 0;
	
	//variables for calculating total units of tractors and lorry and their amount
	
	public static double tamt = 0;
	public static double tsp = 0;
	public static double tox = 0;
	public static double tew = 0;
	public static double tsw = 0;
	public int pos=0;
	public static double sum2015 = 0;
	public static double sum2016 = 0;
	public static double sum2017 = 0;
	public static double f2015 = 0;
	public static double f2016 = 0;
	public static double f2017 = 0;
	
	//data for line chart
	
	public static double lcsp2015 = 0;
	public static double lcsp2016 = 0;
	public static double lcsp2017= 0;
	
	public static double lcox2015 = 0;
	public static double lcox2016 = 0;
	public static double lcox2017 = 0;
	
	public static double lcsw2015 = 0;
	public static double lcsw2016 = 0;
	public static double lcsw2017 = 0;
	
	public static double lcew2015 = 0;
	public static double lcew2016= 0;
	public static double lcew2017 = 0;
	int[] yeararr = new int[30];
	
	//total units produced in every year
	public static double prod2015 = 0;
	public static double prod2016 = 0;
	public static double prod2017 = 0;
	
	//calculating client paid amount in 3 years
	public static double pay2015 =0;
	public static double pay2016 =0;
	public static double pay2017 =0;
	
	public static double finalpay2015 =0;
	public static double finalpay2016 =0;
	public static double finalpay2017 =0;
	
	//calculate yearly manufacture costs
	public static double tractormanu2015 =0;
	public static double tractormanu2016 =0;
	public static double tractormanu2017 =0;
	public static double lorrymanu2015=0;
	public static double lorrymanu2016=0; 
	public static double lorrymanu2017=0; 
	
	//profit variables
	
	public static double profit2015=0;
	public static double profit2016=0;
	public static double profit2017 =0;
	
	
	
	ObservableList<String> years = FXCollections.observableArrayList("2015","2016","2017");
	ObservableList<String> clname = FXCollections.observableArrayList("Ambuja","Mitsubhishi","Canara Agri");
	ObservableList<String> clid = FXCollections.observableArrayList("01","02","03");
	ObservableList<String> splus = FXCollections.observableArrayList("2","2","3");
	ObservableList<String> oxt = FXCollections.observableArrayList("1","2","3");
	ObservableList<String> swq = FXCollections.observableArrayList("2","2","3");
	ObservableList<String> ewq = FXCollections.observableArrayList("1","2","5");
	ObservableList<String> amount = FXCollections.observableArrayList("100000","20000","300000");
	ObservableList<String> am = FXCollections.observableArrayList();
	ObservableList<String> sp = FXCollections.observableArrayList();
	ObservableList<String> ox = FXCollections.observableArrayList();
	ObservableList<String> ewr = FXCollections.observableArrayList();
	ObservableList<String> swr = FXCollections.observableArrayList();
	ObservableList<String> sppos = FXCollections.observableArrayList();
	ObservableList<String> oxpos = FXCollections.observableArrayList();
	ObservableList<String> swpos = FXCollections.observableArrayList();
	ObservableList<String> ewpos = FXCollections.observableArrayList();
	ObservableList<String> yearpos = FXCollections.observableArrayList();
	ObservableList<String> csal = FXCollections.observableArrayList();
	
	//code to add clients
	public void addClients(ActionEvent event){
		
		clname.add(CName.getText());
		clid.add(CID.getText());
		splus.add(SPQ.getText());
		oxt.add(OQ.getText());
		years.add(YEAR.getSelectionModel().getSelectedItem() + "");
		swq.add(SW.getText());
		ewq.add(EW.getText());
		amount.add(PAY.getText());
		
		//add observable list to List View
		cname.setItems(clname);
		cid.setItems(clid);
		pay.setItems(amount);
		year.setItems(years);
		spq.setItems(splus);
		oq.setItems(oxt);
		sw.setItems(swq);
		ew.setItems(ewq);
		
	
		//total amount paid by client
		for(String am : amount){
			tamt = tamt + Double.parseDouble(am);
			
			
		}
		TOTALPAY.setText(tamt + "");
		tamt = 0;
		
		//total shakti plus ordered 
		for(String sp : splus){
			tsp = tsp + Double.parseDouble(sp);
			
			
		}
		TSP.setText(tsp + "");
		tsp = 0;
		
		//total ox ordered 
		for(String ox : oxt){
			tox= tox + Double.parseDouble(ox);
			
			
		}
		TOX.setText(tox + "");
		tox = 0;
		
		//total six wheelers ordered 
		
		for(String swr : swq){
			tsw = tsw + Double.parseDouble(swr);
			
			
		}
		TSW.setText(tsw + "");
		tsw = 0;
		
		//total eight wheelers ordered 
		
		for(String ewr : ewq){
			tew = tew + Double.parseDouble(ewr);
			
			
		}
		TEW.setText(tew + "");
		tew = 0;
		
		fsp = Double.parseDouble(TSP.getText());
		fox = Double.parseDouble(TOX.getText());
		fsw = Double.parseDouble(TSW.getText());
		few = Double.parseDouble(TEW.getText());
		
	}
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
		
		YEAR.setItems(years);
		cname.setItems(clname);
		cid.setItems(clid);
		pay.setItems(amount);
		year.setItems(years);
		spq.setItems(splus);
		oq.setItems(oxt);
		sw.setItems(swq);
		ew.setItems(ewq);
		
		//total amount paid by client
				for(String am : amount){
					tamt = tamt + Double.parseDouble(am);
					
					
				}
				TOTALPAY.setText(tamt + "");
				tamt = 0;
				
				//total shakti plus ordered 
				for(String sp : splus){
					tsp = tsp + Double.parseDouble(sp);
					
					
				}
				TSP.setText(tsp + "");
				tsp = 0;
				
				//total ox ordered 
				for(String ox : oxt){
					tox= tox + Double.parseDouble(ox);
					
					
				}
				TOX.setText(tox + "");
				tox = 0;
				
				//total six wheelers ordered 
				
				for(String swr : swq){
					tsw = tsw + Double.parseDouble(swr);
					
					
				}
				TSW.setText(tsw + "");
				tsw = 0;
				
				//total eight wheelers ordered 
				
				for(String ewr : ewq){
					tew = tew + Double.parseDouble(ewr);
					
					
				}
				TEW.setText(tew + "");
				tew = 0;
				
				fsp = Double.parseDouble(TSP.getText());
				fox = Double.parseDouble(TOX.getText());
				fsw = Double.parseDouble(TSW.getText());
				few = Double.parseDouble(TEW.getText());
	
	}
	
	//calculate totals
	public void calculateYearlyStats(ActionEvent event){
		
		pos=0;
		
		for(String yearpos: years){
			if(Double.parseDouble(yearpos)==2015){
				yeararr[pos]=2015;
				
			}
			else if(Double.parseDouble(yearpos)==2016){
				yeararr[pos]=2016;
				
			}
			else if(Double.parseDouble(yearpos)==2017){
				yeararr[pos]=2017;
				
			}
			pos++;
		}
		
		pos = 0;
		
		for(String sppos: splus){
			if(yeararr[pos]==2015){
				sum2015+= Double.parseDouble(sppos);
				f2015 +=sum2015;
				
			} 
			else if(yeararr[pos]==2016){
				sum2016+= Double.parseDouble(sppos);
				f2016 +=sum2016;
				
			} 
			else if(yeararr[pos]==2017){
				sum2017+= Double.parseDouble(sppos);
				f2017+=sum2017;
				
			} 
			pos++;
			
		}
		
		sp2015.setText(sum2015 + "");
		sp2016.setText(sum2016 + "");
		sp2017.setText(sum2017 + "");
		
		sum2015 =0;
		sum2016 = 0;
		sum2017 = 0;
		pos=0;
		//calculating ox yearly
		for(String oxpos: oxt){
			if(yeararr[pos]==2015){
				sum2015+= Double.parseDouble(oxpos);
				f2015 +=sum2015;
				
			} 
			else if(yeararr[pos]==2016){
				sum2016+= Double.parseDouble(oxpos);
				f2016 +=sum2016;
				
			} 
			else if(yeararr[pos]==2017){
				sum2017+= Double.parseDouble(oxpos);
				f2017 +=sum2017;
				
			} 
			pos++;
			
		}
		
		ox2015.setText(sum2015 + "");
		ox2016.setText(sum2016 + "");
		ox2017.setText(sum2017 + "");
		
		pos = 0;
		sum2015 =0;
		sum2016 = 0;
		sum2017 = 0;
		//calculating sw yearly
		for(String swpos: swq){
			if(yeararr[pos]==2015){
				sum2015+= Double.parseDouble(swpos);
				f2015 +=sum2015;
				
			} 
			else if(yeararr[pos]==2016){
				sum2016+= Double.parseDouble(swpos);
				f2016 +=sum2016;
				
			} 
			else if(yeararr[pos]==2017){
				sum2017+= Double.parseDouble(swpos);
				f2017 +=sum2017;
				
			} 
			pos++;
			
		}
		
		sw2015.setText(sum2015 + "");
		sw2016.setText(sum2016 + "");
		sw2017.setText(sum2017 + "");
		
		pos = 0;
		sum2015 =0;
		sum2016 = 0;
		sum2017 = 0;
		//calculating ew yearly
		for(String ewpos: ewq){
			if(yeararr[pos]==2015){
				sum2015+= Double.parseDouble(ewpos);
				f2015 +=sum2015;
				
				
			} 
			else if(yeararr[pos]==2016){
				sum2016+= Double.parseDouble(ewpos);
				f2016 +=sum2016;
				
			} 
			else if(yeararr[pos]==2017){
				sum2017+= Double.parseDouble(ewpos);
				f2017 +=sum2017;
				
			} 
			pos++;
			
		}
		
		ew2015.setText(sum2015 + "");
		ew2016.setText(sum2016 + "");
		ew2017.setText(sum2017 + "");
		
		//set final credentials
		final2016.setText(Double.parseDouble(sp2016.getText())+Double.parseDouble(ox2016.getText())+Double.parseDouble(sw2016.getText())+Double.parseDouble(ew2016.getText())+"");
		final2015.setText(Double.parseDouble(sp2015.getText())+Double.parseDouble(ox2015.getText())+Double.parseDouble(sw2015.getText())+Double.parseDouble(ew2015.getText())+"");
		final2017.setText(Double.parseDouble(sp2017.getText())+Double.parseDouble(ox2017.getText())+Double.parseDouble(sw2017.getText())+Double.parseDouble(ew2017.getText())+"");
		
		
		//initalize values back to zero for re-calculation
		pos =0;
		sum2015 = 0;
		sum2016 = 0;
		sum2017 = 0;
		
		f2015 = 0;
		f2016 = 0;
		f2017 = 0;
		
		lcsp2015 = Double.parseDouble(sp2015.getText());
		lcsp2016 = Double.parseDouble(sp2016.getText());
		lcsp2017 = Double.parseDouble(sp2017.getText());
		
		lcox2015 = Double.parseDouble(ox2015.getText());
		lcox2016 = Double.parseDouble(ox2016.getText());
		lcox2017 = Double.parseDouble(ox2017.getText());
		
		lcsw2015 = Double.parseDouble(sw2015.getText());
		lcsw2016 = Double.parseDouble(sw2016.getText());
		lcsw2017 = Double.parseDouble(sw2017.getText());
		
		lcew2015 = Double.parseDouble(ew2015.getText());
		lcew2016 = Double.parseDouble(ew2016.getText());
		lcew2017 = Double.parseDouble(ew2017.getText());
		
		prod2015 = Double.parseDouble(final2015.getText());
		prod2016 = Double.parseDouble(final2016.getText());
		prod2017 = Double.parseDouble(final2017.getText());
		
		//calculating client yearly pay
		pos =0;
				for(String csal: amount){
					if(yeararr[pos]==2015){
						pay2015+= Double.parseDouble(csal);
						
						
						
					} 
					else if(yeararr[pos]==2016){
						pay2016+= Double.parseDouble(csal);
						
						
					} 
					else if(yeararr[pos]==2017){
						pay2017+= Double.parseDouble(csal);
						
						
					} 
					pos++;
					
				}
				finalpay2015 = pay2015;
				finalpay2016 = pay2016;
				finalpay2017 = pay2017;
				
				pay2015 =0;
				pay2016=0;
				pay2017=0;
				fpay2015.setText(finalpay2015 + "");
				fpay2016.setText(finalpay2016 + "");
				fpay2017.setText(finalpay2017 + "");
				
				tractormanu2015 = EmployeeController.expenses * (lcsp2015 +lcox2015);
				tractormanu2016 = EmployeeController.expenses * (lcsp2016 +lcox2016);
				tractormanu2017 = EmployeeController.expenses * (lcsp2017 +lcox2017);
				
				
		lorrymanu2015 = EmployeeController.expenses1 *  (lcew2015 + lcsw2015);
		lorrymanu2016 = EmployeeController.expenses1 *  (lcew2016 + lcsw2016);
		lorrymanu2017 = EmployeeController.expenses1 *  (lcew2017 + lcsw2017);
		
		//calculate profit/loss 
		profit2015 = finalpay2015 - (EmployeeController.ttsal + tractormanu2015 + lorrymanu2015);
		profit2016 = finalpay2016 - (EmployeeController.ttsal + tractormanu2016 + lorrymanu2016);
		profit2017 = finalpay2017 - (EmployeeController.ttsal + tractormanu2017 + lorrymanu2017);
		
		
	}
	
	public void exitClient(ActionEvent event)
	{
		Platform.exit();
	
		
	}
	
	
	
}
