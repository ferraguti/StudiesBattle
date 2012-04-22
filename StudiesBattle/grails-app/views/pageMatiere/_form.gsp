<%@ page import="studiesbattle.cours.PageMatiere" %>



<div class="fieldcontain ${hasErrors(bean: pageMatiereInstance, field: 'nom', 'error')} ">
	<label for="nom">
		<g:message code="pageMatiere.nom.label" default="Nom" />
		
	</label>
	<g:textField name="nom" value="${pageMatiereInstance?.nom}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: pageMatiereInstance, field: 'matiere', 'error')} required">
	<label for="matiere">
		<g:message code="pageMatiere.matiere.label" default="Matiere" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="matiere" name="matiere.id" from="${studiesbattle.cours.Matiere.list()}" optionKey="id" required="" value="${pageMatiereInstance?.matiere?.id}" class="many-to-one"/>
</div>

