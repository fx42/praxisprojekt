/**
 * Created by felix on 18.02.17.
 */

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path( "message" )
public class MessageResource
{
    @GET
    @Produces( MediaType.TEXT_PLAIN )
    public String message()
    {
        return "Yea! ";
    }
}


