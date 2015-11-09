package edu.iut.app;

public class ApplicationInfoLog extends AbstractApplicationLog {

	/** Ajouter un tableau ou profiter de l'héritage ? */
	public ApplicationInfoLog() {
		super();
	}
	
	@Override
	public void setMessage(String message) {
		this.message = message;
        super.fireMessage("[INFO]", this.message);
        
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
