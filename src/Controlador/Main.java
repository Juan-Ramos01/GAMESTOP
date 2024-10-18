package Controlador;

import Modelo.Usuario;
import Modelo.UsuarioDAO;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        UsuarioDAO usuarioDAO = null;

        try {
            usuarioDAO = new UsuarioDAO();

            // Simular login
            System.out.println("Ingrese su nombre de usuario:");
            String nombreUsuario = sc.nextLine();
            System.out.println("Ingrese su contraseña:");
            String contrasena = sc.nextLine();

            Usuario usuario = usuarioDAO.validarSesion(nombreUsuario, contrasena);

            if (usuario != null) {
                System.out.println("¡Bienvenido, " + usuario.getUsuario()+ "!");
                usuario.mostrarMenu();
            } else {
                System.out.println("Usuario o contraseña incorrectos.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
