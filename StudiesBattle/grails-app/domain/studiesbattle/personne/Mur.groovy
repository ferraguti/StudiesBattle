package studiesbattle.personne

import java.util.List;
import java.util.ArrayList;


class Mur {
	List<String> posts = new ArrayList<String>()
	
	static belongsTo = [proprietaire : Personne]
	
	Mur(Personne proprio){
		this.proprietaire = proprio
		posts = new ArrayList<String>()
		posts.add(new String("FUCK YOU"))
		posts.add(new String("FUCK YOU TOO"))
		
		System.out.println("MUR DE " + this.proprietaire)
	}
	
	void poster(String message, Personne auteur){
		posts.add(new String (auteur.toString() + " a écrit : \n" + message + "\n\n"))
	}
	
	void poster(String message, String auteurNom){
		posts.add(new String (auteurNom + " a écrit : \n" + message + "\n\n"))
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
