package studiesbattle.personne

import org.example.User


class Personne extends User{
	String nom, prenom, email
	int numNational
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
	
	Personne(String username, String password, String nom, String prenom, String sexe, int num){
		this.username = username
		this.password = password
		this.nom = nom
		this.prenom = prenom
		this.sexe = sexe
		this.numNational = num
		this.email = prenom + "." + nom + "@studiesbattle.com"
		
		//temp.poster("Nick la police !", this)
		this.mur = new Mur(this)
	}
	
	String toString(){
		return (nom.toUpperCase() + " " + prenom)
	}
	
	
	void poster(String message, Personne cible){
		cible.mur.poster(message, this)
		
	}
}
