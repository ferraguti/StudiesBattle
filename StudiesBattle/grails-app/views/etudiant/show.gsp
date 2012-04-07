
<%@ page import="studiesbattle.personne.Etudiant" %>
<!doctype html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'etudiant.label', default: 'Etudiant')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-etudiant" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-etudiant" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list etudiant">
			
				<g:if test="${etudiantInstance?.username}">
				<li class="fieldcontain">
					<span id="username-label" class="property-label"><g:message code="etudiant.username.label" default="Username" /></span>
					
						<span class="property-value" aria-labelledby="username-label"><g:fieldValue bean="${etudiantInstance}" field="username"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${etudiantInstance?.password}">
				<li class="fieldcontain">
					<span id="password-label" class="property-label"><g:message code="etudiant.password.label" default="Password" /></span>
					
						<span class="property-value" aria-labelledby="password-label"><g:fieldValue bean="${etudiantInstance}" field="password"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${etudiantInstance?.nom}">
				<li class="fieldcontain">
					<span id="nom-label" class="property-label"><g:message code="etudiant.nom.label" default="Nom" /></span>
					
						<span class="property-value" aria-labelledby="nom-label"><g:fieldValue bean="${etudiantInstance}" field="nom"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${etudiantInstance?.prenom}">
				<li class="fieldcontain">
					<span id="prenom-label" class="property-label"><g:message code="etudiant.prenom.label" default="Prenom" /></span>
					
						<span class="property-value" aria-labelledby="prenom-label"><g:fieldValue bean="${etudiantInstance}" field="prenom"/></span>
					
				</li>
				</g:if>
			
			
				<g:if test="${etudiantInstance?.numNational}">
				<li class="fieldcontain">
					<span id="numNational-label" class="property-label"><g:message code="etudiant.numNational.label" default="Numero Etudiant" /></span>
					
						<span class="property-value" aria-labelledby="numNational-label"><g:fieldValue bean="${etudiantInstance}" field="numNational"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${etudiantInstance?.sexe}">
				<li class="fieldcontain">
					<span id="sexe-label" class="property-label"><g:message code="etudiant.sexe.label" default="Sexe" /></span>
					
						<span class="property-value" aria-labelledby="sexe-label"><g:fieldValue bean="${etudiantInstance}" field="sexe"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${etudiantInstance?.email}">
				<li class="fieldcontain">
					<span id="email-label" class="property-label"><g:message code="etudiant.email.label" default="Email" /></span>
					
						<span class="property-value" aria-labelledby="email-label"><g:fieldValue bean="${etudiantInstance}" field="email"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${etudiantInstance?.age}">
				<li class="fieldcontain">
					<span id="age-label" class="property-label"><g:message code="etudiant.age.label" default="Age" /></span>
					
						<span class="property-value" aria-labelledby="age-label"><g:fieldValue bean="${etudiantInstance}" field="age"/></span>
					
				</li>
				</g:if>
			
			
			
				<g:if test="${etudiantInstance?.badges}">
				<li class="fieldcontain">
					<span id="badges-label" class="property-label"><g:message code="etudiant.badges.label" default="Badges" /></span>
					
						<g:each in="${etudiantInstance.badges}" var="b">
						<span class="property-value" aria-labelledby="badges-label"><g:link controller="badge" action="show" id="${b.id}">${b?.encodeAsHTML()}</g:link></span>
						</g:each>
					
				</li>
				</g:if>
			

			
				<g:if test="${etudiantInstance?.mur}">
				<li class="fieldcontain">
					<span id="mur-label" class="property-label"><g:message code="etudiant.mur.label" default="Mur" /></span>
					
						<span class="property-value" aria-labelledby="mur-label"><g:link controller="mur" action="show" id="${etudiantInstance?.mur?.id}">${etudiantInstance?.mur?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${etudiantInstance?.parcours}">
				<li class="fieldcontain">
					<span id="parcours-label" class="property-label"><g:message code="etudiant.parcours.label" default="Parcours" /></span>
					
						<span class="property-value" aria-labelledby="parcours-label"><g:link controller="parcours" action="show" id="${etudiantInstance?.parcours?.id}">${etudiantInstance?.parcours?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
	
			
				<g:if test="${etudiantInstance?.points}">
				<li class="fieldcontain">
					<span id="points-label" class="property-label"><g:message code="etudiant.points.label" default="Points" /></span>
					
						<span class="property-value" aria-labelledby="points-label"><g:fieldValue bean="${etudiantInstance}" field="points"/></span>
					
				</li>
				</g:if>
			
			
			</ol>
			<g:form>
				<fieldset class="buttons">
					<g:hiddenField name="id" value="${etudiantInstance?.id}" />
					<g:link class="edit" action="edit" id="${etudiantInstance?.id}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
