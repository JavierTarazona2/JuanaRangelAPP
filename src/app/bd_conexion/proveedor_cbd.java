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
       // Consulta SQL para insertar un nuevo proveedor.
       String proveedorSql = "INSERT INTO proveedor (nombre, telefono, correo) VALUES (?, ?, ?)";

       try (Connection conn = getConnection(); // Obtiene la conexión a la base de datos
            PreparedStatement ps = conn.prepareStatement(proveedorSql)) { // Prepara la consulta SQL

           // Asigna los valores del proveedor a la consulta SQL.
           ps.setString(1, p.getNombre());
           ps.setString(2, p.getTelefono());
           ps.setString(3, p.getCorreo());

           // Ejecuta la consulta de inserción.
           ps.executeUpdate();
           System.out.println("Proveedor registrado exitosamente.");

       } catch (SQLException e) {
           // Registra el error si ocurre una excepción.
           Logger.getLogger(proveedor_cbd.class.getName()).log(Level.SEVERE, "Error al registrar el proveedor", e);
       }
   }
   
   
   /**
    * Actualiza el correo y el teléfono de un proveedor en la base de datos.
    *
    * @param id El ID del proveedor cuya información se va a actualizar.
    * @param nuevoCorreo El nuevo correo del proveedor.
    * @param nuevoTelefono El nuevo número de teléfono del proveedor.
    */
   
   public void actualizarProveedor(Integer id, String nuevoCorreo, String nuevoTelefono) {
       // Consulta SQL para actualizar el correo y el teléfono del proveedor.
       String actualizarSql = "UPDATE proveedor SET correo = ?, telefono = ? WHERE id = ?";

       try (Connection conn = getConnection(); // Obtiene la conexión a la base de datos
            PreparedStatement ps = conn.prepareStatement(actualizarSql)) { // Prepara la consulta SQL

           // Asigna los nuevos valores a los parámetros de la consulta SQL.
           ps.setString(1, nuevoCorreo);
           ps.setString(2, nuevoTelefono);
           ps.setInt(3, id);

           // Ejecuta la actualización en la base de datos.
           int filasActualizadas = ps.executeUpdate();

           // Verifica si se actualizó algún registro.
           if (filasActualizadas > 0) {
               System.out.println("Proveedor actualizado exitosamente.");
           } else {
               System.out.println("No se encontró un proveedor con el ID especificado.");
           }

       } catch (SQLException e) {
           // Registra el error si ocurre una excepción.
           Logger.getLogger(proveedor_cbd.class.getName()).log(Level.SEVERE, "Error al actualizar el proveedor", e);
       }
   }

   
   /**
    * Obtiene una lista de todos los proveedores registrados en la base de datos.
    *
    * @return ArrayList de proveedores.
    */
   
   public ArrayList<proveedor> ListadoProveedores() {
       // Lista para almacenar los proveedores recuperados de la base de datos.
       ArrayList<proveedor> proveedores = new ArrayList<>();

       // Consulta SQL para seleccionar todos los proveedores.
       String sql = "SELECT * FROM proveedor";

       try (Connection conn = getConnection(); // Obtiene la conexión a la base de datos.
            PreparedStatement ps = conn.prepareStatement(sql); // Prepara la consulta SQL.
            ResultSet rs = ps.executeQuery()) { // Ejecuta la consulta y obtiene el resultado.

           // Recorre los resultados y crea objetos proveedor.
           while (rs.next()) {
               proveedor p = new proveedor();
               p.setNombre(rs.getString("nombre"));
               p.setTelefono(rs.getString("telefono"));
               p.setCorreo(rs.getString("correo"));
               proveedores.add(p); // Añade el proveedor a la lista.
           }

       } catch (SQLException ex) {
           // Registra el error si ocurre una excepción.
           Logger.getLogger(proveedor_cbd.class.getName()).log(Level.SEVERE, "Error al listar proveedores", ex);
       }

       return proveedores; // Retorna la lista de proveedores.
   }


   /**
    * Obtiene una lista de proveedores cuyo nombre coincida con la cadena dada.
    *
    * @param sss Cadena de búsqueda para filtrar proveedores por nombre.
    * @return ArrayList de proveedores.
    */
   
   public ArrayList<proveedor> ListadoProveedores(String sss) {
       // Lista para almacenar los proveedores que coinciden con el criterio de búsqueda.
       ArrayList<proveedor> proveedores = new ArrayList<>();

       // Consulta SQL para seleccionar proveedores cuyo nombre contenga la cadena dada.
       String sql = "SELECT * FROM proveedor WHERE nombre LIKE ?";

       try (Connection conn = getConnection(); // Obtiene la conexión a la base de datos.
            PreparedStatement ps = conn.prepareStatement(sql)) { // Prepara la consulta SQL.

           // Asigna el parámetro de búsqueda con comodines para la coincidencia parcial.
           ps.setString(1, "%" + sss + "%");

           try (ResultSet rs = ps.executeQuery()) { // Ejecuta la consulta y obtiene el resultado.
               // Recorre los resultados y crea objetos proveedor.
               while (rs.next()) {
                   proveedor p = new proveedor();
                   p.setNombre(rs.getString("nombre"));
                   p.setTelefono(rs.getString("telefono"));
                   p.setCorreo(rs.getString("correo"));
                   proveedores.add(p); // Añade el proveedor a la lista.
               }
           }

       } catch (SQLException ex) {
           // Registra el error si ocurre una excepción.
           Logger.getLogger(proveedor_cbd.class.getName()).log(Level.SEVERE, "Error al listar proveedores por nombre", ex);
       }

       return proveedores; // Retorna la lista de proveedores que coinciden con el criterio de búsqueda.
   }


   /**
    * Obtiene un proveedor cuyo nombre coincida exactamente con la cadena dada.
    *
    * @param sss Nombre del proveedor.
    * @return El proveedor encontrado.
    * @throws IllegalArgumentException Si no se encuentra un proveedor con el nombre dado.
    */
   
   public proveedor ListadoProveedor(String sss) {
       // Consulta SQL para seleccionar un proveedor por nombre exacto.
       String sql = "SELECT * FROM proveedor WHERE nombre = ?";
       proveedor p = null; // Inicializa el proveedor como nulo.

       try (Connection conn = getConnection(); // Obtiene la conexión a la base de datos.
            PreparedStatement ps = conn.prepareStatement(sql)) { // Prepara la consulta SQL.

           ps.setString(1, sss); // Asigna el nombre del proveedor como parámetro de la consulta.

           try (ResultSet rs = ps.executeQuery()) { // Ejecuta la consulta y obtiene el resultado.
               if (rs.next()) { // Si se encuentra un resultado.
                   p = new proveedor();
                   p.setNombre(rs.getString("nombre"));
                   p.setTelefono(rs.getString("telefono"));
                   p.setCorreo(rs.getString("correo"));
               }
           }

       } catch (SQLException ex) {
           // Registra el error si ocurre una excepción.
           Logger.getLogger(proveedor_cbd.class.getName()).log(Level.SEVERE, "Error al listar proveedor por nombre exacto", ex);
       }

       // Si el proveedor es nulo, lanza una excepción para indicar que no se encontró.
       if (p == null) {
           throw new IllegalArgumentException("No se encontró proveedor con el nombre: " + sss);
       }

       return p; // Retorna el proveedor encontrado.
   }
   
   
    /**
     * Obtiene el ID de un proveedor a partir de su nombre.
     *
     * @param nombre Nombre del proveedor.
     * @return ID del proveedor, o null si no se encuentra.
     */
   
    public Integer obtenerIdProveedor(String nombre) {
        Integer id = null; // Inicializa el ID como nulo.
        // Consulta SQL para seleccionar el ID del proveedor por nombre.
        String sql = "SELECT id FROM proveedor WHERE nombre = ?";

        try (Connection conn = getConnection(); // Obtiene la conexión a la base de datos.
             PreparedStatement ps = conn.prepareStatement(sql)) { // Prepara la consulta SQL.

            ps.setString(1, nombre); // Asigna el nombre del proveedor como parámetro de la consulta.

            try (ResultSet rs = ps.executeQuery()) { // Ejecuta la consulta y obtiene el resultado.
                if (rs.next()) { // Si se encuentra un resultado.
                    id = rs.getInt("id"); // Recupera el ID del proveedor.
                }
            }

        } catch (SQLException ex) {
            // Registra el error si ocurre una excepción.
            Logger.getLogger(proveedor_cbd.class.getName()).log(Level.SEVERE, "Error al obtener ID del proveedor", ex);
        }

        return id; // Retorna el ID del proveedor o null si no se encuentra.
    }


    /**
    * Registra un nuevo pedido de proveedor en la base de datos.
    *
    * @param p El pedido a registrar.
    */
    
   public void RegistrarPedidos(proveedor_pedido p) {
       // Obtiene el ID del proveedor a partir del nombre.
       Integer id_proveedor = obtenerIdProveedor(p.getproveedor().getNombre());

       // Consultas SQL para insertar el pedido y los productos asociados.
       String pedidosql = "INSERT INTO pedido_proveedor (id_proveedor, codigo, valor, fecha_entrega, fecha_realizacion, estado) VALUES (?, ?, ?, ?, ?, ?)";
       String productosql = "INSERT INTO producto_proveedor (id_pedido, id_producto, cantidad_producto) VALUES (?, ?, ?)";

       try (Connection conn = getConnection(); // Obtiene la conexión a la base de datos.
            PreparedStatement psPedido = conn.prepareStatement(pedidosql, Statement.RETURN_GENERATED_KEYS)) { // Prepara la consulta SQL para el pedido.

           // Asigna los valores a los parámetros de la consulta SQL para el pedido.
           psPedido.setInt(1, id_proveedor);
           psPedido.setString(2, p.getCodigo());
           psPedido.setDouble(3, p.getValor_total());
           psPedido.setDate(4, Date.valueOf(p.getFecha_entrega()));
           psPedido.setDate(5, Date.valueOf(p.getFecha_realizacion()));
           psPedido.setBoolean(6, p.getEstado());
           psPedido.executeUpdate();

           // Obtiene el ID generado del pedido.
           int id_pedido;
           try (ResultSet rs = psPedido.getGeneratedKeys()) {
               if (rs.next()) {
                   id_pedido = rs.getInt(1);
               } else {
                   throw new SQLException("Error al obtener el ID del pedido.");
               }
           }

           // Verifica que las listas de productos y cantidades coincidan en tamaño.
           if (p.getProductos().size() != p.getCantidades().size()) {
               throw new IllegalArgumentException("El tamaño de las listas de productos y cantidades no coincide.");
           }

           // Prepara la consulta SQL para los productos asociados al pedido.
           try (PreparedStatement psProducto = conn.prepareStatement(productosql)) {
               for (int i = 0; i < p.getProductos().size(); i++) {
                   producto prod = p.getProductos().get(i);
                   Integer id_producto = prcbd.obtenerIdProducto(prod.getCodigo());

                   if (id_producto == null) {
                       System.out.println("No se encontró el producto: " + prod.getNombre());
                       continue;
                   }

                   int cantidad = p.getCantidades().get(i);
                   // Asigna los valores a los parámetros de la consulta SQL para los productos.
                   psProducto.setInt(1, id_pedido);
                   psProducto.setInt(2, id_producto);
                   psProducto.setInt(3, cantidad);
                   psProducto.addBatch();
               }
               psProducto.executeBatch(); // Ejecuta la inserción en lote.
           }

       } catch (SQLException e) {
           // Registra el error si ocurre una excepción.
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
       // Consultas SQL para seleccionar los pedidos y los productos asociados.
       String sqlPedido = "SELECT * FROM pedido_proveedor";
       String sqlProducto = "SELECT * FROM producto_proveedor WHERE id_pedido = ?";

       try (Connection conn = getConnection(); // Obtiene la conexión a la base de datos.
            PreparedStatement psPedido = conn.prepareStatement(sqlPedido);
            ResultSet rsPedido = psPedido.executeQuery()) { // Ejecuta la consulta para obtener todos los pedidos.

           while (rsPedido.next()) {
               proveedor_pedido pedido = new proveedor_pedido();

               // Asigna los valores del pedido a la instancia de proveedor_pedido.
               pedido.setCodigo(rsPedido.getString("codigo"));
               pedido.setValor_total(rsPedido.getDouble("valor"));
               pedido.setFecha_entrega(rsPedido.getDate("fecha_entrega").toLocalDate());
               pedido.setFecha_realizacion(rsPedido.getDate("fecha_realizacion").toLocalDate());
               pedido.setEstado(rsPedido.getBoolean("estado"));

               Integer id_proveedor = rsPedido.getInt("id_proveedor");
               proveedor prov = obtenerProveedorPorId(id_proveedor); // Obtiene el proveedor asociado al pedido.
               pedido.setProveedor(prov);

               // Prepara la consulta SQL para obtener los productos asociados al pedido.
               try (PreparedStatement psProducto = conn.prepareStatement(sqlProducto)) {
                   psProducto.setInt(1, rsPedido.getInt("id"));
                   try (ResultSet rsProducto = psProducto.executeQuery()) { // Ejecuta la consulta para obtener los productos del pedido.
                       while (rsProducto.next()) {
                           producto prod = prcbd.buscarProductoPorId(rsProducto.getInt("id_producto"));
                           int cantidad = rsProducto.getInt("cantidad_producto");

                           pedido.getProductos().add(prod);
                           pedido.getCantidades().add(cantidad);
                       }
                   }
               }

               pedidos.add(pedido); // Agrega el pedido a la lista de pedidos.
           }

       } catch (SQLException ex) {
           // Registra el error si ocurre una excepción.
           Logger.getLogger(proveedor_cbd.class.getName()).log(Level.SEVERE, "Error al listar pedidos", ex);
       }

       return pedidos; // Retorna la lista de pedidos.
   }

    
   /**
    * Obtiene una lista de pedidos de proveedores cuya fecha de entrega está dentro de los próximos 7 días desde la fecha dada.
    *
    * @param fecha La fecha base para calcular el rango de los próximos 7 días.
    * @return ArrayList de pedidos filtrados.
    */
   
   public ArrayList<proveedor_pedido> ListadoPedidos(LocalDate fecha) {
       ArrayList<proveedor_pedido> pedidos = new ArrayList<>();
       // Consulta SQL para seleccionar pedidos cuya fecha de entrega está dentro de los próximos 7 días.
       String sqlPedido = "SELECT * FROM pedido_proveedor WHERE DATEDIFF(fecha_entrega, ?) BETWEEN 0 AND 7";
       String sqlProducto = "SELECT * FROM producto_proveedor WHERE id_pedido = ?";

       try (Connection conn = getConnection();
            PreparedStatement psPedido = conn.prepareStatement(sqlPedido)) {

           // Establece la fecha base para el filtro.
           psPedido.setDate(1, java.sql.Date.valueOf(fecha));

           try (ResultSet rsPedido = psPedido.executeQuery()) {
               while (rsPedido.next()) {
                   proveedor_pedido pedido = new proveedor_pedido();

                   // Llena el objeto pedido con los datos obtenidos.
                   pedido.setCodigo(rsPedido.getString("codigo"));
                   pedido.setValor_total(rsPedido.getDouble("valor"));
                   pedido.setFecha_entrega(rsPedido.getDate("fecha_entrega").toLocalDate());
                   pedido.setFecha_realizacion(rsPedido.getDate("fecha_realizacion").toLocalDate());
                   pedido.setEstado(rsPedido.getBoolean("estado"));

                   // Obtiene y establece el proveedor asociado al pedido.
                   Integer id_proveedor = rsPedido.getInt("id_proveedor");
                   proveedor prov = obtenerProveedorPorId(id_proveedor);
                   pedido.setProveedor(prov);

                   // Obtiene los productos asociados al pedido.
                   try (PreparedStatement psProducto = conn.prepareStatement(sqlProducto)) {
                       psProducto.setInt(1, rsPedido.getInt("id"));
                       try (ResultSet rsProducto = psProducto.executeQuery()) {
                           while (rsProducto.next()) {
                               producto prod = prcbd.buscarProductoPorId(rsProducto.getInt("id_producto"));
                               int cantidad = rsProducto.getInt("cantidad_producto");

                               pedido.getProductos().add(prod);
                               pedido.getCantidades().add(cantidad);
                           }
                       }
                   }

                   // Agrega el pedido a la lista de pedidos.
                   pedidos.add(pedido);
               }
           }

       } catch (SQLException ex) {
           Logger.getLogger(proveedor_cbd.class.getName()).log(Level.SEVERE, "Error al listar pedidos por fecha", ex);
       }

       return pedidos;
   }


   /**
    * Obtiene una lista de pedidos de proveedores filtrados por nombre del proveedor.
    *
    * @param nombreProveedor Nombre del proveedor o código del pedido.
    * @return ArrayList de pedidos filtrados.
    */
   
   public ArrayList<proveedor_pedido> ListadoPedidos(String nombreProveedor) {
       ArrayList<proveedor_pedido> pedidos = new ArrayList<>();
       Integer id_proveedor = obtenerIdProveedor(nombreProveedor);

       // Consulta SQL para seleccionar pedidos filtrados por ID del proveedor o por código.
       String sqlPedido = id_proveedor != null
               ? "SELECT * FROM pedido_proveedor WHERE id_proveedor = ?"
               : "SELECT * FROM pedido_proveedor WHERE codigo LIKE ?";
       String sqlProducto = "SELECT * FROM producto_proveedor WHERE id_pedido = ?";

       try (Connection conn = getConnection();
            PreparedStatement psPedido = conn.prepareStatement(sqlPedido)) {

           // Establece los parámetros de la consulta SQL.
           if (id_proveedor != null) {
               psPedido.setInt(1, id_proveedor);
           } else {
               psPedido.setString(1, nombreProveedor);
           }

           try (ResultSet rsPedido = psPedido.executeQuery()) {
               while (rsPedido.next()) {
                   proveedor_pedido pedido = new proveedor_pedido();

                   // Llena el objeto pedido con los datos obtenidos.
                   pedido.setCodigo(rsPedido.getString("codigo"));
                   pedido.setValor_total(rsPedido.getDouble("valor"));
                   pedido.setFecha_entrega(rsPedido.getDate("fecha_entrega").toLocalDate());
                   pedido.setFecha_realizacion(rsPedido.getDate("fecha_realizacion").toLocalDate());
                   pedido.setEstado(rsPedido.getBoolean("estado"));

                   // Obtiene y establece el proveedor asociado al pedido.
                   proveedor prov = obtenerProveedorPorId(rsPedido.getInt("id_proveedor"));
                   pedido.setProveedor(prov);

                   // Obtiene los productos asociados al pedido.
                   try (PreparedStatement psProducto = conn.prepareStatement(sqlProducto)) {
                       psProducto.setInt(1, rsPedido.getInt("id"));
                       try (ResultSet rsProducto = psProducto.executeQuery()) {
                           while (rsProducto.next()) {
                               producto prod = prcbd.buscarProductoPorId(rsProducto.getInt("id_producto"));
                               int cantidad = rsProducto.getInt("cantidad_producto");

                               pedido.getProductos().add(prod);
                               pedido.getCantidades().add(cantidad);
                           }
                       }
                   }

                   // Agrega el pedido a la lista de pedidos.
                   pedidos.add(pedido);
               }
           }

       } catch (SQLException ex) {
           Logger.getLogger(proveedor_cbd.class.getName()).log(Level.SEVERE, "Error al listar pedidos por proveedor", ex);
       }

       return pedidos;
   }

    
   /**
    * Obtiene un pedido de proveedor específico filtrado por su código.
    *
    * @param codigo Código del pedido.
    * @return Objeto proveedor_pedido correspondiente al código proporcionado.
    */
   
   public proveedor_pedido ListadoPedido(String codigo) {
       proveedor_pedido pedido = null; // Inicializa la variable del pedido.

       // Consultas SQL para seleccionar el pedido y los productos asociados.
       String sqlPedido = "SELECT * FROM pedido_proveedor WHERE codigo = ?";
       String sqlProducto = "SELECT * FROM producto_proveedor WHERE id_pedido = ?";

       try (Connection conn = getConnection();
            PreparedStatement psPedido = conn.prepareStatement(sqlPedido)) {

           // Establece el parámetro del código del pedido.
           psPedido.setString(1, codigo);

           try (ResultSet rsPedido = psPedido.executeQuery()) {
               if (rsPedido.next()) {
                   pedido = new proveedor_pedido();

                   // Llena el objeto pedido con los datos obtenidos.
                   pedido.setCodigo(rsPedido.getString("codigo"));
                   pedido.setValor_total(rsPedido.getDouble("valor"));
                   pedido.setFecha_entrega(rsPedido.getDate("fecha_entrega").toLocalDate());
                   pedido.setFecha_realizacion(rsPedido.getDate("fecha_realizacion").toLocalDate());
                   pedido.setEstado(rsPedido.getBoolean("estado"));

                   // Obtiene y establece el proveedor asociado al pedido.
                   proveedor prov = obtenerProveedorPorId(rsPedido.getInt("id_proveedor"));
                   pedido.setProveedor(prov);

                   // Obtiene los productos asociados al pedido.
                   try (PreparedStatement psProducto = conn.prepareStatement(sqlProducto)) {
                       psProducto.setInt(1, rsPedido.getInt("id"));
                       try (ResultSet rsProducto = psProducto.executeQuery()) {
                           while (rsProducto.next()) {
                               producto prod = prcbd.buscarProductoPorId(rsProducto.getInt("id_producto"));
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
        proveedor p = null; // Inicializa el objeto proveedor a nulo.
        String sql = "SELECT * FROM proveedor WHERE id = ?";

        // Intenta obtener una conexión y preparar la consulta SQL.
        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id_proveedor); // Establece el ID del proveedor en la consulta SQL.

            // Ejecuta la consulta y obtiene los resultados.
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) { // Si se encuentra un registro, se asignan sus valores al objeto proveedor.
                    p = new proveedor();
                    p.setNombre(rs.getString("nombre"));
                    p.setTelefono(rs.getString("telefono"));
                    p.setCorreo(rs.getString("correo"));
                }
            }

        } catch (SQLException ex) {
            // Registra cualquier error de SQL.
            Logger.getLogger(proveedor_cbd.class.getName()).log(Level.SEVERE, "Error al obtener proveedor por ID", ex);
        }

        // Lanza una excepción si no se encontró un proveedor.
        if (p == null) {
            throw new IllegalArgumentException("No se encontró proveedor con el ID: " + id_proveedor);
        }

        return p; // Devuelve el proveedor encontrado.
    }

    
    /**
     * Registra un nuevo reporte en la base de datos.
     *
     * @param reporte El reporte a registrar.
     */
    
    public void RegistrarReporte(reportes reporte) {
        String sql = "INSERT INTO reporte (id_producto, cantidad_producto, detalle, codigo, fecha) VALUES (?, ?, ?, ?, ?)";

        ArrayList<producto> productos = reporte.getProductos(); // Obtiene la lista de productos del reporte.

        // Abre la conexión a la base de datos fuera del bucle para reutilizarla.
        try (Connection conn = getConnection()) {
            int i = 0; // Índice para iterar a través de los productos.

            for (producto p : productos) { // Itera sobre los productos en el reporte.
                try (PreparedStatement ps = conn.prepareStatement(sql)) { // Prepara la declaración SQL.

                    Integer idProducto = prcbd.obtenerIdProducto(p.getCodigo()); // Obtiene el ID del producto.

                    if (idProducto != null) { // Verifica si el ID del producto no es nulo.
                        // Establece los parámetros del PreparedStatement.
                        ps.setInt(1, idProducto);
                        ps.setInt(2, reporte.getCantidad(i)); // Suponiendo que getCantidad() devuelve una lista de cantidades.
                        ps.setString(3, reporte.getDetalles());
                        ps.setInt(4, reporte.getCodigo());
                        ps.setDate(5, Date.valueOf(reporte.getFecha())); // Nuevo parámetro para la fecha.

                        ps.executeUpdate(); // Ejecuta la actualización.
                        System.out.println("Reporte registrado exitosamente.");
                    } else {
                        System.out.println("No se encontró el ID del producto: " + p.getNombre() + ", " + p.getCodigo());
                    }

                    i++; // Incrementa el índice.

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
    
    public ArrayList<reportes> ListarReportes() {
        ArrayList<reportes> listaReportes = new ArrayList<>();
        String sql = "SELECT * FROM reporte";

        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            Map<Integer, reportes> reportesMap = new HashMap<>(); // Mapa para almacenar reportes por código.

            // Itera sobre el resultado de la consulta.
            while (rs.next()) {
                int idProducto = rs.getInt("id_producto");
                int cantidadProducto = rs.getInt("cantidad_producto");
                String detalle = rs.getString("detalle");
                int codigo = rs.getInt("codigo");
                LocalDate fecha = rs.getDate("fecha").toLocalDate(); // Nuevo campo para la fecha.

                // Si el reporte no existe en el mapa, se crea uno nuevo.
                reportes reporte = reportesMap.computeIfAbsent(codigo, k -> new reportes(detalle, codigo, fecha));

                producto p = prcbd.buscarProductoPorId(idProducto); // Obtiene el producto asociado.
                if (p != null) {
                    reporte.setProductos(p, cantidadProducto); // Asocia el producto al reporte.
                }

                reportesMap.put(codigo, reporte); // Actualiza el mapa de reportes.
            }

            listaReportes.addAll(reportesMap.values()); // Agrega todos los reportes al listado final.

        } catch (SQLException ex) {
            Logger.getLogger(producto_cbd.class.getName()).log(Level.SEVERE, null, ex);
        }

        return listaReportes; // Devuelve la lista de reportes.
    }
    

    /**
    * Lista los reportes registrados en la base de datos para un código específico.
    *
    * @param codigo El código del reporte a buscar.
    * @return Un objeto reportes asociado al código proporcionado.
    */
    
   public reportes ListaReporte(Integer codigo) {
       // Consulta SQL para buscar un reporte específico por su código
       String sql = "SELECT * FROM reporte WHERE codigo = ?";
       reportes reporte = null;

       // Establecer conexión y preparar la declaración SQL
       try (Connection conn = getConnection();
            PreparedStatement ps = conn.prepareStatement(sql)) {

           ps.setInt(1, codigo); // Establecer el código del reporte a buscar

           // Ejecutar la consulta y procesar los resultados
           try (ResultSet rs = ps.executeQuery()) {
               while (rs.next()) {
                   // Obtener datos del resultado de la consulta
                   int idProducto = rs.getInt("id_producto");
                   int cantidadProducto = rs.getInt("cantidad_producto");
                   String detalle = rs.getString("detalle");
                   int codigoReporte = rs.getInt("codigo");
                   LocalDate fecha = rs.getDate("fecha").toLocalDate(); // Convertir el campo de fecha

                   // Si el reporte no ha sido creado, se crea un nuevo objeto reporte
                   if (reporte == null) {
                       reporte = new reportes(detalle, codigoReporte, fecha);
                   }

                   // Obtener el producto asociado al reporte
                   producto p = prcbd.buscarProductoPorId(idProducto);
                   if (p != null) {
                       reporte.setProductos(p, cantidadProducto); // Agregar producto al reporte
                   }
               }
           }

       } catch (SQLException ex) {
           Logger.getLogger(producto_cbd.class.getName()).log(Level.SEVERE, "Error al listar reporte", ex);
       }

       return reporte; // Devolver el reporte encontrado o null si no existe
   }


   /**
    * Actualiza un pedido de proveedor en la base de datos.
    * Actualiza el precio, el valor total y los productos del pedido.
    *
    * @param p El pedido a actualizar.
    */
   
   public void actualizarPedido(proveedor_pedido p) {
       // Sentencias SQL para actualizar pedido y eliminar productos
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

           // Obtener los productos actuales asociados al pedido
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
                   Integer id_producto = prcbd.obtenerIdProducto(productoActual.getCodigo());

                   if (id_producto != null) {
                       psEliminarProducto.setInt(1, id_pedido);
                       psEliminarProducto.setInt(2, id_producto);
                       psEliminarProducto.executeUpdate(); // Ejecuta la eliminación del producto
                   }
               }
           }

           // Actualizar el valor total, la fecha de entrega y el estado del pedido
           psActualizarPedido.setDouble(1, p.getValor_total());
           psActualizarPedido.setDate(2, Date.valueOf(p.getFecha_entrega())); // Convertir LocalDate a Date
           psActualizarPedido.setBoolean(3, p.getEstado()); // Actualizar estado del pedido
           psActualizarPedido.setString(4, p.getCodigo());

           psActualizarPedido.executeUpdate(); // Ejecutar la actualización del pedido

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
       // Consulta SQL para obtener el ID del pedido por su código
       String sql = "SELECT id FROM pedido_proveedor WHERE codigo = ?";

       try (Connection conn = getConnection();
            PreparedStatement ps = conn.prepareStatement(sql)) {
           ps.setString(1, codigo); // Establecer el código del pedido

           // Ejecutar la consulta y obtener el resultado
           try (ResultSet rs = ps.executeQuery()) {
               if (rs.next()) {
                   return rs.getInt("id"); // Retornar el ID del pedido
               }
           }
       } catch (SQLException e) {
           Logger.getLogger(proveedor_cbd.class.getName()).log(Level.SEVERE, "Error al obtener ID del pedido", e);
       }

       return null; // Retornar null si no se encuentra el pedido
   }

   
   /**
    * Obtiene los productos de un pedido por su ID.
    *
    * @param id_pedido El ID del pedido.
    * @return Lista de productos asociados al pedido.
    */
   
   private List<producto> obtenerProductosDePedido(int id_pedido) {
       List<producto> productos = new ArrayList<>(); // Lista para almacenar los productos asociados al pedido
       String sql = "SELECT id_producto, cantidad_producto FROM producto_proveedor WHERE id_pedido = ?";

       // Establecer conexión y preparar la declaración SQL
       try (Connection conn = getConnection();
            PreparedStatement ps = conn.prepareStatement(sql)) {

           ps.setInt(1, id_pedido); // Asignar el ID del pedido a la declaración SQL

           // Ejecutar la consulta y procesar los resultados
           try (ResultSet rs = ps.executeQuery()) {
               while (rs.next()) {
                   // Buscar el producto por su ID obtenido de la consulta
                   producto prod = prcbd.buscarProductoPorId(rs.getInt("id_producto"));

                   if (prod != null) { // Verificar si el producto existe
                       prod.setCantidad(rs.getInt("cantidad_producto")); // Asignar la cantidad de producto obtenida
                       productos.add(prod); // Agregar el producto a la lista
                   }
               }
           }

       } catch (SQLException e) {
           // Registrar un error si ocurre una excepción SQL
           Logger.getLogger(proveedor_cbd.class.getName()).log(Level.SEVERE, "Error al obtener productos del pedido", e);
       }

       return productos; // Devolver la lista de productos asociados al pedido
   }


    }