package edu.hawaii.contactservice.server.resource.contact;

import static org.junit.Assert.assertEquals;
import java.util.Calendar;
import org.junit.BeforeClass;
import org.junit.Test;
import org.restlet.resource.ClientResource;
import edu.hawaii.contactservice.server.ContactServer;

/**
 * Tests the operations supported for the DateServer day resource.
 * @author Philip Johnson
 */
public class TestContactResource {

  /** The port used for testing. */
  private static int testPort = 8112;

  /**
   * Start up a test server before testing any of the operations on this resource.
   * @throws Exception If problems occur starting up the server. 
   */
  @BeforeClass
  public static void startServer () throws Exception {
    ContactServer.runServer(testPort);
  }
  
  /**
   * Test the GET method of the day resource.
   * @throws Exception If problems occur. 
   */
  @Test
  public void testGet() throws Exception {
    // Try to retrieve the year from the DateServer.
    String testUrl = String.format("http://localhost:%s/dateserver/day", testPort);
    ClientResource client = new ClientResource(testUrl);
    String response = client.get().getText();
    // Now check to see if we got the right response. 
    String currDay = String.valueOf(Calendar.getInstance().get(Calendar.DAY_OF_MONTH));
    assertEquals("Testing day", currDay, response);
  }
}
