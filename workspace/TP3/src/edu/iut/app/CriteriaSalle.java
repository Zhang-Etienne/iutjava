package edu.iut.app;

import java.util.ArrayList;
import java.util.List;


public class CriteriaSalle implements Criteria  {
	//On va trouver les salles comprises 1 entre 10
	
	@Override
	public List<ExamEvent> meetCriteria(List<ExamEvent> examEvents) {
		List<ExamEvent> salles = new ArrayList<ExamEvent>();
		
		for(ExamEvent examEvent : examEvents)
		{
			if((Integer.parseInt(examEvent.getClassroom().classRoomNumber) > 0) 
				&&(Integer.parseInt(examEvent.getClassroom().classRoomNumber) < 11)){
				salles.add(examEvent);
			}	

		}

		return salles;
	}
	
}
