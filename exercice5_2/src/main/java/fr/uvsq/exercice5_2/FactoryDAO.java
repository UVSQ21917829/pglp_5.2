package fr.uvsq.exercice5_2;

public class FactoryDAO {
	
	

    public static JdbcDAO<CompositePersonnels> getGroupeDAO(){

        return new GroupeDAO();
    }

    public static JdbcDAO<Personnel> getPersonnelDAO(){

        return new personnelDAO();
    }

}
