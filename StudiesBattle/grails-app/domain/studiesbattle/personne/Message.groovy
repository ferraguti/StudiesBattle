package studiesbattle.personne

class Message {
	String contenu
	Personne auteur
	Mur mur
	
	static belongTo = [mur : Mur]

    static constraints = {
		contenu blank: true
		auteur nullable: true
    }
	
//	Message(Mur m, Personne p){
//		this.mur = m
//		this.auteur = p
//		contenu 
//	}
	
	Message(Mur mur, Personne auteur, String contenu) {
		this.contenu = contenu;
		this.auteur = auteur;
		this.mur = mur
	}

	String toString(){
		return (auteur.toString() + " a ecrit : \r\n" + contenu)
	}
}
