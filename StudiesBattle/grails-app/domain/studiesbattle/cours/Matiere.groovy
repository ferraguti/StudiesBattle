package studiesbattle.cours

import java.util.List;

import studiesbattle.personne.Professeur;

class Matiere {
	String nom
	PageMatiere page
	List cours
	List professeurs

	static belongsTo = [parcours : Parcours]
	static hasMany = [cours : Cours, professeurs : Professeur]

    static constraints = {
		nom blank: false, unique: true
		page nullable: true
    }
	
	Matiere(String nom, Parcours parcours){
		this.nom = nom
		this.parcours = parcours
		this.page = new PageMatiere(matiere: this)
		//this.parcours.ajouterMatiere(this)
	}
	
	
	String toString(){
		return (nom + " (" + parcours + ")")
	}
	
	String getNom(){
		return nom
	}
	
	void ajouterProfesseur(Professeur prof){
		boolean existeDeja = false
		
		//On vérifie si le prof n'est pas déjà associé à cla matière
		for(p in professeurs){
			if(p.getNumNational() == prof.getNumNational())
				existeDeja = true
		}
		
		if(!existeDeja)
			this.professeurs.add(prof)
	}
}

