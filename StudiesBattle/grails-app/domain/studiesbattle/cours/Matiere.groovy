package studiesbattle.cours

import java.util.List;

import studiesbattle.personne.Etudiant;
import studiesbattle.personne.Professeur;

class Matiere {
	String nom
	PageMatiere page
	List cours
	List professeurs
	//List etudiantsInscrit
	
	static belongsTo = [parcours : Parcours]
	static hasMany = [cours : Cours, professeurs : Professeur]//, etudiantsInscrit : Etudiant]

    static constraints = {
		nom blank: false, unique: true
		page nullable: true
		//professeur minSize: 1
		//cours minSize: 1
    }
	
	
	
	String toString(){
		return (nom + " (" + parcours + ")")
	}
}

