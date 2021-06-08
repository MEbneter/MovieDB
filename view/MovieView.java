package view;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.Film;
import model.Person;

import javax.swing.JList;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.GridLayout;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.border.LineBorder;
import java.awt.Color;
/**
 * 
 * @author manue
 *
 */
public class MovieView extends JFrame {
	private JList<Film> movieList;
	private JList<Person> personList;
	private JButton btnAddPerson;
	private JLabel lblErscheinungsjahr;
	private JLabel lblTitel;
	private JButton btnAddMovie;
	private JLabel lblGenre;
	private JComboBox cbFilterGenre;
	private JComboBox cbFilterAufgabe;

	/**
	 * Create the frame. Hauptfenster
	 */
	public MovieView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 640, 480);
		JPanel mainPanel = new JPanel();
		mainPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(mainPanel);
		mainPanel.setLayout(new GridLayout(0, 2, 0, 0));
		
		JPanel leftPanel = new JPanel();
		mainPanel.add(leftPanel);
		leftPanel.setLayout(new BorderLayout(0, 0));
		
		movieList = new JList<Film>();
		movieList.setBorder(new LineBorder(Color.LIGHT_GRAY));
		leftPanel.add(movieList);
		
		JPanel btnPanel = new JPanel();
		leftPanel.add(btnPanel, BorderLayout.NORTH);
		btnPanel.setLayout(new GridLayout(0, 1, 0, 0));
		
		btnAddPerson = new JButton("add person");
		btnAddPerson.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnPanel.add(btnAddPerson);
		
		btnAddMovie = new JButton("add movie");
		btnAddMovie.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnAddMovie.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnPanel.add(btnAddMovie);
		
		JLabel lblFilterByGenre = new JLabel("Filter by Genre:");
		btnPanel.add(lblFilterByGenre);
		
		String[] genres = {"All" ,"Action", "Comedy", "Romance", "SiFi", "Fantasy"};
		cbFilterGenre = new JComboBox(genres);
		btnPanel.add(cbFilterGenre);
		
		JPanel rightPanel = new JPanel();
		mainPanel.add(rightPanel);
		rightPanel.setLayout(new BorderLayout(0, 0));
		
		personList = new JList<Person>();
		personList.setBorder(new LineBorder(Color.LIGHT_GRAY));
		rightPanel.add(personList, BorderLayout.CENTER);
		
		JPanel detailPanel = new JPanel();
		rightPanel.add(detailPanel, BorderLayout.NORTH);
		detailPanel.setLayout(new GridLayout(5, 1, 0, 0));
		
		lblTitel = new JLabel("Titel: ");
		detailPanel.add(lblTitel);
		
		lblErscheinungsjahr = new JLabel("Erscheinungsjahr: ");
		detailPanel.add(lblErscheinungsjahr);
		
		lblGenre = new JLabel("Genre: ");
		detailPanel.add(lblGenre);
		
		JLabel lblFilterByAufgabe = new JLabel("Filter by Aufgabe:");
		detailPanel.add(lblFilterByAufgabe);
		
		String[] aufgaben = {"All", "Schauspieler", "Regisseur"};
		cbFilterAufgabe = new JComboBox(aufgaben);
		detailPanel.add(cbFilterAufgabe);
	}
	/**
	 * getter
	 */
	/**
	 * combo box FilterGenre
	 * @returns für Object ComboBox , Object Selected Item, int Selected Index
	 */
	public Object getCbFilterGenre () {
		return cbFilterGenre;
	}
	public Object getFilterGenreItem () {
		return cbFilterGenre.getSelectedItem();
	}
	public int getFilterGenreIndex () {
		return cbFilterGenre.getSelectedIndex();
	}
	/**
	 * combo box FilterAufgabe
	 * @returns für Object ComboBox , Object Selected Item, int selected Index
	 */
	public Object getCbFilterAufgabe () {
		return cbFilterAufgabe;
	}
	public Object getFilterAufgabeItem () {
		return cbFilterAufgabe.getSelectedItem();
	}
	public int getFilterAufgabeIndex () {
		return cbFilterAufgabe.getSelectedIndex();
	}
	/**
	 * Button Add Person
	 * @return Object JButton
	 */
	public Object getButtonAddPerson () {
		return btnAddPerson;
	}
	/**
	 * Button Add Movie
	 * @return Object JButton
	 */
	public Object getButtonAddMovie () {
		return btnAddMovie;
	}
	/**
	 *  JList Movie Liste
	 * @return Object JList, int selected Index
	 */
	public Object getMovieList () {
		return movieList;
	}
	public Object getMovieListItem() {
		return movieList.getSelectedValue();
	}
	/**
	 * setter
	 */
	/**
	 * Action Listner für FilterGenre hinzufügen
	 * @param action : ActionListner
	 */
	public void setActionFilterGenre(ActionListener action) {
		this.cbFilterGenre.addActionListener(action);
	}
	/**
	 * Action Listner für FilterAufgabe hinzufügen
	 * @param action : ActionListner
	 */
	public void setActionFilterAufgabe(ActionListener action) {
		this.cbFilterAufgabe.addActionListener(action);
	}
	/**
	 * Action Listner für add Person hinzufügen
	 * @param action : ActionListner
	 */
	public void setActionAddPerson(ActionListener action) {
		this.btnAddPerson.addActionListener(action);
	}
	/**
	 * Action Listner für add Movie hinzufügen
	 * @param action : ActionListner
	 */
	public void setActionAddMovie(ActionListener action) {
		this.btnAddMovie.addActionListener(action);
	}
	/**
	 * Action Listner für Movie List hinzufügen und Model der Liste setzen.
	 * @param's action : MouseListener , list : DefaultListModel,
	 */
	public void setActionMovieList(MouseListener action) {
		this.movieList.addMouseListener(action);
	}
	public void setMovieListModel (DefaultListModel list) {
		movieList.setModel(list);
	}
	/**
	 * Model der Person List setzen.
	 * @param list : DefaultListModel
	 */
	public void setPersonListModel (DefaultListModel list) {
		personList.setModel(list);
	}
	/**
	 * Movie-Titel setzen
	 * @param str : String
	 */
	public void setTextTitel (String str) {
		lblTitel.setText("Titel: "+str);
	}
	/**
	 * Movie-Genre setzen
	 * @param str : String
	 */
	public void setTextGenre (String str) {
		lblGenre.setText("Genre: "+str);
	}
	/**
	 * Movie-Erscheinungsjahr setzen
	 * @param i : String
	 */
	public void setTextErscheinungsjahr (int i) {
		lblErscheinungsjahr.setText("Erscheinungsjahr: "+i);
	}
}
