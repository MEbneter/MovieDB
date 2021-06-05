package test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;
import model.Film;
import model.FilmList;
import model.Person;

public class TestFilmList {

	@Test
	public void testGetElementAt() {
		FilmList liste = new FilmList();
		ArrayList<Person> leute = new ArrayList<Person>();
		leute.add(new Person("Jeff","Fahey", true));
		leute.add(new Person("Bruce","Willis", true));
		leute.add(new Person("Josh","Brolin", true));
		Film[] terror = new Film[3];
		for (int i = 0; i < terror.length; i++) {
			terror[i] = new Film("Planet Terror"+i, "Action", 2007);
			terror[i].addLeute(leute);
			liste.addFilm(terror[i]);
		}
		assertEquals(terror[2], liste.getElementAt(2));
	}
	
	@Test
	public void testGetSize() {
		FilmList liste = new FilmList();
		ArrayList<Person> leute = new ArrayList<Person>();
		leute.add(new Person("Jeff","Fahey", true));
		leute.add(new Person("Bruce","Willis", true));
		leute.add(new Person("Josh","Brolin", true));
		Film terror = new Film("Planet Terror", "Action", 2007);
		terror.addLeute(leute);
		liste.addFilm(terror);
		assertEquals(1, liste.getSize());
	}

}
