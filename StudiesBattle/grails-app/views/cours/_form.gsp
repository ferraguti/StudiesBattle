<%@ page import="studiesbattle.cours.Cours" %>

<div class="fieldcontain ${hasErrors(bean: coursInstance, field: 'matiere', 'error')} required">
	<label for="matiere">
		<g:message code="cours.matiere.label" default="Matiere" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="matiere" name="matiere.id" from="${studiesbattle.cours.Matiere.list()}" optionKey="id" required="" value="${coursInstance?.matiere?.id}" class="many-to-one"/>
</div>

<div class="fieldcontain ${hasErrors(bean: coursInstance, field: 'nom', 'error')} ">
	<label for="nom">
		<g:message code="cours.nom.label" default="Nom" />
		
	</label>
	<g:textField name="nom" value="${coursInstance?.nom}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: coursInstance, field: 'heures', 'error')} required">
	<label for="heures">
		<g:message code="cours.heures.label" default="Heures" />
		<span class="required-indicator">*</span>
	</label>
	<g:field type="number" name="heures" min="0.25" required="" value="${fieldValue(bean: coursInstance, field: 'heures')}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: coursInstance, field: 'coefficient', 'error')} required">
	<label for="coefficient">
		<g:message code="cours.coefficient.label" default="Coefficient" />
		<span class="required-indicator">*</span>
	</label>
	<g:field type="number" name="coefficient" min="0.0" required="" value="${fieldValue(bean: coursInstance, field: 'coefficient')}"/>
</div>


<div class="fieldcontain ${hasErrors(bean: coursInstance, field: 'prof', 'error')} required">
	<label for="prof">
		<g:message code="cours.prof.label" default="Prof" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="prof" name="prof.id" from="${studiesbattle.personne.Professeur.list()}" optionKey="id" required="" value="${coursInstance?.prof?.id}" class="many-to-one"/>
</div>

