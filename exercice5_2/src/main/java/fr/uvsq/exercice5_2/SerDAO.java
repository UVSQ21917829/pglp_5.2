package fr.uvsq.exercice5_2;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public  abstract class SerDAO <T>{
	
	//crud
	private  Statement statement = null;
	public abstract T create(T obj) throws IOException;
    public abstract T read(Integer id) throws ClassNotFoundException, IOException;
    public abstract T update(T obj) throws ClassNotFoundException, IOException;
    public abstract T delete(Integer id) throws IOException;
	
    

    

}
