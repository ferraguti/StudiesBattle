package studiesbattle.cours

//Inutilisé
//Controller qui gère l'upload et le download de fichier

class pageMatiereController {
    
    def index = { redirect(action:list,params:params) }
	static transactional = true
    
    def allowedMethods = []

    def list = {
		def pageMatiereInstanceList = []
		def f = new File(".\\files")
		
		if( f.exists() ){
			f.eachFile(){ file->
			if( !file.isDirectory() )
				pageMatiereInstanceList.add( file.name )
			}
		}
        [ pageMatiereInstanceList: pageMatiereInstanceList ]
    }

    def delete = {
		def filename = params.id.replace('###', '.')
		def file = new File( "./" + File.separatorChar +   filename )
		file.delete()
		flash.message = "file ${filename} removed" 
		redirect( action:list )
    }

	def upload = {
		def f = request.getFile('myFile')
		
	    if(!f.empty) {
	      flash.message = 'Votre fichier a ete uploade avec succes'
		  new File("./"  + File.separatorChar + f.getOriginalFilename() )						             			     	
		}    
	    else {
	       flash.message = 'file cannot be empty'
	    }
		
		redirect(action:list)
	}
}
