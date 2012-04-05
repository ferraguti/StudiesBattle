import studiesbattle.cours.Matiere
import studiesbattle.cours.Parcours

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
    }
    def destroy = {
    }
}
