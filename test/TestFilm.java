package test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import model.Film;
import model.Person;

public class TestFilm {

	@Test
	public void testGetTitel() {
		ArrayList<Person> leute = new ArrayList<Person>();
		leute.add(new Person("Jeff","Fahey", true));
		leute.add(new Person("Bruce","Willis", true));
		leute.add(new Person("Josh","Brolin", true));
		Film planetTerror = new Film("Planet Terror", "Action", leute, 2007);
		assertEquals("Planet Terror", planetTerror.getTitel());
	}
	
	@Test
	public void testGetGenre() {
		ArrayList<Person> leute = new ArrayList<Person>();
		leute.add(new Person("Jeff","Fahey", true));
		leute.add(new Person("Bruce","Willis", true));
		leute.add(new Person("Josh","Brolin", true));
		Film planetTerror = new Film("Planet Terror", "Action", leute, 2007);
		assertEquals("Action", planetTerror.getGenre());
	}
	
	@Test
	public void testGetLeute() {
		ArrayList<Person> leute = new ArrayList<Person>();
		leute.add(new Person("Jeff","Fahey", true));
		leute.add(new Person("Bruce","Willis", true));
		leute.add(new Person("Josh","Brolin", true));
		Film planetTerror = new Film("Planet Terror", "Action", leute, 2007);
		assertEquals(leute, planetTerror.getLeute());
		// assertArrayEquals(leute[i],planetTerror.getLeute()[i]);
	}
	
	@Test
	public void testGetErscheinungsjahr() {
		ArrayList<Person> leute = new ArrayList<Person>();
		leute.add(new Person("Jeff","Fahey", true));
		leute.add(new Person("Bruce","Willis", true));
		leute.add(new Person("Josh","Brolin", true));
		Film planetTerror = new Film("Planet Terror", "Action", leute, 2007);
		assertEquals(2007, planetTerror.getErscheinungsjahr());
	}
	
	@Test
	public void testGetSizeLeute() {
		ArrayList<Person> leute = new ArrayList<Person>();
		leute.add(new Person("Jeff","Fahey", true));
		leute.add(new Person("Bruce","Willis", true));
		leute.add(new Person("Josh","Brolin", true));
		Film planetTerror = new Film("Planet Terror", "Action", leute, 2007);
		assertEquals(3, planetTerror.getSizeLeute());
	}
	
	
	@Test
	public void testGetPerson() {
		ArrayList<Person> leute = new ArrayList<Person>();
		leute.add(new Person("Jeff","Fahey", true));
		leute.add(new Person("Bruce","Willis", true));
		leute.add(new Person("Josh","Brolin", true));
		Film planetTerror = new Film("Planet Terror", "Action", leute, 2007);
		Person rod = new Person("Robert","Rodriguez", false);
		planetTerror.addPerson(rod);
		assertEquals(rod, planetTerror.getPerson(3));
	}
}
