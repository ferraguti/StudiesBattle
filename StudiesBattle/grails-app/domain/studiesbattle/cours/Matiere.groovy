package studiesbattle.cours

import java.util.List;

import studiesbattle.personne.Etudiant;
import studiesbattle.personne.Professeur;

class Matiere {
	String nom
	PageMatiere page
	List cours
	List professeurs

	static belongsTo = [parcours : Parcours]
	static hasMany = [cours : Cours, professeurs : Professeur]

    static constraints = {
		nom blank: false, unique: true
		page nullable: true
    }
	
	Matiere(String nom, Parcours parcours){
		this.nom = nom
		this.parcours = parcours
		page = new PageMatiere(matiere: this)
		
	}
	
	
	String toString(){
		return (nom + " (" + parcours + ")")
	}
}

