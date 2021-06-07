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
	private int movieIndex;
	
	/**
	 * main
	 * @param args
	 */
	public static void main(String[] args) {
		MovieController myController = new MovieController();
		myController.testDaten();
		myController.setMovieList();
		myController.run();
	}
	/**
	 * konstruktor
	 */
	public MovieController (){
		view = new MovieView();
		newMovie = new NewMovieWindow(this.view);
		newPerson = new NewPersonWindow(this.view);
		btnAction = new MyActions();
		mouseAction = new MyMouseAction();
	}
	/**
	 * set up fürs GUI
	 */
	public void run () {
		// newMovie addActionListner
		this.newMovie.btnMovieHinzu.addActionListener(btnAction);
		// newPerson addActionListner
		this.newPerson.btnPersonHinzu.addActionListener(btnAction);
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
		view.setMovieListModel(movieListModel);
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
	/**
	 *  ka, läuft nicht mit dem serialisieren
	 */
	/*
	public static void saveMovieList (FilmList filmListe) {
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
			for (Film f : filmList.getFilme()){
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
	
	public static void readMovieList () {
		try {
			String filename = "movieList.ser";
			// objekte für fileinput und objektinput
			FileInputStream file = new FileInputStream(filename);
			ObjectInputStream in = new ObjectInputStream(file);
			// inhalt der file der FilmList hinzufügen
			Film film = null;	
			filmList = in.readObject();		
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("IOException ist aufgetretten");
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("ClassNotFoundException ist aufgetretten");
			e.printStackTrace();
		}		
	}
	*/
	
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
					newPerson.setTitle(filmList.get(view.getMovieListIndex()).getTitel());
					newPerson.setVisible(true);
				} catch (Exception e) {
					JOptionPane.showMessageDialog(view, "Bitte Film zum hinzufügen einer Person auswählen.");
				}
			}
			/**
			 * person dem Film hinzufügen
			 */
			else if (button == newPerson.btnPersonHinzu) {
				String vName= newPerson.txtVname.getText();
				String nName= newPerson.txtNname.getText();
				Boolean aufgabe = true;
				
				if (newPerson.rdbtnRegisseur.isSelected()) {
					aufgabe = false;
				}
				if (vName.length() > 0 && nName.length() > 0) {
				Person newDude = new Person(vName, nName, aufgabe);
				filmList.get(movieIndex).addPerson(newDude);
				newPerson.setVisible(false);
				} else {
					JOptionPane.showMessageDialog(view, "Bitte alle Felder ausfüllen.");
				}
			}
			/**
			 * Movie der Liste hinzufügen
			 */
			else if (button == newMovie.btnMovieHinzu) {	
				String name = newMovie.txtName.getText();			
				String jahr = newMovie.txtJahr.getText();
				String genre = (String)newMovie.cbGenre.getSelectedItem();
				
				if (name.length() > 0 && jahr.length() == 4) {
					DefaultListModel movieListModel = new DefaultListModel<>();
						try {	
							filmList.add(new Film(name, genre, Integer.parseInt(jahr)));
							newMovie.setVisible(false);
							for (Film film : filmList) {
								movieListModel.addElement(film.getTitel());
							}
							view.setMovieListModel(movieListModel);
							// saveMovieList(filmList);
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
				movieIndex = view.getMovieListIndex();
				selectedMovie = filmList.get(movieIndex);
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
