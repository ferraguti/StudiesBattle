package studiesbattle.personne

import org.example.User


class Personne extends User{
	String nom, prenom, pseudo, email
	long identifiant
	String sexe
	Mur mur
	
	//image

    static constraints = {
		nom blank: false
		prenom blank: false
		pseudo blank: false, nullable: true
		identifiant unique: true, blank: false
		sexe inList: ["M", "F"]
		email email: true
    }
	
	String getFullName(){
		return (nom.toUpperCase() + " " + prenom)
	}
	
	String toString(){
		if(pseudo.isEmpty())
			return getFullName()
		else
			return pseudo
	}
	
	void poster(String message, Personne cible){
		//peut on poster sur son propre mur ?
		cible.mur.poster(message, this)
		
	}
}
