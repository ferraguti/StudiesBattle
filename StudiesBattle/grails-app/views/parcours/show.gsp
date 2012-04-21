
<%@ page import="studiesbattle.cours.Parcours" %>
<!doctype html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'parcours.label', default: 'Parcours')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-parcours" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-parcours" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list parcours">
			
			<g:if test="${parcoursInstance?.nom}">
				<li class="fieldcontain">
					<span id="nom-label" class="property-label"><g:message code="parcours.nom.label" default="Nom" /></span>
					
						<span class="property-value" aria-labelledby="nom-label"><g:fieldValue bean="${parcoursInstance}" field="nom"/></span>
					
				</li>
				</g:if>
			
			
				<g:if test="${parcoursInstance?.matieres}">
				<li class="fieldcontain">
					<span id="matieres-label" class="property-label"><g:message code="parcours.matieres.label" default="Matieres" /></span>
					
						<g:each in="${parcoursInstance.matieres}" var="m">
						<span class="property-value" aria-labelledby="matieres-label"><g:link controller="matiere" action="show" id="${m.id}">${m?.encodeAsHTML()}</g:link></span>
						</g:each>
					
				</li>
				</g:if>
				
				<g:if test="${parcoursInstance?.etudiantsInscrit}">
				<li class="fieldcontain">
					<span id="etudiantsInscrit-label" class="property-label"><g:message code="parcours.etudiantsInscrit.label" default="Etudiants Inscrit" /></span>
					
						<g:each in="${parcoursInstance.etudiantsInscrit}" var="e">
						<span class="property-value" aria-labelledby="etudiantsInscrit-label"><g:link controller="etudiant" action="show" id="${e.id}">${e?.encodeAsHTML()}</g:link></span>
						</g:each>
					
				</li>
				</g:if>
			
			
			</ol>
			<g:form>
				<fieldset class="buttons">
					<g:hiddenField name="id" value="${parcoursInstance?.id}" />
					<g:link class="edit" action="edit" id="${parcoursInstance?.id}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
