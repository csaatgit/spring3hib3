package services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import Models.Contact;
import daos.ContactDao;

@Service
public class ContactService {
	@Autowired
	private ContactDao contactDao;

	public ContactDao getContactDao() {
		return contactDao;
	}

	public void setContactDao(ContactDao contactDao) {
		this.contactDao = contactDao;
	}
	
	@Transactional
	public void add(Contact c) {
		contactDao.add(c);
	}
}
