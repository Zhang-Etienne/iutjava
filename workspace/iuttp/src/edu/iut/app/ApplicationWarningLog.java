package edu.iut.app;

public class ApplicationWarningLog extends AbstractApplicationLog {

	/** Ajouter un tableau ou profiter de l'héritage ? */
	public ApplicationWarningLog() {
		super();
	}
	
	@Override
	public void setMessage(String message) {
		this.message = message;
		super.fireMessage("[WARNING]", this.message);
		for (IApplicationLogListener i : listeners)
		{
			i.newMessage(message, message);
		}
	}

	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return null;
	}
}
