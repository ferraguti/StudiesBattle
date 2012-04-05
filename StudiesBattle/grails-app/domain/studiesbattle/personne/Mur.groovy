package studiesbattle.personne

import java.util.List;


class Mur {
	List posts
	
	static belongsTo = [proprietaire : Personne]
	
	void poster(String message, Personne auteur){
		posts.add(new String (auteur.toString() + " a écrit : \n" + message + "\n\n"))
	}
	
	String toString(){
		String res = new String("Mur de " + proprietaire)
		
		for(p in posts){
			res += p.toString()
		}
	}

    static constraints = {
    }
}
