package org.jboss.examples.springmvc.stack.jdbctemplate.web;

import org.jboss.examples.springmvc.stack.api.SuperWebController;
import org.jboss.examples.springmvc.stack.api.ContactService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.inject.Inject;

/**
 * Created by ecervena on 1/18/14.
 */

@Controller
@RequestMapping(value = "jdbcTemplate")
public class JdbcTemplateController extends SuperWebController {

    @Inject
    @Qualifier(value = "jdbcTemplateService")
    private ContactService service;

/*    @RequestMapping(value = "show", method = RequestMethod.GET)
    public String showContactForm(Model model) {
        model.addAttribute(service.getContacts());
        return "jdbcTemplate/jpacontacts";
    }*/
/*
    @RequestMapping(value = "save", method = RequestMethod.POST)
    public String saveContact(ContactForm form) {
        Contact contact = new Contact();
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

*//*    @RequestMapping(value = "delete/contact", method = RequestMethod.GET)
    public String removeContact(@RequestParam("id") long id) {
        service.deleteContact(service.getContact(id));
        return "redirect:/servlet/jdbcTemplate/show";
    }*//*

    @RequestMapping(value = "delete/contact", method = RequestMethod.GET)
    public String removeContact(@RequestParam("id") long id, Model model) {
        service.deleteContact(service.getContact(id));
        model.addAttribute(service.getContacts());
        return "jdbcTemplate/jpacontacts";
    }*/
}
