package business;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;


public class Model {
	
	public Haushaltroboter a;
	
		
	public Haushaltroboter getHaushaltroboter() {
		return a;
	}
	
	public void schreibeBuergeraemterInCsvDatei() throws IOException {
			BufferedWriter aus = new BufferedWriter(new FileWriter("Haushaltsroboter.csv", true));
			aus.write(a.gibHausroboternZurueck(';'));
			aus.close();

	}
	
}
