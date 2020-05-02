package fr.uvsq.exercice5_2;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SerGroupeDAO extends DAO<CompositePersonnels> {
	
	public CompositePersonnels create(CompositePersonnels obj) throws IOException {
		// TODO Auto-generated method stub
		FileOutputStream fout = new FileOutputStream("groupe.ser") ;
    	ObjectOutputStream out = new ObjectOutputStream(fout) ;
    	out.writeObject(obj) ; 
    	out.close() ;
		return obj;
	}

	public CompositePersonnels read(Integer id) throws IOException, ClassNotFoundException {
		CompositePersonnels groupe;
		FileInputStream fileInput = new FileInputStream("groupe.ser");
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInput);
        
        groupe = (CompositePersonnels) objectInputStream.readObject();
  
		return groupe;
	}

	public CompositePersonnels update(CompositePersonnels obj) throws IOException {
		// TODO Auto-generated method stub
		
		FileOutputStream fout = new FileOutputStream("groupe.ser") ;
    	ObjectOutputStream out = new ObjectOutputStream(fout) ;
    	out.writeObject(obj) ; 
    	out.close() ;
		return obj;
	}

	public void delete(Integer id) {
		// TODO Auto-generated method stub
	}

}
