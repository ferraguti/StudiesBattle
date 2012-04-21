
<%@ page import="studiesbattle.personne.Etudiant" %>
<!doctype html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'etudiant.label', default: 'Etudiant')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-etudiant" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-etudiant" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
				<thead>
					<tr>
					
						<g:sortableColumn property="username" title="${message(code: 'etudiant.username.label', default: 'Username')}" />
					
						<g:sortableColumn property="nom" title="${message(code: 'etudiant.nom.label', default: 'Nom')}" />
					
						<g:sortableColumn property="prenom" title="${message(code: 'etudiant.prenom.label', default: 'Prenom')}" />
					
						<g:sortableColumn property="numNational" title="${message(code: 'etudiant.numNational.label', default: 'Numero Etudiant')}" />
						
						<g:sortableColumn property="points" title="${message(code: 'etudiant.points.label', default: 'Points')}" />
						
						<g:sortableColumn property="parcours" title="${message(code: 'etudiant.parcours.label', default: 'Parcours')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${etudiantInstanceList}" status="i" var="etudiantInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${etudiantInstance.id}">${fieldValue(bean: etudiantInstance, field: "username")}</g:link></td>
					
						<td>${fieldValue(bean: etudiantInstance, field: "nom")}</td>
					
						<td>${fieldValue(bean: etudiantInstance, field: "prenom")}</td>
					
						<td>${fieldValue(bean: etudiantInstance, field: "numNational")}</td>
						
						<td>${fieldValue(bean: etudiantInstance, field: "points")}</td>
						
						<td><g:link controller="parcours" action="show" id="${etudiantInstance.parcours.id}">${fieldValue(bean: etudiantInstance, field: "parcours")}</g:link></td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${etudiantInstanceTotal}" />
			</div>
		</div>
	</body>
</html>
