package studiesbattle.personne

import java.util.List;

import studiesbattle.badge.Badge
import studiesbattle.cours.Cours;
import studiesbattle.cours.Matiere;
import studiesbattle.cours.Parcours


class Etudiant extends Personne{
	int age
	float points = 0.0f
	List badges
	//list cours aller/rater
	
	static belongsTo = [parcours : Parcours]
	static hasMany = [badges : Badge]
	
    static constraints = {
		age nullable: true, min: 13
    }
	
	Etudiant(String username, String password, String nom, String prenom, String sexe, int num, Parcours parcours, int age){
		super(username, password, nom, prenom, sexe, num)
		
		this.parcours = parcours
		this.age = age
		this.email = prenom + "." + nom + "@" + parcours.nom + "-studiesbattle.com"
	}
	
	/*void inscrireMatiere(Matiere m){
		
		if(!matieres.contains(m)){
			matieres.add(m)
			m.etudiantsInscrit.add(this)
		}
		//else erreur déja inscrit
	}*/
	
	void allerCours(Cours c){ //on peut le faire dans le controller
		
		if(!c.getEtudiantsPresents().contains(this)){
//			boolean inscritMatiere = false;
//			
//			for(m in matieres){
//				if(m.equals(c.matiere))
//					inscritMatiere = true
//			}
			
			if(c.getMatiere().getParcours.getNom().equals(this.parcours))
				c.etudiantsPresents.add(this)
			//else erreur cours d'une matiere qu'il n'a pas
			
		}
		//else erreur déja present
	}
	
	void gagnerPoints(Cours c){
		points += (c.getCoefficient() * c.getHeures());
		//+badge
	}
}
