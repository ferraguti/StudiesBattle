package studiesbattle.cours

import studiesbattle.personne.Etudiant;
import studiesbattle.personne.Professeur;

class Matiere {
	String nom
	PageMatiere page
	
	static belongsTo = [parcours : Parcours]
	static hasMany = [professeurs : Professeur, cours : Cours, etudiantsInscrit : Etudiant]

    static constraints = {
		nom blank: false, unique: true
		professeur minSize: 1
		cours minSize: 1
    }
}
