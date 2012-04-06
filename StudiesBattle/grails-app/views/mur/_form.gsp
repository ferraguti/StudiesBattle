<%@ page import="studiesbattle.personne.Mur" %>



<div class="fieldcontain ${hasErrors(bean: murInstance, field: 'proprietaire', 'error')} required">
	<label for="proprietaire">
		<g:message code="mur.proprietaire.label" default="Proprietaire" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="proprietaire" name="proprietaire.id" from="${studiesbattle.personne.Personne.list()}" optionKey="id" required="" value="${murInstance?.proprietaire?.id}" class="many-to-one"/>
</div>

