package controller;

import java.util.ArrayList;

import model.Film;
import model.FilmList;
import model.Person;

public class MovieController {

	private FilmList modelz= new FilmList();
	private ArrayList<Person> leute;
	private Film terror;

	public static void main(String[] args) {
		MovieController myController = new MovieController();
		myController.testDaten();
		myController.printDaten(0);
		// irgend ne run funktion gehört hier noch hin fürs GUI wenns dann mal existiert
	}
	
	public void testDaten () {
		leute = new ArrayList<Person>();
		leute.add(new Person("Jeff","Fahey", true));
		leute.add(new Person("Bruce","Willis", true));
		leute.add(new Person("Josh","Brolin", true));
		terror = new Film("Planet Terror", "Action", leute, 2007);
		modelz.addFilm(terror);
	}
	
	public void printDaten (int index) {
		Film showMe = modelz.getElementAt(index);
		System.out.println("filmTitel:");
		System.out.println(showMe.getTitel());
		System.out.println("genre:");
		System.out.println(showMe.getGenre());
		System.out.println("erscheinungsjahr:");
		System.out.println(showMe.getErscheinungsjahr());
		System.out.println("Mitwirkende Personen:");
		for (Person folks : showMe.getLeute()) {
			System.out.println(folks.getVName() + " " + folks.getNName());
		}
	}
}
