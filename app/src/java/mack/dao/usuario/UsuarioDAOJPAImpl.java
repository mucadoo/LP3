package mack.dao.usuario;

import mack.entities.Usuario;
import java.util.*;
import javax.persistence.EntityManager;
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
    public void removeUsuario(final int id) throws UsuarioNaoEncontradoException {
        Usuario u = this.buscaUsuarioPorId(id);
        em.getTransaction().begin();
        em.remove(u);
        em.getTransaction().commit();
        close();
    }

    @Override
    public Usuario criaUsuario(final String nome, final String sobrenome, final String login, final String senha) {
        em.getTransaction().begin();
        Usuario u = new Usuario(null, nome, sobrenome, login, senha);
        em.persist(u);
        em.getTransaction().commit();
        close();
        return u;
    }

    @Override
    public void updateUsuario(final int id, final String nome, final String sobrenome, final String login, final String senha) throws UsuarioNaoEncontradoException {
        Usuario u = this.buscaUsuarioPorId(id);
        em.getTransaction().begin();
        u.setNome(nome);
        u.setSobrenome(sobrenome);
        u.setLogin(login);
        u.setSenha(senha);
        em.getTransaction().commit();
        close();
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
    
    @Override
    public Usuario login(String login, String senha) {
        Query q = em.createQuery("select u from Usuario u WHERE login = :login and senha = :senha");
        q.setParameter("login", login);
        q.setParameter("senha", senha);
        Usuario u = q.getResultList().isEmpty() ? null: (Usuario) q.getResultList().get(0);
        close();
        return u;
    }
}
