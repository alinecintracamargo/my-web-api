package dio.my_web_api.repository;

import dio.my_web_api.model.Usuario;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;


@Repository
public class UsuarioRepository {
    public void save(Usuario usuario) {
        System.out.println("SAVE - Recebendo o usuário na camada de repositório");
        System.out.println(usuario);
    }

    public void update(Usuario usuario) {
        System.out.println("UPDATE - Recebendo o usuário na camada de repositório");
        System.out.println(usuario);
    }

    public void deleteById(Integer id) {
        System.out.println(String.format("DELETE/id - Recebendo o id: %d para excluir um usuário", id));
        System.out.println(id);
    }

    public List<Usuario> listAll() {
        List<Usuario> usuarios = new ArrayList<>();
        usuarios.add(new Usuario("gleyson", "password"));
        usuarios.add(new Usuario("frank", "masterpass"));
        return usuarios;
    }

    public Usuario findByUsername(String username) {
        System.out.println(String.format("GET/username - Recebendo o username: %s para localizar um usuário", username));
        return new Usuario("gleyson", "password");
    }

    public List<Usuario> findAll() {
        List<Usuario> usuarios = new ArrayList<>();
        usuarios.add(new Usuario("gleyson", "password"));
        usuarios.add(new Usuario("frank", "masterpass"));
        return usuarios;
    }
}