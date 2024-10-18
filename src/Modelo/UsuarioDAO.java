package Modelo;

import java.sql.*;

public class UsuarioDAO {

    private Connection conexion;

    public UsuarioDAO() throws SQLException {
        this.conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/gamestop", "JRamos", "3106840188A");
    }

    public Usuario validarSesion(String usuario, String password) throws SQLException {
        String query = "SELECT * FROM usuarios WHERE usuario = ? AND password = ?";
        PreparedStatement stmt = conexion.prepareStatement(query);
        stmt.setString(1, usuario);
        stmt.setString(2, password);
        ResultSet rs = stmt.executeQuery();

        if (rs.next()) {
            String rol = rs.getString("rol");
            switch (rol) {
                case "cliente":
                    return new Cliente(usuario, password);

                case "administrador":
                    return new Administrador(usuario, password);

                case "desarrollador":
                    return new Desarrollador(usuario, password);
                default:
                    return null;
            }
        }
        return null;
    }

    public boolean registrarUsuario(Usuario usuario) throws SQLException {
        String query = "INSERT INTO usuarios (usuario, password, rol) VALUES (?, ?, ?)";
        PreparedStatement stmt = conexion.prepareStatement(query);
        stmt.setString(1, usuario.getUsuario());
        stmt.setString(2, usuario.getPassword());
        stmt.setString(3, usuario.getRol());
        int rowsAffected = stmt.executeUpdate();
        return rowsAffected > 0;
    }

    public void eliminarUsuario() throws SQLException {
    }
}
