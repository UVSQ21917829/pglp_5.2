package fr.uvsq.exercice5_2;

import java.io.Serializable;
import java.util.ArrayList;

@SuppressWarnings("serial")
public class AffichageParGroup implements Serializable {
    
public ArrayList<InterfacePersonnel> list =new ArrayList<InterfacePersonnel>();

	public AffichageParGroup (InterfacePersonnel interfacePersonnel) {
		list.add(interfacePersonnel);
	}
 
   public void afficheGroupe() {
	   
   }
	
	private class GroupIterator implements Iterator{
        
		public GroupIterator() {
			int verifier=0;
			while(verifier<list.size()) {
				if(list.get(verifier) instanceof CompositePersonnels) {
					CompositePersonnels test=(CompositePersonnels)list.get(verifier);
					int i=0;
					while(i<test.listperso.size()) {
						list.add(test.listperso.get(i));
						i++;
					}
					
				
				}
				verifier++;
			}
		}
		private int index;
		public boolean hasNext() {
			
			if(index<list.size()) {
				return true;
			}
			return false;
		}

		public InterfacePersonnel next() {
			// TODO Auto-generated method stub
			if(this.hasNext()) {
				index++;
				return list.get(index-1);
			}
				
			return null;
		}
		
	}
	
	public Iterator getIterator() {
		return new GroupIterator();
		
	}

}
