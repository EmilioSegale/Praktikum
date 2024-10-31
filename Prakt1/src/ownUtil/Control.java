package ownUtil;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import business.Haushaltroboter;
import business.Model;
import gui.View;
import javafx.stage.Stage;


public class Control {
	
	public Model m;
	public View v;
	public Control c;
	
	public Control (Stage st) {
		super();
		this.m = new Model();
		this.v = new View(Model m, Stage st, Control c);
	}
	
	public void leseAusDatei(String typ){
    	try {
      		if("csv".equals(typ)){
      			BufferedReader ein = new BufferedReader(new FileReader("Haushaltsrobotern.csv"));
      			String[] zeile = ein.readLine().split(";");
      			this.m = new Model();
      				ein.close();
      	  			this.v.zeigeInformationsfensterAn(
      	  	   			"Die Haushaltsroboter wurden gelesen!");
      		}
       		else{
	   			this.v.zeigeInformationsfensterAn(
	   				"Noch nicht implementiert!");
	   		}
		}
		catch(IOException exc){
			this.v.zeigeFehlermeldungsfensterAn(
				"IOException beim Lesen!");
		}
		catch(Exception exc){
			 v.zeigeFehlermeldungsfensterAn(
				"Unbekannter Fehler beim Lesen!");
		}
	}
}


