package studiesbattle.personne

import studiesbattle.cours.Matiere;

class Professeur extends Personne{
	
	//doctorant
	
	static hasMany = [matieres : Matiere]
	static belongsTo = Matiere

    static constraints = {
		//matieres minSize: 1
    }
}
