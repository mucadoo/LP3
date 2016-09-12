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
        <script type="text/javascript">
            $(document).ready(function () {
                $('#editModal').on('show.bs.modal', function (e) {
                    var url = $(e.relatedTarget).attr('href');
                    $.get(url, function (data) {
                        $(e.currentTarget).html(data);
                    });
                });

                var btnsDel = document.getElementsByClassName("delUser");

                for (var i = 0; i < btnsDel.length; i++)
                {
                    btnsDel[i].onclick = function () {
<<<<<<< HEAD
                        return confirm("Tem certeza?");
=======
                        return confirm("Tem certeza");
>>>>>>> origin/master
                    };
                }

            });
<<<<<<< HEAD
            
            document.getElementsByTagName("body")[0].onload = function (){
                alert("loaded!");
            };
            
=======
>>>>>>> origin/master
        </script>
    </head>
    <body>

        <div class="jumbotron" style="background: #FFF">
            <div class="container">
                <h1>Users</h1>
                <p><a class="btn btn-primary" href="#" role="button" data-toggle="modal" data-target="#myModal">Create User</a></p>
                <form class="form-inline" action="FrontControllerServlet?control=BuscaUsuario" method="post">
                    <div class="form-group">
                        <input name="name" type="text" class="form-control" placeholder="Insira o Nome">
                    </div>
                    <input type="submit" class="btn btn-primary" value="Pesquisar">
                </form>
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
                            <td><a class="btn btn-warning btn-sm" data-toggle="modal" data-target="#editModal" href="FrontControllerServlet?control=RetornaUsuario&id=<%=u.getId()%>">Editar</a></td>
                            <td><a class="btn btn-danger btn-sm delUser" href="FrontControllerServlet?control=DeletaUsuario&id=<%=u.getId()%>">Exluir</a></td>
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
                    <form action="FrontControllerServlet?control=CriaUsuario" method="post" role="form">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                            <h4 class="modal-title" id="myModalLabel">Criar Usuário</h4>
                        </div>
                        <div class="modal-body">
                            <div class="form-group">
                                <label for="newName">Nome</label>
                                <input id="newName" name="name" type="text" class="form-control" placeholder="Insira o Nome">
                            </div>
                            <div class="form-group">
                                <label for="newSurname">Sobrenome</label>
                                <input id="newSurname" name="surname" type="text" class="form-control" placeholder="Insira o Sobrenome">
                            </div>
                            <div class="form-group">
                                <label for="newLogin">Login</label>
                                <input id="newLogin" name="login" type="text" class="form-control" placeholder="Insira o Login">
                            </div>
                            <div class="form-group">
                                <label for="newPass">Password</label>
                                <input id="newPass" name="senha" type="text" class="form-control" placeholder="Insira a Senha">
                            </div>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-default" data-dismiss="modal">Fechar</button>
                            <input type="submit" class="btn btn-primary" value="Salvar">
                        </div>
                    </form>
                </div>
            </div>
        </div>
        <div class="modal fade" id="editModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel"></div>
    </body>
</html>