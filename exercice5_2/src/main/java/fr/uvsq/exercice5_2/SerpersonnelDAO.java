package fr.uvsq.exercice5_2;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;


public class SerpersonnelDAO extends DAO<Personnel> {

	
	public Personnel create(Personnel personnel)  {
		// TODO Auto-generated method stub
		
		
		try (FileOutputStream fout = new FileOutputStream("personnel.txt") ;
    	ObjectOutputStream out = new ObjectOutputStream(fout);){
			out.writeObject(personnel) ; 
	    	out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
		return personnel;
	}

	public Personnel read(Integer id)   {
		// TODO Auto-generated method stub
		Personnel personnel=null;
		
		try(FileInputStream fileInput = new FileInputStream("personnel.txt");
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInput);) {
			 personnel = (Personnel) objectInputStream.readObject();
		        objectInputStream.close();
		} catch (IOException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
       
		return personnel;
	}

	public Personnel update(Personnel obj)   {
		// TODO Auto-generated method stub
		//Personnel personnel=read(obj.getId());
		
		
		try (FileOutputStream fin = new FileOutputStream("personnel.text") ;
				ObjectOutputStream intn = new ObjectOutputStream(fin);){
			intn.writeObject(obj) ; 
			intn.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return obj;
		
	
	}

	public void delete(Integer id)  {
		// TODO Auto-generated method stub
		
		try(FileOutputStream fout = new FileOutputStream("personnel.ser");
			ObjectOutputStream out = new ObjectOutputStream(fout) ;) {
			out.write(id);
	    	out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    		
    	
      ;
}

}
