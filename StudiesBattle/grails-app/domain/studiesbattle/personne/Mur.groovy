package studiesbattle.personne

import java.util.List;
import java.util.ArrayList;


class Mur {
	List posts = new ArrayList()
	
	static belongsTo = [proprietaire : Personne]
	
	Mur(Personne proprio){
		this.proprietaire = proprio
		posts.add(new String("FUCK YOU"))
	}
	
	void poster(String message, Personne auteur){
		posts.add(new String (auteur.toString() + " a écrit : \n" + message + "\n\n"))
	}
	
	String toString(){
		return("Mur de " + proprietaire.toString())
	}
	
//	String toString(){
//		String res = new String("Mur de " + proprietaire)
//		
//		for(p in posts){
//			res += p.toString()
//		}
//	}

    static constraints = {
    }
	
	
}
