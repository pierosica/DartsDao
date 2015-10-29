package org.ilpider.Darts.DartsDao.view;

import org.ilpider.Darts.DartsDao.model.PartitaModel;

public class MainViewController {
	
	//// *** per la storia del loader.. 3) 
	private PartitaModel model;
	
	
	// *** per la storia del loader.. 2) creo il metodo setModel che verra' richiamato dal main
	// e poi creo anche una variabile PartitaModel qui dentro
	// viene richiamato prima che la scena sia visibile Ma dopo che il controller stesso e' stato creato, cioe' nel main
	public void setModel(PartitaModel model) {
		this.model = model ;
	}
}
