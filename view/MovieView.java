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

	private JPanel contentPane;
	public JList<FilmList> movieList;
	public JList<Person> personList;
	public JButton btnAddPerson;
	private JPanel panel_3;
	public JLabel lblErscheinungsjahr;
	public JLabel lblTitel;
	public JButton btnAddMovie;
	public JLabel lblGenre;
	private JLabel lblNewLabel;
	public JComboBox cbFilterGenre;
	private JLabel lblFilterByAufgabe;
	public JComboBox cbFilterAufgabe;


	/**
	 * Create the frame.
	 */
	public MovieView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 640, 480);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 2, 0, 0));
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		movieList = new JList<FilmList>();
		movieList.setBorder(new LineBorder(Color.LIGHT_GRAY));
		panel_1.add(movieList);
		
		panel_3 = new JPanel();
		panel_1.add(panel_3, BorderLayout.NORTH);
		panel_3.setLayout(new GridLayout(0, 1, 0, 0));
		
		btnAddPerson = new JButton("add person");
		btnAddPerson.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel_3.add(btnAddPerson);
		
		btnAddMovie = new JButton("add movie");
		btnAddMovie.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnAddMovie.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel_3.add(btnAddMovie);
		
		lblNewLabel = new JLabel("Filter by Genre:");
		panel_3.add(lblNewLabel);
		
		String[] genres = {"All" ,"Action", "Comedy", "Romance", "SiFi", "Fantasy"};
		cbFilterGenre = new JComboBox(genres);
		panel_3.add(cbFilterGenre);
		
		JPanel panel_2 = new JPanel();
		contentPane.add(panel_2);
		panel_2.setLayout(new BorderLayout(0, 0));
		
		personList = new JList<Person>();
		personList.setBorder(new LineBorder(Color.LIGHT_GRAY));
		panel_2.add(personList, BorderLayout.CENTER);
		
		JPanel panel = new JPanel();
		panel_2.add(panel, BorderLayout.NORTH);
		panel.setLayout(new GridLayout(5, 1, 0, 0));
		
		lblTitel = new JLabel("Titel: ");
		panel.add(lblTitel);
		
		lblErscheinungsjahr = new JLabel("Erscheinungsjahr: ");
		panel.add(lblErscheinungsjahr);
		
		lblGenre = new JLabel("Genre: ");
		panel.add(lblGenre);
		
		lblFilterByAufgabe = new JLabel("Filter by Aufgabe:");
		panel.add(lblFilterByAufgabe);
		
		String[] aufgaben = {"All", "Schauspieler", "Regisseur"};
		cbFilterAufgabe = new JComboBox(aufgaben);
		panel.add(cbFilterAufgabe);
	}

}
