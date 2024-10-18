package Modelo;

public class Administrador extends Usuario {

    public Administrador(String usuario, String password) {
        super(usuario, password);
    }

    @Override
    public void mostrarMenu() {
        System.out.println("=== Menú del Administrador ===");
        System.out.println("1. Gestionar juegos");
        System.out.println("2. Gestionar usuarios");
        System.out.println("3. Ver reportes de ventas");
    }
}
