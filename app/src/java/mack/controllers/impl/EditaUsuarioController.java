package mack.controllers.impl;

import java.util.logging.Level;
import java.util.logging.Logger;
import mack.controllers.AbstractController;
import mack.dao.usuario.UsuarioDAO;
import mack.dao.usuario.UsuarioDAOFactory;

public class EditaUsuarioController extends AbstractController {

    public void execute() {
        try {
            Integer id = Integer.parseInt(this.getRequest().getParameter("id"));
            String name = this.getRequest().getParameter("name");
            String surname = this.getRequest().getParameter("surname");
            String login = this.getRequest().getParameter("login");
            String senha = this.getRequest().getParameter("senha");
            UsuarioDAO User = new UsuarioDAOFactory().getUsuarioDAO();
            User.updateUsuario(id, name, surname, login, senha);
            this.setReturnPage("FrontControllerServlet?control=ListaUsuario");
            this.setReturnType(ReturnType.REDIRECT);
        } catch (Exception ex) {
            Logger.getLogger(EditaUsuarioController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
