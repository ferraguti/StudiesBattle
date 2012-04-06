<%@ page import="studiesbattle.cours.PageMatiere" %>



<div class="fieldcontain ${hasErrors(bean: pageMatiereInstance, field: 'matiere', 'error')} required">
	<label for="matiere">
		<g:message code="pageMatiere.matiere.label" default="Matiere" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="matiere" name="matiere.id" from="${studiesbattle.cours.Matiere.list()}" optionKey="id" required="" value="${pageMatiereInstance?.matiere?.id}" class="many-to-one"/>
</div>

