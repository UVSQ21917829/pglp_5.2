package fr.uvsq.exercice5_2;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;



public final class Personnel implements InterfacePersonnel, Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
    private String nom;
    private String prenom;
    private LocalDate dateNaissance;
    private String fonction;
    List<Integer> tels= new ArrayList<Integer>();
	public Personnel(Builder builder) {
		this.id = builder.id;
		this.nom = builder.nom;
		this.prenom = builder.prenom;
		this.dateNaissance = builder.dateNaissance;
		
	}
	
	
	
	public void print() {
		// TODO Auto-generated method stub
		System.out.print("id personnel:"+id);
		
	}
	public static class Builder{
		private int id;
	    private String nom;
	    private String prenom;
	    private LocalDate dateNaissance;
	    private String fonction;
	    List<Integer> tels= new ArrayList<Integer>();
	    public Builder(int id, String nom, String prenom, LocalDate dateNaissance) {
			this.id = id;
			this.nom = nom;
			this.prenom = prenom;
			this.dateNaissance = dateNaissance;
		}
       public Builder changer(LocalDate dateNaissance) {
    	   this.dateNaissance=dateNaissance;
    	   return this;
    	   
       }
       public Builder addFonction(String fn) {
   		
   		this.setFonction(fn);
   		return this;
   	}
   	public Builder addDateNumeroTelephone( List<Integer> tels2) {
   		this.tels.addAll(tels2);
   		
   		return this;
   		
   	}
       public Personnel build() {
    	   return new Personnel(this);
       }
	
	public void setFonction(String fonction) {
		this.fonction = fonction;
	}
       
	public String getFonction(String fonction) {
		return this.fonction;
	}
		
	}
	public String toString(){
		  
		  return " Personnel id : " + this.id;
	}



	public Integer getId() {
		return id;
	}



	public String getNom() {
		// TODO Auto-generated method stub
		return nom;
	}



	public String getPrenom() {
		return prenom;
	}



	public LocalDate getDateNaissance() {
		return dateNaissance;
	}

	public List<Integer> getTels() {
		return tels;
	}



	public void setNom(String nom) {
		this.nom = nom;
	}



	public String getFonction() {
		return fonction;
	}



	public void setFonction(String fonction) {
		this.fonction = fonction;
	}


}

