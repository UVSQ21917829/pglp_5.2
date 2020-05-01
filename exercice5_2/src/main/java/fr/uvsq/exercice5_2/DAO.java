package fr.uvsq.exercice5_2;

import java.io.IOException;

public interface DAO <T>{
	//crud
	public T create(T obj) throws IOException;
    public T read(Integer id) throws ClassNotFoundException, IOException;
    public T update(T obj) throws ClassNotFoundException, IOException;
    public T delete(Integer id) throws IOException;
	

}
