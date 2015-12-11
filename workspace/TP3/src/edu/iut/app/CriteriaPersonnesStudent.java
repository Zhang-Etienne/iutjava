package edu.iut.app;

import java.util.ArrayList;
import java.util.List;


public class CriteriaPersonnesStudent implements Criteria  {
	
	private String firstname;
	private String lastname;

	//On va trouver les ¨¦udiants "firstname lastname"
	CriteriaPersonnesStudent(String firstname, String lastname) {
		this.firstname = firstname;
		this.lastname = lastname;
				
	}
	
	public List<ExamEvent> meetCriteria(List<ExamEvent> examEvents, String firstname, String lastname) {
		List<ExamEvent> etudiants = new ArrayList<ExamEvent>();
		
		for(ExamEvent examEvent : examEvents)
		{
			if(examEvent.getStudent().getFirstname().equalsIgnoreCase(this.firstname)
				&& examEvent.getStudent().getLastname().equalsIgnoreCase(this.lastname)){
				etudiants.add(examEvent);
			}	

		}

		return etudiants;
	}

	@Override
	public List<ExamEvent> meetCriteria(List<ExamEvent> examEvent) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
