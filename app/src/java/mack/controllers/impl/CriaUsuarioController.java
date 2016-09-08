package mack.controllers.impl;

import java.util.logging.Level;
import java.util.logging.Logger;
import mack.controllers.AbstractController;
import mack.dao.usuario.UsuarioDAO;
import mack.dao.usuario.UsuarioDAOFactory;

public class CriaUsuarioController extends AbstractController {

    @Override
    public void execute() {
        try {
            String name = this.getRequest().getParameter("name");
            String surname = this.getRequest().getParameter("surname");
            String login = this.getRequest().getParameter("login");
            String senha = this.getRequest().getParameter("senha");
            UsuarioDAO User = UsuarioDAOFactory.getUsuarioDAO();
            User.criaUsuario(name, surname, login, senha);
            this.setReturnPage("/home.html");
            this.setReturnType(ReturnType.FORWARD);
        } catch (Exception ex) {
            Logger.getLogger(CriaUsuarioController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
