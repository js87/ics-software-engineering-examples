package edu.hawaii.contactservice.server.db;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import edu.hawaii.contactservice.common.contact.Contact;

/**
 * Holds an in-memory representation of all Contacts present in this service. 
 * There is no persistency, so the Contacts disappear when this service ceases execution.
 * @author Philip Johnson
 */
public class Contacts implements Iterable<Contact> {
  /** Holds a map from unique IDs to the corresponding Contact instance. */
  private Map<String, Contact> uniqueID2Contact = new HashMap<String, Contact>();
  
  /** Create the singleton instance of this Contacts at class definition time. */
  private static Contacts theInstance = new Contacts();
  
  /** Ensure no clients can create an instance of this class. */
  private Contacts() {
    // do nothing. 
  }
  
  /** 
   * Return the single instance of this Contacts.
   * @return The Contacts instance. 
   */
  public static Contacts getInstance() {
    return theInstance;
  }
  
  /**
   * Add a new contact to our repository.
   * Note that if a contact with the same unique ID is already present, it is overridden. 
   * @param contact The contact to be added.
   */
  public void addContact(Contact contact) {
    uniqueID2Contact.put(contact.getUniqueID(), contact);
  }
  
  /**
   * Returns the Contact instance associated with uniqueID if one is present, or null if not 
   * found.
   * @param uniqueID The uniqueID to search for. 
   * @return The Contact instance or null.
   */
  public Contact getContact(String uniqueID) {
    return uniqueID2Contact.get(uniqueID);
  }


  /**
   * Return an iterator over the Contact instances in this collection. This enables the 
   * use of Contacts in for-each loops.
   */
  @Override
  public Iterator<Contact> iterator() {
    return uniqueID2Contact.values().iterator();
  }
  
  
  
  
  
  
  
  
  
  
  

}
