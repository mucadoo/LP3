package mack.controllers.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import mack.controllers.AbstractController;
import mack.dao.usuario.UsuarioDAO;
import mack.dao.usuario.UsuarioDAOFactory;
import mack.entities.Usuario;

public class ListaUsuarioController extends AbstractController {

    @Override
    public void execute() {
        try {
            List usuarios = new ArrayList<Usuario>();
            UsuarioDAO User = new UsuarioDAOFactory().getUsuarioDAO();
            usuarios = (List) User.buscaTodosUsuarios();
            this.setReturnPage("/lista.jsp");
            this.getRequest().setAttribute("usuarios", usuarios);
            this.setReturnType(ReturnType.FORWARD);
        } catch (Exception ex) {
            Logger.getLogger(ListaUsuarioController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
