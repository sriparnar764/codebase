package com.addressbook;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 * The Class AddressBookPersist.
 */
public class AddressBookPersist {

	/** The Constant logger. */
	private final static Logger logger = Logger.getLogger(AddressBookPersist.class.getName());

	/** The address books. */
	private List<AddressBook> addressBooks = new ArrayList();

	/**
	 * Adds the address book.
	 *
	 * @param addressbook
	 *            the addressbook
	 */
	public void addAddressBook(AddressBook addressbook) {
		addressBooks = new ArrayList<>();
		addressBooks.add(addressbook);
		storeAddressBooks(addressBooks);
	}

	/**
	 * Store address books.
	 *
	 * @param addressBooks
	 *            the address books
	 */
	public void storeAddressBooks(List<AddressBook> addressBooks) {
		try (BufferedWriter out = new BufferedWriter(new FileWriter("AddressBooks.txt", true))) {
			out.write(addressBooks.toString());
		} catch (IOException e) {
			logger.log(null, e.toString());
		}

	}

	/**
	 * Gets the address books.
	 *
	 * @return the address books
	 */
	public List<AddressBook> getAddressBooks() {
		return addressBooks;
	}

	/**
	 * Sets the address books.
	 *
	 * @param addressBooks
	 *            the new address books
	 */
	public void setAddressBooks(List<AddressBook> addressBooks) {
		this.addressBooks = addressBooks;
		storeAddressBooks(addressBooks);

	}

}