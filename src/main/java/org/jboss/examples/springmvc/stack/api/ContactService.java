package org.jboss.examples.springmvc.stack.api;

import org.jboss.examples.springmvc.stack.hibernateorm.model.Contact;

import java.util.List;

/**
 * Created by ecervena on 1/30/14.
 */
public interface ContactService<T extends ContactInterface> {

    void createContact(T contact);

    List<T> getContacts();

    List<T> getContactsByEmail(String email);

    T getContact(Long id);

    void updateContact(T contact);

    void deleteContact(T contact);
}
