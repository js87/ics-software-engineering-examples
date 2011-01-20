package edu.hawaii.simpleclient;

import org.wattdepot.client.WattDepotClient;

/**
 * Connects to a WattDepot server. 
 * @author Philip Johnson
 */
public class SimpleClient {
  
  /**
   * A main program that invokes a WattDepot client instance. 
   * @param args Ignored.
   */
  public static void main(String[] args) {
    String serverUri = "http://server.wattdepot.org:8182/wattdepot/";
    WattDepotClient client = new WattDepotClient(serverUri);
    System.out.println("Server is healthy: " + client.isHealthy());
  }
}
