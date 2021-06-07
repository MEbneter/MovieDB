package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

import model.Film;
import model.Person;
import view.MovieView;
import view.NewMovieWindow;
import view.NewPersonWindow;

public class MovieController {

	private ArrayList<Film> filmList = new ArrayList<Film>();
	private MovieView view;
	private MyActions btnAction;
	private MyMouseAction mouseAction;
	private NewMovieWindow newMovie;
	private NewPersonWindow newPerson;
	private Film selectedMovie;
	/**
	 * main
	 * @param args
	 */
	public static void main(String[] args) {
		MovieController myController = new MovieController();
		myController.run();
	}
	/**
	 * konstruktor
	 */
	public MovieController (){
		this.view = new MovieView();
		this.newMovie = new NewMovieWindow(this.view);
		this.newPerson = new NewPersonWindow(this.view);
		this.btnAction = new MyActions();
		this.mouseAction = new MyMouseAction();
		this.filmList = readMovieList();
		for (Film film : filmList) {
			System.out.println("Titel: " + film.getTitel());
			System.out.println("Genre: " + film.getGenre());
			System.out.println("Jahr: " + film.getErscheinungsjahr());
		}
	}
	/**
	 * set up fürs Programm
	 */
	public void run () {
		// testDaten();
		setMovieList();
		// newMovie addActionListner
		this.newMovie.setActionHinzuButton(btnAction);
		// newPerson addActionListner
		this.newPerson.setActionHinzuButton(btnAction);
		// view mit addActionListner
		this.view.setActionFilterGenre(btnAction);
		this.view.setActionFilterAufgabe(btnAction);
		this.view.setActionAddPerson(btnAction);
		this.view.setActionAddMovie(btnAction);
		this.view.setActionMovieList(mouseAction);
		this.view.setVisible(true);
	}
	
	/*
	 * set up fürs GUI movieListe
	 */
	public void setMovieList () {
		DefaultListModel movieListModel = new DefaultListModel<>();		
		for (Film film : this.filmList) {
			movieListModel.addElement(film.getTitel());
		}		
		this.view.setMovieListModel(movieListModel);
	}
	/**
	 * Testdaten 
	 */
	public void testDaten () {
		Film[] terror = new Film[8];
		for (int i = 0; i < terror.length; i++) {
			ArrayList<Person> leute = new ArrayList<Person>();
			leute.add(new Person("Jeff"+ i,"Fahey", true));
			leute.add(new Person("Bruce"+ i,"Willis", true));
			leute.add(new Person("Josh"+ i,"Brolin", true));
			leute.add(new Person("Robert"+ i,"Rodriguez", false));
			terror[i] = new Film("Planet Terror"+i, "Action", 2007);
			terror[i].addLeute(leute);
			filmList.add(terror[i]);
		}
	}
	
	public ArrayList<Film> getFilmList () {
		return filmList;
	}
	
	public Film getSelectedMovie (Object selectedFilm) {
		for (Film film : this.filmList) {
			if ((String)selectedFilm == film.getTitel()) {
				this.selectedMovie = film;
			}
		}
		return this.selectedMovie;
	}
	
	public int getSelectedMovieIndex (Object selectedFilm) {
		int index = 0;
		for (int i = 0; i < filmList.size(); i++) {
			Film film = filmList.get(i);
			if ((String)selectedFilm == film.getTitel()) {
				index = i;
				break;
			}
		}
		return index;
	}
	/**
	 *  ka, läuft nicht mit dem serialisieren
	 */
	
	public static void saveMovieList (ArrayList<Film> filmListe) {
		String filename = "movieList.ser";
		// Serialization des Objekts filmList
		try
		{
			//objekte für fileoutput und object output
			FileOutputStream file = new FileOutputStream(filename);
			ObjectOutputStream out = new ObjectOutputStream(file);
			
			// Hier sollts ins file schreiben
			//out.writeObject(filmList.getFilme());
			//out.writeObject(filmList);
			for (Film f : filmListe){
				out.writeObject(f);
			}
			out.close();
			file.close();		
			System.out.println("Object wurde serializsiert");
		}
		
		catch(IOException ex)
		{
			ex.printStackTrace();
			System.out.println("IOException ist aufgetretten");
		}
	}
	
