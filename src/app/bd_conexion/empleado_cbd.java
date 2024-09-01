package app.bd_conexion;


import app.datos.empleado;
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
 * Clase para manejar operaciones relacionadas con empleados en la base de datos.
 */

public class empleado_cbd {

    private static final Logger logger = Logger.getLogger(empleado_cbd.class.getName());

    /**
     * Obtiene una conexión a la base de datos.
     *
     * @return Conexión a la base de datos.
     * @throws SQLException si ocurre un error al obtener la conexión.
     */
    
    private Connection getConnection() throws SQLException {
        return new conexion().conexio();
    }

    
    /**
     * Registra un nuevo empleado en la base de datos.
     *
     * @param emp
     * @param empleado El empleado a registrar.
     */
    
    public void registrarEmpleado(empleado emp) {
        String sqlEmpleado = "INSERT INTO empleado (nombre, telefono, correo, identificacion, direccion, fecha_ingreso, fecha_nacimiento, estado, sueldo) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        String sqlActualizacion = "UPDATE balance SET cantidad = cantidad + ?, fecha = ? WHERE id = 9";

        try (Connection conn = getConnection();
             PreparedStatement psEmpleado = conn.prepareStatement(sqlEmpleado);
             PreparedStatement psActualizacion = conn.prepareStatement(sqlActualizacion)) {

            // Configurar parámetros para la inserción del empleado
            setEmpleadoParameters(psEmpleado, emp);
            psEmpleado.executeUpdate();

            // Configurar parámetros para la actualización del balance
            psActualizacion.setDouble(1, emp.getSueldo());
            psActualizacion.setDate(2, Date.valueOf(LocalDate.now()));
            psActualizacion.executeUpdate();

            System.out.println("Empleado registrado exitosamente.");

        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Error al registrar el empleado", e);
        }
    }

    
    /**
     * Configura los parámetros del PreparedStatement para insertar un empleado.
     *
     * @param ps El PreparedStatement a configurar.
     * @param emp El objeto empleado con los datos.
     * @throws SQLException si ocurre un error al configurar los parámetros.
     */
    
    private void setEmpleadoParameters(PreparedStatement ps, empleado emp) throws SQLException {
        ps.setString(1, emp.getNombre());
        ps.setString(2, emp.getTelefono());
        ps.setString(3, emp.getCorreo());
        ps.setInt(4, emp.getIdentificacion());
        ps.setString(5, emp.getDireccion());
        ps.setDate(6, Date.valueOf(emp.getFecha_ingreso()));
        ps.setDate(7, Date.valueOf(emp.getFecha_nacimiento()));
        ps.setBoolean(8, emp.getEstado());
        ps.setDouble(9, emp.getSueldo());
    }

    
    /**
     * Lista todos los empleados en la base de datos.
     *
     * @return Lista de empleados.
     */
    
    public ArrayList<empleado> listarEmpleados() {
        ArrayList<empleado> empleados = new ArrayList<>();
        String sql = "SELECT * FROM empleado";

        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                empleados.add(resultSetToEmpleado(rs));
            }

        } catch (SQLException ex) {
            logger.log(Level.SEVERE, "Error al listar empleados", ex);
        }

        return empleados;
    }

    
    /**
     * Obtiene un empleado específico por nombre.
     *
     * @param nombre Nombre del empleado.
     * @return El empleado con el nombre especificado.
     * @throws IllegalArgumentException si no se encuentra el empleado.
     */
    
    public empleado listarEmpleado(String nombre) {
        String sql = "SELECT * FROM empleado WHERE nombre = ?";
        empleado emp = null;

        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, nombre);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    emp = resultSetToEmpleado(rs);
                }
            }

        } catch (SQLException ex) {
            logger.log(Level.SEVERE, "Error al listar empleado por nombre", ex);
        }

        if (emp == null) {
            throw new IllegalArgumentException("No se encontró empleado con el nombre: " + nombre);
        }

        return emp;
    }

    
    /**
     * Actualiza la información de un empleado en la base de datos.
     *
     * @param emp El objeto empleado con la información actualizada.
     */
    
    public void actualizarEmpleado(empleado emp) {
        String sql = "UPDATE empleado SET telefono = ?, correo = ?, direccion = ?, sueldo = ?, estado = ? WHERE identificacion = ?";

        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, emp.getTelefono());
            ps.setString(2, emp.getCorreo());
            ps.setString(3, emp.getDireccion());
            ps.setDouble(4, emp.getSueldo());
            ps.setBoolean(5, emp.getEstado());
            ps.setInt(6, emp.getIdentificacion());

            int filasActualizadas = ps.executeUpdate();
            if (filasActualizadas > 0) {
                System.out.println("Empleado actualizado exitosamente.");
            } else {
                System.out.println("No se encontró el empleado con la identificación especificada.");
            }

        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Error al actualizar el empleado", e);
        }
    }

    
    /**
     * Convierte un ResultSet en un objeto empleado.
     *
     * @param rs El ResultSet con los datos del empleado.
     * @return El objeto empleado.
     * @throws SQLException si ocurre un error al leer del ResultSet.
     */
    
    private empleado resultSetToEmpleado(ResultSet rs) throws SQLException {
        empleado emp = new empleado();
        emp.setNombre(rs.getString("nombre"));
        emp.setTelefono(rs.getString("telefono"));
        emp.setCorreo(rs.getString("correo"));
        emp.setIdentificacion(rs.getInt("identificacion"));
        emp.setDireccion(rs.getString("direccion"));
        emp.setFecha_ingreso(rs.getDate("fecha_ingreso").toLocalDate());
        emp.setFecha_nacimiento(rs.getDate("fecha_nacimiento").toLocalDate());
        emp.setEstado(rs.getBoolean("estado"));
        emp.setSueldo(rs.getDouble("sueldo"));
        emp.setEdad();
        return emp;
    }
    
    
     /**
     * Obtiene el ID del producto basado en su código.
     * @param nombre Código del producto.
     * @return ID del producto, o null si no se encuentra.
     */
    
    public Integer obtenerIdEmpleado(String nombre) {
        String sql = "SELECT id FROM empleado WHERE nombre = ?";
        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, nombre);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt("id");
                }
            }
        } catch (SQLException e) {
            Logger.getLogger(producto_cbd.class.getName()).log(Level.SEVERE, "Error al obtener el ID del empleado", e);
        }
        return null;
    }
    
    
     /**
     * Obtiene un empleado específico por nombre.
     *
     * @param id id del empleado.
     * @return El empleado con el nombre especificado.
     * @throws IllegalArgumentException si no se encuentra el empleado.
     */
    
    public empleado obtenerEmpleadoporId(Integer id) {
        String sql = "SELECT * FROM empleado WHERE nombre = ?";
        empleado emp = null;

        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    emp = resultSetToEmpleado(rs);
                }
            }

        } catch (SQLException ex) {
            logger.log(Level.SEVERE, "Error al listar empleado por nombre", ex);
        }

        if (emp == null) {
            throw new IllegalArgumentException("No se encontró empleado con el nombre: " + id);
        }

        return emp;
    }
    
    
    
}
