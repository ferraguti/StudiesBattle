
<%@ page import="studiesbattle.personne.Message" %>
<!doctype html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'message.label', default: 'Message')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-message" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-message" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list message">
			
				<g:if test="${messageInstance?.contenu}">
				<li class="fieldcontain">
					<span id="contenu-label" class="property-label"><g:message code="message.contenu.label" default="Contenu" /></span>
					
						<span class="property-value" aria-labelledby="contenu-label"><g:fieldValue bean="${messageInstance}" field="contenu"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${messageInstance?.auteur}">
				<li class="fieldcontain">
					<span id="auteur-label" class="property-label"><g:message code="message.auteur.label" default="Auteur" /></span>
					
					<span class="property-value" aria-labelledby="auteur-label"><g:fieldValue bean="${messageInstance}" field="auteur"/></span>
					
						
					
				</li>
				</g:if>
			
				<g:if test="${messageInstance?.mur}">
				<li class="fieldcontain">
					<span id="mur-label" class="property-label"><g:message code="message.mur.label" default="Mur" /></span>
					
						<span class="property-value" aria-labelledby="mur-label"><g:link controller="mur" action="show" id="${messageInstance?.mur?.id}">${messageInstance?.mur?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
			</ol>
		</div>
	</body>
</html>
