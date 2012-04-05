package studiesbattle.cours

import java.util.List;

import studiesbattle.personne.Etudiant;
import studiesbattle.personne.Professeur;

class Cours {
	//tp, td, cours
	
	String nom
	float heures, coefficient
	Professeur prof
	List etudiantsPresents

	static belongsTo = [matiere : Matiere]
	static hasMany = [etudiantsPresents : Etudiant]
	
	//nbr max eleve

    static constraints = {
		heures min: 0.25f
		coefficient min: 0.0f
    }
	
	Cours(String nom, float heures, float coefficient, Matiere m) {
		this.nom = nom;
		this.heures = heures;
		this.coefficient = coefficient;
		this.matiere = m;
	}
	
	void donnerPoints(){
		for(e in etudiantsPresents)
			e.gagnerPoints(coefficient * heures)
	}

	String toString(){
		return (nom + " (" + matiere.nom + ")")
	}
}
