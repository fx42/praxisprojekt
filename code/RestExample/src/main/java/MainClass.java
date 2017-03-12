import org.glassfish.jersey.jdkhttp.JdkHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.sql.SQLException;

public class MainClass
{
    public static void main(String[] args) throws IOException, SQLException, ClassNotFoundException, URISyntaxException
    {
        ResourceConfig rc = new ResourceConfig(MovieController.class);
        JdkHttpServerFactory.createHttpServer(new URI("http://localhost:8080/rest"), rc);
    }
}
