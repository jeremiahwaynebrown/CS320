import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ContactServiceTest {
    private ContactService service;
    private Contact contact;

    @BeforeEach
    public void setup() {
        service = new ContactService();
        contact = new Contact("001", "Alice", "Smith", "1234567890", "123 Park Blvd");
        service.addContact(contact);
    }

    @Test
    public void testAddContactSuccess() {
        Contact newContact = new Contact("002", "Bob", "Jones", "0987654321", "456 Elm St");
        service.addContact(newContact);
        assertEquals(newContact, service.getContact("002"));
    }

    @Test
    public void testAddContactDuplicateIdFails() {
        Contact duplicate = new Contact("001", "Eve", "Brown", "1112223333", "789 Oak Dr");
        assertThrows(IllegalArgumentException.class, () -> service.addContact(duplicate));
    }

    @Test
    public void testDeleteContactSuccess() {
        service.deleteContact("001");
        assertNull(service.getContact("001"));
    }

    @Test
    public void testDeleteContactNotFoundFails() {
        assertThrows(IllegalArgumentException.class, () -> service.deleteContact("999"));
    }

    @Test
    public void testUpdateContactSuccess() {
        service.updateContact("001", "Anna", "Taylor", "2223334444", "987 Maple Ave");
        Contact updated = service.getContact("001");

        assertEquals("Anna", updated.getFirstName());
        assertEquals("Taylor", updated.getLastName());
        assertEquals("2223334444", updated.getPhone());
        assertEquals("987 Maple Ave", updated.getAddress());
    }

    @Test
    public void testUpdateContactNotFoundFails() {
        assertThrows(IllegalArgumentException.class, () -> {
            service.updateContact("999", "Test", "User", "0000000000", "No Where");
        });
    }
}