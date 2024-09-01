package app.bd_conexion;

import app.datos.categoria;
import app.datos.producto;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.logging.Level;
import java.util.logging.Logger;

public class producto_cbd {

    // Método para obtener una nueva conexión a la base de datos
    
    private Connection getConnection() throws SQLException {
        return new conexion().conexio();
    }

    
    /**
     * Obtiene todas las categorías de productos desde la base de datos.
     * @return Lista de categorías.
     */
    
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
            Logger.getLogger(producto_cbd.class.getName()).log(Level.SEVERE, "Error al obtener categorías", ex);
        }
        return categorias;
    }

    
    /**
     * Registra un nuevo producto en la base de datos.
     * @param p Objeto producto a registrar.
     */
    
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
            Logger.getLogger(producto_cbd.class.getName()).log(Level.SEVERE, "Error al registrar el producto", e);
        }
    }

    
    /**
     * Lista todos los productos desde la base de datos.
     * @return Lista de productos.
     */
    
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
            Logger.getLogger(producto_cbd.class.getName()).log(Level.SEVERE, "Error al listar productos", ex);
        }

        return productos;
    }

    
    /**
     * Obtiene el nombre de la categoría basado en su id.
     * @param id_categoria Id de la categoría.
     * @param conn Conexión a la base de datos.
     * @return Nombre de la categoría.
     */
    
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
            Logger.getLogger(producto_cbd.class.getName()).log(Level.SEVERE, "Error al obtener nombre de categoría", ex);
        }
        return null;
    }

    
    /**
     * Busca productos por nombre o código.
     * @param nombreProducto Nombre o código del producto a buscar.
     * @return Lista de productos que coinciden con la búsqueda.
     */
    
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
            Logger.getLogger(producto_cbd.class.getName()).log(Level.SEVERE, "Error al buscar productos", ex);
        }

        return productos;
    }

    
    /**
     * Busca un producto por nombre exacto o código exacto.
     * @param nombreProducto Nombre del producto.
     * @param codigo_producto Código del producto.
     * @return Producto encontrado.
     */
    
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
            Logger.getLogger(producto_cbd.class.getName()).log(Level.SEVERE, "Error al buscar producto por nombre o código", ex);
        }

        // Verificar si la lista está vacía y retornar el primer producto si existe
        return productos.isEmpty() ? null : productos.get(0);
    }

    
    /**
     * Actualiza los detalles de un producto existente.
     * @param p Producto con detalles actualizados.
     */
    
    public void ActualizarProducto(producto p) {
        String categoriaSql = "SELECT id FROM categoria WHERE nombre = ?";
        String productoSql = "UPDATE producto SET nombre = ?, medida = ?, id_categoria = ?, precio_entrada = ?, precio_venta = ?, fecha_vencimiento = ?, fecha_ingreso = ?, cantidad = ? WHERE codigo = ?";

        try (Connection conn = getConnection();
             PreparedStatement categoriaPs = conn.prepareStatement(categoriaSql);
             PreparedStatement productoPs = conn.prepareStatement(productoSql)) {

            // Obtener el id de la categoría
            categoriaPs.setString(1, p.getCategoria());
            try (ResultSet rs = categoriaPs.executeQuery()) {
                if (rs.next()) {
                    int categoriaId = rs.getInt("id");

                    // Actualizar el producto
                    productoPs.setString(1, p.getNombre());
                    productoPs.setString(2, p.getMedida());
                    productoPs.setInt(3, categoriaId);
                    productoPs.setDouble(4, p.getPrecio_entrada());
                    productoPs.setDouble(5, p.getPrecio_salida());
                    productoPs.setDate(6, java.sql.Date.valueOf(p.getFeche_vencimiento()));
                    productoPs.setDate(7, java.sql.Date.valueOf(p.getFecha_ingreso()));
                    productoPs.setInt(8, p.getCantidad());
                    productoPs.setString(9, p.getCodigo());

                    productoPs.executeUpdate();
                    System.out.println("Producto actualizado exitosamente.");
                } else {
                    throw new IllegalArgumentException("Categoría no encontrada: " + p.getCategoria());
                }
            }

        } catch (SQLException e) {
            Logger.getLogger(producto_cbd.class.getName()).log(Level.SEVERE, "Error al actualizar el producto", e);
        }
    }

    
    /**
     * Elimina un producto de la base de datos.
     * @param codigo Código del producto a eliminar.
     */
    
    public void EliminarProducto(String codigo) {
        String sql = "DELETE FROM producto WHERE codigo = ?";

        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, codigo);
            ps.executeUpdate();
            System.out.println("Producto eliminado exitosamente.");

        } catch (SQLException e) {
            Logger.getLogger(producto_cbd.class.getName()).log(Level.SEVERE, "Error al eliminar el producto", e);
        }
    }
    
    
    /**
     * Busca un producto por su ID.
     * @param id Código del producto a buscar.
     * @return Producto encontrado, o null si no se encuentra.
     */
    
    public producto buscarProductoPorId(Integer id) {
        ArrayList<producto> productos = new ArrayList<>();
        String sql = "SELECT codigo, nombre, medida, id_categoria, precio_entrada, precio_venta, fecha_vencimiento, fecha_ingreso, cantidad FROM producto WHERE id = ?";
        Map<Integer, String> categoriaCache = new HashMap<>();

        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            
            ps.setInt(1, id);
            
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Integer id_categoria = rs.getInt("id_categoria");
                    String categoriaNombre = categoriaCache.computeIfAbsent(id_categoria, (Integer id1) -> obtenerNombreCategoria(id1, conn));

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
            Logger.getLogger(producto_cbd.class.getName()).log(Level.SEVERE, "Error al buscar producto por ID", ex);
        }

        // Verificar si la lista está vacía y retornar el primer producto si existe
        return productos.isEmpty() ? null : productos.get(0);
}
    
    
    /**
     * Obtiene el ID del producto basado en su código.
     * @param codigo Código del producto.
     * @return ID del producto, o null si no se encuentra.
     */
    
    public Integer obtenerIdProducto(String codigo) {
        String sql = "SELECT id FROM producto WHERE codigo = ?";
        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, codigo);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt("id");
                }
            }
        } catch (SQLException e) {
            Logger.getLogger(producto_cbd.class.getName()).log(Level.SEVERE, "Error al obtener el ID del producto", e);
        }
        return null;
    }
}