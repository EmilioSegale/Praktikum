package business;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;


public class Model {
	
	public Haushaltroboter haushaltroboter;
	
		
	public Haushaltroboter getHaushaltroboter() {
		return haushaltroboter;
	}
	public void setHaushaltroboter(Haushaltroboter haushaltroboter) {
	    this.haushaltroboter = haushaltroboter;
	}
	
	
	public void schreibeHaushaltroboterInCsvDatei() throws IOException {
		if (this.haushaltroboter == null) {
	        throw new IllegalStateException("Haushaltroboter can not be Ini.");
	    }
			BufferedWriter aus = new BufferedWriter(new FileWriter("Haushaltsroboter.csv", true));
			aus.write(this.getHaushaltroboter().gibHausroboternZurueck(';'));
			aus.close();

	}
	
}
