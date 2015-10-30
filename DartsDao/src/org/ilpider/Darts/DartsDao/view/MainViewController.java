package org.ilpider.Darts.DartsDao.view;

import org.ilpider.Darts.DartsDao.model.Giocatore;
import org.ilpider.Darts.DartsDao.model.PartitaModel;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;

public class MainViewController {

	@FXML // ResourceBundle that was given to the FXMLLoader
	private ResourceBundle resources;

	@FXML // URL location of the FXML file that was given to the FXMLLoader
	private URL location;

	@FXML // fx:id="cbGiocatore"
	private ComboBox<Giocatore> cbGiocatore; // Value injected by FXMLLoader

	@FXML // fx:id="txtArea"
	private TextArea txtArea; // Value injected by FXMLLoader

	@FXML // fx:id="btnDo"
	private Button btnDo; // Value injected by FXMLLoader

	//// *** per la storia del loader.. 3)
	private PartitaModel model;

	//// *** per la storia del loader.. 2) creo il metodo setModel che verra'
	// richiamato dal main e poi creo anche una variabile PartitaModel qui
	//// dentro
	// viene richiamato prima che la scena sia visibile Ma dopo che il
	// controller stesso e' stato creato, cioe' nel main
	public void setModel(PartitaModel model) {
		this.model = model;
	}

	@FXML // This method is called by the FXMLLoader when initialization is
	// complete
	void initialize() {
		assert cbGiocatore != null : "fx:id=\"cbGiocatore\" was not injected: check your FXML file 'MainView.fxml'.";
	}
	
	@FXML
	void doSeleziona(ActionEvent event) {
		txtArea.appendText(cbGiocatore.getSelectionModel().getSelectedItem().getNome() + "\n");
	}

	@FXML
	void doButton(ActionEvent event) {
		txtArea.appendText(model.contaGiocatori() + "\n");
		
		for (Giocatore g : model.elencoGiocatori()) {
			cbGiocatore.getItems().add(g) ;
		}
	}
}
