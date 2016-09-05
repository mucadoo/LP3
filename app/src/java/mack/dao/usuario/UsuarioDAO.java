package mack.dao.usuario;

import mack.entities.Usuario;
import java.util.Collection;

public interface UsuarioDAO {

    public Usuario buscaUsuarioPorId(int id) throws UsuarioNaoEncontradoException;

    public Collection buscaUsuarioPorNome(String nome);

    public Collection buscaTodosUsuarios();

    public void removeUsuario(int id) throws UsuarioNaoEncontradoException;

    public Usuario criaUsuario(String nome, String sobrenome, String login, String senha);

    public void updateUsuario(int id, String nome, String sobrenome, String login, String senha) throws UsuarioNaoEncontradoException;

    public void close();

    public boolean isClosed();

    public Usuario login(String login, String senha);
}
