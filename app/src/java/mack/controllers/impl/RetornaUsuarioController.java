package mack.controllers.impl;

import java.util.logging.Level;
import java.util.logging.Logger;
import mack.controllers.AbstractController;
import mack.dao.usuario.UsuarioDAO;
import mack.dao.usuario.UsuarioDAOFactory;
import mack.entities.Usuario;

public class RetornaUsuarioController extends AbstractController {

    @Override
    public void execute() {
        try {
            Integer id = Integer.parseInt(this.getRequest().getParameter("id"));
            Usuario usuario = new Usuario();
            UsuarioDAO User = new UsuarioDAOFactory().getUsuarioDAO();
            usuario = User.buscaUsuarioPorId(id);
            this.setReturnPage("/edita.jsp");
            this.getRequest().setAttribute("usuario", usuario);
            this.setReturnType(ReturnType.FORWARD);
        } catch (Exception ex) {
            Logger.getLogger(RetornaUsuarioController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
