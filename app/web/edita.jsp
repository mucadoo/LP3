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
        <form action="FrontControllerServlet?control=EditaUsuario" method="post">
            <input type="hidden" name="id" value="<%=u.getId()%>">
            <input type="text" name="name" value="<%=u.getNome()%>">
            <input type="text" name="surname" value="<%=u.getSobrenome()%>">
            <input type="text" name="login" value="<%=u.getLogin()%>">
            <input type="text" name="senha" value="<%=u.getSenha()%>">
            <input type="submit" value="Salvar">
        </form>
    </body>
</html>