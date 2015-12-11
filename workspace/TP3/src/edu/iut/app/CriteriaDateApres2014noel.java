package edu.iut.app;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;


public class CriteriaDateApres2014noel implements Criteria  {
	//On va trouver le date apr¨¨s 2014-12-25
	
	@Override
	public List<ExamEvent> meetCriteria(List<ExamEvent> examEvents) {
		List<ExamEvent> datesAfter = new ArrayList<ExamEvent>();
		Calendar cal = Calendar.getInstance();
		cal.set(2014, 12, 25, 0, 0, 0);
		Date date = cal.getTime(); // get back a Date object
			
		for(ExamEvent examEvent : examEvents)
		{
			/*if(examEvent.getExamDate().equals(date)){
				dates.add(examEvent);
			}
			*/
			if(examEvent.getExamDate().after(date)){
				datesAfter.add(examEvent);
			}
			/*
			if(examEvent.getExamDate().before(date)){
				dates.add(examEvent);
			}
			*/
		}

		return datesAfter;
	}
	
}
