package edu.iut.exceptions;

import java.util.logging.Logger;

import edu.iut.app.ApplicationSession;

// Exercice 2 
/* ¨¦tendre les exceptions : */
public class IUTException extends Exception {
	public IUTException() {
		super();
		// Logger une erreur avec le message empty en utilisant le singleton session, ie le logger d¨¦fini dans la session */	
		ApplicationSession.instance().getExceptionLogger().severe("Empty");
		//http://www.cjsdn.net/Doc/JDK50/java/util/logging/Logger.html pour expliquer java.util.logging.Logger 
	}
	public IUTException(IUTException e) {
		super (e);
		// Logger une erreur avec le message contenu dans 'e'  en utilisant le singleton session, ie le logger d¨¦fini dans la session */
		ApplicationSession.instance().getExceptionLogger().severe(e.getMessage());
	}
	public IUTException(String message) {
		super(message);
		// Logger une erreur avec le message contenu dans 'message'  en utilisant le singleton session, ie le logger d¨¦fini dans la session */
		ApplicationSession.instance().getExceptionLogger().severe(message);
	}
	
}

