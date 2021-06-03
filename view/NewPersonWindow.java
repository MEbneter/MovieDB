package view;

import javax.swing.JDialog;
import javax.swing.JFrame;

public class NewPersonWindow extends JDialog {

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
		setTitle("Neues Movie hinzufügen");
		setBounds(100, 100, 450, 300);
		this.initApp();
	}
	private void initApp() {
	}

}
