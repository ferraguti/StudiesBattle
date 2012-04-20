package studiesbattle.cours


//PLUTOT UTILISER UN BOUTTON EXAM DANS MATIERE/SHOW

class Exam extends Cours{
	String nom
	boolean termine = false
	
	static belongsTo = [matiere : Matiere]

    static constraints = {
    }
	
	Exam(Matiere m, String nom){
		this.matiere = m
		this.nom = nom
	}
	

	String toString(){
		return nom  + " (Examen " + this.matiere + " )"
	}
	
	String valider(){
		def etudiants = Etudiant.findByParcours(matiere.getParcours())
		String res = new String("")
		
		for(e in etudiants)
			res += e + " a obtenu une note de " + e.passerExam(this) + "/20\n"
		
		return res
	}
}
