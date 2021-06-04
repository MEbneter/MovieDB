package controller;

import java.util.ArrayList;

import javax.swing.DefaultListModel;

import model.Film;
import model.FilmList;
import model.Person;
import view.MovieView;

public class MovieController {

	private FilmList modelz= new FilmList();
	private ArrayList<Person> leute;
	private Film terror;
	private MovieView view;
	
	
	public static void main(String[] args) {
		MovieController myController = new MovieController();
		myController.testDaten();
		myController.printDaten(0);
		myController.setLists();
		myController.run();
		// irgend ne run funktion gehört hier noch hin fürs GUI wenns dann mal existiert
	}
	
	public MovieController (){
		view = new MovieView();
	}
	
	public void run () {
		this.view.setVisible(true);
	}
	
	public void setLists () {
		DefaultListModel movieListModel = new DefaultListModel<>();
		movieListModel.addElement(this.modelz.getElementAt(0).getTitel());
		view.movieList.setModel(movieListModel);
		DefaultListModel personListModel = new DefaultListModel<>();
		for (Person dude : leute) {
			String theDude = dude.getNName() + " " + dude.getNName() + " / " + dude.getAufgabe();
			personListModel.addElement(theDude);
		}
		view.personList.setModel(personListModel); 
		// going to be loaded on MovieListSelection via the MouseListner Interface in the Future	
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
