
<%@ page import="studiesbattle.personne.Mur" %>
<!doctype html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'mur.label', default: 'Mur')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-mur" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-mur" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list mur">
			
				
			
				<g:if test="${murInstance?.proprietaire}">
				<li class="fieldcontain">
					<span id="proprietaire-label" class="property-label"><g:message code="mur.proprietaire.label" default="Proprietaire" /></span>
					
						<span class="property-value" aria-labelledby="proprietaire-label"><g:link controller="personne" action="show" id="${murInstance?.proprietaire?.id}">${murInstance?.proprietaire?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
				
				<g:if test="${murInstance?.messages}">
				<li class="fieldcontain">
					<span id="messages-label" class="property-label"><g:message code="mur.messages.label" default="Messages" /></span>
					
						<g:each in="${murInstance.messages}" var="m">
						<span class="property-value" aria-labelledby="messages-label">${m?.encodeAsHTML()}</span>
						</g:each>
					
				</li>
				</g:if>
			
			</ol>
			<g:form>
				<fieldset class="buttons">
					<g:hiddenField name="id" value="${murInstance?.id}" />
					<sec:ifLoggedIn>
						<g:link controller="message" action="create" params="['mur.id': murInstance?.id]">Poster un message</g:link>
					</sec:ifLoggedIn>
					</fieldset>
			</g:form>
		</div>
	</body>
</html>
