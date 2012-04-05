package studiesbattle.cours

import java.util.List;

import studiesbattle.personne.Etudiant;
import studiesbattle.personne.Professeur;

class Matiere {
	String nom
	PageMatiere page
	List cours
	List professeurs
	//List etudiantsInscrit
	
	static belongsTo = [parcours : Parcours]
	static hasMany = [cours : Cours, professeurs : Professeur]//, etudiantsInscrit : Etudiant]

    static constraints = {
		nom blank: false, unique: true
		page nullable: true
    }
	
	Matiere(String nom, Parcours parcours){
		this.nom = nom
		this.parcours = parcours
		
		page = new PageMatiere(matiere: this)
		cours = new ArrayList<Cours>()
		professeurs = new ArrayList<Professeur>()
		
	}
	
	
	String toString(){
		return (nom + " (" + parcours + ")")
	}
}

