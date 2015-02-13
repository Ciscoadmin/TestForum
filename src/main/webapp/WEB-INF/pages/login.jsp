<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
            <link rel="icon" type="image/x-icon" href="favicon.ico" />

            <title> Welcome to Login page
            </title>
    </head>

    <body>
        <h2>  ${message}</h2>
        		<h3 id="message">Please log in or   <a href="/Forum/register">register</a> </h3>
                <h3 id="errorMessage"><font color='red'>${error}</font></h3>
                <form method="post" action="login">
                    <p>Login<br>
                    <input id="login" type="text" name="login" size="30" /><br>
                    <p>Password<br>
                    <input id="password" type="password" name="password" size="30" /><br>
                    <input id="submit" type="submit" name="submit" value="Login"/><br>
                </form>
    </body>
</html>