package view;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.GridLayout;
import javax.swing.JLabel;

public class NewPersonWindow extends JDialog {
	private JTextField txtVname;
	private JTextField txtNname;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			NewPersonWindow dialog = new NewPersonWindow(null);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public NewPersonWindow(JFrame parent) {
		super(parent);
		setTitle("Neue Person hinzufügen");
		setBounds(100, 100, 300, 200);
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.NORTH);
		
		JRadioButton rdbtnRegisseur = new JRadioButton("Regisseur");
		panel.add(rdbtnRegisseur);
		
		JRadioButton rdbtnSchauspieler = new JRadioButton("Schauspieler");
		panel.add(rdbtnSchauspieler);
		
		JPanel panel_1 = new JPanel();
		getContentPane().add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new GridLayout(3, 1, 0, 0));
		
		JPanel panel_2 = new JPanel();
		panel_1.add(panel_2);
		panel_2.setLayout(new BorderLayout(10, 10));
		
		JLabel lblVname = new JLabel(" Vorname: ");
		panel_2.add(lblVname, BorderLayout.WEST);
		
		txtVname = new JTextField();
		panel_2.add(txtVname);
		txtVname.setText("vName");
		txtVname.setColumns(10);
		
		JPanel panel_3 = new JPanel();
		panel_1.add(panel_3);
		panel_3.setLayout(new BorderLayout(10, 0));
		
		JLabel lblNname = new JLabel(" Nachname: ");
		panel_3.add(lblNname, BorderLayout.WEST);
		
		txtNname = new JTextField();
		panel_3.add(txtNname);
		txtNname.setText("nName");
		txtNname.setColumns(10);
		
		JButton btnHinzufgen = new JButton("hinzuf\u00FCgen");
		panel_1.add(btnHinzufgen);
		this.initApp();
	}
	private void initApp() {
	}

}
