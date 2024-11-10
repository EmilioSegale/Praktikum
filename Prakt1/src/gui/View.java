package gui;

import business.Haushaltroboter;
import business.Model;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.Pane;
import ownUtil.*;

public class View {
	
	public Control c;
	public Model m;
	
	public View(Stage primaryStage, Control c, Model m) {
		this.c = c;
		this.m = m;
		Scene scene = new Scene(this.pane, 700, 340);
    	primaryStage.setScene(scene);
    	primaryStage.setTitle("Verwaltung von Haushaltsroboter");
    	primaryStage.show();
    	this.initKomponenten();
		this.initListener();
	}
	
    private Pane pane     					= new  Pane();
    private Label lblEingabe    	 		= new Label("Eingabe");
    private Label lblAnzeige   	 	    	= new Label("Anzeige");
    
    private Label lblSeriennummer 			= new Label("Seriennummer:");
    private Label lblPreis 					= new Label("Preis:");
    private Label lblModell  	 			= new Label("Modell:");
    private Label lblSensorTyp   			= new Label("Sensortyp:");
    private Label lblFarbe  				= new Label("Farbe:");
    
    private TextField txtSeriennummer 	 			= new TextField();
    private TextField txtPreis				= new TextField();
    private TextField txtModell				= new TextField();
    private TextField txtSensortyp			= new TextField();
    private TextField txtFarbe				= new TextField();
    private TextArea txtAnzeige  			= new TextArea();
    
    private Button btnEingabe 		 		= new Button("Eingabe");
    private Button btnAnzeige 		 		= new Button("Anzeige");
    
    private MenuBar mnbrMenuLeiste  		= new MenuBar();
    private Menu mnDatei             		= new Menu("Datei");
    private MenuItem mnItmCsvImport 		= new MenuItem("csv-Import");
    private MenuItem mnItmTxtImport 		= new MenuItem("txt-Import");
    private MenuItem mnItmCsvExport 		= new MenuItem("csv-Export"); 
	

    
    private void initKomponenten(){
       	// Labels
    	lblEingabe.setLayoutX(20);
    	lblEingabe.setLayoutY(40);
    	Font font = new Font("Arial", 24); 
    	lblEingabe.setFont(font);
    	lblEingabe.setStyle("-fx-font-weight: bold;"); 
    	lblAnzeige.setLayoutX(400);
    	lblAnzeige.setLayoutY(40);
      	lblAnzeige.setFont(font);
       	lblAnzeige.setStyle("-fx-font-weight: bold;"); 
       	lblSeriennummer.setLayoutX(20);
    	lblSeriennummer.setLayoutY(90);
    	lblPreis.setLayoutX(20);
    	lblPreis.setLayoutY(130);
    	lblModell.setLayoutX(20);
    	lblModell.setLayoutY(170);
    	lblSensorTyp.setLayoutX(20);
    	lblSensorTyp.setLayoutY(210);
    	lblFarbe.setLayoutX(20);
    	lblFarbe.setLayoutY(250);    	
       	pane.getChildren().addAll(lblEingabe, lblAnzeige, 
       		lblSeriennummer, lblPreis, lblModell,
       		lblSensorTyp, lblFarbe);
    
    	// Textfelder
     	txtSeriennummer.setLayoutX(170);
    	txtSeriennummer.setLayoutY(90);
    	txtSeriennummer.setPrefWidth(200);
    	txtPreis.setLayoutX(170);
    	txtPreis.setLayoutY(130);
    	txtPreis.setPrefWidth(200);
    	txtModell.setLayoutX(170);
    	txtModell.setLayoutY(170);
    	txtModell.setPrefWidth(200);
      	txtSensortyp.setLayoutX(170);
    	txtSensortyp.setLayoutY(210);
    	txtSensortyp.setPrefWidth(200);
    	txtFarbe.setLayoutX(170);
    	txtFarbe.setLayoutY(250);
    	txtFarbe.setPrefWidth(200);
      	pane.getChildren().addAll( 
      			txtSeriennummer, txtPreis, txtModell,
      			txtSensortyp, txtFarbe);
     	
        // Textbereich	
        txtAnzeige.setEditable(false);
     	txtAnzeige.setLayoutX(400);
    	txtAnzeige.setLayoutY(90);
     	txtAnzeige.setPrefWidth(270);
    	txtAnzeige.setPrefHeight(185);
       	pane.getChildren().add(txtAnzeige); 
       	
        // Buttons
        btnEingabe.setLayoutX(20);
        btnEingabe.setLayoutY(290);
        btnAnzeige.setLayoutX(400);
        btnAnzeige.setLayoutY(290);
        pane.getChildren().addAll(btnEingabe, btnAnzeige); 
        
 		// Menue
  	    this.mnbrMenuLeiste.getMenus().add(mnDatei);
  	    this.mnDatei.getItems().add(mnItmCsvImport);
  	    this.mnDatei.getItems().add(mnItmTxtImport);
  	    this.mnDatei.getItems().add(new SeparatorMenuItem());
  	    this.mnDatei.getItems().add(mnItmCsvExport);
 	    pane.getChildren().add(mnbrMenuLeiste);
   }
   
   private void initListener() {
	    btnEingabe.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
            	nehmeHaushaltsroboterAuf();
            }
	    });
	    btnAnzeige.setOnAction(new EventHandler<ActionEvent>() {
	    	@Override
	        public void handle(ActionEvent e) {
	            zeigeHaushaltroboterAn();
	        } 
   	    });
	    mnItmTxtImport.setOnAction(new EventHandler<ActionEvent>() {
		    @Override
		    public void handle(ActionEvent e) {
				schreibeHaushaltroboterInDatei("txt");
		    }
    	});
	    mnItmCsvExport.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				schreibeHaushaltroboterInDatei("csv");
			}
	    });
    }
	
	private void nehmeHaushaltsroboterAuf(){
    	try{
    		this.m.haushaltroboter = new Haushaltroboter(
    			Integer.parseInt(txtSeriennummer.getText()), 
   	            Float.parseFloat(txtPreis.getText()),
   	            txtModell.getText(),
    		    txtSensortyp.getText(),
    		    txtFarbe.getText().split(";"));
    		zeigeInformationsfensterAn("Das Haushaltsroboter wurde aufgenommen!");
       	}
       	catch(Exception e){
       		zeigeFehlermeldungsfensterAn(e.getMessage());
     	}
    }
   
    private void zeigeHaushaltroboterAn(){
    	if(this.m.haushaltroboter != null){
    		txtAnzeige.setText(
    			this.m.haushaltroboter.gibHausroboternZurueck('-'));
    	}
    	else{
    		zeigeInformationsfensterAn("Bisher wurde kein Haushaltsroboter aufgenommen!");
    	}
    }
    
	private void schreibeHaushaltroboterInDatei(String typ) {
		this.c.schreibeHaushaltroboterInDatei(typ);
	} 
	
    public void zeigeInformationsfensterAn(String meldung){
    	new MeldungsfensterAnzeiger(AlertType.INFORMATION,
    		"Information", meldung).zeigeMeldungsfensterAn();
    }	
    
    public void zeigeFehlermeldungsfensterAn(String meldung){
       	new MeldungsfensterAnzeiger(AlertType.ERROR,
        	"Fehler", meldung).zeigeMeldungsfensterAn();
    }

}
