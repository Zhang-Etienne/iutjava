package edu.iut.gui.listeners;

import javax.swing.JOptionPane;

public class ApplicationInfoMessageDialog extends
		AbstractApplicationMessageDialog {

	public void showMessage(String level, String message) {
		/** UTILISER l'AIDE FORUNIR DANS L'ENNONCE */
		
		JOptionPane jop = new JOptionPane();
		jop.showMessageDialog(null, level, message, JOptionPane.INFORMATION_MESSAGE);
	}
}
