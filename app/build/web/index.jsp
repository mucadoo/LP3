<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Página de Login</title>
    </head>
    <body>
        <form action="FrontControllerServlet?control=Login" method="post">
            Nome de usuario: <input type="text" name="login">
            <br>
            Senha: <input type="password" name="senha">
            <br>
            <input type="submit" value="Login">
        </form>
        <%
            String msg = request.getAttribute("msg") == null ? "" : (String) request.getAttribute("msg");
        %>
        <h3><%=msg%></h3>
    </body>
</html>