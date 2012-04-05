
<%@ page import="studiesbattle.personne.Personne" %>
<!doctype html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'personne.label', default: 'Personne')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-personne" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-personne" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list personne">
			
				<g:if test="${personneInstance?.username}">
				<li class="fieldcontain">
					<span id="username-label" class="property-label"><g:message code="personne.username.label" default="Username" /></span>
					
						<span class="property-value" aria-labelledby="username-label"><g:fieldValue bean="${personneInstance}" field="username"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${personneInstance?.password}">
				<li class="fieldcontain">
					<span id="password-label" class="property-label"><g:message code="personne.password.label" default="Password" /></span>
					
						<span class="property-value" aria-labelledby="password-label"><g:fieldValue bean="${personneInstance}" field="password"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${personneInstance?.nom}">
				<li class="fieldcontain">
					<span id="nom-label" class="property-label"><g:message code="personne.nom.label" default="Nom" /></span>
					
						<span class="property-value" aria-labelledby="nom-label"><g:fieldValue bean="${personneInstance}" field="nom"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${personneInstance?.prenom}">
				<li class="fieldcontain">
					<span id="prenom-label" class="property-label"><g:message code="personne.prenom.label" default="Prenom" /></span>
					
						<span class="property-value" aria-labelledby="prenom-label"><g:fieldValue bean="${personneInstance}" field="prenom"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${personneInstance?.pseudo}">
				<li class="fieldcontain">
					<span id="pseudo-label" class="property-label"><g:message code="personne.pseudo.label" default="Pseudo" /></span>
					
						<span class="property-value" aria-labelledby="pseudo-label"><g:fieldValue bean="${personneInstance}" field="pseudo"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${personneInstance?.identifiant}">
				<li class="fieldcontain">
					<span id="identifiant-label" class="property-label"><g:message code="personne.identifiant.label" default="Identifiant" /></span>
					
						<span class="property-value" aria-labelledby="identifiant-label"><g:fieldValue bean="${personneInstance}" field="identifiant"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${personneInstance?.sexe}">
				<li class="fieldcontain">
					<span id="sexe-label" class="property-label"><g:message code="personne.sexe.label" default="Sexe" /></span>
					
						<span class="property-value" aria-labelledby="sexe-label"><g:fieldValue bean="${personneInstance}" field="sexe"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${personneInstance?.email}">
				<li class="fieldcontain">
					<span id="email-label" class="property-label"><g:message code="personne.email.label" default="Email" /></span>
					
						<span class="property-value" aria-labelledby="email-label"><g:fieldValue bean="${personneInstance}" field="email"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${personneInstance?.accountExpired}">
				<li class="fieldcontain">
					<span id="accountExpired-label" class="property-label"><g:message code="personne.accountExpired.label" default="Account Expired" /></span>
					
						<span class="property-value" aria-labelledby="accountExpired-label"><g:formatBoolean boolean="${personneInstance?.accountExpired}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${personneInstance?.accountLocked}">
				<li class="fieldcontain">
					<span id="accountLocked-label" class="property-label"><g:message code="personne.accountLocked.label" default="Account Locked" /></span>
					
						<span class="property-value" aria-labelledby="accountLocked-label"><g:formatBoolean boolean="${personneInstance?.accountLocked}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${personneInstance?.enabled}">
				<li class="fieldcontain">
					<span id="enabled-label" class="property-label"><g:message code="personne.enabled.label" default="Enabled" /></span>
					
						<span class="property-value" aria-labelledby="enabled-label"><g:formatBoolean boolean="${personneInstance?.enabled}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${personneInstance?.mur}">
				<li class="fieldcontain">
					<span id="mur-label" class="property-label"><g:message code="personne.mur.label" default="Mur" /></span>
					
						<span class="property-value" aria-labelledby="mur-label"><g:link controller="mur" action="show" id="${personneInstance?.mur?.id}">${personneInstance?.mur?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${personneInstance?.passwordExpired}">
				<li class="fieldcontain">
					<span id="passwordExpired-label" class="property-label"><g:message code="personne.passwordExpired.label" default="Password Expired" /></span>
					
						<span class="property-value" aria-labelledby="passwordExpired-label"><g:formatBoolean boolean="${personneInstance?.passwordExpired}" /></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form>
				<fieldset class="buttons">
					<g:hiddenField name="id" value="${personneInstance?.id}" />
					<g:link class="edit" action="edit" id="${personneInstance?.id}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
