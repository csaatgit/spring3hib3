package controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import Models.Contact;
import services.ContactService;

@Controller
//@SessionAttributes
public class ContactController {
	@Autowired
	private ContactService contactService;
	
	public ContactService getContactService() {
		return contactService;
	}

	public void setContactService(ContactService contactService) {
		this.contactService = contactService;
	}

	@RequestMapping(value = "/addContact", method = RequestMethod.POST)
	public ModelAndView addContact(@ModelAttribute
							Contact contact, BindingResult result) {
		
		System.out.println("First Name:" + contact.getFirstname() + 
					"Last Name:" + contact.getLastname());
				
		this.contactService.add(contact);
		return new ModelAndView("redirect:contacts.html", "firstname", contact.getFirstname());
	}
	
	@RequestMapping("/contacts")
	public ModelAndView showContacts() {
		
		return new ModelAndView("contact", "command", new Contact());
	}
}
