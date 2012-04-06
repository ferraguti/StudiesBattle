<%@ page import="studiesbattle.personne.Etudiant" %>



<div class="fieldcontain ${hasErrors(bean: etudiantInstance, field: 'username', 'error')} required">
	<label for="username">
		<g:message code="etudiant.username.label" default="Username" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="username" required="" value="${etudiantInstance?.username}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: etudiantInstance, field: 'password', 'error')} required">
	<label for="password">
		<g:message code="etudiant.password.label" default="Password" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="password" required="" value="${etudiantInstance?.password}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: etudiantInstance, field: 'nom', 'error')} required">
	<label for="nom">
		<g:message code="etudiant.nom.label" default="Nom" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="nom" required="" value="${etudiantInstance?.nom}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: etudiantInstance, field: 'prenom', 'error')} required">
	<label for="prenom">
		<g:message code="etudiant.prenom.label" default="Prenom" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="prenom" required="" value="${etudiantInstance?.prenom}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: etudiantInstance, field: 'pseudo', 'error')} ">
	<label for="pseudo">
		<g:message code="etudiant.pseudo.label" default="Pseudo" />
		
	</label>
	<g:textField name="pseudo" value="${etudiantInstance?.pseudo}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: etudiantInstance, field: 'sexe', 'error')} required">
	<label for="sexe">
		<g:message code="etudiant.sexe.label" default="Sexe" />
		<span class="required-indicator">*</span>
	</label>
	<g:select name="sexe" from="${etudiantInstance.constraints.sexe.inList}" required="" value="${fieldValue(bean: etudiantInstance, field: 'sexe')}" valueMessagePrefix="etudiant.sexe"/>
</div>

<div class="fieldcontain ${hasErrors(bean: etudiantInstance, field: 'email', 'error')} ">
	<label for="email">
		<g:message code="etudiant.email.label" default="Email" />
		
	</label>
	<g:field type="email" name="email" value="${etudiantInstance?.email}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: etudiantInstance, field: 'age', 'error')} required">
	<label for="age">
		<g:message code="etudiant.age.label" default="Age" />
		<span class="required-indicator">*</span>
	</label>
	<g:field type="number" name="age" min="13" required="" value="${fieldValue(bean: etudiantInstance, field: 'age')}"/>
</div>


<div class="fieldcontain ${hasErrors(bean: etudiantInstance, field: 'parcours', 'error')} required">
	<label for="parcours">
		<g:message code="etudiant.parcours.label" default="Parcours" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="parcours" name="parcours.id" from="${studiesbattle.cours.Parcours.list()}" optionKey="id" required="" value="${etudiantInstance?.parcours?.id}" class="many-to-one"/>
</div>


