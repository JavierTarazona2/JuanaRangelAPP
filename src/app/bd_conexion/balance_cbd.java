package app.bd_conexion;

import app.datos.balance;
import app.datos.producto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class balance_cbd {

    // Método para obtener una nueva conexión a la base de datos
    private Connection getConnection() throws SQLException {
        return new conexion().conexio();
    }

    /**
     * Método para registrar un balance en la base de datos.
     * 
     * @param b Objeto balance a registrar.
     */
    public void registrarBalance(balance b) {
        // Consultas SQL
        String sqlTipo = "SELECT id FROM tipo_balance WHERE nombre = ?";
        String sqlBalance = "INSERT INTO balance (detalle, cantidad, fecha, tipo_balance) VALUES (?, ?, ?, ?)";

        try (Connection conn = getConnection();
             PreparedStatement tipoPs = conn.prepareStatement(sqlTipo);
             PreparedStatement balancePs = conn.prepareStatement(sqlBalance)) {

            // Obtener el ID del tipo de balance
            tipoPs.setString(1, b.getTipo());
            try (ResultSet rs = tipoPs.executeQuery()) {
                if (rs.next()) {
                    int tipoId = rs.getInt("id");

                    // Preparar y ejecutar la inserción del balance
                    balancePs.setString(1, b.getDetalles());
                    balancePs.setDouble(2, b.getValor());
                    balancePs.setDate(3, java.sql.Date.valueOf(b.getFecha()));
                    balancePs.setInt(4, tipoId);

                    balancePs.executeUpdate();
                    System.out.println("Balance registrado exitosamente.");
                } else {
                    throw new IllegalArgumentException("Tipo de balance no encontrado: " + b.getTipo());
                }
            }

        } catch (SQLException e) {
            Logger.getLogger(balance_cbd.class.getName()).log(Level.SEVERE, "Error al registrar el balance", e);
        }
    }

    /**
     * Método para listar todos los balances.
     * 
     * @return Lista de objetos balance.
     */
    public ArrayList<balance> listarBalances() {
        ArrayList<balance> balances = new ArrayList<>();
        String sql = "SELECT detalle, cantidad, fecha, tipo_balance FROM balance";

        // Mapa para almacenar en caché los nombres de los tipos de balance
        Map<Integer, String> tipoCache = new HashMap<>();

        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                int tipoId = rs.getInt("tipo_balance");

                // Obtener el nombre del tipo de balance, usando el caché si es posible
                String tipoNombre = tipoCache.computeIfAbsent(tipoId, id -> {
                    String tipoSql = "SELECT nombre FROM tipo_balance WHERE id = ?";
                    try (PreparedStatement tipoPs = conn.prepareStatement(tipoSql)) {
                        tipoPs.setInt(1, id);
                        try (ResultSet tipoRs = tipoPs.executeQuery()) {
                            if (tipoRs.next()) {
                                return tipoRs.getString("nombre");
                            }
                        }
                    } catch (SQLException e) {
                        Logger.getLogger(balance_cbd.class.getName()).log(Level.SEVERE, "Error al obtener el nombre del tipo de balance", e);
                    }
                    return null;
                });

                // Crear el objeto balance
                balance b = new balance();
                b.setDetalles(rs.getString("detalle"));
                b.setValor(rs.getDouble("cantidad"));
                b.setFecha(rs.getDate("fecha").toLocalDate());
                b.setTipo(tipoNombre);

                balances.add(b);
            }

        } catch (SQLException ex) {
            Logger.getLogger(balance_cbd.class.getName()).log(Level.SEVERE, "Error al listar los balances", ex);
        }

        return balances;
    }
    public ArrayList<balance> listarBalances(Integer año, Integer mes) {
    ArrayList<balance> balances = new ArrayList<>();
    String sql = "SELECT detalle, cantidad, fecha, tipo_balance FROM balance WHERE YEAR(fecha) = ? AND MONTH(fecha) = ?";

    // Caché para almacenar los nombres de los tipos de balance, evitando múltiples consultas
    Map<Integer, String> tipoCache = new HashMap<>();

    try (Connection conn = getConnection();
         PreparedStatement ps = conn.prepareStatement(sql)) {
        
        // Establecer los parámetros del año y mes en la consulta
        ps.setInt(1, año);
        ps.setInt(2, mes);
        
        try (ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                int tipoId = rs.getInt("tipo_balance");

                // Obtener el nombre del tipo de balance desde el caché, o hacer la consulta si no está en caché
                String tipoNombre = tipoCache.computeIfAbsent(tipoId, id -> {
                    String tipoSql = "SELECT nombre FROM tipo_balance WHERE id = ?";
                    try (PreparedStatement tipoPs = conn.prepareStatement(tipoSql)) {
                        tipoPs.setInt(1, id);
                        try (ResultSet tipoRs = tipoPs.executeQuery()) {
                            if (tipoRs.next()) {
                                return tipoRs.getString("nombre");
                            }
                        }
                    } catch (SQLException e) {
                        Logger.getLogger(balance_cbd.class.getName()).log(Level.SEVERE, "Error al obtener el nombre del tipo de balance", e);
                    }
                    return null; // En caso de error, devuelve null para que no agregue datos incorrectos
                });

                // Crear y agregar el objeto balance a la lista
                balance b = new balance();
                b.setDetalles(rs.getString("detalle"));
                b.setValor(rs.getDouble("cantidad"));
                b.setFecha(rs.getDate("fecha").toLocalDate());
                b.setTipo(tipoNombre); // Asignar el nombre del tipo desde el caché o la consulta

                balances.add(b);
            }
        }

    } catch (SQLException ex) {
        Logger.getLogger(balance_cbd.class.getName()).log(Level.SEVERE, "Error al listar los balances", ex);
    }

    return balances;
}


    /**
     * Método para obtener el ID de un tipo de balance basado en su nombre.
     * 
     * @param nombre_tipo Nombre del tipo de balance.
     * @return ID del tipo de balance, o null si no se encuentra.
     */
    public Integer obtenerIdTipo(String nombre_tipo) {
        String sql = "SELECT id FROM tipo_balance WHERE nombre = ?";
        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, nombre_tipo);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt("id");
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(balance_cbd.class.getName()).log(Level.SEVERE, "Error al obtener el ID del tipo de balance", ex);
        }
        return null;
    }

    /**
     * Método para calcular la utilidad total (Ingresos - Gastos).
     * 
     * @param balancess
     * @return La utilidad total.
     */
    public Double utilidad(ArrayList<balance> balancess) {
        double utilidad = 0.0;
        ArrayList<balance> utilidades = balancess ;

        for (balance b : utilidades) {
            if (b.getTipo().equalsIgnoreCase("Gasto")) {
                utilidad -= b.getValor();
            } else if (b.getTipo().equalsIgnoreCase("Ingreso")) {
                utilidad += b.getValor();
            }
        }

        return utilidad;
    }
}
