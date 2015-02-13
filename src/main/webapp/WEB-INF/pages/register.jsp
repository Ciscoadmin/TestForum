<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
            <link rel="icon" type="image/x-icon" href="favicon.ico" />

            <title> Registration Form </title>
    </head>

    <body>
        <h2>  ${message}</h2>
        		<h3 id="message"> Don't forget <a href="/Forum/login">log in</a> </h3>
                <h3 id="errorMessage"><font color='red'>${error}</font></h3>
                <form method="post" action="register">
                    <p>Username<br>
                    <input id="login" type="text" name="login" size="30" /><br>
                    <p>Password<br>
                    <input id="password" type="password" name="password" size="30" /><br>
                    <input id="submit" type="submit" name="submit" value="Reg"/><br>
                </form>
    </body>
</html>