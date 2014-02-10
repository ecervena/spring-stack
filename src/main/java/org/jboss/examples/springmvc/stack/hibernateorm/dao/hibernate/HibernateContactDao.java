package org.jboss.examples.springmvc.stack.hibernateorm.dao.hibernate;

import org.jboss.examples.springmvc.stack.hibernateorm.dao.ContactDao;
import org.jboss.examples.springmvc.stack.hibernateorm.model.Contact;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by ecervena on 1/30/14.
 */
@Repository
public class HibernateContactDao extends AbstractHibernateDao<Contact> implements ContactDao {

    @Override
    public List<Contact> getByEmail(String email) {
        return getSession()
                .getNamedQuery("findContactsByEmail")
                .setString("email", "%" + email + "%")
                .list();
    }
}
