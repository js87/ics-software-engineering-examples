package edu.hawaii.dateservice.server.resource.month;

import java.util.Calendar;
import java.util.Locale;
import org.restlet.resource.Get;
import org.restlet.resource.ServerResource;

/**
 * A server resource that will handle requests for the current year.
 * A new instance of this resource is created for each request. 
 * @author Philip Johnson
 */
public class MonthResource extends ServerResource {
  
  /**
   * Returns the year as of the time this request was received. 
   * @return The year as a text string. 
   */
  @Get
  public String getMonth() {
    Calendar currentDate = Calendar.getInstance(Locale.US);
    return String.valueOf(currentDate.get(Calendar.MONTH));
  }

}
