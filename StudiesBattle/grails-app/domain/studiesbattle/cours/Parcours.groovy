package studiesbattle.cours

import studiesbattle.personne.Etudiant;

class Parcours {
	String nom
	
	static hasManny = [matieres : Matiere, etudiants : Etudiant]

    static constraints = {
		nom blank: false, unique: true
		//matieres minSize: 1
    }
	
	String toString(){
		return nom
	}
}
