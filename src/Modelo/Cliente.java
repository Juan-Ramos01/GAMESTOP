package Modelo;

public class Cliente extends Usuario {

    public Cliente(String usuario, String password) {
        super(usuario, password);
    }

    @Override
    public void mostrarMenu() {
        System.out.println("=== Menú del Cliente ===");
        System.out.println("1. Ver juegos disponibles");
        System.out.println("2. Comprar juego");
        System.out.println("3. Ver historial de compras");
    }

}
