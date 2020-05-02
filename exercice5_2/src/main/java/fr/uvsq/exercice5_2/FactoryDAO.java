package fr.uvsq.exercice5_2;

public class FactoryDAO extends AbstractFactoryDAO{
	
	


	@Override
	public DAO<Personnel> getPersonneDAO() {
		// TODO Auto-generated method stub
		return new personnelDAO();

		
	}

	@Override
	public DAO<CompositePersonnels> getGroupeDAO() {
		// TODO Auto-generated method stub
		return new GroupeDAO();
		
	}

}
