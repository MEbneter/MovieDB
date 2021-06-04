package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JList;
import javax.swing.JButton;
import javax.swing.BoxLayout;
import java.awt.CardLayout;
import java.awt.GridLayout;
import javax.swing.JLabel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.FlowLayout;

public class MovieView extends JFrame {

	private JPanel contentPane;
	private JButton btnAddMovie;


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
		
		JList movieList = new JList();
		panel_1.add(movieList);
		
		JPanel panel = new JPanel();
		panel_1.add(panel, BorderLayout.NORTH);
		panel.setLayout(new GridLayout(3, 1, 0, 0));
		
		JLabel lblTitel = new JLabel("Titel: ");
		panel.add(lblTitel);
		
		JLabel lblErscheinungsjahr = new JLabel("Erscheinungsjahr: ");
		panel.add(lblErscheinungsjahr);
		
		JLabel lblGenre = new JLabel("Genre: ");
		panel.add(lblGenre);
		
		JPanel panel_2 = new JPanel();
		contentPane.add(panel_2);
		panel_2.setLayout(new BorderLayout(0, 0));
		
		btnAddMovie = new JButton("add movie");
		panel_2.add(btnAddMovie, BorderLayout.NORTH);
		
		JList personList = new JList();
		panel_2.add(personList);
	}

}
