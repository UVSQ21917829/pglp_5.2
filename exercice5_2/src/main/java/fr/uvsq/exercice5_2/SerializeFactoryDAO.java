package fr.uvsq.exercice5_2;

public class SerializeFactoryDAO extends AbstractFactoryDAO {
	
	public static SerDAO<CompositePersonnels> getGroupeDAO(){

        return new SerGroupeDAO();
    }

    public static SerDAO<Personnel> getPersonnelDAO(){

        return new SerpersonnelDAO();
    }

}
