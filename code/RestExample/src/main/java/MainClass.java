import com.sun.jersey.api.container.httpserver.HttpServerFactory;
import com.sun.net.httpserver.HttpServer;

import javax.swing.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MainClass
{
    public static void main(String[] args) throws IOException, SQLException, ClassNotFoundException {
        HttpServer server = HttpServerFactory.create( "http://localhost:8080/rest" );
        server.start();
        JOptionPane.showMessageDialog( null, "Click OK to stop server" );
        server.stop( 0 );
    }
}
