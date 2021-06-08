package view;

import javax.swing.JFrame;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.BorderLayout;
/**
 * 
 * @author manue
 *
 */
public class NewMovieWindow extends AddWindow {
	private JTextField txtName;
	private JTextField txtJahr;
	private JComboBox cbGenre;
	private JButton btnMovieHinzu;

	/**
	 * Create the dialog.
	 */
	public NewMovieWindow(JFrame parent) {
		super(parent);
		setTitle("Neues Movie hinzuf�gen");
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

	/**
	 * getter
	 */
	/**
	 * Movie hinzuf�gen 
	 * @return Object JButton
	 */
	public Object getButtonMovieHinzu () {
		return btnMovieHinzu;
	}
	/**
	 * Movie Name
	 * @return name : String
	 */
	public String getName () {
		return txtName.getText();
	}
	/**
	 * Escheinungsjahr
	 * @return jahr : String
	 */
	public String getJahr () {
		return txtJahr.getText();
	}
	/**
	 * Gew�hltes Genre
	 * @return genre : Object
	 */
	public Object getGenre () {
		return cbGenre.getSelectedItem();
	}
	/**
	 * setter
	 */
	/**
	 * adds Action zu hinzuf�gen butten
	 * @param action : ActionListener
	 */
	@Override
	public void setActionHinzuButton (ActionListener action) {
		btnMovieHinzu.addActionListener(action);
	}
}
