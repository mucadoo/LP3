package mack.controllers.impl;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpSession;
import mack.controllers.AbstractController;
import javax.servlet.http.Cookie;

public class LogoutController extends AbstractController {

    @Override
    public void execute() {
        try {
            this.getResponse().setContentType("text/html");
            Cookie[] cookies = this.getRequest().getCookies();
            if (cookies != null) {
                for (Cookie cookie : cookies) {
                    if (cookie.getName().equals("JSESSIONID")) {
                        //System.out.println("JSESSIONID=" + cookie.getValue());
                        break;
                    }
                }
            }
            //invalidate the session if exists
            HttpSession session = this.getRequest().getSession(false);
            //System.out.println("Usuario=" + session.getAttribute("usuario"));
            if (session != null) {
                session.invalidate();
            }
            this.getResponse().sendRedirect("login.html");
        } catch (Exception ex) {
            Logger.getLogger(ListaUsuarioController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
