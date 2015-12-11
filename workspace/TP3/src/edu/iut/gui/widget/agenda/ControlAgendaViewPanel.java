package edu.iut.gui.widget.agenda;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.Date;

import javax.swing.BoxLayout;
import javax.swing.JComboBox;
import javax.swing.JSpinner;
import javax.swing.JPanel;
import javax.swing.SpinnerNumberModel;
import javax.swing.SpinnerModel;

import edu.iut.app.ApplicationSession;

public class ControlAgendaViewPanel extends JPanel {

	CardLayout agendaViewLayout;
	JPanel contentPane;
	
	int selectedYear;
	int selectedMonth;
	int selectedDay;
	
	public ControlAgendaViewPanel(CardLayout layerLayout, final JPanel contentPane) {

		this.agendaViewLayout = layerLayout;
		this.contentPane = contentPane;
		/** EX3: REMPLACEMENT DU BOUTON NEXT */
		JPanel commandPanel = new JPanel();
		JPanel botton = new JPanel();
		commandPanel.setLayout(new BoxLayout(commandPanel,BoxLayout.PAGE_AXIS));
		Calendar calendar = Calendar.getInstance();
		JSpinner spinner = new JSpinner();
	    SpinnerNumberModel model = new SpinnerNumberModel(calendar.get(Calendar.YEAR),
															  calendar.get(Calendar.YEAR)-5,
															  calendar.get(Calendar.YEAR)+5,
															  1);
		JSpinner yearSpinner = new JSpinner(model);
		yearSpinner.setEditor(new JSpinner.NumberEditor(yearSpinner, "#")); //"#" pour afficher juste les num¨¦ros
		JComboBox monthComboBox = new JComboBox(ApplicationSession.instance().getMonths());
		JComboBox dayComboBox = new JComboBox(ApplicationSession.instance().getDays());
		
		commandPanel.add(yearSpinner);
		commandPanel.add(monthComboBox);
		commandPanel.add(dayComboBox);
		this.add(commandPanel,BorderLayout.CENTER);
		this.add(botton,BorderLayout.PAGE_END);
		
	}
	
	public int getYear() {
		return selectedYear;
	}
	public int getMonth() {
		return selectedMonth;
	}
	public int getDay() {
		return selectedDay;
	}
	
}
