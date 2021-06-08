package test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import model.Film;
import model.Person;
/**
 * Test für die Klasse Film
 * @author manue
 *
 */
public class TestFilm {
	/**
	 * Test getter Titel
	 */
	@Test
	public void testGetTitel() {
		ArrayList<Person> leute = new ArrayList<Person>();
		leute.add(new Person("Jeff","Fahey", true));
		leute.add(new Person("Bruce","Willis", true));
		leute.add(new Person("Josh","Brolin", true));
		Film planetTerror = new Film("Planet Terror", "Action", 2007);
		planetTerror.addLeute(leute);
		assertEquals("Planet Terror", planetTerror.getTitel());
	}
	/**
	 * test getter Genre
	 */
	@Test
	public void testGetGenre() {
		ArrayList<Person> leute = new ArrayList<Person>();
		leute.add(new Person("Jeff","Fahey", true));
		leute.add(new Person("Bruce","Willis", true));
		leute.add(new Person("Josh","Brolin", true));
		Film planetTerror = new Film("Planet Terror", "Action", 2007);
		planetTerror.addLeute(leute);
		assertEquals("Action", planetTerror.getGenre());
	}
	/**
	 * test getter Leute
	 */
	@Test
	public void testGetLeute() {
		ArrayList<Person> leute = new ArrayList<Person>();
		leute.add(new Person("Jeff","Fahey", true));
		leute.add(new Person("Bruce","Willis", true));
		leute.add(new Person("Josh","Brolin", true));
		Film planetTerror = new Film("Planet Terror", "Action", 2007);
		planetTerror.addLeute(leute);
		assertEquals(leute, planetTerror.getLeute());
	}
	/**
	 * test getter Erscheinungsjahr
	 */
	@Test
	public void testGetErscheinungsjahr() {
		ArrayList<Person> leute = new ArrayList<Person>();
		leute.add(new Person("Jeff","Fahey", true));
		leute.add(new Person("Bruce","Willis", true));
		leute.add(new Person("Josh","Brolin", true));
		Film planetTerror = new Film("Planet Terror", "Action", 2007);
		planetTerror.addLeute(leute);
		assertEquals(2007, planetTerror.getErscheinungsjahr());
	}
	/**
	 * test getter Person
	 */
	@Test
	public void testGetPerson() {
		ArrayList<Person> leute = new ArrayList<Person>();
		leute.add(new Person("Jeff","Fahey", true));
		leute.add(new Person("Bruce","Willis", true));
		leute.add(new Person("Josh","Brolin", true));
		Film planetTerror = new Film("Planet Terror", "Action", 2007);
		planetTerror.addLeute(leute);
		Person rod = new Person("Robert","Rodriguez", false);
		planetTerror.addPerson(rod);
		assertEquals(rod, planetTerror.getPerson(3));
	}
}
