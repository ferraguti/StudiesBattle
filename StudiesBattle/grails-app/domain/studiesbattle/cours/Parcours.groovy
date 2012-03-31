package studiesbattle.cours

import studiesbattle.personne.Etudiant;

class Parcours {
	String nom
	List matieres, etudiants
	
	static hasManny = [matieres : Matiere, etudiants : Etudiant]

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