	public static ArrayList<Film> readMovieList () {
		ArrayList<Film> tMovieList = new ArrayList<Film>();
		try {
			String filename = "movieList.ser";
			// objekte für fileinput und objektinput
			FileInputStream file = new FileInputStream(filename);
			ObjectInputStream in = new ObjectInputStream(file);
			// inhalt der file der FilmList hinzufügen
			Film film = null;	
			while ((film = (Film) in.readObject()) != null) {
				tMovieList.add(film);
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("IOException ist aufgetretten");
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("ClassNotFoundException ist aufgetretten");
			e.printStackTrace();
		}
		return tMovieList;
	}
	
	
	public class MyActions implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent hui) {
			// TODO Auto-generated method stub
			Object button = hui.getSource();
			/**
			 * Fenster addMovie öffnen
			 */
			if (button == view.getButtonAddMovie()) {
				newMovie.setVisible(true);
			}
			/**
			 * Fenster addPerson öffnen
			 */
			else if (button == view.getButtonAddPerson()) {
				try {
					newPerson.setTitle(getSelectedMovie(view.getMovieListItem()).getTitel());
					newPerson.setVisible(true);
				} catch (Exception e) {
					JOptionPane.showMessageDialog(view, "Bitte Film zum hinzufügen einer Person auswählen.");
				}
			}
			/**
			 * person dem Film hinzufügen
			 */
			else if (button == newPerson.getButtonPersonHinzu()) {
				String vName= newPerson.getVname();
				String nName= newPerson.getNname();
				boolean aufgabe = true;
				
				if (newPerson.isRegisseur()) {
					aufgabe = false;
				}
				if (vName.length() > 0 && nName.length() > 0) {
				Person newDude = new Person(vName, nName, aufgabe);
				filmList.get(getSelectedMovieIndex(view.getMovieListItem())).addPerson(newDude);
				saveMovieList(filmList);
				newPerson.setVisible(false);
				} else {
					JOptionPane.showMessageDialog(view, "Bitte alle Felder ausfüllen.");
				}
			}
			/**
			 * Movie der Liste hinzufügen
			 */
			else if (button == newMovie.getButtonMovieHinzu()) {	
				String name = newMovie.getName();			
				String jahr = newMovie.getJahr();
				String genre = (String)newMovie.getGenre();
				
				if (name.length() > 0 && jahr.length() == 4) {
					DefaultListModel movieListModel = new DefaultListModel<>();
						try {	
							filmList.add(new Film(name, genre, Integer.parseInt(jahr)));
							newMovie.setVisible(false);
							for (Film film : filmList) {
								movieListModel.addElement(film.getTitel());
							}
							view.setMovieListModel(movieListModel);
							saveMovieList(filmList);
						} catch (Exception e) {
						// TODO: handle exception
							JOptionPane.showMessageDialog(view, "Das Jahr muss aus 4 Zahlen bestehen.");
						}
					
				} else {
						JOptionPane.showMessageDialog(view, "Bitte eingabe überprüfen.");
				}
			}
			/**
			 * Filter für Genre
			 */
			else if (button == view.getCbFilterGenre()) {
				DefaultListModel movieListModel = new DefaultListModel<>();
				try {	
					for (Film film : filmList) {		
							if (film.getGenre() == view.getFilterGenreItem()) {
								movieListModel.addElement(film.getTitel());
							} else if (view.getFilterGenreIndex() == 0) {
								movieListModel.addElement(film.getTitel());
							}
						}
				} catch (Exception e) {
					// TODO: handle exception
				movieListModel.removeAllElements();
				}
				view.setMovieListModel(movieListModel);
					
			}
			/**
			 * Filter für Aufgabe
			 */
			else if (button == view.getCbFilterAufgabe()) {
				
				DefaultListModel personListModel = new DefaultListModel<>();
				try {
					for (Person dude : selectedMovie.getLeute()) {
						String theDude = dude.getVName() + " " + dude.getNName() + " / " + dude.getAufgabe();
								
						if (dude.getAufgabe() == view.getFilterAufgabeItem()) {
							personListModel.addElement(theDude);
						} else if (view.getFilterAufgabeIndex() == 0) {
							personListModel.addElement(theDude);
						}
						
					}
				} catch (Exception e) {
					// TODO: handle exception
					personListModel.removeAllElements();
				}
				view.setPersonListModel(personListModel);
			}
		}
	}
	
	public class MyMouseAction implements MouseListener {

		@Override
		public void mouseClicked(MouseEvent hey) {
			// TODO Auto-generated method stub
			Object liste = hey.getSource();
			/**
			 * Selektierung eines Movie's in der MovieListe
			 * Personen vom Movie werden in die PersonenListe geladen
			 */
			if (liste == view.getMovieList()) {
				selectedMovie = getSelectedMovie(view.getMovieListItem());
				
				DefaultListModel personListModel = new DefaultListModel<>();
				try {
					for (Person dude : selectedMovie.getLeute()) {
						String theDude = dude.getVName() + " " + dude.getNName() + " / " + dude.getAufgabe();
						personListModel.addElement(theDude);
					}
				} catch (Exception e) {
					// TODO: handle exception
					personListModel.removeAllElements();
				}
				view.setTextTitel(selectedMovie.getTitel());
				view.setTextGenre(selectedMovie.getGenre());
				view.setTextErscheinungsjahr(selectedMovie.getErscheinungsjahr());
				view.setPersonListModel(personListModel);
			}
		}

		@Override
		public void mouseEntered(MouseEvent hey) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent hey) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mousePressed(MouseEvent hey) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent hey) {
			// TODO Auto-generated method stub
			
		}
		
	}
}
