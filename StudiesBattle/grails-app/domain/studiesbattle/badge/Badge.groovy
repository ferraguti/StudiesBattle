package studiesbattle.badge

//Inutilisé

class Badge {
	String nom

    static constraints = {
		nom blank: false, unique: true
    }
	
	String toString(){
		return nom
	}
}
