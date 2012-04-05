<%@ page import="studiesbattle.cours.Parcours" %>



<div class="fieldcontain ${hasErrors(bean: parcoursInstance, field: 'nom', 'error')} required">
	<label for="nom">
		<g:message code="parcours.nom.label" default="Nom" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="nom" required="" value="${parcoursInstance?.nom}"/>
</div>


<div class="fieldcontain ${hasErrors(bean: parcoursInstance, field: 'matieres', 'error')} ">
	<label for="matiere">
		<g:message code="parcours.matieres.label" default="Matieres" />
		
	</label>

<ul class="one-to-many">
<g:each in="${parcoursInstance?.matieres?}" var="c">
    <li><g:link controller="matiere" action="show" id="${c.id}">${c?.encodeAsHTML()}</g:link></li>
</g:each>
<li class="add">
<g:link controller="matiere" action="create" params="['parcours.id': parcoursInstance?.id]">${message(code: 'default.add.label', args: [message(code: 'matiere.label', default: 'Matiere')])}</g:link>
</li>
</ul>

</div>

<div class="fieldcontain ${hasErrors(bean: parcoursInstance, field: 'etudiantsInscrit', 'error')} ">
	<label for="etudiant">
		<g:message code="parcours.etudiantsInscrit.label" default="Etudiants Inscrit" />
		
	</label>

<ul class="one-to-many">
<g:each in="${parcoursInstance?.etudiantsInscrit?}" var="c">
    <li><g:link controller="etudiant" action="show" id="${c.id}">${c?.encodeAsHTML()}</g:link></li>
</g:each>
<li class="add">
<g:link controller="etudiant" action="create" params="['parcours.id': parcoursInstance?.id]">${message(code: 'default.add.label', args: [message(code: 'etudiant.label', default: 'Matiere')])}</g:link>
</li>
</ul>

</div>


