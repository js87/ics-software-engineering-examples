package edu.hawaii.dateservice.client;

import org.restlet.resource.ClientResource;
import org.restlet.resource.ResourceException;

/**
 * A simple example of a "client" class for the DateServer service. 
 * @author Philip Johnson
 */
public class DateClient {
  /**
   * Connect to a running DateService and get the requested date component.
   * @param args First arg is the host (such as "http://localhost:8112/") and the 
   * second arg is the requested resource (either "year", "month", or "day").
   * @throws Exception If problems occur.
   */
  public static void main(String[] args) throws Exception {
    // Make sure we were passed exactly two arguments. 
    if (args.length != 2) {
      System.out.println("Usage: <host> <resource>");
      System.out.println("Example host: http://localhost:8112");
      System.out.println("Resource must be one of: year, month, day");
      return;
    }
    // Figure out the URL we want to retrieve from the args. 
    String host = args[0];
    String contextRoot = "/dateserver/";
    String resource = args[1];
    String url = host + contextRoot + resource;
    // Now try to retrieve the URL.  The get() method will throw an exception if not successful.
    try {
      ClientResource client = new ClientResource(url);
      System.out.format("GET %s: %s%n", url, client.get().getText());
    }
    // If problems occur during retrieval, determine what happened and print it out.
    catch (ResourceException e) {
      int code = e.getStatus().getCode();
      String description = e.getStatus().getDescription();
      System.out.format("GET %s: Response %s: %s%n", url, code, description);
    }
  }
}

