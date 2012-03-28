package studiesbattle.cours

import studiesbattle.personne.Etudiant;

class Cours {
	//tp, td, cours
	
	String nom
	int heures
	float coefficient

	static belongsTo = [matiere : Matiere]
	static hasMany = [etudiantsPresents : Etudiant]
	
	//nbr max eleve

    static constraints = {
    }
}
