package test;

import static org.junit.Assert.*;

import org.junit.Test;

import model.Person;
/**
 * Test zur Klasse Person
 * @author manue
 *
 */
public class TestPerson {
	/**
	 * Test zu getter Vorname
	 */
	@Test
	public void testGetVName() {
		Person ueli= new Person("ueli","jung", true);
		assertEquals("ueli", ueli.getVName());
	}
	/**
	 * Test zu getter Nachname
	 */
	@Test
	public void testGetNName() {
		Person ueli= new Person("ueli","jung", true);
		assertEquals("jung", ueli.getNName());
	}
	/**
	 * Test zu getter Aufgabe
	 */
	@Test
	public void testGetAufgabe() {
		Person ueli= new Person("ueli","jung", true);
		assertEquals("Schauspieler" , ueli.getAufgabe());
		}

}
