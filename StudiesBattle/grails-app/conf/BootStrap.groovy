import studiesbattle.cours.Cours
import studiesbattle.cours.Matiere
import studiesbattle.cours.Parcours

class BootStrap {

    def init = { servletContext ->
		
		if(!Parcours.count()){
			new Parcours("Informatique").save(failOnError: true)
			new Parcours("Biologie").save(failOnError: true)
			new Parcours("Chimie").save(failOnError: true)
		}
		
		if(!Matiere.count()){
			new Matiere(nom: "JEE", parcours: Parcours.findByNom("Informatique")).save(failOnError: true)
			new Matiere(nom: "IAWS", parcours: Parcours.findByNom("Informatique")).save(failOnError: true)
			new Matiere(nom: "AL", parcours: Parcours.findByNom("Informatique")).save(failOnError: true)
			new Matiere(nom: "MA", parcours: Parcours.findByNom("Informatique")).save(failOnError: true)
			new Matiere(nom: "Projet", parcours: Parcours.findByNom("Informatique")).save(failOnError: true)
			new Matiere(nom: "TER", parcours: Parcours.findByNom("Informatique")).save(failOnError: true)
			new Matiere(nom: "MCPOO", parcours: Parcours.findByNom("Informatique")).save(failOnError: true)
			new Matiere(nom: "DCLL", parcours: Parcours.findByNom("Informatique")).save(failOnError: true)
		}
		
		if(!Cours.count()){
		//	new Cours("XML", 2.0f, 1.0f, Matiere.findByNom("IAWS")).save(failOnError: true)
		}
    }
	
	
    def destroy = {
    }
}


