package org.jboss.examples.springmvc.stack;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ContactSet
{
   
   private Set<Contact> contacts;

   public ContactSet()
   {
      this.contacts = new HashSet<Contact>();
   }

   public ContactSet(HashSet<Contact> contacts)
   {
      this.contacts = contacts;
   }

   @XmlElement(name="contact")
   public Collection<Contact> getContacts()
   {
      return contacts;
   }

   public void setContacts(HashSet<Contact> contact)
   {
      this.contacts = contact;
   }

   
   
}
