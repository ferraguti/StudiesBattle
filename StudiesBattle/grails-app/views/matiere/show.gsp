
<%@ page import="studiesbattle.cours.Matiere" %>
<!doctype html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'matiere.label', default: 'Matiere')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-matiere" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-matiere" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list matiere">
			
				<g:if test="${matiereInstance?.nom}">
				<li class="fieldcontain">
					<span id="nom-label" class="property-label"><g:message code="matiere.nom.label" default="Nom" /></span>
					
						<span class="property-value" aria-labelledby="nom-label"><g:fieldValue bean="${matiereInstance}" field="nom"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${matiereInstance?.page}">
				<li class="fieldcontain">
					<span id="page-label" class="property-label"><g:message code="matiere.page.label" default="Page" /></span>
					
						<span class="property-value" aria-labelledby="page-label"><g:link controller="pageMatiere" action="show" id="${matiereInstance?.page?.id}">${matiereInstance?.page?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${matiereInstance?.cours}">
				<li class="fieldcontain">
					<span id="cours-label" class="property-label"><g:message code="matiere.cours.label" default="Cours" /></span>
					
						<g:each in="${matiereInstance.cours}" var="c">
						<span class="property-value" aria-labelledby="cours-label"><g:link controller="cours" action="show" id="${c.id}">${c?.encodeAsHTML()}</g:link></span>
						</g:each>
					
				</li>
				</g:if>
			
				<g:if test="${matiereInstance?.parcours}">
				<li class="fieldcontain">
					<span id="parcours-label" class="property-label"><g:message code="matiere.parcours.label" default="Parcours" /></span>
					
						<span class="property-value" aria-labelledby="parcours-label"><g:link controller="parcours" action="show" id="${matiereInstance?.parcours?.id}">${matiereInstance?.parcours?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${matiereInstance?.professeurs}">
				<li class="fieldcontain">
					<span id="professeurs-label" class="property-label"><g:message code="matiere.professeurs.label" default="Professeurs" /></span>
					
						<g:each in="${matiereInstance.professeurs}" var="p">
						<span class="property-value" aria-labelledby="professeurs-label"><g:link controller="professeur" action="show" id="${p.id}">${p?.encodeAsHTML()}</g:link></span>
						</g:each>
					
				</li>
				</g:if>
				
			
			</ol>
			<g:form>
				<fieldset class="buttons">
					<g:hiddenField name="id" value="${matiereInstance?.id}" />
					<g:link class="edit" action="edit" id="${matiereInstance?.id}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
