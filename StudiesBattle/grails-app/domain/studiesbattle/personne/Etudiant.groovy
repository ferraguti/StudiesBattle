package studiesbattle.personne

import java.util.List;

import studiesbattle.badge.Badge
import studiesbattle.cours.Cours;
import studiesbattle.cours.Matiere;
import studiesbattle.cours.Parcours


class Etudiant extends Personne{
	int age
	float points = 0.0f
	Mur profil
	List badges, matieres
	//list cours aller/rater
	
	//static belongsTo = Matiere
	static hasMany = [matieres : Matiere, badges : Badge]
	
    static constraints = {
		age nullable: true, min: 13
    }
	
	/*void inscrireMatiere(Matiere m){
		
		if(!matieres.contains(m)){
			matieres.add(m)
			m.etudiantsInscrit.add(this)
		}
		//else erreur déja inscrit
	}*/
	
	void allerCours(Cours c){
		
		if(!c.etudiantsPresents.contains(this)){
			boolean inscritMatiere = false;
			
			for(m in matieres){
				if(m.equals(c.matiere))
					inscritMatiere = true
			}
			
			if(inscritMatiere)
				c.etudiantsPresents.add(this)
			//else erreur cours d'une matiere qu'il n'a pas
			
		}
		//else erreur déja present
	}
	
	void gagnerPoints(float x){
		points += x;
		//+badge
	}
}
