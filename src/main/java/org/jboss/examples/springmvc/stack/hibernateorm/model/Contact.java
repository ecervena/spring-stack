package org.jboss.examples.springmvc.stack.hibernateorm.model;



import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.jboss.examples.springmvc.stack.api.ContactInterface;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Created by ecervena on 1/30/14.
 */

@Entity
@Table(name = "contact")
@NamedQuery(
        name = "findContactsByEmail",
        query = "from Contact where email like :email")
public class Contact implements ContactInterface{

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    @Length(min = 1, max = 40)
    @Column(name = "first_name")
    private String firstName;

    @NotNull
    @Length(min = 1, max = 40)
    @Column(name = "last_name")
    private String lastName;


    @Email
    @Length(min = 6, max = 40)
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
    public String getEmail() {
        return email;
    }

    @Override
    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    @Transient
    public String getFullName() {
        return firstName + " " + lastName;
    }

    @Override
    public String toString() {
        return "[Contact: id=" + id
             +", firstName=" + firstName
             +", lastName=" + lastName
             +", email=" + email
             +"]";
    }
}
