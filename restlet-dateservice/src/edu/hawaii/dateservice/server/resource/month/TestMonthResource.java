package edu.hawaii.dateservice.server.resource.month;

import static org.junit.Assert.assertEquals;
import java.util.Calendar;
import org.junit.BeforeClass;
import org.junit.Test;
import org.restlet.resource.ClientResource;
import edu.hawaii.dateservice.server.DateServer;

/**
 * Tests the operations supported for the DateServer month resource.
 * @author Philip Johnson
 */
public class TestMonthResource {

  /** The port used for testing. */
  private static int testPort = 8112;

  /**
   * Start up a test server before testing any of the operations on this resource.
   * @throws Exception If problems occur starting up the server. 
   */
  @BeforeClass
  public static void startServer () throws Exception {
    DateServer.runServer(testPort);
  }
  
  /**
   * Test the GET method of the month resource.
   * @throws Exception If problems occur. 
   */
  @Test
  public void testGet() throws Exception {
    // Try to retrieve the year from the DateServer.
    String testUrl = String.format("http://localhost:%s/dateserver/month", testPort);
    ClientResource client = new ClientResource(testUrl);
    String response = client.get().getText();
    // Now check to see if we got the right response. 
    String currMonth = String.valueOf(Calendar.getInstance().get(Calendar.MONTH));
    assertEquals("Testing month", currMonth, response);
  }
}
