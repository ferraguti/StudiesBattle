<%@ page import="studiesbattle.personne.Mur" %>



<div class="fieldcontain ${hasErrors(bean: murInstance, field: 'proprietaire', 'error')} required">
	<label for="proprietaire">
		<g:message code="mur.proprietaire.label" default="Proprietaire" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="proprietaire" name="proprietaire.id" from="${studiesbattle.personne.Personne.list()}" optionKey="id" required="" value="${murInstance?.proprietaire?.id}" class="many-to-one"/>
</div>

<div class="fieldcontain ${hasErrors(bean: murInstance, field: 'messages', 'error')} ">
	<label for="messages">
		<g:message code="mur.messages.label" default="Messages" />
		
	</label>
	
<ul class="one-to-many">
<g:each in="${murInstance?.messages?}" var="m">
    <li><g:link controller="message" action="show" id="${m.id}">${m?.encodeAsHTML()}</g:link></li>
</g:each>
<li class="add">
<g:link controller="message" action="create" params="['mur.id': murInstance?.id]">${message(code: 'default.add.label', args: [message(code: 'message.label', default: 'Message')])}</g:link>
</li>
</ul>

</div>