<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
    <head>
        <title>Adding new topic</title>
    </head>
    <body>
        <h2>Adding new topic</h2>
		<h3 id="errorMessage"><font color='red'>${message}</font></h3><br>
        <a href="main">Return to forum</a>
        <form:form method="post" action="addtopic">
            <p>Title<br>
            <input id="topicName" type="text" name="topicName" size="25" />
            <p>Text<br>
            <textarea id="content" name="text" cols="25" rows="3" >${text}</textarea><br>
            <input id="addTopic" type="submit" value="Add topic"/>
        </form:form>
    </body>
</html>