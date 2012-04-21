<!doctype html>
<html>
	<head>
		<meta name="layout" content="main"/>
		<title>Welcome to Grails</title>
		<style type="text/css" media="screen">
			#status {
				background-color: #eee;
				border: .2em solid #fff;
				margin: 2em 2em 1em;
				padding: 1em;
				width: 12em;
				float: left;
				-moz-box-shadow: 0px 0px 1.25em #ccc;
				-webkit-box-shadow: 0px 0px 1.25em #ccc;
				box-shadow: 0px 0px 1.25em #ccc;
				-moz-border-radius: 0.6em;
				-webkit-border-radius: 0.6em;
				border-radius: 0.6em;
			}

			.ie6 #status {
				display: inline; /* float double margin fix http://www.positioniseverything.net/explorer/doubled-margin.html */
			}

			#status ul {
				font-size: 0.9em;
				list-style-type: none;
				margin-bottom: 0.6em;
				padding: 0;
			}
            
			#status li {
				line-height: 1.3;
			}

			#status h1 {
				text-transform: uppercase;
				font-size: 1.1em;
				margin: 0 0 0.3em;
			}

			#page-body {
				margin: 2em 1em 1.25em 18em;
			}

			h2 {
				margin-top: 1em;
				margin-bottom: 0.3em;
				font-size: 1em;
			}

			p {
				line-height: 1.5;
				margin: 0.25em 0;
			}

			#controller-list ul {
				list-style-position: inside;
			}

			#controller-list li {
				line-height: 1.3;
				list-style-position: inside;
				margin: 0.25em 0;
			}

			@media screen and (max-width: 480px) {
				#status {
					display: none;
				}

				#page-body {
					margin: 0 1em 1em;
				}

				#page-body h1 {
					margin-top: 0;
				}
			}
		</style>
	</head>
	<body>
		<a href="#page-body" class="skip"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div id="status" role="complementary">
		
		<sec:ifNotLoggedIn>
		<h1>Inscription</h1>
		<p>Venez découvrir ce réseau social en vous inscrivant ou en vous loggant si vous possédez déjà un compte</p>
		
		<br><h1>Etudiant</h1><br>
		<g:link controller="Etudiant" action="create">Inscription</g:link><br><br>
		<g:link controller="Login">Se Connecter</g:link>
		<br>
		<br>
		<br><h1>Professeur</h1><br>
		<g:link controller="Professeur" action="create">Inscription</g:link><br><br>
		<g:link controller="Login">Se Connecter</g:link>
		
		</sec:ifNotLoggedIn>
		
		<sec:ifLoggedIn>
			Logger en temps que : <sec:username /> 
			<br>
			(cliquer <g:link controller="logout">ici</g:link> pour vous deconnecter)	
		</sec:ifLoggedIn>
			
		</div>
		<div id="page-body" role="main">
			<h1>Welcome !</h1>
			<p>Bienvenu sur Studies Battle, le reseau social de l'université Paul Sabatier. Vous trouverez ici les differents parcours proposés par l'université, ainsi que les cours et matières qu'elle dispense.
			Studies Battle vous permet, entre autre, de donner des cours si vous êtes professeur et de gagner des points en allant a ceux-ci si vous êtes étudiant.
			Ce réseau social offre aussi la possibilité d'intéragir avec toutes les personnes qui y sont inscrit, au travers de leur "mur".
			</p>

			<br><br>Espace Authentification :
			<br><g:link controller="login">- Login</g:link>
			<br><g:link controller="logout">- Logout</g:link>
			
			<br><br>Espace Personne :
			<br><g:link controller="etudiant">- Etudiant</g:link>
			<br><g:link controller="professeur">- Professeur</g:link>
			
			<br><br>Espace Enseignement :
			<br><g:link controller="parcours">- Parcours</g:link>
			<br><g:link controller="matiere">- Matiere</g:link>
			<br><g:link controller="cours">- Cours</g:link>
		</div>
	</body>
</html>
