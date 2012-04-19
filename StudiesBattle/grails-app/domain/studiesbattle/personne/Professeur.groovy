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
		
		ArrayList<Professeur> profs = c.getMatiere().getProfesseurs()
			
		for(p in profs){
			if(p.getNumNational() == this.numNational)
				inscritMatiere = true
		}
			
		if(inscritMatiere)
			c.donnerPoints()
		//else erreur cours d'une matiere qu'il n'a pas

	}


}