// Contact.java
// Created by Jeremy Brown on 3/23/25
/**
 * Represents a contact with a unique ID, first name, last name, phone number, and address.
 * The contact ID is immutable and must be unique.
 */
public class Contact {
	private final String contactId;
	private String firstName;
	private String lastName;
	private String phone;
	private String address;
	
	/**
     * Constructs a new Contact object.
     * @param contactId Unique ID for the contact (max 10 characters, non-null, immutable).
     * @param firstName First name (max 10 characters, non-null).
     * @param lastName Last name (max 10 characters, non-null).
     * @param phone Phone number (exactly 10 digits, non-null).
     * @param address Address (max 30 characters, non-null).
     */
	public Contact(String contactId, String firstName, String lastName, String phone, String address) {
		//Check if all parameters are valid
		if (contactId == null || contactId.length() > 10) {
            throw new IllegalArgumentException("Invalid contact ID");
        }
        if (firstName == null || firstName.length() > 10) {
            throw new IllegalArgumentException("Invalid first name");
        }
        if (lastName == null || lastName.length() > 10) {
            throw new IllegalArgumentException("Invalid last name");
        }
        if (phone == null || !phone.matches("\\d{10}")) {
            throw new IllegalArgumentException("Invalid phone number");
        }
        if (address == null || address.length() > 30) {
            throw new IllegalArgumentException("Invalid address");
        }
        //Assign parameters to object
        this.contactId = contactId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.address = address;
	}
	
	public String getContactId() { return contactId; }	//Getter method for contactId
	
	public String getFirstName() { return firstName; }	//Getter method for firstName
	
	//Setter method for firstName
	public void setFirstName(String firstName) {
		//Check is firstName is a valid first name, if so assign to object
		if (firstName == null || firstName.length() > 10) {
			throw new IllegalArgumentException("Invalid first name");
		}
		this.firstName = firstName;
	}
	
	public String getLastName() { return lastName; }	//Getter method for lastName
    
	//Setter method for lastName
	public void setLastName(String lastName) {
		//Check if lastName is a valid last name, if so assign to object
        if (lastName == null || lastName.length() > 10) {
            throw new IllegalArgumentException("Invalid last name");
        }
        this.lastName = lastName;
    }

	public String getPhone() { return phone; }	//Getter method for phone
    
	//Setter method for phone
	public void setPhone(String phone) {
		//Check if phone is a valid phone number, if so assign to object
          if (phone == null || !phone.matches("\\d{10}")) {
            throw new IllegalArgumentException("Invalid phone number");
        }
        this.phone = phone;
    }

    public String getAddress() { return address; }	//Getter method for address
    //Setter method for address
    public void setAddress(String address) {
        //Check if address is a valid address, if so assign to object
    	if (address == null || address.length() > 30) {
            throw new IllegalArgumentException("Invalid address");
        }
        this.address = address;
    }
	
	
}
