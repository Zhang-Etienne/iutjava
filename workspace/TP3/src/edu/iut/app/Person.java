package edu.iut.app;

public class Person {
	
	protected PersonFunction personFunction;
	protected String firstname;
	protected String lastname;
	protected String email;
	protected String phone;
	
	public enum PersonFunction{
		/* EX2 : Internationalisation */
		NONE("None"),
		JURY("Jury"),
		STUDENT("Student");
		
		private String personFunction;
		
		PersonFunction(String personFunction) {
			this.personFunction = personFunction;
		}
		
		public String toString() {
			return ApplicationSession.instance().getString(personFunction.toString()); // Internationalisation
		}	
	}
	
	public Person() {
		personFunction = PersonFunction.NONE;
	}
	
	/*
	public Person(Person cpy) {
		this.personFunction = cpy.personFunction;
		this.firstname = new String(cpy.firstname);
		this.lastname = new String(cpy.email);
		this.phone = new String(cpy.phone);	
		}
	*/
	
	public Person(PersonFunction personFunction,
				  String firstname,
				  String lastname,
				  String email,
				  String phone) {
		/* EX2: initialisation */;
		this.personFunction = personFunction;
		this.firstname = new String(firstname);
		this.lastname = email;
		this.phone = phone;
	}
	
	public void setFunction(PersonFunction function) {
		this.personFunction = function;
	}
	public PersonFunction getFunction() {
		return personFunction;
	}
	
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getFirstname() {
		return firstname;
	}
	
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getEmail() {
		return email;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getPhone() {
		return phone;
	}


}
