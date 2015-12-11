package edu.iut.app;

import java.util.HashMap;
import java.util.ArrayList;
import java.io.File;

public class CommandLineParser {
	
	protected HashMap<String, CommandLineOption /* EX1: option generique */> options;
	protected ArrayList<String> parseErrors;
		
	public CommandLineParser() {
		options = new HashMap<>(); // créer Map par HashMap
		parseErrors = new ArrayList<String>();
	}
	
	public void addOption(CommandLineOption<?> option) {
		if (option != null) {
			options.put(option.getKey(),option);
		}
	}
	
	public void parse(String[] args) {
		for (String argument: args) {
			String[] keyValue=argument.split("=");
			if (options.containsKey(keyValue[0])) {
				switch (((CommandLineOption<?>)options.get(keyValue[0])).getOptionType()) {
					case FILE:
						CommandLineOption<File> fileOption = (CommandLineOption<File>)options.get(keyValue[0]);
						if (keyValue.length == 2) {
							fileOption.setValue(new File(keyValue[1]));
						}
						else {
							parseErrors.add("Option should have a key and a value.");
						}
						break;
					/* EX1 : reproduire le comportement de 'case FILE', pour STRING,INTEGER, ... */
					case STRING:
						CommandLineOption<String> stringOption = (CommandLineOption<String>)options.get(keyValue[0]);
						if (keyValue.length == 2) {
							stringOption.setValue(new String(keyValue[1]));
						}
						else {
							parseErrors.add("Option should have a key and a value.");
						}
						break;
						
					case INTEGER:
						CommandLineOption<Integer> integerOption = (CommandLineOption<Integer>)options.get(keyValue[0]);
						if (keyValue.length == 2) {
							integerOption.setValue(new Integer(keyValue[1]));
						}
						else {
							parseErrors.add("Option should have a key and a value.");
						}
						break;

					case DOUBLE:
						CommandLineOption<Double> doubleOption = (CommandLineOption<Double>)options.get(keyValue[0]);
						if (keyValue.length == 2) {
							doubleOption.setValue(new Double(keyValue[1]));
						}
						else {
							parseErrors.add("Option should have a key and a value.");
						}
						break;
						
					/*Si on passe un booléen en ligne de commandes mais qu'on n'a pas précisé true ou false derrière
					 * Exemple : --no-gui
					 * Alors keyValue.length = 1
					 * Sinon si on a : --no-gui = true
					 * On a keyValue.length = 2. On lit si le booléen vaut true ou false. Puis on ajoute le booléen vrai ou faux dans notre tableau*/
					case NOVALUE:
					case BOOLEAN:
						CommandLineOption<Boolean> boolOption = (CommandLineOption<Boolean>)options.get(keyValue[0]);
						if (keyValue.length == 1) {
							boolOption.setValue(new Boolean(true));
						}
						else if (keyValue.length == 2) {
							if (keyValue[1].equals("true")) {
								boolOption.setValue(new Boolean(true));
							}
							else if (keyValue[1].equals("false")){
								boolOption.setValue(new Boolean(false));
							}
						}
						else {
							parseErrors.add("Option should have a key and a value.");
						}
						break;
					default:
						parseErrors.add("Unrecognize option type.");						
				}
			}
		}
	}
	
	public CommandLineOption<?> getOption(String key) {
		if (options.containsKey(key)) {
			return options.get(key);
		}
		return null;
	}
	
	public ArrayList<String> getErrors() {
		return parseErrors;
	}
	
}
