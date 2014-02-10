package org.jboss.examples.springmvc.stack.jdbctemplate.service;

import org.jboss.examples.springmvc.stack.jdbctemplate.model.Contact;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by ecervena on 1/18/14.
 */

@Component
public class ContactRowMapper implements RowMapper<Contact> {

    public Contact mapRow(ResultSet resultSet, int i) throws SQLException {
        Contact contact = new Contact();
        contact.setId(resultSet.getLong(1));
        contact.setFirstName(resultSet.getString(2));
        contact.setLastName(resultSet.getString(3));
        contact.setEmail(resultSet.getString(4));
        return contact;
    }
}
