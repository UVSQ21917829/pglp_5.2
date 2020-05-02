package fr.uvsq.exercice5_2;


import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GroupeDAO extends JdbcDAO<CompositePersonnels> {
	
	public CompositePersonnels create(CompositePersonnels obj) throws IOException {
		// TODO Auto-generated method stub
		this.createConnection();
		
		try {
		PreparedStatement prepareGroup = this.connection.prepareStatement("INSERT INTO GROUPE (id) VALUES(?)");
		prepareGroup.setInt(1,obj.getId());
		prepareGroup.executeUpdate();
		this.closeConnexion();
		for (InterfacePersonnel composite : obj.listperso ) {
			
	        if (composite instanceof Personnel) {
	          personnelDAO pd= new personnelDAO();
	          pd.create((Personnel) composite);
	          this.createConnection();
	  		  PreparedStatement prepareEstDansPersonnal = this.connection.prepareStatement("INSERT INTO DANSPERSONNEL (id,id_p) VALUES(?,?)");
	  		  
	          prepareEstDansPersonnal.setInt(1, obj.getId());
	          prepareEstDansPersonnal.setInt(2, ((Personnel) composite).getId());
	          prepareEstDansPersonnal.executeUpdate();

	        } else if (obj.getId()!=((CompositePersonnels) composite).getId()&&composite instanceof CompositePersonnels ) {
	          this.create((CompositePersonnels) composite);
	          this.createConnection();
	          PreparedStatement prepareEstDansGroup = this.connection.prepareStatement("INSERT INTO DANSGROUP (id,id_g) VALUES(?,?)");

	          prepareEstDansGroup.setInt(1, obj.getId());
	          prepareEstDansGroup.setInt(2, ((CompositePersonnels) composite).getId());
	          
	          prepareEstDansGroup.executeUpdate();
	        }
	      
		}
	}catch (SQLException e) {
		// TODO: handle exception
		e.printStackTrace();
	}
	this.closeConnexion();
		
		return obj;
	}

	public CompositePersonnels read(Integer id) throws IOException, ClassNotFoundException {
		this.createConnection();
		CompositePersonnels gr=null;
		try {
			  PreparedStatement preapareGroupe =connection.prepareStatement("SELECT * FROM GROUPE  WHERE id = ?");
	          PreparedStatement estdansperso =this.connection.prepareStatement("SELECT id_p FROM DANSPERSONNEL  WHERE id = ?");  
	          PreparedStatement estdandgrop =this.connection.prepareStatement("SELECT id_g FROM DANSGROUPE  WHERE id =  ?");
	          preapareGroupe.setInt(1, id);
	          
		      ResultSet ressultGroupeObj = preapareGroupe.executeQuery();
		      while (ressultGroupeObj.next()) {
		    	  gr = new CompositePersonnels(ressultGroupeObj.getInt("id"));
		    	  //perso

		    	  estdansperso.setInt(1, id);
		    	  

		          ResultSet resPerso = estdansperso.executeQuery();
		          this.closeConnexion();
		          
		          while (resPerso.next()) {
		            personnelDAO pdao= new personnelDAO();
		            gr.addPersonnel((Personnel) pdao.read(resPerso.getInt("id_p")));
		          }
	             //groupe
		          estdandgrop.setInt(1, id);
		          
		         ResultSet resultGrp = estdandgrop.executeQuery();
		          while (resultGrp.next()) { 
		           gr.addPersonnel((CompositePersonnels) this.read(resultGrp.getInt("id")));
		        }
	      }

	    } catch (SQLException e) {
	      e.printStackTrace();
	    }

	    this.closeConnexion();

				
		return gr;
	}

	

	public void  delete(Integer id) {
		// TODO Auto-generated method stub
		
		try {
			PreparedStatement preparedeleteG =this.connection.prepareStatement("DELETE FROM GROUPE WHERE id= ?"); 
			
			preparedeleteG.setInt(1, id);
			preparedeleteG.executeUpdate();

			
		    } catch (SQLException e) {
		      e.printStackTrace();
		    }

		    this.closeConnexion();;
		
	}

	@Override
	public CompositePersonnels update(CompositePersonnels obj) throws ClassNotFoundException, IOException {
		// TODO Auto-generated method stub
		return null;
	}

}
