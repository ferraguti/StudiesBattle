package studiesbattle.personne

import java.util.List;

import studiesbattle.badge.Badge
import studiesbattle.cours.Cours;
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

	
	void gagnerPoints(Cours c){
		points += (c.getCoefficient() * c.getHeures());
		//+badge
	}
	
	float passerExam(){
		int note = Math.random() * 20
		
		while (note < 20 && points > 0){
			note += 1/50
			points -= 1
		}
		
		return note
	}
}
