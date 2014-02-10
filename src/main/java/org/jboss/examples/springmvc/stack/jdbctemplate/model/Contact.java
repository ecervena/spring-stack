package org.jboss.examples.springmvc.stack.jdbctemplate.model;

import org.jboss.examples.springmvc.stack.api.ContactInterface;

/**
 * Created by ecervena on 1/18/14.
 */
public class Contact implements ContactInterface{

    public Contact() {}

    private Long id;
    private String firstName;
    private String lastName;
    private String email;

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String getFirstName() {
        return firstName;
    }

    @Override
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Override
    public String getLastName() {
        return lastName;
    }

    @Override
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String getEmail() { return email; }

    @Override
    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String getFullName() { return firstName + " " + lastName; }
}
