package view;

import javax.swing.JDialog;
import javax.swing.JFrame;
import java.awt.GridLayout;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.JComboBox;
import java.awt.BorderLayout;

public class NewMovieWindow extends JDialog {
	private JTextField txtName;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			NewMovieWindow dialog = new NewMovieWindow(null);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

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
		
		JComboBox comboBox = new JComboBox();
		panel_2.add(comboBox);
		
		JPanel panel_3 = new JPanel();
		getContentPane().add(panel_3);
		panel_3.setLayout(new BorderLayout(0, 0));
		
		JLabel lblGenre = new JLabel(" Genre: ");
		panel_3.add(lblGenre, BorderLayout.WEST);
		
		JComboBox comboBox_1 = new JComboBox();
		panel_3.add(comboBox_1);
		
		JPanel panel = new JPanel();
		getContentPane().add(panel);
		panel.setLayout(new GridLayout(0, 1, 0, 0));
		
		JButton btnHinzufgen = new JButton("hinzuf\u00FCgen");
		panel.add(btnHinzufgen);
		this.initApp();
	}
	private void initApp() {
	}

}
