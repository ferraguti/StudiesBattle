<%@ page import="com.grailsrocks.authentication.AuthenticationUser" %>



<div class="fieldcontain ${hasErrors(bean: authenticationUserInstance, field: 'login', 'error')} ">
	<label for="login">
		<g:message code="authenticationUser.login.label" default="Login" />
		
	</label>
	<g:textField name="login" maxlength="64" value="${authenticationUserInstance?.login}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: authenticationUserInstance, field: 'password', 'error')} ">
	<label for="password">
		<g:message code="authenticationUser.password.label" default="Password" />
		
	</label>
	<g:field type="password" name="password" maxlength="64" value="${authenticationUserInstance?.password}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: authenticationUserInstance, field: 'email', 'error')} ">
	<label for="email">
		<g:message code="authenticationUser.email.label" default="Email" />
		
	</label>
	<g:field type="email" name="email" value="${authenticationUserInstance?.email}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: authenticationUserInstance, field: 'status', 'error')} required">
	<label for="status">
		<g:message code="authenticationUser.status.label" default="Status" />
		<span class="required-indicator">*</span>
	</label>
	<g:select name="status" from="${authenticationUserInstance.constraints.status.inList}" required="" value="${fieldValue(bean: authenticationUserInstance, field: 'status')}" valueMessagePrefix="authenticationUser.status"/>
</div>

