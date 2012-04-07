package studiesbattle.personne

import java.util.List;

import studiesbattle.cours.Cours;
import studiesbattle.cours.Matiere;

class Professeur extends Personne{	
	//doctorant
	

    static constraints = {
    }
	
	Professeur(String username, String password, String nom, String prenom, String sexe, int num) {
		super(username, password, nom, prenom, sexe, num)
		
		
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