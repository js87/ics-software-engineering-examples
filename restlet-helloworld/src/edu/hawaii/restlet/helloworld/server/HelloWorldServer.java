package edu.hawaii.restlet.helloworld.server;

import org.restlet.Server;
import org.restlet.data.Protocol;
import org.restlet.resource.Get;
import org.restlet.resource.ServerResource;

/**
 * Implements a basic HTTP server for responding to time requests.
 * @author Philip Johnson
 */
public class HelloWorldServer extends ServerResource {
  
  /**
   * The main class which starts up the server on port 8182.
   * @param args Ignored.
   * @throws Exception If problems occur instantiating the server. 
   */
  public static void main(String[] args) throws Exception {
    new Server(Protocol.HTTP, 8182, HelloWorldServer.class).start();
  }

  /**
   * Temporary get method.
   * @return The string 'hello world'.
   */
  @Get
  public String toString() {
    return "hello, world";
  }

}
