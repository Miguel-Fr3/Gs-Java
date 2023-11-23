package mapped.api.models.services;

import mapped.api.models.entities.Usuario;
import mapped.api.models.repositories.UsuarioRepository;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class UsuarioService {
    private final UsuarioRepository usuarioRepository;

    public UsuarioService() {
        this.usuarioRepository = new UsuarioRepository();
    }

    public List<Usuario> findAll() throws SQLException {
        return usuarioRepository.findAll();
    }

    public void add(Usuario usuario) throws SQLException {
        usuarioRepository.add(usuario);
    }

    public Optional<Usuario> find(Integer cdUsuario) throws SQLException {
        return usuarioRepository.find(cdUsuario);
    }

    public void update(Integer cdUsuario, Usuario usuario) throws SQLException {
        usuarioRepository.update(cdUsuario, usuario);
    }

    public void delete(Integer cdUsuario) throws SQLException {
        usuarioRepository.delete(cdUsuario);
    }
}
