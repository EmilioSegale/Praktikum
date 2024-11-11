package gui;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import business.Haushaltroboter;
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
				this.v.zeigeInformationsfensterAn("Die Haushaltroboter wurden gespeichert");
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
	
	public void leseAusDatei(String typ) {
        try {
            if ("csv".equals(typ)) {
                BufferedReader ein = new BufferedReader(new FileReader("Haushaltsrobotern.csv"));
                String[] zeile = ein.readLine().split(";");
                this.m.setHaushaltroboter(new Haushaltroboter(Integer.parseInt(zeile[0]), 
                    Float.parseFloat(zeile[1]), 
                    zeile[2], 
                    zeile[3], 
                    zeile[4].split("_"))); 
                ein.close();
                v.zeigeInformationsfensterAn("Die Haushaltsroboter wurden gelesen!");
            } else {
                v.zeigeInformationsfensterAn("Noch nicht implementiert!");
            }
        } catch (IOException exc) {
            v.zeigeFehlermeldungsfensterAn("IOException beim Lesen!");
        } catch (Exception exc) {
            v.zeigeFehlermeldungsfensterAn("Unbekannter Fehler beim Lesen!");
            exc.printStackTrace();
        }
    }
}


