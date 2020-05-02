package fr.uvsq.exercice5_2;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public  abstract class JdbcDAO <T>{
	
	//crud
	protected Connection connection=null;
	String databaseURL = "jdbc:derby:my_db;create=true";
	private  Statement statement = null;
	public abstract T create(T obj) throws IOException;
    public abstract T read(Integer id) throws ClassNotFoundException, IOException;
    public abstract T update(T obj) throws ClassNotFoundException, IOException;
    public abstract T delete(Integer id) throws IOException;
	
    // la creation de la connexion avec un SGBD derby en mode embarqué
    public void createConnection() {
    	try
        {
            Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();
            //Get a connection
            connection = DriverManager.getConnection(databaseURL); 
        }
        catch (Exception except)
        {
            except.printStackTrace();
        }
    }
    
    //fermer la connection
    public  void closeConnexion()
    {
    	try
        {
            if (statement != null)
            {
            	statement.close();
            }
            if (connection != null)
            {
                DriverManager.getConnection(databaseURL + ";shutdown=true");
                connection.close();
            }           
        }
        catch (SQLException sqlExcept)
        {
            
        }

    }

}
