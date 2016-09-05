package mack.controllers.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import mack.controllers.AbstractController;
import mack.dao.usuario.UsuarioDAO;
import mack.dao.usuario.UsuarioDAOFactory;
import mack.entities.Usuario;

public class CriaUsuarioController extends AbstractController {

    public void execute() {
        try {
            String name = this.getRequest().getParameter("name");
            String surname = this.getRequest().getParameter("surname");
            List usuarios = new ArrayList<Usuario>();
            UsuarioDAO User = new UsuarioDAOFactory().getUsuarioDAO();
            usuarios.add(User.criaUsuario(name, surname));
            this.setReturnPage("/lista.jsp");
            this.getRequest().setAttribute("usuarios", usuarios);
        } catch (Exception ex) {
            Logger.getLogger(CriaUsuarioController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
