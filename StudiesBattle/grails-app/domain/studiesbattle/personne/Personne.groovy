package studiesbattle.personne

import org.example.User


class Personne extends User{
	String nom, prenom, email
	long numNational
	String sexe
	Mur mur
	
	//image

    static constraints = {
		nom blank: false
		prenom blank: false
		numNational unique: true, blank: false
		sexe inList: ["M", "F"], blank: false
		email email: true
		mur nullable: true
    }
	
	String toString(){
		return (nom.toUpperCase() + " " + prenom)
	}
	
	
	void poster(String message, Personne cible){
		cible.mur.poster(message, this)
		
	}
}
