package edu.iut.gui.listeners;

import javax.swing.JOptionPane;

public class ApplicationWarningMessageDialog extends
		AbstractApplicationMessageDialog {

	@Override
	public void showMessage(String level, String message) {
		/** UTILISER l'AIDE FORUNIR DANS L'ENNONCE */
		JOptionPane jop = new JOptionPane();
		jop.showMessageDialog(null, level, message, JOptionPane.WARNING_MESSAGE);
	}

}
