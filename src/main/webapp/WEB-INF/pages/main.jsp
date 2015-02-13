<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
                <link rel="icon" type="image/x-icon" href="favicon.ico" />

            <title> Forum </title>
        </head>

    <body>
      <h2>  ${message}</h2>




   <h3>Hello  <font color='blue'> ${user}</font>  <a href="/Forum">LogOut from forum</a></h3>
  <h5 > <a id="addPost" href="/Forum/addtopic">${ifAdmin}</a> </h5>


	    <div>
			<h3 >Available Topics</h3>
		</div>
		<ul>
        <c:forEach var="topic" items="${topics}">
                <li ><a id="${topic}" href="${topic}"><h4>${topic}</h4></a></li>
        </c:forEach>
        </ul>



    </body>
    </html>