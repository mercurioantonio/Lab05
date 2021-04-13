package it.polito.tdp.anagrammi;

import java.net.URL;
import java.util.ResourceBundle;
import it.polito.tdp.anagrammi.model.Model;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {
	
	Model model;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtParola;

    @FXML
    private TextArea txtCorretti;

    @FXML
    private TextArea txtErrati;

    @FXML
    void doCalcola(ActionEvent event) {
    	String stringaCorretti = "";
    	String stringaErrati = "";
    	
    	String parola = txtParola.getText();
    	
    	for(String s : model.anagrammiCorretti(parola)) {
    		stringaCorretti = stringaCorretti + s +"\n";
    	}
    	txtCorretti.setText(stringaCorretti);
    	
    	
    	for(String s : model.anagrammiErrati(parola)) {
    		stringaErrati= stringaErrati + s +"\n";
    	}
    	txtErrati.setText(stringaErrati);

    }

    @FXML
    void doReset(ActionEvent event) {
    	txtParola.clear();
    	txtCorretti.clear();
    	txtErrati.clear();

    }

    @FXML
    void initialize() {
        assert txtParola != null : "fx:id=\"txtParola\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtCorretti != null : "fx:id=\"txtCorretti\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtErrati != null : "fx:id=\"txtErrati\" was not injected: check your FXML file 'Scene.fxml'.";

    }

   
	public void setModel(Model m) {
		this.model = m ;
		txtCorretti.setStyle("-fx-font-family: monospace");
		txtErrati.setStyle("-fx-font-family: monospace");
		}
		
	}

