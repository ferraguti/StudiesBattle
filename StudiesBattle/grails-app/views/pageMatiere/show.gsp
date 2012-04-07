
<%@ page import="studiesbattle.cours.PageMatiere" %>
<!doctype html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'pageMatiere.label', default: 'PageMatiere')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-pageMatiere" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-pageMatiere" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list pageMatiere">
			
				<g:if test="${pageMatiereInstance?.matiere}">
				<li class="fieldcontain">
					<span id="matiere-label" class="property-label"><g:message code="pageMatiere.matiere.label" default="Matiere" /></span>
					
						<span class="property-value" aria-labelledby="matiere-label"><g:link controller="matiere" action="show" id="${pageMatiereInstance?.matiere?.id}">${pageMatiereInstance?.matiere?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
			</ol>
			
			<br />
		    <g:uploadForm action="upload">
		        <input type="file" name="myFile" />
		        <input type="submit" />
		    </g:uploadForm>
			
			<g:form>
				<fieldset class="buttons">
					<g:hiddenField name="id" value="${pageMatiereInstance?.id}" />
					<g:link class="edit" action="edit" id="${pageMatiereInstance?.id}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
