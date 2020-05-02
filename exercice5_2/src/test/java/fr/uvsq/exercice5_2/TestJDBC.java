package fr.uvsq.exercice5_2;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;



public class TestJDBC {

	public static Connection connection = null;
	public static Statement statement = null;
	static File db;
	public final static String type = "SGBD";
	@Before
	public void initialization() {

		   db = new File("my_db");
		    try {
		      try {
				Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		      connection = DriverManager.getConnection("jdbc:derby:my_db;create=true");
		      statement = connection.createStatement();

		     /* String tablePersennel ="CREATE TABLE  PERSONNEL (id int PRIMARY KEY NOT NULL,nom varchar(50) , prenom  varchar(50), datenaissance DATE,fonction varchar(50))";
		      statement.execute(tablePersennel);
		      String tableTel ="CREATE TABLE  TELS (id int, tel int, PRIMARY KEY(id, tel), FOREIGN KEY(id) REFERENCES PERSONNEL(id) )";
		      statement.execute(tableTel);
		      String tableGroupe = "CREATE TABLE  GROUPE ( id int PRIMARY KEY NOT NULL)";
		      statement.execute(tableGroupe);
		      String tableDansPers ="CREATE TABLE DANSPERSONNEL(id int, id_p int, PRIMARY KEY(id,id_p), FOREIGN KEY (id) REFERENCES GROUPE(id), FOREIGN KEY (id_p) REFERENCES PERSONNEL(id) )";
		      statement.execute(tableDansPers);
		      String tableDansGrp ="CREATE TABLE DANSGROUPE(id int, id_g int, PRIMARY KEY(id,id_g), FOREIGN KEY (id) REFERENCES GROUPE(id), FOREIGN KEY (id_g) REFERENCES GROUPE(id) )";
		      statement.execute(tableDansGrp);*/
		      connection.close();
		    } catch (SQLException e) {
		      e.printStackTrace();
		      try {
		        connection.close();
		      } catch (SQLException ex) {
		        ex.printStackTrace();
		      }
		    }
		  
		
	}
	@Test
	public void testCreateFindPersonnelDao() throws IOException, ClassNotFoundException {
		List<Integer> tels = new ArrayList<Integer>();
		personnelDAO perDAO = new personnelDAO();
		tels.add(456789328);
		tels.add(655638644);
		Personnel p1= new Personnel.Builder(12, "aa", "jj",LocalDate.parse("1997-08-01",DateTimeFormatter.ISO_DATE)).addDateNumeroTelephone(tels).addFonction("developer").build();
		perDAO.create(p1);
		Personnel p2=perDAO.read(p1.getId());
		assertNotNull(p2);
		System.out.println(p2.getTels());
		
	}
	

}
