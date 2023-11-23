package mapped.api.controllers;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import mapped.api.models.entities.Usuario;
import mapped.api.models.repositories.UsuarioRepository;

import java.sql.SQLException;
import java.util.List;

@Path("/usuarios")
public class UsuarioResource {
    private UsuarioRepository repository = new UsuarioRepository();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Usuario> getUsuarios() throws SQLException {
        return repository.findAll();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void addUsuario(Usuario usuario) throws SQLException {
        repository.add(usuario);
    }

    @GET
    @Path("/{cdUsuario}")
    @Produces(MediaType.APPLICATION_JSON)
    public Usuario getUsuarioByCd(@PathParam("cdUsuario") Integer cdUsuario) throws SQLException {
        return repository.find(cdUsuario).orElse(null);
    }

    @PUT
    @Path("/{cdUsuario}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Usuario updateUsuario(@PathParam("cdUsuario") Integer cdUsuario, Usuario usuario) throws SQLException {
        if (repository.find(cdUsuario).isPresent()) {
            usuario.setCdUsuario(cdUsuario);
            repository.update(cdUsuario, usuario);
            return repository.find(cdUsuario).orElse(null);
        }
        return usuario;
    }

    @DELETE
    @Path("/{cdUsuario}")
    public void deleteUsuario(@PathParam("cdUsuario") Integer cdUsuario) throws SQLException {
        if (repository.find(cdUsuario).isPresent()) {
            repository.delete(cdUsuario);
        }
    }
}
