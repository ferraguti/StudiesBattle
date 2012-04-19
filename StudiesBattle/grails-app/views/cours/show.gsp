
<%@ page import="studiesbattle.cours.Cours" %>
<!doctype html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'cours.label', default: 'Cours')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-cours" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-cours" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list cours">
			
			<g:if test="${coursInstance?.matiere}">
				<li class="fieldcontain">
					<span id="matiere-label" class="property-label"><g:message code="cours.matiere.label" default="Matiere" /></span>
					
						<span class="property-value" aria-labelledby="matiere-label"><g:link controller="matiere" action="show" id="${coursInstance?.matiere?.id}">${coursInstance?.matiere?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
				
				<g:if test="${coursInstance?.nom}">
				<li class="fieldcontain">
					<span id="nom-label" class="property-label"><g:message code="cours.nom.label" default="Nom" /></span>
					
						<span class="property-value" aria-labelledby="nom-label"><g:fieldValue bean="${coursInstance}" field="nom"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${coursInstance?.heures}">
				<li class="fieldcontain">
					<span id="heures-label" class="property-label"><g:message code="cours.heures.label" default="Heures" /></span>
					
						<span class="property-value" aria-labelledby="heures-label"><g:fieldValue bean="${coursInstance}" field="heures"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${coursInstance?.coefficient}">
				<li class="fieldcontain">
					<span id="coefficient-label" class="property-label"><g:message code="cours.coefficient.label" default="Coefficient" /></span>
					
						<span class="property-value" aria-labelledby="coefficient-label"><g:fieldValue bean="${coursInstance}" field="coefficient"/></span>
					
				</li>
				</g:if>
				
				<g:if test="${coursInstance?.prof}">
				<li class="fieldcontain">
					<span id="prof-label" class="property-label"><g:message code="cours.prof.label" default="Prof" /></span>
					
						<span class="property-value" aria-labelledby="prof-label"><g:link controller="professeur" action="show" id="${coursInstance?.prof?.id}">${coursInstance?.prof?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${coursInstance?.etudiantsPresents}">
				<li class="fieldcontain">
					<span id="etudiantsPresents-label" class="property-label"><g:message code="cours.etudiantsPresents.label" default="Etudiants Presents" /></span>
					
						<g:each in="${coursInstance.etudiantsPresents}" var="e">
						<span class="property-value" aria-labelledby="etudiantsPresents-label"><g:link controller="etudiant" action="show" id="${e.id}">${e?.encodeAsHTML()}</g:link></span>
						</g:each>
					
				</li>
				</g:if>
			
			
			</ol>
			<g:form>
				<fieldset class="buttons">
					<g:hiddenField name="id" value="${coursInstance?.id}" />
					<g:link controller="cours" action="aller" id="${coursInstance?.id}">Aller a ce cours</g:link>
					<g:link class="edit" action="edit" id="${coursInstance?.id}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
