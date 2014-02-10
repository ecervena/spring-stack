package org.jboss.examples.springmvc.stack;

import javax.inject.Inject;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "customers")
public class CustomersController {

	@Inject
	ContactService service;
	
	@RequestMapping(value="/")
	public String contacts(Model model) {
		model.addAttribute("contacts", service.getAll());
		model.addAttribute("contact", new Contact());
		return("customers");
	}
	
	@RequestMapping(value = "save",method = RequestMethod.POST)
	public String saveCustomer(Contact contact) {
		System.out.println(contact.toString());
		service.save(contact);
		return "redirect:/servlet/customers/";
	}
	
	@RequestMapping(value = "xml", method = RequestMethod.GET, produces = MediaType.APPLICATION_XML_VALUE)
	public @ResponseBody ContactList getContactsXml() {
		return service.getAll();
	}
	
	@RequestMapping(value = "json", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ContactList getContactsJson() {
		return service.getAll();
	}
	
	@RequestMapping(value = "xml/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_XML_VALUE)
	public @ResponseBody Contact getXml(@PathVariable long id) {
		return service.getContact(id);
	}
	
	@RequestMapping(value = "json/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Contact getJson(@PathVariable long id) {
		return service.getContact(id);
	}
}
