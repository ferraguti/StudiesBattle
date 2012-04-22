package studiesbattle.cours

import java.util.List;

import studiesbattle.personne.Etudiant;
import studiesbattle.personne.Professeur;

class Cours {
	
	String nom
	float heures = 2.0f
	float coefficient = 1.0f
	boolean termine = false
	Professeur prof
	List etudiantsPresents

	static belongsTo = [matiere : Matiere]
	static hasMany = [etudiantsPresents : Etudiant]
	

    static constraints = {
		nom blank: false
		heures min: 0.25f
		coefficient min: 0.0f
		prof nullable: true
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
	
	//idées d'extension : type (cours, td, tp), nbr élèves max
}
