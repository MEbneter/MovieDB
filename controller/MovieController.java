package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

import model.Film;
import model.FilmList;
import model.Person;
import view.MovieView;
import view.NewMovieWindow;
import view.NewPersonWindow;

public class MovieController {

	private FilmList modelz= new FilmList();
	private ArrayList<Person> leute;
	private Film terror;
	private MovieView view;
	private MyActions btnAction;
	private MyMouseAction mouseAction;
	private NewMovieWindow newMovie;
	private NewPersonWindow newPerson;
	private Film selectedMovie;
	private int movieIndex;
	
	
	public static void main(String[] args) {
		MovieController myController = new MovieController();
		myController.testDaten();
		myController.setMovieList();
		myController.run();
	}
	
	public MovieController (){
		view = new MovieView();
		newMovie = new NewMovieWindow(this.view);
		newPerson = new NewPersonWindow(this.view);
		btnAction = new MyActions();
		mouseAction = new MyMouseAction();
	}
	
	public void run () {
		// newMovie addActionListner
		this.newMovie.btnMovieHinzu.addActionListener(btnAction);
		// newPerson addActionListner
		this.newPerson.btnPersonHinzu.addActionListener(btnAction);
		// view mit addActionListner
		this.view.btnAddPerson.addActionListener(btnAction);
		this.view.btnAddMovie.addActionListener(btnAction);
		this.view.movieList.addMouseListener(mouseAction);
		this.view.setVisible(true);
	}
	
	public void setMovieList () {
		DefaultListModel movieListModel = new DefaultListModel<>();
		
		for (Film film : this.modelz.getFilme()) {
			movieListModel.addElement(film.getTitel());
		}
		
		view.movieList.setModel(movieListModel);
	}
	
	public void testDaten () {
		leute = new ArrayList<Person>();
		leute.add(new Person("Jeff","Fahey", true));
		leute.add(new Person("Bruce","Willis", true));
		leute.add(new Person("Josh","Brolin", true));
		terror = new Film("Planet Terror", "Action", 2007);
		terror.addLeute(leute);
		modelz.addFilm(terror);
	}
	
	public class MyActions implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent hui) {
			// TODO Auto-generated method stub
			Object button = hui.getSource();
			/**
			 * Fenster addMovie öffnen
			 */
			if (button == view.btnAddMovie) {
				newMovie.setVisible(true);
			}
			/**
			 * Fenster addPerson öffnen
			 */
			else if (button == view.btnAddPerson) {
				try {
					newPerson.setTitle(modelz.getElementAt(view.movieList.getSelectedIndex()).getTitel());
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
				modelz.getElementAt(movieIndex).addPerson(newDude);
				newPerson.setVisible(false);
				} else {
					JOptionPane.showMessageDialog(view, "Bitte alle Felder ausfüllen.");
				}
			}
			/**
			 * Movie der Liste hinzufügen hoffentlich bald
			 */
			else if (button == newMovie.btnMovieHinzu) {	
				
				String name = newMovie.txtName.getText();			
				String jahr = newMovie.txtJahr.getText();
				String genre = (String)newMovie.cbGenre.getSelectedItem();
				
				if (name.length() > 0 && jahr.length() == 4) {
					DefaultListModel movieListModel = new DefaultListModel<>();
						try {	
							modelz.addFilm(new Film(name, genre, Integer.parseInt(jahr)));
							newMovie.setVisible(false);
							for (Film film : modelz.getFilme()) {
								movieListModel.addElement(film.getTitel());
							}
							view.movieList.setModel(movieListModel);
						} catch (Exception e) {
						// TODO: handle exception
							JOptionPane.showMessageDialog(view, "Das Jahr muss aus 4 Zahlen bestehen.");
						}
					
				} else {
						JOptionPane.showMessageDialog(view, "Bitte eingabe überprüfen.");
				}
			}
		}
	}
	
	public class MyMouseAction implements MouseListener {

		@Override
		public void mouseClicked(MouseEvent hey) {
			// TODO Auto-generated method stub
			Object liste = hey.getSource();
			if (liste == view.movieList) {
				movieIndex = view.movieList.getSelectedIndex();
				selectedMovie = modelz.getElementAt(movieIndex);
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
				view.personList.setModel(personListModel);
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
