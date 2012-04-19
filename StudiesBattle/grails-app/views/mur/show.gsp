
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
				
				<g:if test="${murInstance?.posts}">
				<li class="fieldcontain">
					<span id="posts-label" class="property-label"><g:message code="mur.posts.label" default="posts" /></span>
					
						<g:each in="${murInstance.posts}" var="c">
						<span class="property-value" aria-labelledby="posts-label">${c.encodeAsHTML()}</span>
						</g:each>
					
				</li>
				</g:if>
			
			</ol>
			<g:form>
				<fieldset class="buttons">
					<g:hiddenField name="id" value="${murInstance?.id}" />
					<g:link class="edit" action="edit" id="${murInstance?.id}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
					<g:link controller="mur" action="poster" id="${murInstance?.id}">Nique la police</g:link>
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
