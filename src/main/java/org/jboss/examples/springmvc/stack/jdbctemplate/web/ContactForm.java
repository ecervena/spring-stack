package org.jboss.examples.springmvc.stack.jdbctemplate.web;

/**
 * Created by ecervena on 1/19/14.
 */
public class ContactForm {

    public ContactForm() {}

    private String firstName, lastName, email;

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
