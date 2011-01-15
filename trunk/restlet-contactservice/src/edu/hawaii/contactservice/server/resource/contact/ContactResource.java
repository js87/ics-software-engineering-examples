package edu.hawaii.contactservice.server.resource.contact;

import org.restlet.data.Status;
import org.restlet.ext.xml.DomRepresentation;
import org.restlet.representation.Representation;
import org.restlet.resource.Get;
import org.restlet.resource.Put;
import org.restlet.resource.Delete;
import org.restlet.resource.ServerResource;
import edu.hawaii.contactservice.common.contact.Contact;
import edu.hawaii.contactservice.server.db.Contacts;

/**
 * A server resource that will handle requests regarding a specific Contact.
 * Supported operations: GET, PUT, and DELETE.
 * Supported representations: XML.
 * @author Philip Johnson
 */
public class ContactResource extends ServerResource {
  
  /**
   * Returns the Contact instance requested by the URL. 
   * @return The XML representation of the contact, or CLIENT_ERROR_NOT_FOUND if the 
   * unique ID is not present.
   * @throws Exception If problems occur making the representation. Shouldn't occur in 
   * practice but if it does, Restlet will set the Status code. 
   */
  @Get
  public Representation getContact() throws Exception {
    DomRepresentation result = new DomRepresentation();
    // Get the requested Contact ID from the URL.
    String uniqueID = (String)this.getRequestAttributes().get("uniqueID");
    // Look for it in the Contacts database.
    Contact contact = Contacts.getInstance().getContact(uniqueID);
    if (contact == null) {
      // It was not found, so set the status to indicate this.
      getResponse().setStatus(Status.CLIENT_ERROR_NOT_ACCEPTABLE);
    } 
    else {
      // It was found, so add the Contact's XML representation to the response.
      result.setDocument(contact.toXml());
      }
    return result;
  }
  
  /**
   * Adds the passed Contact to our internal database of Contacts.
   * @param representation The XML representation of the new Contact to add.
   * @return null.
   * @throws Exception If problems occur unpacking the representation.
   */
  @Put
  public Representation putContact(Representation representation) throws Exception {
    DomRepresentation domRepresentation = new DomRepresentation(representation);
    Contact contact = new Contact(domRepresentation.getDocument());
    Contacts.getInstance().addContact(contact);
    return null;
  }
  
  /**
   * Deletes the unique ID from the internal database. 
   * @return null.
   */
  @Delete
  public Representation deleteContact() {
    // Get the requested Contact ID from the URL.
    String uniqueID = (String)this.getRequestAttributes().get("uniqueID");
    // Make sure it is no longer present in the Contacts database. 
    Contacts.getInstance().deleteContact(uniqueID);
    return null;
  }
}
