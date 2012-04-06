import org.example.Role
import studiesbattle.cours.Cours
import studiesbattle.cours.Matiere
import studiesbattle.cours.Parcours
import studiesbattle.personne.Professeur

class BootStrap {

    def init = { servletContext ->
		
		if(!Parcours.count()){
			new Parcours("Informatique").save(failOnError: true)
			new Parcours("Biologie").save(failOnError: true)
			new Parcours("Chimie").save(failOnError: true)
		}
		
		if(!Matiere.count()){
			new Matiere("JEE", Parcours.findByNom("Informatique")).save(failOnError: true)
			new Matiere("IAWS",  Parcours.findByNom("Informatique")).save(failOnError: true)
			new Matiere("AL",  Parcours.findByNom("Informatique")).save(failOnError: true)
			new Matiere("MA",  Parcours.findByNom("Informatique")).save(failOnError: true)
			new Matiere("Projet",  Parcours.findByNom("Informatique")).save(failOnError: true)
			new Matiere("TER",  Parcours.findByNom("Informatique")).save(failOnError: true)
			new Matiere("MCPOO",  Parcours.findByNom("Informatique")).save(failOnError: true)
			new Matiere("DCLL",  Parcours.findByNom("Informatique")).save(failOnError: true)
		}
		
		if(!Cours.count()){
//		//new Cours(nom: "name").save(failOnError: true)
//		new Cours(nom: "name2", matiere: Matiere.findByNom("TER")).save(failOnError: true)
//		new Cours(nom: "name3", matiere: Matiere.findByNom("TER"), heure: 0.26).save(failOnError: true)
//		new Cours(nom: "name4", matiere: Matiere.findByNom("TER"), heure: 1, coefficient: 1).save(failOnError: true)
		}
		
		if(!Role.count()){
			new Role(authority: "Administrateur").save(failOnError: true)
			new Role(authority: "Professeur").save(failOnError: true)
			new Role(authority: "Etudiant").save(failOnError: true)
		}
		
		if(!Professeur.count()){
			//new Professeur()
		}
		
    }
	
	
    def destroy = {
    }
}


