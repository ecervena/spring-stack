package org.jboss.examples.springmvc.stack;

import java.util.HashSet;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * 
 * @author Emil Cervenan <ecervena@redhat.com>
 *
 */

@Repository
@Transactional
public class ContactService {
	
	@Inject
	private EntityManager em;
	
	public void save(Contact contact) {
		em.persist(contact);
	}

//	@SuppressWarnings("unchecked")
//	public Contact getContact(String lastName) {
//		Query query = em.createQuery("select c from Contact c where c.lastName = :lastName");
//		query.setParameter("lastName", lastName);
//		List<Contact> result = query.getResultList();
//		return result.get(0);
//	}
	
	public Contact getContact(long id) {
	    return em.find(Contact.class, id);
	}

	@SuppressWarnings("unchecked")
	public ContactList getAll() {
		Query query = em.createQuery("select c FROM Contact c");
			List<Contact> result = query.getResultList();
		return new ContactList(result);
	}
	
	@SuppressWarnings("unchecked")
	public ContactSet getSet() {
	    Query query = em.createQuery("select c FROM Contact c");
        List<Contact> result = query.getResultList();
        HashSet<Contact> set = new HashSet<Contact>(result);
	    return new ContactSet(set);
	}
}
