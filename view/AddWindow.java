package view;

import java.awt.event.ActionListener;

import javax.swing.JDialog;
import javax.swing.JFrame;
/**
 * Abstakte Klasse für Daten-Hinzufügen JDialog Windows
 * @author manue
 *
 */
abstract class AddWindow extends JDialog{
	 public AddWindow (JFrame parent) {
		 super(parent);
	 }
	 /**
	  * 
	  * @param action : ActionListener
	  */
	 public abstract void setActionHinzuButton(ActionListener action);
}
