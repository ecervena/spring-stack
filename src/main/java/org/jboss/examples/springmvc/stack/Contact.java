package org.jboss.examples.springmvc.stack;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
//import javax.ws.rs.FormParam;
import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.stereotype.Component;

@Entity
@XmlRootElement
@Component
public class Contact {

    @Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	private String firstName; 
	
	private String lastName;

	public Contact() {
	}

	public Contact(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public boolean equals(Object other) {
		Contact otherContact = (Contact) other;
		return otherContact.firstName.equals(this.firstName) && otherContact.lastName.equals(this.lastName);
	}

	public int hashCode() {
		return firstName.hashCode() ^ lastName.hashCode();
	}
	
	public String toString() {
		return "class/Contact: "+this.firstName+" "+this.lastName;
	}
}