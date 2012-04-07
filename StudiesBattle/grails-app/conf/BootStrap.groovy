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
		

		
		if(!Role.count()){
			new Role(authority: "Administrateur").save(failOnError: true)
			new Role(authority: "Professeur").save(failOnError: true)
			new Role(authority: "Etudiant").save(failOnError: true)
		}
		
		if(!Professeur.count()){
			new Professeur("Fredou", "1234", "Migeon", "Frederick", "M", 1).save(failOnError: true)
			new Professeur("JBR", "1234", "Raclet", "JB", "M", 2).save(failOnError: true)
			new Professeur("Lucky", "1234",  "Pons", "Luc", "M", 3).save(failOnError: true)
		}
		
		if(!Cours.count()){
			//		//new Cours(nom: "name").save(failOnError: true)
			//		new Cours(nom: "name2", matiere: Matiere.findByNom("TER")).save(failOnError: true)
					//new Cours(nom: "XML", matiere: Matiere.findByNom("IAWS"), heure: 0.26, coefficient: 1, prof: Professeur.findByUsername("Fredi")).save(failOnError: true)
						//new Cours("name4", 1, 1, Matiere.findByNom("TER")).save(failOnError: true)
					}
		
    }
	
	
    def destroy = {
    }
}


