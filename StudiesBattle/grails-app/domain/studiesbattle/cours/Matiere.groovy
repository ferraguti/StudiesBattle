package studiesbattle.cours

import java.util.List;

import studiesbattle.personne.Etudiant;
import studiesbattle.personne.Professeur;

class Matiere {
	String nom
	PageMatiere page// = new PageMatiere(matiere: this)
	List cours
	List professeurs

	static belongsTo = [parcours : Parcours]
	static hasMany = [cours : Cours, professeurs : Professeur]

    static constraints = {
		nom blank: false, unique: true
		page nullable: true
    }
	
	
	String toString(){
		return (nom + " (" + parcours + ")")
	}
}

