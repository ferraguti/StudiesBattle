package studiesbattle.personne

import java.util.List;

import studiesbattle.cours.Cours;
import studiesbattle.cours.Matiere;

class Professeur extends Personne{	
    static constraints = {
    }
	
	Professeur(String username, String password, String nom, String prenom, String sexe, int num) {
		super(username, password, nom, prenom, sexe, num)
	}
	
	//idées d'extension : type(doctorant, normal)
}