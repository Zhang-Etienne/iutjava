package edu.iut.app;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;


public class CriteriaDateAvant2014noel implements Criteria  {
	//On va trouver le date après 2014-12-25
	
	@Override
	public List<ExamEvent> meetCriteria(List<ExamEvent> examEvents) {
		List<ExamEvent> datesBefore = new ArrayList<ExamEvent>();
		Calendar cal = Calendar.getInstance();
		cal.set(2014, 12, 25, 0, 0, 0);
		Date date = cal.getTime(); // get back a Date object
			
		for(ExamEvent examEvent : examEvents)
		{
			if(examEvent.getExamDate().before(date)){
				datesBefore.add(examEvent);
			}	
		}

		return datesBefore;
	}
	
}
