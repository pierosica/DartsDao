package org.ilpider.Darts.DartsDao;

import org.ilpider.Darts.DartsDao.model.PartitaModel;
import org.ilpider.Darts.DartsDao.view.MainViewController;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.fxml.FXMLLoader;

/**
 * In questo main (e nelle classi correlate {@link PartitaModel}, {@link Giocatore} e {@link MainViewController}) è stato commentato in verde quello che ho potuto riassumere dal corso
 * di Fulvio Corno (lez.13 - TdP 2014/2015)
 * @author Piero Sica
 *
 */
public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			// *** per la storia del loader.. 5) alla fine esplicito il loader
			// *** per la storia del loader.. 6) ORIGINALE
			//       AnchorPane root = (AnchorPane) FXMLLoader.load(getClass().getResource("view/MainView.fxml"));
			// *** per la storia del loader.. 7) MODIFICATO
			FXMLLoader loader = new FXMLLoader(getClass().getResource("view/MainView.fxml"));
			
			AnchorPane root = (AnchorPane) loader.load();
			Scene scene = new Scene(root, 400, 400);
			scene.getStylesheets().add(getClass().getResource("view/application.css").toExternalForm());
			
			// *** per la storia del loader.. 1) Creo il Model..poi vado nel controller a creare il setModel
			PartitaModel partitaModel = new PartitaModel() ;
			// *** per la storia del loader.. 4) ora posso richiamare il metodo setModel nel controller appena creato dal new PartitaModel
			// ..MA non ho ancora il riferimento al controller per cui vado a modificare il merdone dell'FXMLLoader
			// *** per la storia del loader.. 8) posso creare il riferimento completo al controller ed eseguirne i metodi
			MainViewController controller = loader.getController();
			controller.setModel(partitaModel);

			
			
			
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}
