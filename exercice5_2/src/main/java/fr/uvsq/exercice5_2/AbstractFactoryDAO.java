package fr.uvsq.exercice5_2;

public  abstract class AbstractFactoryDAO {
	public enum DaoType { Serialize, JDBC; }
	
	public abstract DAO<Personnel> getPersonneDAO ( ) ;
	public abstract DAO<CompositePersonnels> getGroupeDAO ( ) ;
	public static AbstractFactoryDAO getDAOFactory (DaoType type ) {
	if ( type == DaoType.Serialize) return new SerializeFactoryDAO ( ) ;
	if ( type == DaoType.JDBC) return new FactoryDAO ( ) ;
	return null ;
	}

}
