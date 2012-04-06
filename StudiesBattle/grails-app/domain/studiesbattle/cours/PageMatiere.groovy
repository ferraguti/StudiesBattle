package studiesbattle.cours


class PageMatiere {
	//Documents
	String nom
	
	static belongsTo = [matiere : Matiere]
	
    static constraints = {
		nom nullable: true
    }
	
	PageMatiere(Matiere m){
		this.matiere = m
		nom = new String("Page de " + m.getNom())
	}
	
	String toString(){
		return "Page de " + matiere.getNom()
	}
}
