/**
 * 
 */
package test;

import static org.junit.Assert.*;
import org.junit.Test;
import org.mockito.Mockito;

import controller.MovieController;
import model.Film;

import static org.mockito.Mockito.*;

import javax.swing.DefaultListModel;

/**
 * @author manuel
 *
 */

public class TestMovieControl {

	// der zu testende controller - System under test
	MovieController mControl;
	// die benötigten Interface-Klassen	- Dependent on component
	Film film;
	DefaultListModel<String> filmListModel = new DefaultListModel<String>();
	String filmTitel;

	// getestet wird setMovieList, getSelectedMovie, getSelectedMovieIndex...
	@Test
	public void testRunMethod() {
		// Konstruktoraufrug mit mock() methode der Interface-Klassen - Abhängigkeit des controller erstellen
		film = Mockito.mock(Film.class);
	
		// Konstruktoraufruf
		mControl = new MovieController();
		// Setup für den Test
		film = mControl.getFilmList().get(0);
		filmListModel.addElement(filmTitel);
		filmTitel = film.getTitel();
		/**
		 * test der getSelectedMovie Methode
		 * Funktioniert nicht.
		 */
		assertEquals(filmTitel, mControl.getSelectedMovie(filmListModel.get(0)));
		/**
		 * test der getSelectedMovieIndex Methode
		 * Funktioniert nicht.
		 */
		assertEquals(0, mControl.getSelectedMovieIndex(filmListModel.get(0)));
		
	}

}
