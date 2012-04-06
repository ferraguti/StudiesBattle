package studiesbattle.personne

import org.example.User


class Personne extends User{
	String nom, prenom, pseudo, email
	long numNational
	String sexe
	Mur mur = new Mur(proprietaire: this)
	
	//image

    static constraints = {
		nom blank: false
		prenom blank: false
		numNational unique: true, blank: false
		sexe inList: ["M", "F"], blank: false
		email email: true
		mur nullable: true
    }
	
	String getFullName(){
		return (nom.toUpperCase() + " " + prenom)
	}
	
//	String toString(){
//		if(pseudo.isEmpty())
//			return getFullName()
//		else
//			return pseudo
//	}
	
	void poster(String message, Personne cible){
		cible.mur.poster(message, this)
		
	}
}
