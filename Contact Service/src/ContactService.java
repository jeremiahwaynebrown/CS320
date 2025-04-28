// ContactService.java
// Created by Jeremy Brown on 3/23/25
import java.util.ArrayList;
import java.util.List;

/**
 * Manages a list of contacts, allowing addition, deletion, and updates.
 */
public class ContactService {
	private final List<Contact> contacts = new ArrayList<>();
	
	/**
     * Adds a new contact if the contact ID is unique.
     * @param contact The contact to add.
     * @throws IllegalArgumentException if the contact ID already exists.
     */
	public void addContact(Contact contact) {
		for (Contact c : contacts) {
			if (c.getContactId().equals(contact.getContactId())) {
				throw new IllegalArgumentException("Contact ID already exists");
			}
		}
		contacts.add(contact);
	}
	
	/**
     * Deletes a contact by its unique ID.
     * @param contactId The ID of the contact to remove.
     * @throws IllegalArgumentException if the contact ID does not exist.
     */
	public void deleteContact(String contactId) {
        Contact contactToRemove = null;
        for (Contact c : contacts) {
            if (c.getContactId().equals(contactId)) {
                contactToRemove = c;
                break;
            }
        }
        if (contactToRemove == null) {
            throw new IllegalArgumentException("Contact ID not found");
        }
        contacts.remove(contactToRemove);
    }
	
	/**
     * Updates the details of an existing contact.
     * @param contactId The ID of the contact to update.
     * @param firstName The new first name (optional, max 10 characters).
     * @param lastName The new last name (optional, max 10 characters).
     * @param phone The new phone number (must be exactly 10 digits).
     * @param address The new address (optional, max 30 characters).
     * @throws IllegalArgumentException if the contact ID is not found.
     */
	public void updateContact(String contactId, String firstName, String lastName, String phone, String address) {
        for (Contact c : contacts) {
            if (c.getContactId().equals(contactId)) {
                c.setFirstName(firstName);
                c.setLastName(lastName);
                c.setPhone(phone);
                c.setAddress(address);
                return;
            }
        }
        throw new IllegalArgumentException("Contact ID not found");
    }
	
	/**
     * Retrieves a contact by its ID.
     * @param contactId The unique ID of the contact.
     * @return The contact if found, or null otherwise.
     */
	public Contact getContact(String contactId) {
        for (Contact c : contacts) {
            if (c.getContactId().equals(contactId)) {
                return c;
            }
        }
        return null;
    }
}
