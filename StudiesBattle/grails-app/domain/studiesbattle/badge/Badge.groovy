package studiesbattle.badge

//Inutilis�

class Badge {
	String nom

    static constraints = {
		nom blank: false, unique: true
    }
	
	String toString(){
		return nom
	}
}
