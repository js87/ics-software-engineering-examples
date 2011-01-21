package edu.hawaii.contactdb.client;

import edu.hawaii.contactdb.db.Contact;
import edu.hawaii.contactdb.db.ContactDAO;

/**
 * A simple client that can store or retrieve contact objects.
 * @author Philip Johnson
 */
public class ContactClient {

  /**
   * Provide a way to store store or retrieve contact objects. 
   * @param args First arg is either "put" or "get".  If "put", next three args are Contact's
   * first name, last name, info, and unique ID. If "get", next arg is the unique ID.
   * @throws Exception If problems occur.
   */
  public static void main(String[] args) throws Exception {
    // Make sure we were at least passed the minimum number of arguments. 
    if (args.length < 2) {
      System.out.println("Usage: put <firstname> <lastname> <info> <uniqueID> ");
      System.out.println("       get <uniqueID>");
      return;
    }
    
    // Get the command and process it.
    String command = args[0];
    if ("put".equals(command)) {
      Contact contact = new Contact(args[1], args[2], args[3], args[4]);
      ContactDAO.putContact(contact);
      System.out.println("Contact stored in database.");
    }
    else if ("get".equals(command)) {
      Contact contact = ContactDAO.getContact(args[1]);
      if (contact == null) {
        System.out.println("No such contact with ID: " + args[1]);
      }
      else {
        System.out.println("Retrieved contact: " + contact.toString());
      }
    }
    else if ("delete".equals(command)) {
      ContactDAO.deleteContact(args[1]);
      System.out.println("Contact deleted.");
    }
  }
}
