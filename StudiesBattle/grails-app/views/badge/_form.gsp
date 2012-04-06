<%@ page import="studiesbattle.badge.Badge" %>



<div class="fieldcontain ${hasErrors(bean: badgeInstance, field: 'nom', 'error')} required">
	<label for="nom">
		<g:message code="badge.nom.label" default="Nom" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="nom" required="" value="${badgeInstance?.nom}"/>
</div>

