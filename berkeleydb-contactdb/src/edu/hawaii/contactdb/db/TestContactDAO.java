package edu.hawaii.contactdb.db;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import org.junit.Test;

/**
 * Simple unit test of the Contact data access object.
 * @author Philip Johnson
 */
public class TestContactDAO {
  
  /**
   * Test the DAO interface. 
   */
  @Test
  public void testContactDatabase() {
    String pmjID = "pmj";
    String dsID = "ds";
    Contact contact1 = new Contact("Philip", "Johnson", "Professor", pmjID);
    Contact contact2 = new Contact("Dan", "Suthers", "Professor", dsID);
    ContactDAO.putContact(contact1);
    ContactDAO.putContact(contact2);
    Contact contact1a = ContactDAO.getContact(pmjID);
    Contact contact2a = ContactDAO.getContact(dsID);
    assertEquals("Check contact1", contact1.toString(), contact1a.toString());
    assertEquals("Check contact2", contact2.toString(), contact2a.toString());
    ContactDAO.deleteContact(pmjID);
    assertNull("Check deletion", ContactDAO.getContact(pmjID));
  }
}
