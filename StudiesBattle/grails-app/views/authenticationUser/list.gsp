
<%@ page import="com.grailsrocks.authentication.AuthenticationUser" %>
<!doctype html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'authenticationUser.label', default: 'AuthenticationUser')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-authenticationUser" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-authenticationUser" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
				<thead>
					<tr>
					
						<g:sortableColumn property="login" title="${message(code: 'authenticationUser.login.label', default: 'Login')}" />
					
						<g:sortableColumn property="password" title="${message(code: 'authenticationUser.password.label', default: 'Password')}" />
					
						<g:sortableColumn property="email" title="${message(code: 'authenticationUser.email.label', default: 'Email')}" />
					
						<g:sortableColumn property="status" title="${message(code: 'authenticationUser.status.label', default: 'Status')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${authenticationUserInstanceList}" status="i" var="authenticationUserInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${authenticationUserInstance.id}">${fieldValue(bean: authenticationUserInstance, field: "login")}</g:link></td>
					
						<td>${fieldValue(bean: authenticationUserInstance, field: "password")}</td>
					
						<td>${fieldValue(bean: authenticationUserInstance, field: "email")}</td>
					
						<td>${fieldValue(bean: authenticationUserInstance, field: "status")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${authenticationUserInstanceTotal}" />
			</div>
		</div>
	</body>
</html>
