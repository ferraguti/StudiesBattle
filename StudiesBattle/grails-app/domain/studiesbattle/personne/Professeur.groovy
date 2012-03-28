package studiesbattle.personne

import studiesbattle.cours.Matiere;

class Professeur extends Personne{
	//doctorant
	
	static hasMany = [matieres : Matiere]

    static constraints = {
    }
}
