package business;

public class Haushaltroboter {
	
    private int seriennummer;
    private float preis;
    private String modell;
    private String sensortyp;
    private String[] farbe;

    public Haushaltroboter(int seriennummer, float preis, String modell,
    	String sensortyp, String[] farbe){
   		this.seriennummer = seriennummer;
  	    this.preis = preis;
   	    this.modell = modell;
   	    this.sensortyp = sensortyp;
   	    this.farbe = farbe;
    }
    
    //Getter and Setter

	public int getSeriennummer() {
		return seriennummer;
	}


	public void setSeriennummer(int seriennummer) {
		this.seriennummer = seriennummer;
	}


	public float getPreis() {
		return preis;
	}


	public void setPreis(float preis) {
		this.preis = preis;
	}


	public String getModell() {
		return modell;
	}


	public void setModell(String modell) {
		this.modell = modell;
	}


	public String getSensorTyp() {
		return sensortyp;
	}


	public void setSensorTyp(String sensortyp) {
		this.sensortyp = sensortyp;
	}


	public String[] getFarbe() {
		return farbe;
	}


	public void setFarbe(String[] farbe) {
		this.farbe = farbe;
	}
	
	//GetColor
	public String getColor(char trenner) {
		String ergebnis = "";
		int i = 0;
		for(i = 0; i < this.getFarbe().length - 1; i++) {
			ergebnis = ergebnis + this.getFarbe()[i] + trenner; 
		}
		return ergebnis	+ this.getFarbe()[i];
	}
	
	//GetHaushaltroboter
	public String gibHausroboternZurueck(char trenner){
  		return this.getSeriennummer() + trenner 
  			+ this.getPreis() + trenner
  		    + this.getModell() + trenner
  		    + this.getSensorTyp() + trenner + "\n"
  		    + this.getColor(trenner) + "\n";
  	}


}
