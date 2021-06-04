package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.FilmList;
import model.Person;

import javax.swing.JList;
import javax.swing.JButton;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;

import java.awt.CardLayout;
import java.awt.GridLayout;
import javax.swing.JLabel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.FlowLayout;

public class MovieView extends JFrame {

	private JPanel contentPane;
	public JList<FilmList> movieList;
	private JLabel lblTitel;
	private JLabel lblErscheinungsjahr;
	private JLabel lblGenre;
	public JList<Person> personList;


	/**
	 * Create the frame.
	 */
	public MovieView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 2, 0, 0));
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		movieList = new JList<FilmList>();
		panel_1.add(movieList);
		
		JPanel panel = new JPanel();
		panel_1.add(panel, BorderLayout.NORTH);
		panel.setLayout(new GridLayout(3, 1, 0, 0));
		
		lblTitel = new JLabel("Titel: ");
		panel.add(lblTitel);
		
		lblErscheinungsjahr = new JLabel("Erscheinungsjahr: ");
		panel.add(lblErscheinungsjahr);
		
		lblGenre = new JLabel("Genre: ");
		panel.add(lblGenre);
		
		JPanel panel_2 = new JPanel();
		contentPane.add(panel_2);
		panel_2.setLayout(new BorderLayout(0, 0));
		
		JButton btnAddMovie = new JButton("add movie");
		panel_2.add(btnAddMovie, BorderLayout.NORTH);
		
		personList = new JList<Person>();
		panel_2.add(personList);
	}

}
