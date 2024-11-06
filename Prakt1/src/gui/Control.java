package gui;

import java.io.IOException;

import business.Model;
import javafx.stage.Stage;


public class Control {
	
	private Model m;
	private View v;
	
	public Control (Stage st) throws Exception{
		this.m = new Model();
		this.v = new View(st, this, m);
	}
	
	public void schreibeHaushaltroboterInDatei(String typ) {
		try {
			if("csv".equals(typ)) {
				this.m.schreibeHaushaltroboterInCsvDatei();
				this.v.zeigeInformationsfensterAn("Die Buegeraemte wurden gespeichert");
			} else {
				this.v.zeigeInformationsfensterAn("Noch nicht implementiert");
			}
		} 
		catch (IOException ioe) {
			v.zeigeFehlermeldungsfensterAn("IOException");
			ioe.printStackTrace();
		} catch(Exception exc) {
			v.zeigeFehlermeldungsfensterAn("Unbekannter Fehler beim Speichern!");
			exc.printStackTrace();
		} 
	}
}


