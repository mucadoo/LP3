package mack.controllers.impl;

import java.util.logging.Level;
import java.util.logging.Logger;
import mack.controllers.AbstractController;
import mack.dao.usuario.UsuarioDAO;
import mack.dao.usuario.UsuarioDAOFactory;

public class DeletaUsuarioController extends AbstractController {

    public void execute() {
        try {
            Integer id = Integer.parseInt(this.getRequest().getParameter("id"));
            UsuarioDAO User = new UsuarioDAOFactory().getUsuarioDAO();
            User.removeUsuario(id);
            this.setReturnPage("/index.html");
        } catch (Exception ex) {
            Logger.getLogger(DeletaUsuarioController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
