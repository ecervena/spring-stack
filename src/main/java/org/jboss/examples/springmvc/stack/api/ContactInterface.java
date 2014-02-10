package org.jboss.examples.springmvc.stack.api;

/**
 * Created by ecervena on 1/31/14.
 */
public interface ContactInterface {

    public Long getId();

    public void setId(Long id);

    public String getFirstName();

    public void setFirstName(String firstName);

    public String getLastName();

    public void setLastName(String lastName);

    public String getEmail();

    public void setEmail(String email);

    public String getFullName();

}
