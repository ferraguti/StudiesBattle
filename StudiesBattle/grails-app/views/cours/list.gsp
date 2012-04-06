
<%@ page import="studiesbattle.cours.Cours" %>
<!doctype html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'cours.label', default: 'Cours')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-cours" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-cours" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
				<thead>
					<tr>
					
						<g:sortableColumn property="nom" title="${message(code: 'cours.nom.label', default: 'Nom')}" />
					
						<th><g:message code="cours.matiere.label" default="Matiere" /></th>
						
						<g:sortableColumn property="heures" title="${message(code: 'cours.heures.label', default: 'Heures')}" />
					
						<g:sortableColumn property="coefficient" title="${message(code: 'cours.coefficient.label', default: 'Coefficient')}" />
						
						<th><g:message code="cours.prof.label" default="Prof" /></th>
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${coursInstanceList}" status="i" var="coursInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${coursInstance.id}">${fieldValue(bean: coursInstance, field: "nom")}</g:link></td>
						
						<td><g:link action="show" id="${coursInstance.id}">${fieldValue(bean: coursInstance, field: "matiere")}</g:link></td>
						
						<td>${fieldValue(bean: coursInstance, field: "heures")}</td>
						
						<td>${fieldValue(bean: coursInstance, field: "coefficient")}</td>
					
						<td><g:link action="show" id="${coursInstance.id}">${fieldValue(bean: coursInstance, field: "prof")}</g:link></td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${coursInstanceTotal}" />
			</div>
		</div>
	</body>
</html>
