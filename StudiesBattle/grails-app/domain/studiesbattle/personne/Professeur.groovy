package studiesbattle.personne

import studiesbattle.cours.Matiere;

class Professeur implements Personne{
	
	//doctorant
	
	static hasMany = [matieres : Matiere]

    static constraints = {
		matieres minSize: 1
    }
}
