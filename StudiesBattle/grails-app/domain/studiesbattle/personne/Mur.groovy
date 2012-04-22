package studiesbattle.personne

import java.util.List;
import java.util.ArrayList;


class Mur {
	List messages //une list de string ne fonctionnait pas
	
	static belongsTo = [proprietaire : Personne]
	static hasMany = [messages : Message]
	
	static constraints = {
	}
	
	Mur(Personne proprio){
		this.proprietaire = proprio
	}
	
	
	String toString(){
		return("Mur de " + proprietaire.toString())
	}
	
}
