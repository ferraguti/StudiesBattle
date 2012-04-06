import org.example.Role
import studiesbattle.cours.Matiere
import studiesbattle.cours.Parcours
import studiesbattle.personne.Etudiant

class BootStrap {

    def init = { servletContext ->
		
		if(!Parcours.count()){
			Parcours info = new Parcours("Informatique").save(failOnError: true)
			Parcours bio = new Parcours("Biologie").save(failOnError: true)
			Parcours chimie = new Parcours("Chimie").save(failOnError: true)
		}
		
		if(!Matiere.count()){
			//new Matiere(nom: 'JEE', parcours: info).save(failOnError: true)
		}
		
		if(!Role.count()){
			new Role(authority: "Administrateur").save(failOnError: true)
			new Role(authority: "Professeur").save(failOnError: true)
			new Role(authority: "Etudiant").save(failOnError: true)
		}
		
		if(!Etudiant.count()){
		}
		
    }
    def destroy = {
    }
}
