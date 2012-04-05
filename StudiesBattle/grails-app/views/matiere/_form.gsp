<%@ page import="studiesbattle.cours.Matiere" %>



<div class="fieldcontain ${hasErrors(bean: matiereInstance, field: 'nom', 'error')} required">
	<label for="nom">
		<g:message code="matiere.nom.label" default="Nom" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="nom" required="" value="${matiereInstance?.nom}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: matiereInstance, field: 'parcours', 'error')} required">
	<label for="parcours">
		<g:message code="matiere.parcours.label" default="Parcours" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="parcours" name="parcours.id" from="${studiesbattle.cours.Parcours.list()}" optionKey="id" required="" value="${matiereInstance?.parcours?.id}" class="many-to-one"/>
</div>

<div class="fieldcontain ${hasErrors(bean: matiereInstance, field: 'cours', 'error')} ">
	<label for="cours">
		<g:message code="matiere.cours.label" default="Cours" />
		
	</label>
	
<ul class="one-to-many">
<g:each in="${matiereInstance?.cours?}" var="c">
    <li><g:link controller="cours" action="show" id="${c.id}">${c?.encodeAsHTML()}</g:link></li>
</g:each>
<li class="add">
<g:link controller="cours" action="create" params="['matiere.id': matiereInstance?.id]">${message(code: 'default.add.label', args: [message(code: 'cours.label', default: 'Cours')])}</g:link>
</li>
</ul>

</div>

<div class="fieldcontain ${hasErrors(bean: matiereInstance, field: 'professeurs', 'error')} ">
	<label for="professeur">
		<g:message code="matiere.cours.label" default="Professeurs" />
		
	</label>

<ul class="one-to-many">
<g:each in="${matiereInstance?.professeurs?}" var="c">
    <li><g:link controller="professeur" action="show" id="${c.id}">${c?.encodeAsHTML()}</g:link></li>
</g:each>
<li class="add">
<g:link controller="professeur" action="create" params="['matiere.id': matiereInstance?.id]">${message(code: 'default.add.label', args: [message(code: 'professeur.label', default: 'Professeur')])}</g:link>
</li>
</ul>

</div>
