package org.jboss.examples.springmvc.stack;

import java.util.ArrayList;
import java.util.Collection;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;



@XmlRootElement
public class ContactList 
{
   
   private Collection<Contact> contacts;

   public ContactList()
   {
      this.contacts = new ArrayList<Contact>();
   }

   public ContactList(Collection<Contact> contacts)
   {
      this.contacts = contacts;
   }

   @XmlElement(name="contact")
   public Collection<Contact> getContacts()
   {
      return contacts;
   }

   public void setContacts(Collection<Contact> contact)
   {
      this.contacts = contact;
   }

   
   
}
