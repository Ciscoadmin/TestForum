<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
    <head>
        <title>Adding new post</title>
    </head>
    <body>
        <h2>Adding new post</h2><br>
        <a href="main">Back to forum</a>
		<h3><font color='red'>${message}</font></h3><br>
        <form:form method="post" action="addpost">

            <input type="hidden"  name="topicName" value="${topic}" size="25" readonly/>

            <textarea id="PostField" name="text" cols="25" rows="3" ></textarea><br>
                   <input id="addPost" type="submit" value="Add post"/>
                   <input type="reset" value="Cancel"/>
               </form:form>
           </body>
       </html>