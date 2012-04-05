package studiesbattle.personne

import java.util.List;

import studiesbattle.cours.Cours;
import studiesbattle.cours.Matiere;

class Professeur extends Personne{
	List matieres
	
	//doctorant
	
	static hasMany = [matieres : Matiere]
	static belongsTo = Matiere

    static constraints = {
		//matieres minSize: 1
    }
	
	void donnerCours(Cours c){
		boolean inscritMatiere = false;
			
		for(m in matieres){
			if(m.equals(c.matiere))
				inscritMatiere = true
		}
			
		if(inscritMatiere)
			c.donnerPoints()
		//else erreur cours d'une matiere qu'il n'a pas

	}
}