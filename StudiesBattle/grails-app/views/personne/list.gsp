
<%@ page import="studiesbattle.personne.Personne" %>
<!doctype html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'personne.label', default: 'Personne')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-personne" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-personne" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
				<thead>
					<tr>
					
						<g:sortableColumn property="username" title="${message(code: 'personne.username.label', default: 'Username')}" />
					
						<g:sortableColumn property="password" title="${message(code: 'personne.password.label', default: 'Password')}" />
					
						<g:sortableColumn property="nom" title="${message(code: 'personne.nom.label', default: 'Nom')}" />
					
						<g:sortableColumn property="prenom" title="${message(code: 'personne.prenom.label', default: 'Prenom')}" />
					
						<g:sortableColumn property="pseudo" title="${message(code: 'personne.pseudo.label', default: 'Pseudo')}" />
					
						<g:sortableColumn property="identifiant" title="${message(code: 'personne.identifiant.label', default: 'Identifiant')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${personneInstanceList}" status="i" var="personneInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${personneInstance.id}">${fieldValue(bean: personneInstance, field: "username")}</g:link></td>
					
						<td>${fieldValue(bean: personneInstance, field: "password")}</td>
					
						<td>${fieldValue(bean: personneInstance, field: "nom")}</td>
					
						<td>${fieldValue(bean: personneInstance, field: "prenom")}</td>
					
						<td>${fieldValue(bean: personneInstance, field: "pseudo")}</td>
					
						<td>${fieldValue(bean: personneInstance, field: "identifiant")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${personneInstanceTotal}" />
			</div>
		</div>
	</body>
</html>
