package Modelo;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UsuarioDAO {

    String bd = "gamestop";
    String url = "jdbc:mysql://localhost:3306/";
    String user = "JRamos";
    String password = "3106840188A";
    String driver = "com.mysql.cj.jdbc.Driver";
    Connection conexion;

    public UsuarioDAO(String bd) {
        this.bd = bd;
    }

    public Connection conectar() {
        try {
            Class.forName(driver);
            conexion = DriverManager.getConnection(url + bd, user, password);
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("No se conecto a la base de datos " + bd);
//            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return conexion;
    }

    public void desconectar() {
        try {
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void main(String[] args) {
        UsuarioDAO cn = new UsuarioDAO("gamestop");
        cn.conectar();
    }
}
