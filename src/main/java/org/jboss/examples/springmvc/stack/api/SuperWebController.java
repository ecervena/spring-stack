package org.jboss.examples.springmvc.stack.api;

import org.jboss.examples.springmvc.stack.api.*;
import org.jboss.examples.springmvc.stack.jdbctemplate.web.ContactForm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.AbstractController;

import javax.inject.Inject;

/**
 * Created by ecervena on 1/31/14.
 */
//@Controller
public class SuperWebController {

    private ContactService service;

    @RequestMapping(value = "show", method = RequestMethod.GET)
    public String showContactForm(Model model) {
        System.out.println("From: SuperWebController ========================");
        model.addAttribute(service.getContacts());
        return "jdbcTemplate/jpacontacts";
    }

    @RequestMapping(value = "save", method = RequestMethod.POST)
    public String saveContact(ContactForm form) {
        org.jboss.examples.springmvc.stack.jdbctemplate.model.Contact contact = new org.jboss.examples.springmvc.stack.jdbctemplate.model.Contact();
        contact.setFirstName(form.getFirstName());
        contact.setLastName(form.getLastName());
        contact.setEmail(form.getEmail());
        service.createContact(contact);
        return "redirect:show";
    }

    @RequestMapping(value = "form", method = RequestMethod.GET)
    public String contactForm(Model model) {
        model.addAttribute("contact", new ContactForm());
        return "jdbcTemplate/contactForm";
    }

/*    @RequestMapping(value = "delete/contact", method = RequestMethod.GET)
    public String removeContact(@RequestParam("id") long id) {
        service.deleteContact(service.getContact(id));
        return "redirect:/servlet/jdbcTemplate/show";
    }*/

    @RequestMapping(value = "delete/contact", method = RequestMethod.GET)
    public String removeContact(@RequestParam("id") long id, Model model) {
        service.deleteContact(service.getContact(id));
        model.addAttribute(service.getContacts());
        return "jdbcTemplate/jpacontacts";
    }
}
