package view;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.FilmList;
import model.Person;

import javax.swing.JList;
import javax.swing.JButton;
import java.awt.GridLayout;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.border.CompoundBorder;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;
import java.awt.Color;

public class MovieView extends JFrame {
	public JList<FilmList> movieList;
	public JList<Person> personList;
	public JButton btnAddPerson;
	public JLabel lblErscheinungsjahr;
	public JLabel lblTitel;
	public JButton btnAddMovie;
	public JLabel lblGenre;
	public JComboBox cbFilterGenre;
	public JComboBox cbFilterAufgabe;


	/**
	 * Create the frame.
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
		
		movieList = new JList<FilmList>();
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

}
