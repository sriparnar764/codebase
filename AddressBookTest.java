package com.addressbook;

import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Logger;

import org.junit.Before;
import org.junit.Test;

/**
 * The Class AddressBookTest.
 */
public class AddressBookTest {

	/** The Constant logger. */
	private final static Logger logger = Logger.getLogger(AddressBookTest.class.getName());

	/** The c 5. */
	private ContactDetails c1;
	private ContactDetails c2;
	private ContactDetails c3;
	private ContactDetails c4;
	private ContactDetails c5;

	/** The address book persist. */
	private AddressBookPersist addressBookPersist;

	/**
	 * Create new contacts before starting the test.
	 * 
	 * @throws IOException
	 */
	@Before
	public void setUp() throws IOException {
		addressBookPersist = new AddressBookPersist();
		createNewContacts();
	}

	/**
	 * Unique friends from two address books.
	 * 
	 * @throws IOException
	 */
	@Test
	public void uniqueFriendsFromTwoAddressBooks() throws IOException {
		logger.info("========== Display Unique Friends from Two Address Books ==========");

		List<AddressBook> addressBooks = addTwoAddressBooks();
		printInput(addressBooks);

		// Get unique contacts from three AddressBooks
		Set<ContactDetails> uniqueContacts = AddressBook.getUniqueContacts(addressBooks);
		printOutput(addressBooks, uniqueContacts);

		// The unique contacts from three address books should be c1,c4
		Set<ContactDetails> expected = new HashSet<ContactDetails>(Arrays.asList(c1, c4));
		assertTrue(uniqueContacts.equals(expected));
	}

	/**
	 * Sort friends by their names.
	 */
	@Test
	public void sortFriendsByTheirNames() {
		logger.info("========== Display the list of friends sorted by their name ==========");
		AddressBook addressBook = new AddressBook("Address Book 1");
		addressBook.addContact(c5);
		addressBook.addContact(c1);
		addressBook.addContact(c4);
		addressBook.addContact(c2);
		addressBook.addContact(c3);

		logger.info("==INPUT==");
		for (ContactDetails contact : addressBook.getContacts()) {
			System.out.println(contact);
		}
		Collections.sort(addressBook.getContacts());
		logger.info("==OUTPUT==");
		for (ContactDetails contact : addressBook.getContacts()) {
			System.out.println(contact);
		}

		// Sorted list
		assertTrue("Bob".equals(addressBook.getContacts().get(0).getName()));
		assertTrue("Jane".equals(addressBook.getContacts().get(1).getName()));
		assertTrue("John".equals(addressBook.getContacts().get(2).getName()));
		assertTrue("Mark".equals(addressBook.getContacts().get(3).getName()));
		assertTrue("Mary".equals(addressBook.getContacts().get(4).getName()));

	}

	/**
	 * Creates the new contacts.
	 */
	private void createNewContacts() {
		c1 = new ContactDetails("Bob", "9876778877");
		c2 = new ContactDetails("Mary", "9973211123");
		c3 = new ContactDetails("Jane", "8876787677");
		c4 = new ContactDetails("John", "7898998989");
		c5 = new ContactDetails("Mark", "7866555555");

	}

	/**
	 * Adds two address books.
	 * 
	 * @throws IOException
	 */
	private List<AddressBook> addTwoAddressBooks() throws IOException {

		AddressBook ab1 = new AddressBook("Address Book 1");
		AddressBook ab2 = new AddressBook("Address Book 2");
		List<AddressBook> addressBooks = new ArrayList<>();

		// AddContacts to the addressBooks
		ab1.addContact(c1);
		ab1.addContact(c2);
		ab1.addContact(c3);
		ab2.addContact(c2);
		ab2.addContact(c4);
		ab2.addContact(c3);

		addressBooks.add(ab1);
		addressBooks.add(ab2);

		addressBookPersist.persistAddressBook(addressBooks);
		return addressBooks;
	}

	/**
	 * Prints the input.
	 *
	 * @param addressBooks
	 *            the address books
	 */
	private void printInput(List<AddressBook> addressBooks) {
		logger.info("==INPUT==");
		for (AddressBook addressBook : addressBooks) {
			for (ContactDetails c : addressBook.getContacts()) {
				System.out.println(c.getName() + "\n");

			}

		}
	}

	/**
	 * Prints the output.
	 *
	 * @param addressBooks
	 *            the address books
	 * @param uniqueContacts
	 *            the unique contacts
	 */
	private void printOutput(List<AddressBook> addressBooks, Set<ContactDetails> uniqueContacts) {
		logger.info("==OUTPUT==");
		for (ContactDetails c : uniqueContacts) {
			System.out.println(c.getName() + "\n");
		}
	}

}
