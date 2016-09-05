package mack.controllers.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import mack.controllers.AbstractController;
import mack.dao.usuario.UsuarioDAO;
import mack.dao.usuario.UsuarioDAOFactory;
import mack.entities.Usuario;

public class BuscaUsuarioController extends AbstractController {

    public void execute() {
        try {
            String name = this.getRequest().getParameter("name");
            List usuarios = new ArrayList<Usuario>();
            UsuarioDAO User = new UsuarioDAOFactory().getUsuarioDAO();
            usuarios = (List) User.buscaUsuarioPorNome(name);
            this.setReturnPage("/lista.jsp");
            this.getRequest().setAttribute("usuarios", usuarios);
        } catch (Exception ex) {
            Logger.getLogger(BuscaUsuarioController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
