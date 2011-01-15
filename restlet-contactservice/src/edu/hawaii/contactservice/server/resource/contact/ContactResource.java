package edu.hawaii.contactservice.server.resource.contact;

import org.restlet.resource.Get;
import org.restlet.resource.ServerResource;

/**
 * A server resource that will handle requests regarding a specific Contact.
 * Supported operations: GET, PUT, and DELETE.
 * Supported representations: XML.
 * @author Philip Johnson
 */
public class ContactResource extends ServerResource {
  
  /**
   * Returns the Contact instance requested given its unique ID. 
   * @return The 
   */
  @Get
  public String getContact() {
    String uniqueID = (String)this.getRequestAttributes().get("uniqueID");
    

    return null;
  }

}
