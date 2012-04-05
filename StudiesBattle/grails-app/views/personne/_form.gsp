<%@ page import="studiesbattle.personne.Personne" %>



<div class="fieldcontain ${hasErrors(bean: personneInstance, field: 'username', 'error')} required">
	<label for="username">
		<g:message code="personne.username.label" default="Username" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="username" required="" value="${personneInstance?.username}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: personneInstance, field: 'password', 'error')} required">
	<label for="password">
		<g:message code="personne.password.label" default="Password" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="password" required="" value="${personneInstance?.password}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: personneInstance, field: 'nom', 'error')} required">
	<label for="nom">
		<g:message code="personne.nom.label" default="Nom" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="nom" required="" value="${personneInstance?.nom}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: personneInstance, field: 'prenom', 'error')} required">
	<label for="prenom">
		<g:message code="personne.prenom.label" default="Prenom" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="prenom" required="" value="${personneInstance?.prenom}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: personneInstance, field: 'pseudo', 'error')} ">
	<label for="pseudo">
		<g:message code="personne.pseudo.label" default="Pseudo" />
		
	</label>
	<g:textField name="pseudo" value="${personneInstance?.pseudo}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: personneInstance, field: 'identifiant', 'error')} required">
	<label for="identifiant">
		<g:message code="personne.identifiant.label" default="Identifiant" />
		<span class="required-indicator">*</span>
	</label>
	<g:field type="number" name="identifiant" required="" value="${fieldValue(bean: personneInstance, field: 'identifiant')}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: personneInstance, field: 'sexe', 'error')} required">
	<label for="sexe">
		<g:message code="personne.sexe.label" default="Sexe" />
		<span class="required-indicator">*</span>
	</label>
	<g:select name="sexe" from="${personneInstance.constraints.sexe.inList}" required="" value="${fieldValue(bean: personneInstance, field: 'sexe')}" valueMessagePrefix="personne.sexe"/>
</div>

<div class="fieldcontain ${hasErrors(bean: personneInstance, field: 'email', 'error')} ">
	<label for="email">
		<g:message code="personne.email.label" default="Email" />
		
	</label>
	<g:field type="email" name="email" value="${personneInstance?.email}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: personneInstance, field: 'accountExpired', 'error')} ">
	<label for="accountExpired">
		<g:message code="personne.accountExpired.label" default="Account Expired" />
		
	</label>
	<g:checkBox name="accountExpired" value="${personneInstance?.accountExpired}" />
</div>

<div class="fieldcontain ${hasErrors(bean: personneInstance, field: 'accountLocked', 'error')} ">
	<label for="accountLocked">
		<g:message code="personne.accountLocked.label" default="Account Locked" />
		
	</label>
	<g:checkBox name="accountLocked" value="${personneInstance?.accountLocked}" />
</div>

<div class="fieldcontain ${hasErrors(bean: personneInstance, field: 'enabled', 'error')} ">
	<label for="enabled">
		<g:message code="personne.enabled.label" default="Enabled" />
		
	</label>
	<g:checkBox name="enabled" value="${personneInstance?.enabled}" />
</div>

<div class="fieldcontain ${hasErrors(bean: personneInstance, field: 'mur', 'error')} required">
	<label for="mur">
		<g:message code="personne.mur.label" default="Mur" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="mur" name="mur.id" from="${studiesbattle.personne.Mur.list()}" optionKey="id" required="" value="${personneInstance?.mur?.id}" class="many-to-one"/>
</div>

<div class="fieldcontain ${hasErrors(bean: personneInstance, field: 'passwordExpired', 'error')} ">
	<label for="passwordExpired">
		<g:message code="personne.passwordExpired.label" default="Password Expired" />
		
	</label>
	<g:checkBox name="passwordExpired" value="${personneInstance?.passwordExpired}" />
</div>

