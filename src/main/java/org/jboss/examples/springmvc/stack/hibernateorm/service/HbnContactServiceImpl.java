package org.jboss.examples.springmvc.stack.hibernateorm.service;

import org.jboss.examples.springmvc.stack.api.ContactService;
import org.jboss.examples.springmvc.stack.hibernateorm.dao.ContactDao;
import org.jboss.examples.springmvc.stack.hibernateorm.model.Contact;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static org.springframework.util.Assert.notNull;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by ecervena on 1/30/14.
 */
@Service(value = "hbnContactServiceImpl")
@Transactional
public class HbnContactServiceImpl implements ContactService<Contact> {

    @Inject private ContactDao contactDao;

    @Override
    public void createContact(Contact contact) {
        notNull(contact, "contact can't be null");
        contactDao.create(contact);
    }

    @Override
    public List<Contact> getContacts() {
        return contactDao.getAll();
    }

    @Override
    public List<Contact> getContactsByEmail(String email) {
        notNull(email, "email can't be null");
        return contactDao.getByEmail(email);
    }

    @Override
    public Contact getContact(Long id) {
        notNull(id, "id can't be null");
        return contactDao.get(id);
    }

    @Override
    public void updateContact(Contact contact) {
        notNull(contact, "contact can't be null");
    }

    @Override
    public void deleteContact(Contact contact) {
        notNull(contact, "contact can't by null");
    }
}
