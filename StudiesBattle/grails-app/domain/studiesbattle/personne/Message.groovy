package studiesbattle.personne

class Message {
	String contenu
	Personne auteur //calcul� automatiquement en fonction de l'utilisateur logg�
	Mur mur
	
	static belongTo = [mur : Mur]

    static constraints = {
		contenu blank: true
		auteur nullable: true
    }
	
	Message(Mur mur, Personne auteur, String contenu) {
		this.contenu = contenu;
		this.auteur = auteur;
		this.mur = mur
	}

	String toString(){
		return (auteur.toString() + " a ecrit : \r\n" + contenu)
	}
}
