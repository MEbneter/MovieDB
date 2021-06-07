package view;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.ButtonGroup;

public class NewPersonWindow extends AddWindow {
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JRadioButton rdbtnRegisseur;
	private JRadioButton rdbtnSchauspieler;
	private JButton btnPersonHinzu;
	private JTextField txtNname;
	private JTextField txtVname;

	/**
	 * Create the dialog.
	 */
	public NewPersonWindow(JFrame parent) {
		super(parent);
		setTitle("Neue Person hinzufügen");
		setBounds(100, 100, 300, 200);
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.NORTH);
		
		rdbtnRegisseur = new JRadioButton("Regisseur");
		buttonGroup.add(rdbtnRegisseur);
		panel.add(rdbtnRegisseur);
		
		rdbtnSchauspieler = new JRadioButton("Schauspieler");
		buttonGroup.add(rdbtnSchauspieler);
		rdbtnSchauspieler.setSelected(true);
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
		txtVname.setColumns(10);
		
		JPanel panel_3 = new JPanel();
		panel_1.add(panel_3);
		panel_3.setLayout(new BorderLayout(10, 0));
		
		JLabel lblNname = new JLabel(" Nachname: ");
		panel_3.add(lblNname, BorderLayout.WEST);
		
		txtNname = new JTextField();
		panel_3.add(txtNname);
		txtNname.setColumns(10);
		
		btnPersonHinzu = new JButton("hinzuf\u00FCgen");
		panel_1.add(btnPersonHinzu);
		this.initApp();
	}
	private void initApp() {
	}
	/**
	 * getter
	 */
	/**
	 * Vorname
	 * @return vorname : String
	 */
	public String getVname () {
		return txtVname.getText();
	}
	/**
	 * Nachname
	 * @return nachname : String
	 */
	public String getNname () {
		return txtNname.getText();
	}
	/**
	 * ist er Regisseur?
	 * @return aufgabe : boolean
	 */
	public boolean isRegisseur () {
		return rdbtnRegisseur.isSelected();
	}
	/**
	 * Button Person hinzufügen
	 * @return JButton : Object
	 */
	public Object getButtonPersonHinzu () {
		return btnPersonHinzu;
	}
	/**
	 * setter
	 */
	/**
	 * adds Action zum hinzufügen Button 
	 * @param action
	 */
	@Override
	public void setActionHinzuButton(ActionListener action) {
		btnPersonHinzu.addActionListener(action);
	}
}








