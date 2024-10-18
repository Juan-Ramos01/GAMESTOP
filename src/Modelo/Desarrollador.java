package Modelo;

public class Desarrollador extends Usuario {

    public Desarrollador(String usuario, String password) {
        super(usuario, password);
    }

    @Override
    public void mostrarMenu() {
        System.out.println("=== Menú del Desarrollador ===");
        System.out.println("1. Subir juego");
        System.out.println("2. Ver estadísticas de juegos subidos");
        System.out.println("3. Actualizar información de juegos");
    }

}
