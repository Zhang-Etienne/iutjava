package edu.iut.app;

import java.util.ArrayList;
import java.util.LinkedList;

public class Agenda extends ArrayList<ExamEvent> /* extends /* EX2: COLLECTION d'ExamEvent */ {
	public Agenda() {		
		super();
	}
	
	public void addCheckedEvent(ExamEvent examEvent) {
		this.add(examEvent); // ajout d'examEvent dans l'agenda
		// Il y a des v�rifications � faire (ex : pas 2 events dans la m�me pi�ce)
	}
	
}
