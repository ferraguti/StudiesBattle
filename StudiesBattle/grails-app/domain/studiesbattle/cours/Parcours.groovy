package studiesbattle.cours

import java.util.List;

import studiesbattle.personne.Etudiant;

class Parcours {
	String nom
	List matieres, etudiantsInscrit
	
	static hasManny = [matieres : Matiere, etudiantsInscrit : Etudiant]

    static constraints = {
		nom blank: false, unique: true
		//matieres minSize: 1
    }
	
	Parcours(String nom){
		this.nom = nom
	}
	
	String toString(){
		return nom
	}
}
