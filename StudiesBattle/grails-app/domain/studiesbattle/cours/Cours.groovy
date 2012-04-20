package studiesbattle.cours

import java.util.List;

import studiesbattle.personne.Etudiant;
import studiesbattle.personne.Professeur;

class Cours {
	//tp, td, cours
	
	String nom
	float heures = 2.0f
	float coefficient = 1.0f//dans matière ?
	boolean termine = false
	Professeur prof
	List etudiantsPresents

	static belongsTo = [matiere : Matiere]
	static hasMany = [etudiantsPresents : Etudiant]
	
	//nbr max eleve

    static constraints = {
		nom blank: false
		heures min: 0.25f
		coefficient min: 0.0f
		prof nullable: true
    }
	
	static mapping = {
		etudiantsPresent ignoreNotfound : true
	}
	
	Cours(String nom, float heures, float coefficient, Matiere m, Professeur p) {
		this.nom = nom;
		this.heures = heures;
		this.coefficient = coefficient;
		this.matiere = m;
		this.prof = p
		this.etudiantsPresents = new ArrayList()
	}
	
	Cours(String nom, Matiere m, Professeur p) {
		this.nom = nom;
		this.matiere = m;
		this.prof = p
		this.etudiantsPresents = new ArrayList()
	}
	
	
//	void donnerPoints(){
//		for(e in etudiantsPresents)
//			e.gagnerPoints(coefficient * heures)
//			
//		
//	}
//	
	boolean estPresent(Etudiant etudiant){
		for(e in  etudiantsPresents){
			if(e.getUsername().equals(etudiant.getUsername()))
				return true
		}
		
		return false
	}

	String toString(){
		return (nom + " (" + matiere.nom + ")")
	}
}
