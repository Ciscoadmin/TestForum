<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
       <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
       <html lang="en">
           <head>
               <title> Forum</title>
           </head>
           <body>
               <a href="main">Back to forum</a>


               <a id="Postlink" href="addpost?valueOfTopic=${valueOfTopic}">Add Post</a><br>

               <c:forEach var="post" items="${topic.getPosts()}">
               ===========================
                   <form method="post" action="editPost"><br>
                       <textarea  disabled name="text" cols="25" rows="5" >${post.getContent()}</textarea><br>

                       <h5>Created by ${post.getUsername()}</h5>

                   </form>
                ===========================
               </c:forEach>
           </body>
       </html>