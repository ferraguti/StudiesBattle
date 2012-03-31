package studiesbattle.personne


class Personne {
	String nom, prenom, pseudo, email
	long id
	char sexe
	Mur mur
	
	//image

    static constraints = {
		nom blank: false
		prenom blank: false
		pseudo blank: false, nullable: true
		id unique: true, blank: false
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
