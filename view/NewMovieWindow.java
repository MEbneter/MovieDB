package view;

import javax.swing.JDialog;
import javax.swing.JFrame;
import java.awt.GridLayout;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.BorderLayout;

public class NewMovieWindow extends JDialog {
	public JTextField txtName;
	public JTextField txtJahr;
	public JComboBox cbGenre;
	public JButton btnMovieHinzu;

	/**
	 * Create the dialog.
	 */
	public NewMovieWindow(JFrame parent) {
		super(parent);
		setTitle("Neues Movie hinzufügen");
		setBounds(100, 100, 300, 200);
		getContentPane().setLayout(new GridLayout(4, 1, 0, 0));
		
		JPanel panel_1 = new JPanel();
		getContentPane().add(panel_1);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JLabel lblName = new JLabel(" Name: ");
		panel_1.add(lblName, BorderLayout.WEST);
		
		txtName = new JTextField();
		panel_1.add(txtName);
		txtName.setColumns(10);
		
		JPanel panel_2 = new JPanel();
		getContentPane().add(panel_2);
		panel_2.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel = new JLabel(" Erscheinungsjahr: ");
		panel_2.add(lblNewLabel, BorderLayout.WEST);
		
		txtJahr = new JTextField();
		panel_2.add(txtJahr);
		
		JPanel panel_3 = new JPanel();
		getContentPane().add(panel_3);
		panel_3.setLayout(new BorderLayout(0, 0));
		
		JLabel lblGenre = new JLabel(" Genre: ");
		panel_3.add(lblGenre, BorderLayout.WEST);
		
		String[] genres = {"Action", "Comedy", "Romance", "SiFi", "Fantasy"};
		cbGenre = new JComboBox(genres);
		panel_3.add(cbGenre);
		
		JPanel panel = new JPanel();
		getContentPane().add(panel);
		panel.setLayout(new GridLayout(0, 1, 0, 0));
		
		btnMovieHinzu = new JButton("hinzuf\u00FCgen");
		panel.add(btnMovieHinzu);
		this.initApp();
	}
	private void initApp() {
	}

}
