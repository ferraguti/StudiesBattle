package studiesbattle.personne

import java.util.List;

import studiesbattle.cours.Cours;
import studiesbattle.cours.Parcours


class Etudiant extends Personne{
	int age
	float points = 0.0f
	//List badges //inutilisé
	
	static belongsTo = [parcours : Parcours]
	//static hasMany = [badges : Badge]
	
    static constraints = {
		age nullable: true, min: 13
    }
	
	Etudiant(String username, String password, String nom, String prenom, String sexe, int num, Parcours parcours, int age){
		super(username, password, nom, prenom, sexe, num)
		
		this.parcours = parcours
		this.age = age
		this.email = prenom + "." + nom + "@" + parcours.nom + "-studiesbattle.com"
		
		this.parcours.addToEtudiantsInscrit(this)
	}

	
	void gagnerPoints(Cours c){
		points += (c.getCoefficient() * c.getHeures());
		//+badge
	}
	
	//Donne une note aléatoire, mais l'améliore en consommant tous les points qu'il a
	float passerExam(){
		int note = Math.random() * 20
		
		while (note < 20 && points > 0){
			note += 1/50 //50 points permet d'améliorer la note de 1/20
			points -= 1
		}
		
		return note
	}
}
