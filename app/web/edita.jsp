<%@page import="mack.entities.Usuario"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Pagina Principal</title>
    </head>
    <body>
        <h1>Edita Usuário</h1>
        <%
            Usuario u = (Usuario) request.getAttribute("usuario");
        %>
        <form action="FrontControllerServlet?control=BuscaUsuario" method="post">
            <input type="text" name="name" value="<%=u.getNome()%>">
            <input type="text" name="sobrenome" value="<%=u.getSobrenome()%>">
            <input type="submit" value="Pesquisar">
        </form>
    </body>
</html>