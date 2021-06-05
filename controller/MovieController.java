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
		movieListModel.addElement(this.modelz.getElementAt(0).getTitel());
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
			 * Fenster addMovie �ffnen
			 */
			if (button == view.btnAddMovie) {
				newMovie.setVisible(true);
			}
			/**
			 * Fenster addPerson �ffnen
			 */
			else if (button == view.btnAddPerson) {
				try {
					newPerson.setTitle(modelz.getElementAt(view.movieList.getSelectedIndex()).getTitel());
					newPerson.setVisible(true);
				} catch (Exception e) {
					JOptionPane.showMessageDialog(view, "Bitte Film zum hinzuf�gen einer Person ausw�hlen.");
				}
			}
			/**
			 * person dem Film hinzuf�gen
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
					JOptionPane.showMessageDialog(view, "Bitte alle Felder ausf�llen.");
				}
			}
			/**
			 * Movie der Liste hinzuf�gen hoffentlich bald
			 */
			else if (button == newMovie.btnMovieHinzu) {
				newMovie.setVisible(false);
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
				for (Person dude : selectedMovie.getLeute()) {
					String theDude = dude.getVName() + " " + dude.getNName() + " / " + dude.getAufgabe();
					personListModel.addElement(theDude);
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
