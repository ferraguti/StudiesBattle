package studiesbattle.badge

//Inutilisť

class Badge {
	String nom

    static constraints = {
		nom blank: false, unique: true
    }
	
	String toString(){
		return nom
	}
}
