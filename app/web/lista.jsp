<%@page import="mack.entities.Usuario"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" type="text/css" href="style/lib/bootstrap-theme.min.css">
        <link rel="stylesheet" type="text/css" href="style/lib/bootstrap.min.css">
        <script src="script/lib/jquery-3.1.0.min.js" type="text/javascript"></script>
        <script src="script/lib/bootstrap.min.js" type="text/javascript"></script>
    </head>
    <body>

        <div class="jumbotron" style="background: #FFF">
            <div class="container">
                <h1>Users</h1>
                <p><a class="btn btn-primary btn-lg" href="#" role="button" data-toggle="modal" data-target="#myModal">Create User</a></p>
                    <%
                        List<Usuario> usuarios = (List<Usuario>) request.getAttribute("usuarios");
                    %>
                    <%if (usuarios.size() > 0) { %>
                <table class="table table-striped table-bordered table-hover">
                    <thead class="thead-inverse">
                        <tr>
                            <th>ID</th>
                            <th>Nome</th>
                            <th>Sobrenome</th>
                            <th>Login</th>
                            <th>Senha</th>
                            <th>Editar</th>
                            <th>Excluir</th>
                        </tr>
                    </thead>
                    <% for (Usuario u : usuarios) {%>
                    <tbody>
                        <tr>
                            <td><%=u.getId()%></td>
                            <td><%=u.getNome()%></td>
                            <td><%=u.getSobrenome()%></td>
                            <td><%=u.getLogin()%></td>
                            <td><%=u.getSenha()%></td>
                            <td><a class="btn btn-warning btn-sm" href="FrontControllerServlet?control=RetornaUsuario&id=<%=u.getId()%>">Editar</a></td>
                            <td><a class="btn btn-danger btn-sm" href="FrontControllerServlet?control=DeletaUsuario&id=<%=u.getId()%>">Exluir</a></td>
                        </tr>
                    </tbody>
                    <%}%>
                </table>
                <%}%>
            </div>
        </div>

        <div class="container">
            <hr>
        </div>

        <!-- Modal -->
        <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                        <h4 class="modal-title" id="myModalLabel">Modal title</h4>
                    </div>
                    <div class="modal-body">
                        ...
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                        <button type="button" class="btn btn-primary">Save changes</button>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>