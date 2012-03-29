package studiesbattle.personne

import studiesbattle.badge.Badge
import studiesbattle.cours.Parcours


class Etudiant implements Personne{
	int age, points = 0
	Mur profil
	
	static belongsTo =  [parcours : Parcours]
	static hasMany = [badges : Badge]
	
    static constraints = {
		age nullable: true, min: 13
    }
}
