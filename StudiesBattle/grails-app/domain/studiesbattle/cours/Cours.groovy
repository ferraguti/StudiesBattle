package studiesbattle.cours

import studiesbattle.personne.Etudiant;

class Cours {
	//tp, td, cours
	
	String nom
	float heures, coefficient

	static belongsTo = [matiere : Matiere]
	static hasMany = [etudiantsPresents : Etudiant]
	
	//nbr max eleve

    static constraints = {
		heures min: 0.25f
		coefficient min: 0.0f
    }
	
	String toString(){
		return (nom + " (" + matiere.nom + ")")
	}
}
