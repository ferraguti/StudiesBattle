package studiesbattle.cours

import java.util.List;

import studiesbattle.personne.Etudiant;
import studiesbattle.personne.Professeur;

class Parcours {
	String nom
	List matieres = new ArrayList()
	List etudiantsInscrit = new ArrayList()
	
	static hasManny = [matieres : Matiere, etudiantsInscrit : Etudiant]
	
	static mapping = {
		matieres cascade:'all'
	}

    static constraints = {
    }
	
	Parcours(String nom){
		this.nom = nom
	}
	
	String toString(){
		return nom
	}
	
	void ajouterMatiere(Matiere mat){
		boolean existeDeja = false
		
		for(m in matieres){
			if(m.toString().equals(mat.toString()))
				existeDeja = true
		}
		
		if(!existeDeja)
			this.matieres.add(mat)
	}
	
	
}
