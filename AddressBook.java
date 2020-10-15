package com.addressbook;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * The Class AddressBook.
 */
public class AddressBook implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String name;

	/** The contacts. */
	private List<ContactDetails> contacts = new ArrayList<>();

	/**
	 * Gets the contacts.
	 *
	 * @return the contacts
	 */
	public List<ContactDetails> getContacts() {
		return contacts;
	}

	/**
	 * Sets the contacts.
	 *
	 * @param contacts
	 *            the new contacts
	 */
	public void setContacts(List<ContactDetails> contacts) {
		this.contacts = contacts;
	}

	public AddressBook(String name) {
		this(name, new ArrayList<ContactDetails>());
	}

	public AddressBook(String name, List<ContactDetails> contacts) {
		this.name = name;
		this.contacts = contacts;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Adds the contact.
	 *
	 * @param contact
	 *            the contact
	 */
	public void addContact(ContactDetails contact) {
		contacts.add(contact);
	}

	/**
	 * Gets the unique contacts.
	 *
	 * @param addressBooks
	 *            the address books
	 * @return the unique contacts
	 */
	public static Set<ContactDetails> getUniqueContacts(List<AddressBook> addressBooks) {

		Set<ContactDetails> commonContacts = new HashSet<>();
		Set<ContactDetails> uniqueContacts = new HashSet<>();

		for (AddressBook addressBook : addressBooks) {
			List<ContactDetails> contacts = addressBook.getContacts();
			List<ContactDetails> allContacts = new ArrayList<>();
			allContacts.addAll(uniqueContacts);
			allContacts.addAll(contacts);
			contacts.retainAll(uniqueContacts);
			commonContacts.addAll(contacts);
			allContacts.removeAll(commonContacts);
			// set new uinque contacts
			uniqueContacts.clear();
			uniqueContacts.addAll(allContacts);

		}
		return uniqueContacts;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "AddressBook [name=" + name + ", contacts=" + contacts + "]";
	}

}
