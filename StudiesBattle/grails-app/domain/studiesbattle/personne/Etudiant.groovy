package studiesbattle.personne

import studiesbattle.badge.Badge
import studiesbattle.cours.Parcours


class Etudiant extends Personne{
	int age, points
	Mur profil
	
	static belongsTo =  [parcours : Parcours]
	static hasMany = [badges : Badge]
    static constraints = {
    }
}
