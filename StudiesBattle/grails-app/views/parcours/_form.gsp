<%@ page import="studiesbattle.cours.Parcours" %>



<div class="fieldcontain ${hasErrors(bean: parcoursInstance, field: 'nom', 'error')} ">
	<label for="nom">
		<g:message code="parcours.nom.label" default="Nom" />
		
	</label>
	<g:textField name="nom" value="${parcoursInstance?.nom}"/>
</div>



<div class="fieldcontain ${hasErrors(bean: parcoursInstance, field: 'matieres', 'error')} ">
	<label for="matieres">
		<g:message code="parcours.matieres.label" default="Matieres" />
		
	</label>
	
<ul class="one-to-many">
<g:each in="${parcoursInstance?.matieres?}" var="m">
    <li><g:link controller="matiere" action="show" id="${m.id}">${m?.encodeAsHTML()}</g:link></li>
</g:each>
<li class="add">
<g:link controller="matiere" action="create" params="['parcours.id': parcoursInstance?.id]">${message(code: 'default.add.label', args: [message(code: 'matiere.label', default: 'Matiere')])}</g:link>
</li>
</ul>

</div>


<div class="fieldcontain ${hasErrors(bean: parcoursInstance, field: 'etudiantsInscrit', 'error')} ">
	<label for="etudiantsInscrit">
		<g:message code="parcours.etudiantsInscrit.label" default="Etudiants Inscrit" />
		
	</label>
	
	
	
<ul class="one-to-many">
<g:each in="${parcoursInstance?.etudiantsInscrit?}" var="e">
    <li><g:link controller="etudiant" action="show" id="${e.id}">${e?.encodeAsHTML()}</g:link></li>
</g:each>
<li class="add">
<g:link controller="etudiant" action="create" params="['parcours.id': parcoursInstance?.id]">${message(code: 'default.add.label', args: [message(code: 'etudiant.label', default: 'Etudiant')])}</g:link>
</li>
</ul>

</div>
