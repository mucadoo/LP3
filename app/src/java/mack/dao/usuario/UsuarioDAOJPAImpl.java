package mack.dao.usuario;

import mack.entities.Usuario;
import java.util.*;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import org.apache.commons.logging.*;

public class UsuarioDAOJPAImpl implements UsuarioDAO {

    static final private Log log = LogFactory.getLog(UsuarioDAOJPAImpl.class);
    private boolean bIsClosed = false;
    private EntityManager em = Persistence.createEntityManagerFactory("UsuarioPU").createEntityManager();

    public UsuarioDAOJPAImpl() {
    }

    @Override
    public Usuario buscaUsuarioPorId(final int id) throws UsuarioNaoEncontradoException {
        Usuario u = em.find(Usuario.class, id);
        if (u == null) {
            throw new UsuarioNaoEncontradoException("usuario não encontrado");
        }
        close();
        return u;
    }

    @Override
    public Collection buscaUsuarioPorNome(final String nome) {
        Query q = em.createQuery("select u from Usuario u WHERE nome like :search or sobrenome like :search");
        q.setParameter("search", "%" + nome + "%");
        Collection<Usuario> lista = q.getResultList();
        close();
        return lista;
    }

    @Override
    public void removeUsuario(final int id)
            throws UsuarioNaoEncontradoException {
    }

    @Override
    public Usuario criaUsuario(final String nome, final String sobrenome) {
        em.getTransaction().begin();
        Usuario result = new Usuario(null, nome, sobrenome);
        em.persist(result);
        em.getTransaction().commit();
        close();
        return result;
    }

    @Override
    public void updateUsuario(final int id,
            final String nome,
            final String sobrenome) throws UsuarioNaoEncontradoException {
    }

    @Override
    public void close() {
        log.info("close() called");
        bIsClosed = true;
        em.clear();
        em.close();
    }

    @Override
    public boolean isClosed() {
        return bIsClosed;
    }

    @Override
    public Collection buscaTodosUsuarios() {
        Collection<Usuario> lista = em.createQuery("SELECT u FROM Usuario u").getResultList();
        close();
        return lista;
    }
}
