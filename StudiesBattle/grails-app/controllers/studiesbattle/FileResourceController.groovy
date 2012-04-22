package studiesbattle

//Controller qui gère l'upload de fichier. Download par encore supporté et pour l'instant toutes les matières partagent le même repertoire

class FileResourceController {
    
    def index = { redirect(action:list,params:params) }
	static transactional = true
    
    def allowedMethods = []

    def list = {
		def fileResourceInstanceList = []
		def f = new File( grailsApplication.config.images.location.toString() )
		if( f.exists() ){
			f.eachFile(){ file->
			if( !file.isDirectory() )
				fileResourceInstanceList.add( file.name )
			}
		}
        [ fileResourceInstanceList: fileResourceInstanceList ]
    }

    def delete = {
		def filename = params.id.replace('###', '.')
		def file = new File( grailsApplication.config.images.location.toString() + File.separatorChar +   filename )
		file.delete()
		flash.message = "Le fichier ${filename} a ete supprimer" 
		redirect( action:list )
    }

	def upload = {
		def f = request.getFile('fileUpload')
	    if(!f.empty) {
	      flash.message = 'Le fichier ${filename} a ete uploade avec succes'
		  new File( grailsApplication.config.images.location.toString() ).mkdirs()
		  f.transferTo( new File( grailsApplication.config.images.location.toString() + File.separatorChar + f.getOriginalFilename() ) )								             			     	
		}    
	    else {
	       flash.message = 'Le fichier ne peut etre vide'
	    }
		redirect( action:list)
	}
}
