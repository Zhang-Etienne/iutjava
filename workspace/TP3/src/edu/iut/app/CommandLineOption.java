package edu.iut.app;

import java.util.regex.Pattern;

public class CommandLineOption <ValueType> {
	
	protected String key;
	protected String description;
	protected ValueType defaultValue;
	protected ValueType value;
	protected OptionType optionType;
	
	/* La clé sera toujours un string.
	 * La valeur peut être de type string, integer, boolean, double.
	 * La description sera toujours un string.
	 */
	
	// Les types possibles pour l'option
	public enum OptionType{
		NONE("None"),
		FILE("File"),
		STRING("String"),
		INTEGER("Integer"),
		DOUBLE("Double"),
		BOOLEAN("Boolean"),
		NOVALUE("NoValue");
		private String optionType;
		
		OptionType(String optionType) {
			
			this.optionType = optionType;
		}
		
		public String toString() {
			return ApplicationSession.instance().getString(optionType.toString()); // Internationalisation
		}		
	}
	
	// Constructeur sans paramètres
	public CommandLineOption() {		
		/* EX1: Initializer les attributs */
		this.key = null;
		this.description = null;
		this.defaultValue = null;
		this.value = null;
		this.optionType = null;		
	}
	
	// Constructeur avec paramètres
	public CommandLineOption(final OptionType optionType, final String key, final String description, final ValueType defaultValue) {
		/* EX1 : Affecter les attributs */
		this.optionType = optionType;
		this.key = key;
		this.description = description;
		this.defaultValue = defaultValue;
	}
	
	public void setOption(OptionType optionType, String key, String description, ValueType defaultValue) {
		/* EX1 : Affecter les attributs */
		this.optionType = optionType;
		this.key = key;
		this.description = description;
		this.defaultValue = defaultValue;
	}
	
	public  void setValue(ValueType value) {
		this.value = value;
	}
		
	public String getKey() {
		return this.key;
	}
	
	public String getDescription() {
		String myKey = key;
		// suppress -- at start of the String 'key'
		myKey.replace("^--", "");
		
		return ApplicationSession.instance().getString(myKey);
	}
	
	public ValueType getValue() {
		if (value != null) {
			return value;
		}
		return defaultValue;
	}
	
	public OptionType getOptionType() {
		return optionType;
	}



}
