package app.bd_conexion;

import app.datos.pdf;
import app.datos.usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class usuario_cbd {

    private static final Logger logger = Logger.getLogger(usuario_cbd.class.getName());
    private empleado_cbd empleados = new empleado_cbd();

    private Connection getConnection() throws SQLException {
        return (Connection) new conexion().conexio();
    }

    
    // Método para registrar un usuario
    public void registrarUsuario(usuario nuevoUsuario) {
        String sql = "INSERT INTO usuario (user, contraseña, correo, id_empleado, estado) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, nuevoUsuario.getUser());
            ps.setString(2, nuevoUsuario.getContraseña());
            ps.setString(3, nuevoUsuario.getCorreo());
            ps.setInt(4, empleados.obtenerIdEmpleado(nuevoUsuario.getEmpleado().getNombre()) );
            ps.setBoolean(5, nuevoUsuario.getAdministrador());
            ps.executeUpdate();

            System.out.println("Usuario registrado exitosamente.");

        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Error al registrar el usuario", e);
        }
    }

    
    // Método para listar todos los usuarios
    public ArrayList<usuario> listarUsuarios() {
        ArrayList<usuario> listaUsuarios = new ArrayList<>();
        String sql = "SELECT * FROM usuario";

        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                usuario user = new usuario();
                user.setUser(rs.getString("user"));
                user.setContraseña(rs.getString("contraseña"));
                user.setCorreo(rs.getString("correo"));
                user.setEmpleado(empleados.obtenerEmpleadoporId(rs.getInt("id_empleado"))); // Ajusta según constructor
                user.setAdministrador(rs.getBoolean("estado"));
                listaUsuarios.add(user);
            }

        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Error al listar los usuarios", e);
        }

        return listaUsuarios;
    }

    
    // Método para realizar el login de un usuario
    public usuario login(String user, String contraseña) {
        String sql = "SELECT * FROM usuario WHERE correo = ? AND contraseña = ?";
        usuario userLogged = null;

        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, user);
            ps.setString(2, contraseña);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    userLogged = new usuario();
                    userLogged.setUser(rs.getString("user"));
                    userLogged.setContraseña(rs.getString("contraseña"));
                    userLogged.setCorreo(rs.getString("correo"));
                    userLogged.setEmpleado(empleados.obtenerEmpleadoporId(rs.getInt("id_empleado"))); // Ajusta según constructor
                    userLogged.setAdministrador(rs.getBoolean("estado"));
                }
            }

        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Error al realizar el login", e);
        }
        return userLogged;
    }

    
    // Método para modificar la información de un usuario
    public void modificarUsuario(usuario user) {
        String sql = "UPDATE usuario SET contraseña = ?, correo = ?, estado = ? WHERE user = ?";

        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, user.getContraseña());
            ps.setString(2, user.getCorreo());
            ps.setBoolean(3, user.getAdministrador());
            ps.setString(4, user.getUser());
            int rowsUpdated = ps.executeUpdate();

            if (rowsUpdated > 0) {
                System.out.println("Usuario modificado exitosamente.");
            } else {
                System.out.println("No se encontró el usuario para modificar.");
            }

        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Error al modificar el usuario", e);
        }
    }

    
    // Método para eliminar un usuario
    public void eliminarUsuario(String user) {
        String sql = "DELETE FROM usuario WHERE user = ?";

        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, user);
            int rowsDeleted = ps.executeUpdate();

            if (rowsDeleted > 0) {
                System.out.println("Usuario eliminado exitosamente.");
            } else {
                System.out.println("No se encontró el usuario para eliminar.");
            }

        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Error al eliminar el usuario", e);
        }
    }
    
}
