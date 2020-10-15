package com.addressbook;

import java.io.Serializable;

/**
 * The Class ContactDetails.
 */
public class ContactDetails implements Comparable<ContactDetails>, Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The name. */
	private String name;

	/** The ph number. */
	private String phNumber;

	/**
	 * Instantiates a new contact details.
	 *
	 * @param name
	 *            the name
	 * @param phNumber
	 *            the ph number
	 */
	public ContactDetails(String name, String phNumber) {
		this.name = name;
		this.phNumber = phNumber;
	}

	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the name.
	 *
	 * @param name
	 *            the new name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Gets the ph number.
	 *
	 * @return the ph number
	 */
	public String getPhNumber() {
		return phNumber;
	}

	/**
	 * Sets the ph number.
	 *
	 * @param phNumber
	 *            the new ph number
	 */
	public void setPhNumber(String phNumber) {
		this.phNumber = phNumber;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return name + "-" + phNumber;
	}

	/*
	 * 
	 * 
	 * compareTo to sort objects by name
	 */
	@Override
	public int compareTo(ContactDetails o) {

		return this.name.compareTo(o.name);
	}

	/*
	 * 
	 * 
	 * Overriding Equals Method
	 */
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof ContactDetails) {
			ContactDetails contact = (ContactDetails) obj;
			return (name.equals(contact.getName()) && phNumber.equals(contact.getPhNumber()));
		}

		return false;
	}

	/*
	 * 
	 * 
	 * Overriding hashCode() Method
	 */
	@Override
	public int hashCode() {
		return (name.length() + phNumber.length());
	}

}
