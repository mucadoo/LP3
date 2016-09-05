package mack.controllers.impl;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpSession;
import mack.controllers.AbstractController;
import javax.servlet.http.Cookie;
import mack.dao.usuario.UsuarioDAO;
import mack.dao.usuario.UsuarioDAOFactory;
import mack.entities.Usuario;

public class LoginController extends AbstractController {

    @Override
    public void execute() {
        try {
            // get request parameters for userID and password
            String login = this.getRequest().getParameter("login");
            String senha = this.getRequest().getParameter("senha");
            UsuarioDAO User = UsuarioDAOFactory.getUsuarioDAO();
            Usuario u = User.login(login, senha);
            if (u != null) {
                HttpSession session = this.getRequest().getSession();
                session.setAttribute("usuario", login);
                //setting session to expiry in 30 mins
                session.setMaxInactiveInterval(30 * 60);
                Cookie userName = new Cookie("usuario", login);
                userName.setMaxAge(30 * 60);
                this.getResponse().addCookie(userName);
                this.setReturnPage("/sucessoLogin.jsp");
            } else {
                this.setReturnPage("/login.html");
            }
        } catch (Exception ex) {
            Logger.getLogger(ListaUsuarioController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
