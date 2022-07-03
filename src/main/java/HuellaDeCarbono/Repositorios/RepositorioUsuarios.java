package HuellaDeCarbono.Repositorios;

import HuellaDeCarbono.MedioDeTransporte.Parada;
import HuellaDeCarbono.Seguridad.Usuario;

import java.util.ArrayList;
import java.util.List;

public class RepositorioUsuarios {
    private static RepositorioUsuarios instance = new RepositorioUsuarios();
    private ArrayList<Usuario> usuarios;

    private RepositorioUsuarios() {
        this.usuarios = new ArrayList<>();

    }

    public ArrayList<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(ArrayList<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public static RepositorioUsuarios getRepositorio() {
        return instance;
    }

    public void agregarUsuario(Usuario user){
        this.usuarios.add(user);
    }
}
