package org.ilpider.Darts.DartsDao.model;

import java.util.LinkedList;
import java.util.List;

import org.ilpider.Darts.DartsDao.dao.GiocatoreDAO;

public class PartitaModel {

	private List<Giocatore> partita;

	public PartitaModel() {
		this.partita = new LinkedList<Giocatore>();
	}

	public void addGiocatore(Giocatore g) {
		this.partita.add(g);
	}

	public int getNumeroGiocatori() {
		return this.partita.size();
	}

	public Giocatore vincitore() {
		// TODO andare a prendere il giocatore che ha il punteggio minore con
		// tutti i calcoli del caso...
		return null;
	}

	public int contaGiocatori() {
		GiocatoreDAO dao = new GiocatoreDAO() ;
		
		int numeroGiocatori = dao.contaTutti() ;

		return numeroGiocatori ;
	}

	public List<Giocatore> elencoGiocatori() {

		GiocatoreDAO dao = new GiocatoreDAO() ;

		this.partita = dao.listGiocatore() ;

		return this.partita;
		
	}
}
