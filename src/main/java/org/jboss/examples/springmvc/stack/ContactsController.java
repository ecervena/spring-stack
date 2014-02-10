package org.jboss.examples.springmvc.stack;

/**
 * @author Emil Cervenan <ecervena@redhat.com>
 */

import java.net.URISyntaxException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping(value = "contacts")
public class ContactsController {
	
	@Autowired
	ContactService service;
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public ModelAndView contacts() {
			return new ModelAndView("contacts","contactsModel",service.getAll());
	}
	
	/**
	 * Post/Redirect/Get pattern
	 */
	@RequestMapping(value="/save", method=RequestMethod.POST)
	public ModelAndView saveContactForm(@RequestParam("firstName") String firstName,
										@RequestParam("lastName") String lastName) throws URISyntaxException {
		Contact contact = new Contact(firstName, lastName);
		service.save(contact);
		return new ModelAndView("redirect:/servlet/contacts/");
	}
	
	/**
	 * @PathVariable is used for uri placeholders like "/json/{id}"
	 * @RequestParam is used for uri parameter like "/json/contact?id=2"
	 */
	@RequestMapping(value="/json/{id}", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Contact getJson(@PathVariable long id) {
		return service.getContact(id);	
	}
	
	@RequestMapping(value="/xml/{id}", method=RequestMethod.GET, produces=MediaType.APPLICATION_XML_VALUE)
	public @ResponseBody Contact getXml(@PathVariable long id) {
		return service.getContact(id);	
	}
	
	@RequestMapping(value="/xml", method=RequestMethod.GET, produces=MediaType.APPLICATION_XML_VALUE)
	public @ResponseBody ContactList getAllXml() {
		return service.getAll();
	}
	
	@RequestMapping(value="/json", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ContactList getAllJson() {
		return service.getAll();
	}
	
	/**
	 * @return Set of contacts according to Contact's equals and hashCode method
	 */
	@RequestMapping(value="/xml/set", method=RequestMethod.GET, produces=MediaType.APPLICATION_XML_VALUE)
	public @ResponseBody ContactSet getXmlSet() {
	    return service.getSet();
	}

}
