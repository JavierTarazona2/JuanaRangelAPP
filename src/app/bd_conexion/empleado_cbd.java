/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app.bd_conexion;

import app.datos.balance;
import app.datos.cliente;
import app.datos.empleado;
import app.datos.proveedor;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author javie
 */
public class empleado_cbd {
    
    /**
     * Obtiene una conexión a la base de datos.
     *
     * @return Connection a la base de datos.
     * @throws SQLException si ocurre un error al obtener la conexión.
     */
    private Connection getConnection() throws SQLException {
        return new conexion().conexio();
    }
    /**
     * Registra un nuevo proveedor en la base de datos.
     *
     * @param p El proveedor a registrar.
     */
    public void RegistrarEmpleado(empleado p) {
        String empleadoSql = "INSERT INTO empleado (nombre, telefono, correo,identificacion,direccion,fecha_ingreso,fecha_nacimiento,estado,sueldo) VALUES ( ?, ?, ?, ?, ?, ?, ?, ?, ? )";
        String sqlActualizacion = "UPDATE balance set cantidad = cantidad + ?, fecha = ? WHERE id = 9";
        try (Connection conn = getConnection();
             PreparedStatement psActualizar = conn.prepareStatement(sqlActualizacion);
             PreparedStatement ps = conn.prepareStatement(empleadoSql)) {

            ps.setString(1, p.getNombre());
            ps.setString(2, p.getTelefono());
            ps.setString(3, p.getCorreo());
            ps.setInt(4, p.getIdentificacion());
            ps.setString(5, p.getDireccion());
            ps.setDate(6, Date.valueOf(p.getFecha_ingreso()));
            ps.setDate(7, Date.valueOf(p.getFecha_nacimiento()));
            ps.setBoolean(8, p.getEstado());
            ps.setDouble(9, p.getSueldo());
            psActualizar.setDouble(1,p.getSueldo());
            psActualizar.setDate(2, Date.valueOf(LocalDate.now()));
            psActualizar.executeUpdate();
            ps.executeUpdate();
            System.out.println("Empleado registrado exitosamente.");

        } catch (SQLException e) {
            Logger.getLogger(proveedor_cbd.class.getName()).log(Level.SEVERE, "Error al registrar el Empleado", e);
        }
    }
    
    /**
     * Método para listar todos los clientes en la base de datos.
     * 
     * @return Lista de clientes.
     */
    public ArrayList<empleado> ListarEmpleados() {
        ArrayList<empleado> empleados = new ArrayList<>();
        String sql = "SELECT * FROM empleado";

        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            // Recorrer el ResultSet y añadir los clientes a la lista
            while (rs.next()) {
                empleado c = new empleado();
                c.setNombre(rs.getString("nombre"));
                c.setTelefono(rs.getString("telefono"));
                c.setCorreo(rs.getString("correo"));
                c.setIdentificacion(rs.getInt("identificacion"));
                c.setDireccion(rs.getString("direccion"));
                c.setFecha_ingreso(rs.getDate("fecha_ingreso").toLocalDate());
                c.setFecha_nacimiento(rs.getDate("fecha_nacimiento").toLocalDate());
                c.setEstado(rs.getBoolean("estado"));
                c.setSueldo(rs.getDouble("sueldo"));
                c.setEdad();
                
                empleados.add(c);
                
            }

        } catch (SQLException ex) {
            Logger.getLogger(venta_cbd.class.getName()).log(Level.SEVERE, null, ex);
        }

        return empleados;
    }
    public empleado ListarEmpleado(String nombre) {
        String sql = "SELECT * FROM empleado WHERE nombre = ?";
        empleado c = null;

        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, nombre);
            
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                c = new empleado();
                c.setNombre(rs.getString("nombre"));
                c.setTelefono(rs.getString("telefono"));
                c.setCorreo(rs.getString("correo"));
                c.setIdentificacion(rs.getInt("identificacion"));
                c.setDireccion(rs.getString("direccion"));
                c.setFecha_ingreso(rs.getDate("fecha_ingreso").toLocalDate());
                c.setFecha_nacimiento(rs.getDate("fecha_nacimiento").toLocalDate());
                c.setEstado(rs.getBoolean("estado"));
                c.setSueldo(rs.getDouble("sueldo"));
                c.setEdad();
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(proveedor_cbd.class.getName()).log(Level.SEVERE, "Error al listar proveedor por nombre exacto", ex);
        }

        if (c == null) {
            throw new IllegalArgumentException("No se encontró proveedor con el nombre: " + nombre);
        }

        return c;
    }
    /**
    * Actualiza la información de un empleado en la base de datos.
    *
    * @param empleado El objeto empleado con la información actualizada.
    */
   public void actualizarEmpleado(empleado empleado) {
       String sql = "UPDATE empleado SET telefono = ?, correo = ?, direccion = ?, sueldo = ?, estado = ? WHERE identificacion = ?";

       try (Connection conn = getConnection();
            PreparedStatement ps = conn.prepareStatement(sql)) {

           ps.setString(1, empleado.getTelefono());
           ps.setString(2, empleado.getCorreo());
           ps.setString(3, empleado.getDireccion());
           ps.setDouble(4, empleado.getSueldo());
           ps.setBoolean(5, empleado.getEstado());
           ps.setInt(6, empleado.getIdentificacion());

           int filasActualizadas = ps.executeUpdate();
           if (filasActualizadas > 0) {
               System.out.println("Empleado actualizado exitosamente.");
           } else {
               System.out.println("No se encontró el empleado con la identificación especificada.");
           }

       } catch (SQLException e) {
           Logger.getLogger(empleado_cbd.class.getName()).log(Level.SEVERE, "Error al actualizar el empleado", e);
       }
   }

}
