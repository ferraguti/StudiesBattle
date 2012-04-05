
<%@ page import="com.grailsrocks.authentication.AuthenticationUser" %>
<!doctype html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'authenticationUser.label', default: 'AuthenticationUser')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-authenticationUser" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-authenticationUser" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list authenticationUser">
			
				<g:if test="${authenticationUserInstance?.login}">
				<li class="fieldcontain">
					<span id="login-label" class="property-label"><g:message code="authenticationUser.login.label" default="Login" /></span>
					
						<span class="property-value" aria-labelledby="login-label"><g:fieldValue bean="${authenticationUserInstance}" field="login"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${authenticationUserInstance?.password}">
				<li class="fieldcontain">
					<span id="password-label" class="property-label"><g:message code="authenticationUser.password.label" default="Password" /></span>
					
						<span class="property-value" aria-labelledby="password-label"><g:fieldValue bean="${authenticationUserInstance}" field="password"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${authenticationUserInstance?.email}">
				<li class="fieldcontain">
					<span id="email-label" class="property-label"><g:message code="authenticationUser.email.label" default="Email" /></span>
					
						<span class="property-value" aria-labelledby="email-label"><g:fieldValue bean="${authenticationUserInstance}" field="email"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${authenticationUserInstance?.status}">
				<li class="fieldcontain">
					<span id="status-label" class="property-label"><g:message code="authenticationUser.status.label" default="Status" /></span>
					
						<span class="property-value" aria-labelledby="status-label"><g:fieldValue bean="${authenticationUserInstance}" field="status"/></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form>
				<fieldset class="buttons">
					<g:hiddenField name="id" value="${authenticationUserInstance?.id}" />
					<g:link class="edit" action="edit" id="${authenticationUserInstance?.id}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
