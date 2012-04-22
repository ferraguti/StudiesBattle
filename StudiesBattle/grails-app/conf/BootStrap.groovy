import org.example.Role
import studiesbattle.cours.Cours
import studiesbattle.cours.Matiere
import studiesbattle.cours.Parcours
import studiesbattle.personne.Etudiant
import studiesbattle.personne.Professeur

class BootStrap {

    def init = { servletContext ->
		
		if(!Parcours.count()){
			new Parcours(nom : "Informatique").save(failOnError: true)
			new Parcours(nom: "Biologie").save(failOnError: true)
			new Parcours(nom: "Chimie").save(failOnError: true)
		}
		
		if(!Matiere.count()){
			//new Matiere("JEE", Parcours.findByNom("Informatique")).save(failOnError: true)
			//new Matiere(parcours : Parcours.findByNom("Informatique"), nom: "JEE").save(failOnError: true)
//			new Matiere("IAWS",  Parcours.findByNom("Informatique")).save(failOnError: true)
//			new Matiere("AL",  Parcours.findByNom("Informatique")).save(failOnError: true)
//			new Matiere("MA",  Parcours.findByNom("Informatique")).save(failOnError: true)
//			new Matiere("Projet",  Parcours.findByNom("Informatique")).save(failOnError: true)
//			new Matiere("TER",  Parcours.findByNom("Informatique")).save(failOnError: true)
//			new Matiere("MCPOO",  Parcours.findByNom("Informatique")).save(failOnError: true)
//			new Matiere("DCLL",  Parcours.findByNom("Informatique")).save(failOnError: true)
		}
		
		if(!Role.count()){
			new Role(authority: "Administrateur").save(failOnError: true)
			new Role(authority: "Professeur").save(failOnError: true)
			new Role(authority: "Etudiant").save(failOnError: true)
		}
		
		if(!Professeur.count()){
			new Professeur("f_migeon", "1234", "Migeon", "Frederick", "M", 1).save(failOnError: true)
			new Professeur("jb_raclet", "1234", "Raclet", "JB", "M", 2).save(failOnError: true)
			new Professeur("l_pons", "1234",  "Pons", "Luc", "M", 3).save(failOnError: true)
		}
		
		if(!Etudiant.count()){
			new Etudiant("l_lebeau", "camilleriforever",  "Lebeau", "Julien", "M", 4, Parcours.findByNom("Informatique"), 23).save(failOnError: true)
			new Etudiant("w_ferraguti", "a",  "Ferraguti", "William", "M", 5, Parcours.findByNom("Informatique"), 21).save(failOnError: true)
			Etudiant.findByPrenom("William").setPoints(50)
		}
//		
//		if(!Cours.count()){
//			//new Cours("JSP", Matiere.findByNom("JEE"), Professeur.findByNom("Raclet")).save(failOnError: true)
//		}
//		
    }
	
	
    def destroy = {
    }
}


