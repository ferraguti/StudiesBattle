package studiesbattle.personne

import java.util.List;

import studiesbattle.cours.Cours;
import studiesbattle.cours.Matiere;

class Professeur extends Personne{	
	//doctorant
	
	static belongsTo = [matiere : Matiere]

    static constraints = {
		//matieres minSize: 1
    }
	
	void donnerCours(Cours c){
		boolean inscritMatiere = false;
		def profs = c.matiere.professeurs
			
		for(p in profs){
			if(p.equals(this))
				inscritMatiere = true
		}
			
		if(inscritMatiere)
			c.donnerPoints()
		//else erreur cours d'une matiere qu'il n'a pas

	}
}