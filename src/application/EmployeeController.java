package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.Window;

public class EmployeeController implements Initializable {
	
@FXML
public  TextField Ename; 
@FXML
public TextField EID; 
@FXML
public  TextField EDes; 
@FXML
public TextField ESal; 

 
@FXML
public TextField TS; 

@FXML
public TextField ENG; 
@FXML
public TextField EXP; 

@FXML
public TextField EXP1; 

@FXML
public TextField CH; 
@FXML
public TextField TI; 
@FXML
public TextField BO; 
@FXML
public TextField PC; 
@FXML
public TextField TC; 

@FXML
public TextField CH1; 
@FXML
public TextField TI1; 
@FXML
public TextField BO1; 
@FXML
public TextField ENG1; 
@FXML
public TextField OH; 

@FXML
public  ListView<String> ENAME ;
@FXML
public ListView<String> Eid ;
@FXML
public ListView<String> EDES;
@FXML
public ListView<String> ESAL;

public double salary;
public double tsal = 0;

public static double pc;
public static double tc;
public static double ch;
public static double bo;
public static double eng;
public static double ti;

public static double tc1;
public static double ch1;
public static double bo1;
public static double eng1;
public static double ti1;
public static double expenses1 = 0;
public static double expenses = 0;

public static double unittractor = 0;
public static double unitlorry =0;

public static double totalcompanyexpenditure =0;

public static double ttsal =0;
@FXML
private MenuItem closescreen;


ObservableList<String> name =  FXCollections.observableArrayList("Nishanth Hegde","Sachin Bhagwat","Uday Hegde","Sumanth");
ObservableList<String> id =  FXCollections.observableArrayList("01","02","03","04");
ObservableList<String> des =  FXCollections.observableArrayList("Software Engineer","Singer/developer","Tester","Database Admin");
ObservableList<String> sal =  FXCollections.observableArrayList("115000","100000","750000","60000");
ObservableList<String> isal =  FXCollections.observableArrayList();

public void addEmployees(ActionEvent event){
	
	name.add(Ename.getText());
	id.add(EID.getText());
	des.add(EDes.getText());
	sal.add(ESal.getText());
	
	ENAME.setItems(name);
	Eid.setItems(id);
	
	EDES.setItems(des);
	ESAL.setItems(sal);
	for(String isal : ESAL.getItems() ){
		salary =Double.parseDouble(isal);
		tsal = tsal + salary;
	}
		TS.setText(tsal+ "");
		ttsal =tsal;
		tsal = 0;
		
		
	
	
}


	public void calculateExpenses(ActionEvent event){
		
		
		
		
		ti = Double.parseDouble(TI.getText());
		
		eng = Double.parseDouble(ENG.getText());
		bo = Double.parseDouble(BO.getText());
		ch = Double.parseDouble(CH.getText());
		expenses =  eng + bo + ch +ti;
		EXP.setText(expenses + "");
		
        ti1 = Double.parseDouble(TI1.getText());
		
		eng1 = Double.parseDouble(ENG1.getText());
		bo1 = Double.parseDouble(BO1.getText());
		ch1 = Double.parseDouble(CH1.getText());
		expenses1 =  eng1 + bo1 + ch1 +ti1;
		EXP1.setText(expenses1 + "");
		unittractor = pc+tc+expenses;
		unitlorry = pc+tc+expenses1;
		
		
	}
	
public void calculateOverhead(ActionEvent event){
	
	pc = Double.parseDouble(PC.getText());
	tc = Double.parseDouble(TC.getText());
	OH.setText((pc+tc) + "");
}

@Override
public void initialize(URL arg0, ResourceBundle arg1) {
	// TODO Auto-generated method stub
	
	Eid.setItems(id);
	ENAME.setItems(name);
	ESAL.setItems(sal);
	EDES.setItems(des);
	PC.setText("1000");
	TC.setText("600");
	CH.setText("1000");
	ENG.setText("3000");
	BO.setText("2000");
	TI.setText("500");
	CH1.setText("1500");
	ENG1.setText("4000");
	BO1.setText("2500");
	TI1.setText("700");
	
	for(String isal : ESAL.getItems() ){
		salary =Double.parseDouble(isal);
		tsal = tsal + salary;
	}
		TS.setText(tsal+ "");
		ttsal =tsal;
		tsal = 0;
	
	
}
public void exitEmp(ActionEvent event)
{
Platform.exit();
}

}
