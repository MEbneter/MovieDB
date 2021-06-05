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
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

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
		
		panel_3 = new JPanel();
		panel_2.add(panel_3, BorderLayout.NORTH);
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
		
		personList = new JList<Person>();
		panel_2.add(personList, BorderLayout.CENTER);
	}

}
