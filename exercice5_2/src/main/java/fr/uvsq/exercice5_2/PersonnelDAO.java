package fr.uvsq.exercice5_2;

import java.io.IOException;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class PersonnelDAO extends DAO<Personnel> {

	
	public Personnel create(Personnel personnel) throws IOException {

		this.createConnection();
		try (PreparedStatement prepareTel = this.connection.prepareStatement("INSERT INTO TELS (id, tel) VALUES(?, ?)");
			PreparedStatement preparePers = this.connection.prepareStatement(
	                    	"INSERT INTO PERSONNEL (id,nom,prenom,datenaissance,fonction) VALUES(?, ?, ?, ?, ?)");)
		{
			//inserer le numero telephone
			
			for(Integer tel : personnel.getTels()) {
				prepareTel.setLong(1, personnel.getId());
				prepareTel.setInt(2, tel);
				prepareTel.executeUpdate();
			}
			//inserer personelle
			
			
			preparePers.setLong(1, personnel.getId());
			preparePers.setString(2,personnel.getNom() );
			preparePers.setString(3,personnel.getPrenom() );
			preparePers.setDate(4, Date.valueOf(personnel.getDateNaissance()));
			preparePers.setString(5,personnel.getFonction());
			preparePers.executeUpdate();
			
		}catch (SQLException e) {

		e.printStackTrace();}
		this.closeConnexion();
		return personnel;
	}

	public Personnel read(Integer id)  {
		// TODO Auto-generated method stub
		Personnel personnel=null;
	    this.createConnection();;
	    try (PreparedStatement preparePers = this.connection.prepareStatement("SELECT * FROM PERSONNEL  WHERE id = ?");
	          PreparedStatement prepareTel = this.connection.prepareStatement("SELECT * FROM TELS  WHERE id = ?"); ){ 
	    	  
	          preparePers.setInt(1, id);
	          prepareTel.setInt(1, id);
	          // liste des telephones
		      try(ResultSet resultTels = prepareTel.executeQuery();){
		      List<Integer> tels = new ArrayList<Integer>();
		        while (resultTels.next()) {
		          tels.add(resultTels.getInt("tel"));
		        }

	            //selection personnel
		        try(ResultSet resultPers = preparePers.executeQuery();){
		          if (resultPers.next()) {
		            personnel =new Personnel.Builder(resultPers.getInt("id"),
		                	resultPers.getString("nom"), resultPers.getString("prenom"), resultPers.getDate("datenaissance").toLocalDate())
		                    .addDateNumeroTelephone(tels).addFonction(resultPers.getString("fonction"))
		                    .build();
	              }
		        }
	          }
	    } catch (SQLException e) {
	      e.printStackTrace();
	    }

	    this.closeConnexion();;
	    return personnel;
	}

	public Personnel update(Personnel obj) throws ClassNotFoundException, IOException {
		// TODO Auto-generated method stub
		Personnel perseonnel=null;
		this.createConnection();
	    try(PreparedStatement udateStatemnt=this.connection.prepareStatement("UPDATE PERSONNEL SET fonction=? WHERE id=?");
        ) {
	    	
		    udateStatemnt.setString(1, obj.getFonction());
		    udateStatemnt.setInt(2, obj.getId());
		    udateStatemnt.executeUpdate();
		    perseonnel= this.read(obj.getId());
	    }catch (SQLException e) {
			// TODO: handle exception
	    	
		}
		 return perseonnel;
		
	
	}

	public void delete(Integer id) throws IOException {
		// TODO Auto-generated method stub
		this.createConnection();
	    try(PreparedStatement deletePers =this.connection.prepareStatement("DELETE FROM PERSONNEL  WHERE id = ?");)
	    {
	    	deletePers.setInt(1, id);

	    	deletePers.executeUpdate();
		} catch (SQLException e) {
				      e.printStackTrace();
		}
	    this.closeConnexion();
	}

}
