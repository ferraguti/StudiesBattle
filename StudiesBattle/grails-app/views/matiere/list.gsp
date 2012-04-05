
<%@ page import="studiesbattle.cours.Matiere" %>
<!doctype html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'matiere.label', default: 'Matiere')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-matiere" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-matiere" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
				<thead>
					<tr>
					
						<g:sortableColumn property="nom" title="${message(code: 'matiere.nom.label', default: 'Nom')}" />
						
						<th><g:message code="matiere.parcours.label" default="Parcours" /></th>
					
						<th><g:message code="matiere.page.label" default="Page" /></th>
					
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${matiereInstanceList}" status="i" var="matiereInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${matiereInstance.id}">${fieldValue(bean: matiereInstance, field: "nom")}</g:link></td>
					
						<td>${fieldValue(bean: matiereInstance, field: "parcours")}</td>
						
						<td>${fieldValue(bean: matiereInstance, field: "page")}</td>
					
					
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${matiereInstanceTotal}" />
			</div>
		</div>
	</body>
</html>
