class UrlMappings {

	static mappings = {
		"/$controller/$action?/$id?"{
			constraints {
				// apply constraints here
			}
		}
		
		//Deux ligne ajoute pour spring security
		"/login/$action?"(controller: "login")
		"/logout/$action?"(controller: "logout")
		
		"/"(view:"/index")
		"500"(view:'/error')
	}
}
