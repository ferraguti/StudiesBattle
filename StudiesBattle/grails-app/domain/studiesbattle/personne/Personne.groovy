package studiesbattle.personne


interface Personne {
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
}
