package org.jboss.examples.springmvc.stack.jdbctemplate.service;

import org.jboss.examples.springmvc.stack.api.ContactService;
import org.jboss.examples.springmvc.stack.jdbctemplate.model.Contact;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Service;

import static org.springframework.util.Assert.notNull;

import javax.inject.Inject;
import java.util.HashMap;
import java.util.List;

/**
 * Created by ecervena on 1/18/14.
 */
@Service(value = "jdbcTemplateService")
public class JdbcContactServiceImpl implements ContactService<Contact> {

    private static final String CREATE_SQL = "insert into contact(first_name, last_name, email) values(:firstName, :lastName, :email)";
    private static final String GET_ALL_SQL = "select id, first_name, last_name, email from contact";
    private static final String GET_ALL_BY_EMAIL_SQL = "select id, first_name, last_name, email from contact where email like :email";
    private static final String GET_CONTACT_BY_ID_SQL = "select id, first_name, last_name, email from contact where id = :id";
    private static final String UPDATE_CONTACT_SQL = "update contact set first_name = :firstName, last_name = :lastName, email = :email where id = :id";
    private static final String DELETE_CONTACT_SQL = "delete from contact where id = :id";

    @Inject private NamedParameterJdbcOperations jdbcTemplate;
    @Inject private ContactRowMapper contactRowMapper;

    @Override
    public void createContact(Contact contact) {
        notNull(contact, "Contact can't be null.");
        SqlParameterSource params = new MapSqlParameterSource()
                .addValue("firstName", contact.getFirstName())
                .addValue("lastName", contact.getLastName())
                .addValue("email", contact.getEmail());
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(CREATE_SQL, params, keyHolder);
        contact.setId(keyHolder.getKey().longValue());
    }

    @Override
    public List<Contact> getContacts() {
        return jdbcTemplate.query(GET_ALL_SQL, new HashMap<String, Object>(), contactRowMapper);
    }

    @Override
    public List<Contact> getContactsByEmail(String email) {
        notNull(email, "Email can't be null.");
        // % is SQL wildcard
        SqlParameterSource params = new MapSqlParameterSource("email", "%" + email + "%");
        return jdbcTemplate.query(GET_ALL_BY_EMAIL_SQL, params, contactRowMapper);
    }

    @Override
    public Contact getContact(Long id) {
        notNull(id, "ID can't be null.");
        SqlParameterSource params = new MapSqlParameterSource("id", id);
        return jdbcTemplate.queryForObject(GET_CONTACT_BY_ID_SQL, params, contactRowMapper);
    }

    @Override
    public void updateContact(Contact contact) {
        notNull(contact, "Contact can't be null");
        SqlParameterSource params = new MapSqlParameterSource()
                .addValue("id", contact.getId())
                .addValue("firstName", contact.getFirstName())
                .addValue("lastName", contact.getLastName())
                .addValue("email", contact.getEmail());

        jdbcTemplate.update(UPDATE_CONTACT_SQL, params);
    }

    @Override
    public void deleteContact(Contact contact) {
        notNull(contact, "Contact can't be null");
        jdbcTemplate.update(DELETE_CONTACT_SQL, new MapSqlParameterSource("id", contact.getId()));
    }
}
