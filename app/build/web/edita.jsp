<%@page import="mack.entities.Usuario"%>
<%
    Usuario u = (Usuario) request.getAttribute("usuario");
%>
<div class="modal-dialog" role="document">
    <div class="modal-content">
        <form action="FrontControllerServlet?control=EditaUsuario" method="post" role="form">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="myModalLabel">Edita Usuário</h4>
            </div>
            <div class="modal-body">
                <input type="hidden" name="id" value="<%=u.getId()%>">
                <div class="form-group">
                    <label for="newName">Nome</label>
                    <input id="newName" name="name" type="text" class="form-control" placeholder="Insira o Nome" value="<%=u.getNome()%>">
                           </div>
                           <div class="form-group">
                           <label for="newSurname">Sobrenome</label>
                    <input id="newSurname" name="surname" type="text" class="form-control" placeholder="Insira o Sobrenome" value="<%=u.getSobrenome()%>">
                </div>
                <div class="form-group">
                    <label for="newLogin">Login</label>
                    <input id="newLogin" name="login" type="text" class="form-control" placeholder="Insira o Login" value="<%=u.getLogin()%>">
                </div>
                <div class="form-group">
                    <label for="newPass">Password</label>
                    <input id="newPass" name="senha" type="text" class="form-control" placeholder="Insira a Senha" value="<%=u.getSenha()%>">
                </div>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">Fechar</button>
                <input type="submit" lass="btn btn-primary" value="Salvar">
            </div>
        </form>
    </div>
</div>