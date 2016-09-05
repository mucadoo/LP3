<%@page import="mack.entities.Usuario"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <script type="text/javascript">
            var lnks = document.getElementsByClassName("delete");
            for (var i = 0; i < lnks.length; i++) {
                lnks[i].onclick = function () {
                    return confirm("Tem certeza?");
                };
            }

        </script>
    </head>
    <body>
        <h1>Usuários</h1>
        <%
            List<Usuario> usuarios = (List<Usuario>) request.getAttribute("usuarios");
        %>
        <%if (usuarios.size() > 0) { %>
        <table>
            <tr>
                <th>ID</th>
                <th>Nome</th>
                <th>Sobrenome</th>
                <th>Login</th>
                <th>Senha</th>
                <th>Editar</th>
                <th>Excluir</th>
            </tr>
            <% for (Usuario u : usuarios) {%>
            <tr>
                <td><%=u.getId()%></td>
                <td><%=u.getNome()%></td>
                <td><%=u.getSobrenome()%></td>
                <td><%=u.getLogin()%></td>
                <td><%=u.getSenha()%></td>
                <td><a href="FrontControllerServlet?control=RetornaUsuario&id=<%=u.getId()%>">/</a></td>
                <td><a class="delete" href="FrontControllerServlet?control=DeletaUsuario&id=<%=u.getId()%>">X</a></td>
            </tr>
            <%}%>
        </table>
        <%}%>
    </body>
</html>
