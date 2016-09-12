package mack.filters;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter(filterName = "FiltroAutenticacao", urlPatterns = {"/*"})
public class FiltroAutenticacao implements Filter {

    private ServletContext context;

    @Override
    public void init(FilterConfig fConfig) throws ServletException {
        this.context = fConfig.getServletContext();
        this.context.log("Filtro de autenticacao inicializado");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        String uri = req.getRequestURI();
        String control = request.getParameter("control") == null ? "" : req.getParameter("control");
        this.context.log("Requested Resource::" + uri);

        HttpSession session = req.getSession(false);

        if ((session == null || session.getAttribute("usuario") == null) && !(uri.endsWith("index.jsp") || uri.endsWith("LP3_-_1/") || control.equals("Login") || uri.endsWith(".css") || uri.endsWith(".js"))) {
            req.setAttribute("msg", "Unauthorized access request");
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/index.jsp");
            requestDispatcher.forward(req, res);
        } else if (session != null && session.getAttribute("usuario") != null && (uri.endsWith("index.jsp") || uri.endsWith("LP3_-_1/") || control.equals("Login"))) {
            res.sendRedirect("sucessoLogin.jsp");
        } else {
            // pass the request along the filter chain
            chain.doFilter(request, response);
        }
    }

    @Override
    public void destroy() {
        //close any resources here
    }

}
