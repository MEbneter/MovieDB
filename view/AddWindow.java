package view;

import java.awt.event.ActionListener;

import javax.swing.JDialog;
import javax.swing.JFrame;

abstract class AddWindow extends JDialog{
	 public AddWindow (JFrame parent) {
		 super(parent);
	 }
	 public abstract void setActionHinzuButton(ActionListener action);
}
