package mack.dao.usuario;

public final class UsuarioDAOFactory {

    public UsuarioDAOFactory() {
    }

    public static UsuarioDAO getUsuarioDAO() {
        return new UsuarioDAOJPAImpl();
    }
}
