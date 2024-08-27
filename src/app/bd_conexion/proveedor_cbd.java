package app.bd_conexion;

import app.datos.producto;
import app.datos.proveedor;
import app.datos.proveedor_pedido;
import app.datos.reportes;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class proveedor_cbd {
    private final producto_cbd prcbd = new producto_cbd();

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
    public void RegistrarProveedor(proveedor p) {
        String proveedorSql = "INSERT INTO proveedor (nombre, telefono, correo) VALUES (?, ?, ?)";

        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(proveedorSql)) {

            ps.setString(1, p.getNombre());
            ps.setString(2, p.getTelefono());
            ps.setString(3, p.getCorreo());
            ps.executeUpdate();
            System.out.println("Proveedor registrado exitosamente.");

        } catch (SQLException e) {
            Logger.getLogger(proveedor_cbd.class.getName()).log(Level.SEVERE, "Error al registrar el proveedor", e);
        }
    }
    /**
    * Actualiza el correo y el teléfono de un proveedor en la base de datos.
    *
    * @param nombre El nombre del proveedor cuya información se va a actualizar.
    * @param nuevoCorreo El nuevo correo del proveedor.
    * @param nuevoTelefono El nuevo número de teléfono del proveedor.
    */
   public void actualizarProveedor(Integer nombre, String nuevoCorreo, String nuevoTelefono) {
       // Consulta SQL para actualizar el correo y el teléfono del proveedor con el nombre especificado.
       String actualizarSql = "UPDATE proveedor SET correo = ?, telefono = ? WHERE id = ?";

       try (Connection conn = getConnection();
            PreparedStatement ps = conn.prepareStatement(actualizarSql)) {

           // Asignación de valores a los parámetros en la consulta SQL.
           ps.setString(1, nuevoCorreo);
           ps.setString(2, nuevoTelefono);
           ps.setInt(3, nombre);

           // Ejecución de la actualización en la base de datos.
           int filasActualizadas = ps.executeUpdate();

           if (filasActualizadas > 0) {
               System.out.println("Proveedor actualizado exitosamente.");
           } else {
               System.out.println("No se encontró un proveedor con el nombre especificado.");
           }

       } catch (SQLException e) {
           // Manejo de excepciones y registro de errores en caso de fallar la operación.
           Logger.getLogger(proveedor_cbd.class.getName()).log(Level.SEVERE, "Error al actualizar el proveedor", e);
       }
   }


    /**
     * Obtiene una lista de todos los proveedores.
     *
     * @return ArrayList de proveedores.
     */
    public ArrayList<proveedor> ListadoProveedores() {
        ArrayList<proveedor> proveedores = new ArrayList<>();
        String sql = "SELECT * FROM proveedor";

        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                proveedor p = new proveedor();
                p.setNombre(rs.getString("nombre"));
                p.setTelefono(rs.getString("telefono"));
                p.setCorreo(rs.getString("correo"));
                proveedores.add(p);
            }

        } catch (SQLException ex) {
            Logger.getLogger(proveedor_cbd.class.getName()).log(Level.SEVERE, "Error al listar proveedores", ex);
        }

        return proveedores;
    }

    /**
     * Obtiene una lista de proveedores cuyo nombre coincida con la cadena dada.
     *
     * @param sss Cadena de búsqueda.
     * @return ArrayList de proveedores.
     */
    public ArrayList<proveedor> ListadoProveedores(String sss) {
        ArrayList<proveedor> proveedores = new ArrayList<>();
        String sql = "SELECT * FROM proveedor WHERE nombre LIKE ?";

        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, "%" + sss + "%");

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    proveedor p = new proveedor();
                    p.setNombre(rs.getString("nombre"));
                    p.setTelefono(rs.getString("telefono"));
                    p.setCorreo(rs.getString("correo"));
                    proveedores.add(p);
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(proveedor_cbd.class.getName()).log(Level.SEVERE, "Error al listar proveedores por nombre", ex);
        }

        return proveedores;
    }

    /**
     * Obtiene un proveedor cuyo nombre coincida exactamente con la cadena dada.
     *
     * @param sss Nombre del proveedor.
     * @return El proveedor encontrado.
     */
    public proveedor ListadoProveedor(String sss) {
        String sql = "SELECT * FROM proveedor WHERE nombre = ?";
        proveedor p = null;

        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, sss);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    p = new proveedor();
                    p.setNombre(rs.getString("nombre"));
                    p.setTelefono(rs.getString("telefono"));
                    p.setCorreo(rs.getString("correo"));
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(proveedor_cbd.class.getName()).log(Level.SEVERE, "Error al listar proveedor por nombre exacto", ex);
        }

        if (p == null) {
            throw new IllegalArgumentException("No se encontró proveedor con el nombre: " + sss);
        }

        return p;
    }

    /**
     * Obtiene el ID de un proveedor a partir de su nombre.
     *
     * @param nombre Nombre del proveedor.
     * @return ID del proveedor, o null si no se encuentra.
     */
    public Integer obtenerIdProveedor(String nombre) {
        Integer id = null;
        String sql = "SELECT id FROM proveedor WHERE nombre = ?";

        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, nombre);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    id = rs.getInt("id");
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(proveedor_cbd.class.getName()).log(Level.SEVERE, "Error al obtener ID del proveedor", ex);
        }

        return id;
    }

    /**
     * Registra un nuevo pedido de proveedor en la base de datos.
     *
     * @param p El pedido a registrar.
     */
    public void RegistrarPedidos(proveedor_pedido p) {
        Integer id_proveedor = obtenerIdProveedor(p.getproveedor().getNombre());

        String pedidosql = "INSERT INTO pedido_proveedor (id_proveedor, codigo, valor, fecha_entrega, fecha_realizacion,estado) VALUES (?, ?, ?, ?, ?, ?)";
        String productosql = "INSERT INTO producto_proveedor (id_pedido, id_producto, cantidad_producto) VALUES (?, ?, ?)";

        try (Connection conn = getConnection();
             PreparedStatement psPedido = conn.prepareStatement(pedidosql, Statement.RETURN_GENERATED_KEYS)) {

            psPedido.setInt(1, id_proveedor);
            psPedido.setString(2, p.getCodigo());
            psPedido.setDouble(3, p.getValor_total());
            psPedido.setDate(4, Date.valueOf(p.getFecha_entrega()));
            psPedido.setDate(5, Date.valueOf(p.getFecha_realizacion()));
            psPedido.setBoolean(6, p.getEstado());
            psPedido.executeUpdate();

            int id_pedido;
            try (ResultSet rs = psPedido.getGeneratedKeys()) {
                if (rs.next()) {
                    id_pedido = rs.getInt(1);
                } else {
                    throw new SQLException("Error al obtener el ID del pedido.");
                }
            }

            if (p.getProductos().size() != p.getCantidades().size()) {
                throw new IllegalArgumentException("El tamaño de las listas de productos y cantidades no coincide.");
            }

            try (PreparedStatement psProducto = conn.prepareStatement(productosql)) {
                for (int i = 0; i < p.getProductos().size(); i++) {
                    producto prod = p.getProductos().get(i);
                    Integer id_producto = prcbd.obtenerIdProducto(prod.getNombre(), prod.getCodigo());

                    if (id_producto == null) {
                        System.out.println("No se encontró el producto: " + prod.getNombre());
                        continue;
                    }

                    int cantidad = p.getCantidades().get(i);
                    psProducto.setInt(1, id_pedido);
                    psProducto.setInt(2, id_producto);
                    psProducto.setInt(3, cantidad);
                    psProducto.addBatch();
                }
                psProducto.executeBatch();
            }

        } catch (SQLException e) {
            Logger.getLogger(proveedor_cbd.class.getName()).log(Level.SEVERE, "Error al registrar el pedido", e);
        }
    }

    /**
     * Obtiene una lista de todos los pedidos de proveedores.
     *
     * @return ArrayList de pedidos de proveedores.
     */
    public ArrayList<proveedor_pedido> ListadoPedidos() {
        ArrayList<proveedor_pedido> pedidos = new ArrayList<>();
        String sqlPedido = "SELECT * FROM pedido_proveedor";
        String sqlProducto = "SELECT * FROM producto_proveedor WHERE id_pedido = ?";

        try (Connection conn = getConnection();
             PreparedStatement psPedido = conn.prepareStatement(sqlPedido);
             ResultSet rsPedido = psPedido.executeQuery()) {

            while (rsPedido.next()) {
                proveedor_pedido pedido = new proveedor_pedido();

                pedido.setCodigo(rsPedido.getString("codigo"));
                pedido.setValor_total(rsPedido.getDouble("valor"));
                pedido.setFecha_entrega(rsPedido.getDate("fecha_entrega").toLocalDate());
                pedido.setFecha_realizacion(rsPedido.getDate("fecha_realizacion").toLocalDate());
                pedido.setEstado(rsPedido.getBoolean("estado"));

                Integer id_proveedor = rsPedido.getInt("id_proveedor");
                proveedor prov = obtenerProveedorPorId(id_proveedor);
                pedido.setProveedor(prov);

                try (PreparedStatement psProducto = conn.prepareStatement(sqlProducto)) {
                    psProducto.setInt(1, rsPedido.getInt("id"));
                    try (ResultSet rsProducto = psProducto.executeQuery()) {
                        while (rsProducto.next()) {
                            producto prod = prcbd.obtenerProductoPorId(rsProducto.getInt("id_producto"));
                            int cantidad = rsProducto.getInt("cantidad_producto");

                            pedido.getProductos().add(prod);
                            pedido.getCantidades().add(cantidad);
                        }
                    }
                }

                pedidos.add(pedido);
            }

        } catch (SQLException ex) {
            Logger.getLogger(proveedor_cbd.class.getName()).log(Level.SEVERE, "Error al listar pedidos", ex);
        }

        return pedidos;
    }
    
    public ArrayList<proveedor_pedido> ListadoPedidos(LocalDate fecha) {
    ArrayList<proveedor_pedido> pedidos = new ArrayList<>();
    // Filtrar los pedidos cuya fecha de entrega esté dentro de los próximos 7 días desde la fecha dada
    String sqlPedido = "SELECT * FROM pedido_proveedor WHERE DATEDIFF(fecha_entrega, ?) BETWEEN 0 AND 7";
    String sqlProducto = "SELECT * FROM producto_proveedor WHERE id_pedido = ?";

    try (Connection conn = getConnection();
         PreparedStatement psPedido = conn.prepareStatement(sqlPedido)) {
        
        // Establecer la fecha para el filtro
        psPedido.setDate(1, java.sql.Date.valueOf(fecha));

        try (ResultSet rsPedido = psPedido.executeQuery()) {
            while (rsPedido.next()) {
                proveedor_pedido pedido = new proveedor_pedido();

                pedido.setCodigo(rsPedido.getString("codigo"));
                pedido.setValor_total(rsPedido.getDouble("valor"));
                pedido.setFecha_entrega(rsPedido.getDate("fecha_entrega").toLocalDate());
                pedido.setFecha_realizacion(rsPedido.getDate("fecha_realizacion").toLocalDate());
                pedido.setEstado(rsPedido.getBoolean("estado"));

                Integer id_proveedor = rsPedido.getInt("id_proveedor");
                proveedor prov = obtenerProveedorPorId(id_proveedor);
                pedido.setProveedor(prov);

                try (PreparedStatement psProducto = conn.prepareStatement(sqlProducto)) {
                    psProducto.setInt(1, rsPedido.getInt("id"));
                    try (ResultSet rsProducto = psProducto.executeQuery()) {
                        while (rsProducto.next()) {
                            producto prod = prcbd.obtenerProductoPorId(rsProducto.getInt("id_producto"));
                            int cantidad = rsProducto.getInt("cantidad_producto");

                            pedido.getProductos().add(prod);
                            pedido.getCantidades().add(cantidad);
                        }
                    }
                }

                pedidos.add(pedido);
            }
        }

    } catch (SQLException ex) {
        Logger.getLogger(proveedor_cbd.class.getName()).log(Level.SEVERE, "Error al listar pedidos", ex);
    }

    return pedidos;
}


    /**
     * Obtiene una lista de pedidos de proveedores filtrados por nombre del proveedor.
     *
     * @param nombreProveedor Nombre del proveedor.
     * @return ArrayList de pedidos filtrados.
     */
    public ArrayList<proveedor_pedido> ListadoPedidos(String nombreProveedor) {
        ArrayList<proveedor_pedido> pedidos = new ArrayList<>();
        Integer id_proveedor = obtenerIdProveedor(nombreProveedor);

        String sqlPedido = "SELECT * FROM pedido_proveedor WHERE id_proveedor = ? OR codigo LIKE ?";
        String sqlProducto = "SELECT * FROM producto_proveedor WHERE id_pedido = ?";
        if( id_proveedor == null){
             sqlPedido = "SELECT * FROM pedido_proveedor WHERE codigo LIKE ?";
        }
        try (Connection conn = getConnection();
             PreparedStatement psPedido = conn.prepareStatement(sqlPedido)) {
            if(id_proveedor != null){
                psPedido.setInt(1, id_proveedor);
                psPedido.setString(2, nombreProveedor);
            }else{
                psPedido.setString(1, nombreProveedor);
            }
            try (ResultSet rsPedido = psPedido.executeQuery()) {
                while (rsPedido.next()) {
                    proveedor_pedido pedido = new proveedor_pedido();

                    pedido.setCodigo(rsPedido.getString("codigo"));
                    pedido.setValor_total(rsPedido.getDouble("valor"));
                    pedido.setFecha_entrega(rsPedido.getDate("fecha_entrega").toLocalDate());
                    pedido.setFecha_realizacion(rsPedido.getDate("fecha_realizacion").toLocalDate());
                    pedido.setEstado(rsPedido.getBoolean("estado"));

                    proveedor prov = obtenerProveedorPorId(id_proveedor);
                    pedido.setProveedor(prov);

                    try (PreparedStatement psProducto = conn.prepareStatement(sqlProducto)) {
                        psProducto.setInt(1, rsPedido.getInt("id"));
                        try (ResultSet rsProducto = psProducto.executeQuery()) {
                            while (rsProducto.next()) {
                                producto prod = prcbd.obtenerProductoPorId(rsProducto.getInt("id_producto"));
                                int cantidad = rsProducto.getInt("cantidad_producto");

                                pedido.getProductos().add(prod);
                                pedido.getCantidades().add(cantidad);
                            }
                        }
                    }

                    pedidos.add(pedido);
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(proveedor_cbd.class.getName()).log(Level.SEVERE, "Error al listar pedidos filtrados", ex);
        }

        return pedidos;
    }
    
    /**
     * Obtiene una lista de pedidos de proveedores filtrados por nombre del proveedor.
     *
     * @param codigo Nombre del proveedor.
     * @return ArrayList de pedidos filtrados.
     */
    public proveedor_pedido ListadoPedido(String codigo) {
    proveedor_pedido pedido = null; // Inicializamos la variable del pedido

    String sqlPedido = "SELECT * FROM pedido_proveedor WHERE codigo = ?";
    String sqlProducto = "SELECT * FROM producto_proveedor WHERE id_pedido = ?";

    try (Connection conn = getConnection();
         PreparedStatement psPedido = conn.prepareStatement(sqlPedido)) {

        // Establecer el parámetro del código del pedido
        psPedido.setString(1, codigo);

        try (ResultSet rsPedido = psPedido.executeQuery()) {
            if (rsPedido.next()) {
                pedido = new proveedor_pedido();

                // Llenar el objeto pedido con los datos obtenidos
                pedido.setCodigo(rsPedido.getString("codigo"));
                pedido.setValor_total(rsPedido.getDouble("valor"));
                pedido.setFecha_entrega(rsPedido.getDate("fecha_entrega").toLocalDate());
                pedido.setFecha_realizacion(rsPedido.getDate("fecha_realizacion").toLocalDate());
                pedido.setEstado(rsPedido.getBoolean("estado"));

                proveedor prov = obtenerProveedorPorId(rsPedido.getInt("id_proveedor"));
                pedido.setProveedor(prov);

                try (PreparedStatement psProducto = conn.prepareStatement(sqlProducto)) {
                    psProducto.setInt(1, rsPedido.getInt("id"));
                    try (ResultSet rsProducto = psProducto.executeQuery()) {
                        while (rsProducto.next()) {
                            producto prod = prcbd.obtenerProductoPorId(rsProducto.getInt("id_producto"));
                            int cantidad = rsProducto.getInt("cantidad_producto");

                            pedido.getProductos().add(prod);
                            pedido.getCantidades().add(cantidad);
                        }
                    }
                }
            }
        }
    } catch (SQLException ex) {
        Logger.getLogger(proveedor_cbd.class.getName()).log(Level.SEVERE, "Error al listar pedido por código", ex);
    }

    return pedido;
}


    /**
     * Obtiene un proveedor por su ID.
     *
     * @param id_proveedor ID del proveedor.
     * @return El proveedor encontrado.
     */
    private proveedor obtenerProveedorPorId(Integer id_proveedor) {
        proveedor p = null;
        String sql = "SELECT * FROM proveedor WHERE id = ?";

        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id_proveedor);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    p = new proveedor();
                    p.setNombre(rs.getString("nombre"));
                    p.setTelefono(rs.getString("telefono"));
                    p.setCorreo(rs.getString("correo"));
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(proveedor_cbd.class.getName()).log(Level.SEVERE, "Error al obtener proveedor por ID", ex);
        }

        if (p == null) {
            throw new IllegalArgumentException("No se encontró proveedor con el ID: " + id_proveedor);
        }

        return p;
    }
 /**
     * Registra un nuevo reporte en la base de datos.
     *
     * @param reporte El reporte a registrar.
        */
   public void RegistrarReporte(reportes reporte) {
       String sql = "INSERT INTO reporte (id_producto, cantidad_producto, detalle, codigo, fecha) VALUES (?, ?, ?, ?, ?)";

       // Obtener la lista de productos del reporte
       ArrayList<producto> productos = reporte.getProductos();

       // Abrir la conexión fuera del bucle para reutilizarla
       try (Connection conn = getConnection()) {

           // Iniciar el índice para iterar a través de los productos
           int i = 0;

           // Iterar sobre los productos en el reporte
           for (producto p : productos) {
               // Preparar la declaración SQL
               try (PreparedStatement ps = conn.prepareStatement(sql)) {

                   // Obtener el id del producto
                   Integer idProducto = prcbd.obtenerIdProducto(p.getNombre(), p.getCodigo());

                   // Verificar si el idProducto no es nulo
                   if (idProducto != null) {
                       // Establecer los parámetros del PreparedStatement
                       ps.setInt(1, idProducto);
                       ps.setInt(2, reporte.getCantidad(i));  // Suponiendo que getCantidad() devuelve una lista de cantidades
                       ps.setString(3, reporte.getDetalles());
                       ps.setInt(4, reporte.getCodigo());
                       ps.setDate(5, Date.valueOf(reporte.getFecha())); // Nuevo parámetro para la fecha

                       // Ejecutar la actualización
                       ps.executeUpdate();
                       System.out.println("Reporte registrado exitosamente.");
                   } else {
                       System.out.println("No se encontró el ID del producto: " + p.getNombre() + ", " + p.getCodigo());
                   }

                   // Incrementar el índice
                   i++;

               } catch (SQLException e) {
                   e.printStackTrace();
                   System.out.println("Error al registrar el reporte para el producto: " + p.getNombre() + " - " + e.getMessage());
               }
           }

       } catch (SQLException e) {
           e.printStackTrace();
           System.out.println("Error al establecer la conexión: " + e.getMessage());
       }
   }


    /**
     * Lista todos los reportes registrados en la base de datos.
     *
     * @return ArrayList de reportes.
     */
    /**
  * Lista todos los reportes registrados en la base de datos.
  *
  * @return ArrayList de reportes.
  */
    public ArrayList<reportes> ListarReportes() {
        ArrayList<reportes> listaReportes = new ArrayList<>();
        String sql = "SELECT * FROM reporte";

        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            // Mapa para almacenar reportes por código
            Map<Integer, reportes> reportesMap = new HashMap<>();

            // Iterar sobre el resultado de la consulta
            while (rs.next()) {
                int idProducto = rs.getInt("id_producto");
                int cantidadProducto = rs.getInt("cantidad_producto");
                String detalle = rs.getString("detalle");
                int codigo = rs.getInt("codigo");
                LocalDate fecha = rs.getDate("fecha").toLocalDate(); // Nuevo campo para la fecha

                // Si el reporte no existe en el mapa, se crea uno nuevo
                reportes reporte = reportesMap.computeIfAbsent(codigo, k -> new reportes(detalle, codigo, fecha));

                // Obtener el producto asociado
                producto p = prcbd.obtenerProductoPorId(idProducto);
                if (p != null) {
                    reporte.setProductos(p, cantidadProducto);
                }

                reportesMap.put(codigo, reporte);
            }

            // Agregar todos los reportes al listado final
            listaReportes.addAll(reportesMap.values());

        } catch (SQLException ex) {
            Logger.getLogger(producto_cbd.class.getName()).log(Level.SEVERE, null, ex);
        }

        return listaReportes;
    }

        /**
     * Lista los reportes registrados en la base de datos para un código específico.
     *
     * @param codigo El código del reporte a buscar.
     * @return Un objeto reportes asociado al código proporcionado.
     */
    public reportes ListaReporte(Integer codigo) {
    String sql = "SELECT * FROM reporte WHERE codigo = ?";
    reportes reporte = null;

    try (Connection conn = getConnection();
         PreparedStatement ps = conn.prepareStatement(sql)) {
        
        ps.setInt(1, codigo);
        try (ResultSet rs = ps.executeQuery()) {
            // Iterar sobre el resultado de la consulta
            while (rs.next()) {
                int idProducto = rs.getInt("id_producto");
                int cantidadProducto = rs.getInt("cantidad_producto");
                String detalle = rs.getString("detalle");
                int codigoReporte = rs.getInt("codigo");
                LocalDate fecha = rs.getDate("fecha").toLocalDate(); // Nuevo campo para la fecha

                // Si el reporte aún no ha sido creado, se crea uno nuevo
                if (reporte == null) {
                    reporte = new reportes(detalle, codigoReporte, fecha);
                }

                // Obtener el producto asociado
                producto p = prcbd.obtenerProductoPorId(idProducto);
                if (p != null) {
                    reporte.setProductos(p, cantidadProducto);
                }
            }
        }

    } catch (SQLException ex) {
        Logger.getLogger(producto_cbd.class.getName()).log(Level.SEVERE, null, ex);
    }
    
    return reporte;
}



     /**
  * Actualiza un pedido de proveedor en la base de datos.
  * Se actualizan el precio, el valor total (si se eliminan productos), y los productos del pedido (solo se eliminan productos).
  *
  * @param p El pedido a actualizar.
  */
    public void actualizarPedido(proveedor_pedido p) {
        String actualizarPedidoSQL = "UPDATE pedido_proveedor SET valor = ?, fecha_entrega = ?, estado = ? WHERE codigo = ?";
        String eliminarProductoSQL = "DELETE FROM producto_proveedor WHERE id_pedido = ? AND id_producto = ?";

        try (Connection conn = getConnection();
             PreparedStatement psActualizarPedido = conn.prepareStatement(actualizarPedidoSQL);
             PreparedStatement psEliminarProducto = conn.prepareStatement(eliminarProductoSQL)) {

            // Obtener el ID del pedido para trabajar con los productos
            Integer id_pedido = obtenerIdPedidoPorCodigo(p.getCodigo());

            if (id_pedido == null) {
                throw new SQLException("No se encontró el pedido con el código: " + p.getCodigo());
            }

            // Verificar productos para eliminar
            List<producto> productosActuales = obtenerProductosDePedido(id_pedido);
            for (producto productoActual : productosActuales) {
                boolean productoEnPedido = false;

                // Verificar si el producto aún está en la lista de productos del pedido
                for (producto prod : p.getProductos()) {
                    if (prod.getCodigo().equals(productoActual.getCodigo())) {
                        productoEnPedido = true;
                        break;
                    }
                }

                // Si el producto no está en la lista actualizada, se elimina
                if (!productoEnPedido) {
                    Integer id_producto = prcbd.obtenerIdProducto(productoActual.getNombre(), productoActual.getCodigo());

                    if (id_producto != null) {
                        psEliminarProducto.setInt(1, id_pedido);
                        psEliminarProducto.setInt(2, id_producto);
                        psEliminarProducto.executeUpdate();


                    }
                }
            }

            // Actualizar el valor total, la fecha de entrega y el estado del pedido
            psActualizarPedido.setDouble(1, p.getValor_total());
            psActualizarPedido.setDate(2, Date.valueOf(p.getFecha_entrega())); // Asegúrate de que p.getFecha_entrega() devuelve LocalDate
            psActualizarPedido.setBoolean(3, p.getEstado()); // Solo si el estado puede cambiar
            psActualizarPedido.setString(4, p.getCodigo());

            psActualizarPedido.executeUpdate();

        } catch (SQLException e) {
            Logger.getLogger(proveedor_cbd.class.getName()).log(Level.SEVERE, "Error al actualizar el pedido", e);
        }
    }


    /**
     * Obtiene el ID de un pedido por su código.
     *
     * @param codigo El código del pedido.
     * @return El ID del pedido, o null si no se encuentra.
     */
    private Integer obtenerIdPedidoPorCodigo(String codigo) {
        String sql = "SELECT id FROM pedido_proveedor WHERE codigo = ?";
        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, codigo);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt("id");
                }
            }
        } catch (SQLException e) {
            Logger.getLogger(proveedor_cbd.class.getName()).log(Level.SEVERE, "Error al obtener ID del pedido", e);
        }
        return null;
    }

    /**
     * Obtiene los productos de un pedido por su ID.
     *
     * @param id_pedido El ID del pedido.
     * @return Lista de productos asociados al pedido.
     */
    private List<producto> obtenerProductosDePedido(int id_pedido) {
        List<producto> productos = new ArrayList<>();
        String sql = "SELECT id_producto, cantidad_producto FROM producto_proveedor WHERE id_pedido = ?";
        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id_pedido);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    producto prod = prcbd.obtenerProductoPorId(rs.getInt("id_producto"));
                    if (prod != null) {
                        prod.setCantidad(rs.getInt("cantidad_producto"));
                        productos.add(prod);
                    }
                }
            }
        } catch (SQLException e) {
            Logger.getLogger(proveedor_cbd.class.getName()).log(Level.SEVERE, "Error al obtener productos del pedido", e);
        }
        return productos;
    }

    }