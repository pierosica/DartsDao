package org.ilpider.Darts.DartsDao.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.ilpider.Darts.DartsDao.model.Giocatore;

/**
 * Data Access Object per manipolare la tabella TBLGIOCATORI del database DARTS
 */
public class GiocatoreDAO {

	/**
	 * Conta il numero di record nella tabella TBLGIOCATORI
	 * 
	 * @return il numero di giocatori nella tabella
	 */
	public int contaTutti() {

		Connection conn = DBConnect.getConnection();

		String query = "SELECT count(id) as tutti FROM `tblgiocatori`";
		try {
			Statement st1 = conn.createStatement();
			ResultSet rs1 = st1.executeQuery(query);
			rs1.next();
			int numeroRecord = rs1.getInt("tutti");
			rs1.close();
			conn.close();
			return numeroRecord;

		} catch (SQLException e) {
			System.out.println("non connetto");
			return -1;
		}
	}

	/**
	 * Restituisce come stringa il valore del campo NOME della TBLGIOCATORE che
	 * ha l'id specificato come parametro
	 * 
	 * @param id
	 *            è l'id del giocatore che voglio leggere dal db
	 * @return (inizialmente) la stringa letta dal campo NOME
	 */
	public String giocatoreNome(int id) {

		Connection conn = DBConnect.getConnection();

		String query = "SELECT nome FROM `tblgiocatori` where id = " + id;

		try {
			Statement st1 = conn.createStatement();
			ResultSet rs1 = st1.executeQuery(query);
			rs1.next();
			String nome = rs1.getString("nome");
			rs1.close();
			conn.close();
			return nome;
		} catch (SQLException e) {
			System.out.println("non connetto");
			return null;
		}
	}

	public List<Giocatore> listGiocatore() {

		Connection conn = DBConnect.getConnection();

		String query = "SELECT * FROM `tblgiocatori`";

		List<Giocatore> lista = new ArrayList<>();

		try {
			Statement st1 = conn.createStatement();
			ResultSet rs1 = st1.executeQuery(query);

			while (rs1.next()) {
				Giocatore g = new Giocatore(rs1.getInt("id"), rs1.getString("nome"));
				lista.add(g);
			}

			conn.close();
			return lista;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}

	}

	/**
	 * Restituisce TRUE se nel database esiste gia' un giocatore che ha il nome
	 * di quello che sta verificando se inserire o no.
	 * 
	 * @param g
	 *            E' il giocatore da verificare se e' gia' presente nel database
	 * @return TRUE se esiste un record che ha lo stesso nome, FALSE se invece
	 *         non lo trova
	 */
	public boolean esisteNomeGiocatore(String nome) {

		Connection conn = DBConnect.getConnection();
		String query = "SELECT * from `tblgiocatori` where `nome` = " + nome;

		try {
			Statement st1 = conn.createStatement();
			ResultSet rs1 = st1.executeQuery(query);

			if (rs1.next()) {
				conn.close();
				return true;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return false;

	}

}
