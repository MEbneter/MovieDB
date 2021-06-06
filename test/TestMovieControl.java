/**
 * 
 */
package test;

import static org.junit.Assert.*;
// import org.junit.BeforeClass;
// https://junit.org/junit4/javadoc/4.13/org/junit/package-tree.html 
import org.junit.Test;
import org.mockito.Mockito;

import controller.MovieController;
import view.MovieView;
import view.NewMovieWindow;
import view.NewPersonWindow;
import static org.mockito.Mockito.*;

/**
 * @author manuel
 *
 */

public class TestMovieControl {

	// der zu testende controller - System under test
	MovieController mControl;
	// die benötigten Interface-Klassen	- Dependent on component
	NewPersonWindow personWindow;
	NewMovieWindow movieWindow;
	MovieView mainView;

	
	@Test
	public void testRunMethod() {
		// Konstruktoraufrug mit mock() methode der Interface-Klassen - Abhängigkeit des controller erstellen
		mainView = Mockito.mock(MovieView.class);
	
		// Konstruktoraufruf
		mControl = new MovieController();
		// so ne art main methode ... glaube ich
		mControl.run();
		// zeugs aus der schule , platzhalter..
		//assertEquals( "AC should be off initially", 0, sutIotControl.getAcForce());
		//assertFalse( "Alarm should be off initalially", sutIotControl.isAlarmState());
		// beim temperatur aufruf (when) gibt er 25 grad zurück (then)
		/**
		 * If you specify more than one value, they are returned in the order of specification, 
		 * until the last one is used. Afterwards the last specified value is returned.
		 *
		when(tempSensorMock.getTemperature()).thenReturn(25.0);
		sutIotControl.run();
		assertEquals( "AC should still be off", 0, sutIotControl.getAcForce());
		assertFalse( "Alarm should be off now", sutIotControl.isAlarmState());
		
		when(tempSensorMock.getTemperature()).thenReturn(IotControl.ACTHRESHOLD+3);
		sutIotControl.run();
		assertEquals( "AC should be running now", IotControl.ACTHRESHOLD+3, sutIotControl.getAcForce(), 0);
		assertFalse( "Alarm should be off now", sutIotControl.isAlarmState());
	*/
	}

}
