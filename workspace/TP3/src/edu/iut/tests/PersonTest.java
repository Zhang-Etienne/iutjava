package edu.iut.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import edu.iut.app.Person;
import edu.iut.app.Person.PersonFunction;

public class PersonTest {

	@Test
	public void testPerson() {
		fail("Not yet implemented");
	}

	@Test
	public void testPersonPersonFunctionStringStringStringString() {
		String p = new String("Sonia");
		Person personne = new Person(PersonFunction.STUDENT, p, "Dubois", "sonia@email.fr", "254165");
		Person p2 = new Person(personne.getFunction(),personne.getFirstname(),personne.getLastname(),
				               personne.getEmail(),personne.getPhone());
		p2.setFirstname("titi");
		//assertTrue(personne.getFirstname().equals("Sonia"));
		System.err.println("#:"+personne.getFirstname());
		
		/**** new String modifie le contenu + la r��f��rence de l'objet (c��d qu'on cr��e une nouvelle nouvelle r��f��rence)
		 * Sans new String on modifie le contenu de l'objet 
		 * ����˵ ���ֱ���� p2 = personne һ���༭ p2, personne Ҳ���ű�
		 * �½�һ���Ͳ������****/
	}

	@Test
	public void testSetFunction() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetFunction() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetFirstname() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetFirstname() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetLastname() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetLastname() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetEmail() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetEmail() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetPhone() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetPhone() {
		fail("Not yet implemented");
	}

}
