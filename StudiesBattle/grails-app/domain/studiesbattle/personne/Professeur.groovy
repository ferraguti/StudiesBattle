package studiesbattle.personne

import java.util.List;


class Professeur extends Personne{	
    static constraints = {
    }
	
	Professeur(String username, String password, String nom, String prenom, String sexe, int num) {
		super(username, password, nom, prenom, sexe, num)
	}
	
	//id�es d'extension : type(doctorant, normal)
}