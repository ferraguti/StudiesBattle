<%@ page import="studiesbattle.personne.Message" %>



<div class="fieldcontain ${hasErrors(bean: messageInstance, field: 'contenu', 'error')} ">
	<label for="contenu">
		<g:message code="message.contenu.label" default="Contenu" />
		
	</label>
	<g:textField name="contenu" value="${messageInstance?.contenu}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: messageInstance, field: 'mur', 'error')} required">
	<label for="mur">
		<g:message code="message.mur.label" default="Mur" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="mur" name="mur.id" from="${studiesbattle.personne.Mur.list()}" optionKey="id" required="" value="${messageInstance?.mur?.id}" class="many-to-one"/>
</div>

