package org.jboss.examples.springmvc.stack.hibernateorm.dao;

import org.jboss.examples.springmvc.stack.api.Dao;
import org.jboss.examples.springmvc.stack.hibernateorm.model.Contact;

import java.util.List;

/**
 * Created by ecervena on 1/30/14.
 */
public interface ContactDao extends Dao<Contact> {

    List<Contact> getByEmail(String email);
}
