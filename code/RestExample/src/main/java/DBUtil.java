import org.h2.jdbcx.JdbcConnectionPool;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DBUtil
{
    private static Connection conn;

    private static DBUtil instance;

    private DBUtil()
    {
        try
        {
            System.out.println("Setup DB...");
            DataSource ds = JdbcConnectionPool.create("jdbc:h2:mem:test;DB_CLOSE_DELAY=-1", "user", "password");
            conn = ds.getConnection();
            conn.createStatement().executeUpdate("CREATE TABLE movies(id INTEGER(20) PRIMARY KEY, title VARCHAR2(50), director VARCHAR2(50), genre VARCHAR2(100), year INTEGER(4) )");
            conn.commit();
            createBackToTheFuture();
            createLotR();
            createStarWars();
            createTerminator2();
            createHitchhikersGuide();
            System.out.println("Table created, 5 entries written");
        }
        catch(Exception e)
        {
            e.fillInStackTrace();
        }
    }

    public static DBUtil getInstance()
    {
        if(DBUtil.instance == null)
        {
            DBUtil.instance = new DBUtil();
        }
        return DBUtil.instance;
    }

   public List<Movie> getAllMovies()
   {
       List<Movie> result = new ArrayList<Movie>();
       try
       {
           ResultSet resultSet = conn.createStatement().executeQuery("SELECT * FROM movies ORDER BY id");
           while (resultSet.next())
           {
               Movie m = new Movie();
               m.setMovieId(resultSet.getLong("id"));
               m.setTitle(resultSet.getString("title"));
               m.setDirector(resultSet.getString("director"));
               m.setGenre(resultSet.getString("genre"));
               m.setYear(resultSet.getInt("year"));
               result.add(m);
           }
       }
       catch(SQLException e)
       {
           e.printStackTrace();
       }

       return result;
   }

   public Movie getMovieWithId(long id)
   {
       Movie result = null;
       try
       {
           ResultSet resultSet = conn.createStatement().executeQuery("SELECT * FROM movies WHERE id=" + id);
           while (resultSet.next())
           {
               Movie m = new Movie();
               m.setMovieId(resultSet.getLong("id"));
               m.setTitle(resultSet.getString("title"));
               m.setDirector(resultSet.getString("director"));
               m.setGenre(resultSet.getString("genre"));
               m.setYear(resultSet.getInt("year"));
               result = m;
           }
       }
       catch(SQLException e)
       {
           e.printStackTrace();
       }
       return result;
   }

    public void deleteMovieWithId(long id)
    {
        try
        {
            conn.createStatement().executeUpdate("DELETE FROM movies WHERE id='" + id + "'");
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }


    }

    public void createNewMovie(Movie movie)
    {
        try
        {
            conn.createStatement().executeUpdate("INSERT INTO movies VALUES(" + movie.getMovieId() + ", '" + movie.getTitle() + "','" + movie.getDirector() + "','" + movie.getGenre()+ "'," + movie.getYear() + ")");
            conn.commit();
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
    }

    private static void createBackToTheFuture()
   {
       Movie movie = new Movie();
       movie.setTitle("Back to the Future");
       movie.setDirector("Robert Zemeckis");
       movie.setGenre("Adventure, Comedy, Sci-Fi");
       movie.setYear(1985);
       try
       {
           conn.createStatement().executeUpdate("INSERT INTO movies VALUES(" + movie.getMovieId() + ", '" + movie.getTitle() + "','" + movie.getDirector() + "','" + movie.getGenre()+ "'," + movie.getYear() + ")");
           conn.commit();
       }
       catch(SQLException e)
       {
           e.printStackTrace();
       }
   }

   private static void createTerminator2()
   {
       Movie movie = new Movie();
       movie.setTitle("Terminator 2: Judgement Day");
       movie.setDirector("James Cameron");
       movie.setGenre("Action, Thriller, Sci-Fi");
       movie.setYear(1991);
       try
       {
           conn.createStatement().executeUpdate("INSERT INTO movies VALUES(" + movie.getMovieId() + ", '" + movie.getTitle() + "','" + movie.getDirector() + "','" + movie.getGenre()+ "'," + movie.getYear() + ")");
           conn.commit();
       }
       catch(SQLException e)
       {
           e.printStackTrace();
       }
   }

   private static void createLotR()
   {
       Movie movie = new Movie();
       movie.setTitle("Lord of the Rings: The Fellowship of the Ring");
       movie.setDirector("Peter Jackson");
       movie.setGenre("Adventure, Drama, Fantasy");
       movie.setYear(2001);
       try
       {
           conn.createStatement().executeUpdate("INSERT INTO movies VALUES(" + movie.getMovieId() + ", '" + movie.getTitle() + "','" + movie.getDirector() + "','" + movie.getGenre()+ "'," + movie.getYear() + ")");
           conn.commit();
       }
       catch(SQLException e)
       {
           e.printStackTrace();
       }
   }

   private static void createHitchhikersGuide()
   {
       Movie movie = new Movie();
       movie.setTitle("The Hitchhkers Guide to the Galaxy");
       movie.setDirector("Garth Jennings");
       movie.setGenre("Adventure, Comedy, Sci-Fi");
       movie.setYear(2005);
       try
       {
           conn.createStatement().executeUpdate("INSERT INTO movies VALUES(" + movie.getMovieId() + ", '" + movie.getTitle() + "','" + movie.getDirector() + "','" + movie.getGenre()+ "'," + movie.getYear() + ")");
           conn.commit();
       }
       catch(SQLException e)
       {
           e.printStackTrace();
       }
   }

   private static void createStarWars()
   {
       Movie movie = new Movie();
       movie.setTitle("Star Wars: Episode IV - A new Hope");
       movie.setDirector("George Lucas");
       movie.setGenre("Adventure, Action, Fantasy");
       movie.setYear(1977);
       try
       {
           conn.createStatement().executeUpdate("INSERT INTO movies VALUES(" + movie.getMovieId() + ", '" + movie.getTitle() + "','" + movie.getDirector() + "','" + movie.getGenre()+ "'," + movie.getYear() + ")");
           conn.commit();
       }
       catch(SQLException e)
       {
           e.printStackTrace();
       }
   }
}
