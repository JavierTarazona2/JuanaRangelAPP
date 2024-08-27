package app.bd_conexion;

import app.datos.categoria;
import app.datos.producto;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class producto_cbd {

    // Método para obtener una nueva conexión a la base de datos
    private Connection getConnection() throws SQLException {
        return new conexion().conexio();
    }

    // Método para obtener todas las categorías de productos
    public ArrayList<categoria> obtenerCategorias() {
        ArrayList<categoria> categorias = new ArrayList<>();
        String sql = "SELECT id, nombre FROM categoria";

        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                categoria c = new categoria(rs.getInt("id"), rs.getString("nombre"));
                categorias.add(c);
            }

        } catch (SQLException ex) {
            Logger.getLogger(producto_cbd.class.getName()).log(Level.SEVERE, null, ex);
        }
        return categorias;
    }

    // Método para registrar un nuevo producto en la base de datos
    public void RegistrarProducto(producto p) {
        String categoriaSql = "SELECT id FROM categoria WHERE nombre = ?";
        String productoSql = "INSERT INTO producto (codigo, nombre, medida, id_categoria, precio_entrada, precio_venta, fecha_vencimiento, fecha_ingreso, cantidad) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = getConnection();
             PreparedStatement categoriaPs = conn.prepareStatement(categoriaSql);
             PreparedStatement productoPs = conn.prepareStatement(productoSql)) {

            // Obtener el id de la categoría
            categoriaPs.setString(1, p.getCategoria());
            try (ResultSet rs = categoriaPs.executeQuery()) {
                if (rs.next()) {
                    int categoriaId = rs.getInt("id");

                    // Insertar el producto
                    productoPs.setString(1, p.getCodigo());
                    productoPs.setString(2, p.getNombre());
                    productoPs.setString(3, p.getMedida());
                    productoPs.setInt(4, categoriaId);
                    productoPs.setDouble(5, p.getPrecio_entrada());
                    productoPs.setDouble(6, p.getPrecio_salida());
                    productoPs.setDate(7, java.sql.Date.valueOf(p.getFeche_vencimiento()));
                    productoPs.setDate(8, java.sql.Date.valueOf(p.getFecha_ingreso()));
                    productoPs.setInt(9, p.getCantidad());

                    productoPs.executeUpdate();
                    System.out.println("Producto registrado exitosamente.");
                } else {
                    throw new IllegalArgumentException("Categoría no encontrada: " + p.getCategoria());
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error al registrar el producto: " + e.getMessage());
        }
    }

    // Método para listar todos los productos
    public ArrayList<producto> ListarProductos() {
        ArrayList<producto> productos = new ArrayList<>();
        String sql = "SELECT codigo, nombre, medida, id_categoria, precio_entrada, precio_venta, fecha_vencimiento, fecha_ingreso, cantidad FROM producto";
        Map<Integer, String> categoriaCache = new HashMap<>();

        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Integer id_categoria = rs.getInt("id_categoria");
                String categoriaNombre = categoriaCache.computeIfAbsent(id_categoria, id -> obtenerNombreCategoria(id, conn));

                // Crear el objeto producto
                producto p = new producto();
                p.setCodigo(rs.getString("codigo"));
                p.setNombre(rs.getString("nombre"));
                p.setMedida(rs.getString("medida"));
                p.setCategoria(categoriaNombre);
                p.setPrecio_entrada(rs.getDouble("precio_entrada"));
                p.setPrecio_salida(rs.getDouble("precio_venta"));
                p.setFeche_vencimiento(rs.getDate("fecha_vencimiento").toLocalDate());
                p.setFecha_ingreso(rs.getDate("fecha_ingreso").toLocalDate());
                p.setCantidad(rs.getInt("cantidad"));

                productos.add(p);
            }

        } catch (SQLException ex) {
            Logger.getLogger(producto_cbd.class.getName()).log(Level.SEVERE, null, ex);
        }

        return productos;
    }

    // Método para obtener el nombre de la categoría basado en su id
    private String obtenerNombreCategoria(Integer id_categoria, Connection conn) {
        String sql = "SELECT nombre FROM categoria WHERE id = ?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id_categoria);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return rs.getString("nombre");
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(producto_cbd.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    // Método para buscar productos por nombre o código
    public ArrayList<producto> buscadoListarProductos(String nombreProducto) {
        ArrayList<producto> productos = new ArrayList<>();
        String sql = "SELECT codigo, nombre, medida, id_categoria, precio_entrada, precio_venta, fecha_vencimiento, fecha_ingreso, cantidad FROM producto WHERE nombre LIKE ? OR codigo LIKE ?";
        Map<Integer, String> categoriaCache = new HashMap<>();

        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            
            ps.setString(1, "%" + nombreProducto + "%");
            ps.setString(2, "%" + nombreProducto + "%");
            
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Integer id_categoria = rs.getInt("id_categoria");
                    String categoriaNombre = categoriaCache.computeIfAbsent(id_categoria, id -> obtenerNombreCategoria(id, conn));

                    // Crear el objeto producto
                    producto p = new producto();
                    p.setCodigo(rs.getString("codigo"));
                    p.setNombre(rs.getString("nombre"));
                    p.setMedida(rs.getString("medida"));
                    p.setCategoria(categoriaNombre);
                    p.setPrecio_entrada(rs.getDouble("precio_entrada"));
                    p.setPrecio_salida(rs.getDouble("precio_venta"));
                    p.setFeche_vencimiento(rs.getDate("fecha_vencimiento").toLocalDate());
                    p.setFecha_ingreso(rs.getDate("fecha_ingreso").toLocalDate());
                    p.setCantidad(rs.getInt("cantidad"));

                    productos.add(p);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(producto_cbd.class.getName()).log(Level.SEVERE, null, ex);
        }

        return productos;
    }

    // Método para buscar un producto por nombre exacto o código exacto
    public producto buscadoListarProductos(String nombreProducto, String codigo_producto) {
        ArrayList<producto> productos = new ArrayList<>();
        String sql = "SELECT codigo, nombre, medida, id_categoria, precio_entrada, precio_venta, fecha_vencimiento, fecha_ingreso, cantidad FROM producto WHERE nombre = ? OR codigo = ?";
        Map<Integer, String> categoriaCache = new HashMap<>();

        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            
            ps.setString(1, nombreProducto);
            ps.setString(2, codigo_producto);
            
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Integer id_categoria = rs.getInt("id_categoria");
                    String categoriaNombre = categoriaCache.computeIfAbsent(id_categoria, id -> obtenerNombreCategoria(id, conn));

                    // Crear el objeto producto
                    producto p = new producto();
                    p.setCodigo(rs.getString("codigo"));
                    p.setNombre(rs.getString("nombre"));
                    p.setMedida(rs.getString("medida"));
                    p.setCategoria(categoriaNombre);
                    p.setPrecio_entrada(rs.getDouble("precio_entrada"));
                    p.setPrecio_salida(rs.getDouble("precio_venta"));
                    p.setFeche_vencimiento(rs.getDate("fecha_vencimiento").toLocalDate());
                    p.setFecha_ingreso(rs.getDate("fecha_ingreso").toLocalDate());
                    p.setCantidad(rs.getInt("cantidad"));

                    productos.add(p);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(producto_cbd.class.getName()).log(Level.SEVERE, null, ex);
        }

        // Verificar si la lista está vacía antes de acceder al primer elemento
        if (productos.isEmpty()) {
            throw new IllegalArgumentException("No se encontró producto con el nombre o código proporcionado.");
        }

        return productos.get(0);
    }

    // Método para obtener el ID de un producto por su nombre o código
    public Integer obtenerIdProducto(String nombre, String codigo) {
        Integer id = null;
        String sql = "SELECT id FROM producto WHERE nombre = ? OR codigo = ?";

        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            
            ps.setString(1, nombre);
            ps.setString(2, codigo);
            
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    id = rs.getInt("id");
                }
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(proveedor_cbd.class.getName()).log(Level.SEVERE, null, ex);
        }

        return id;
    }

    // Método para obtener un producto por su ID
    public producto obtenerProductoPorId(Integer id) {
        producto p = null;
        String sql = "SELECT * FROM producto WHERE id = ?";

        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    p = new producto();
                    p.setNombre(rs.getString("nombre"));
                    p.setCodigo(rs.getString("codigo"));
                    p.setPrecio_entrada(rs.getDouble("precio_entrada"));
                    // Añade cualquier otro campo necesario
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(producto_cbd.class.getName()).log(Level.SEVERE, null, ex);
        }

        return p;
    }
}
