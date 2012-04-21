<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <meta name="layout" content="main" />
        <title>FileResource List</title>
    </head>
    <body>
        <div class="nav">
   			  <span class="menuButton"><a class="home" href="/">Home</a></span>
     </div>
        <div class="body">

			<h1>File Upload:</h1><br>

			 <g:form method="post"  enctype="multipart/form-data">
	                <div class="dialog">
	                    <table>
	                        <tbody>
	                            <tr class="prop">
	                                <td valign="top" class="name">
	                                    <label for="fileUpload">Upload:</label>
	                                </td>
	                                <td valign="top" class="value ${hasErrors(bean:fileResourceInstance,field:'upload','errors')}">
	                                    <input type="file" id="fileUpload" name="fileUpload" />
	                                </td>
	                            </tr> 
	                        </tbody>
	                    </table>
	                </div>
	                <div class="buttons">
	                    <span class="button"><g:actionSubmit class="upload" value="Upload" action="upload" /></span>
	                </div>
	            </g:form>

            <h1>FileResource List</h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
			<div id="success"></div>
            <div class="list">
                <table>
                    <thead>
                        <tr>
                            <g:sortableColumn property="files" title="file"/>
                            <g:sortableColumn property="path" title="path" colspan="3"/>
                       </tr>
                    </thead>
                    <tbody>
                    <g:each in="${fileResourceInstanceList}" status="i" var="fileResourceInstance">
                        <tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
                            <td>${fileResourceInstance.decodeURL()}</td>
                            <td> <input type="text" value="/images/${fileResourceInstance.decodeURL()}"></input></td>
                            <td><a href="${createLinkTo( dir:'images' , file: fileResourceInstance.decodeURL(), absolute:true )}" target="_new">view</a></td>
                            <td><g:link action="delete" id="${fileResourceInstance.replace('.','###')}" onclick="return confirm('Are you sure?');"> delete </g:link></td>
                        </tr>
                    </g:each>
                    </tbody>
                </table>
            </div>
        </div>
    </body>
</html>
