package fr.uvsq.exercice5_2;

public class FactoryDAO extends AbstractFactoryDAO{
	
	


	@Override
	public DAO<Personnel> getPersonneDAO() {
		return new PersonnelDAO();

		
	}

	@Override
	public DAO<CompositePersonnels> getGroupeDAO() {
		return new GroupeDAO();
		
	}

}
