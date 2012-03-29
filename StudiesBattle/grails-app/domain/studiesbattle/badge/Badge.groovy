package studiesbattle.badge

class Badge {
	String nom

    static constraints = {
		nom blank: false, unique: true
    }
}
