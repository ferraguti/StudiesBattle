<%@ page import="studiesbattle.personne.Professeur" %>



<div class="fieldcontain ${hasErrors(bean: professeurInstance, field: 'username', 'error')} required">
	<label for="username">
		<g:message code="professeur.username.label" default="Username" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="username" required="" value="${professeurInstance?.username}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: professeurInstance, field: 'password', 'error')} required">
	<label for="password">
		<g:message code="professeur.password.label" default="Password" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="password" required="" value="${professeurInstance?.password}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: professeurInstance, field: 'nom', 'error')} required">
	<label for="nom">
		<g:message code="professeur.nom.label" default="Nom" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="nom" required="" value="${professeurInstance?.nom}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: professeurInstance, field: 'prenom', 'error')} required">
	<label for="prenom">
		<g:message code="professeur.prenom.label" default="Prenom" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="prenom" required="" value="${professeurInstance?.prenom}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: professeurInstance, field: 'pseudo', 'error')} ">
	<label for="pseudo">
		<g:message code="professeur.pseudo.label" default="Pseudo" />
		
	</label>
	<g:textField name="pseudo" value="${professeurInstance?.pseudo}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: professeurInstance, field: 'numNational', 'error')} required">
	<label for="numNational">
		<g:message code="professeur.numNational.label" default="numNational" />
		<span class="required-indicator">*</span>
	</label>
	<g:field type="number" name="numNational" required="" value="${fieldValue(bean: professeurInstance, field: 'numNational')}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: professeurInstance, field: 'sexe', 'error')} required">
	<label for="sexe">
		<g:message code="professeur.sexe.label" default="Sexe" />
		<span class="required-indicator">*</span>
	</label>
	<g:select name="sexe" from="${professeurInstance.constraints.sexe.inList}" required="" value="${fieldValue(bean: professeurInstance, field: 'sexe')}" valueMessagePrefix="professeur.sexe"/>
</div>

<div class="fieldcontain ${hasErrors(bean: professeurInstance, field: 'email', 'error')} ">
	<label for="email">
		<g:message code="professeur.email.label" default="Email" />
		
	</label>
	<g:field type="email" name="email" value="${professeurInstance?.email}"/>
</div>

