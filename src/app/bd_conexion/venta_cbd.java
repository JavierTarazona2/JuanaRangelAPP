package app.bd_conexion;

import app.bd_conexion.proveedor_cbd;
import app.datos.Ventas;
import app.datos.cliente;
import app.datos.pedido;
import app.datos.producto;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Clase para gestionar las operaciones relacionadas con ventas en la base de datos.
 */
public class venta_cbd {
    private producto_cbd prcbd = new producto_cbd();  // Objeto para operaciones con productos

    // Método para obtener una nueva conexión a la base de datos
    private Connection getConnection() throws SQLException {
        return new conexion().conexio();
    }

    
    /**
    * Registra un nuevo cliente en la base de datos.
    * 
    * @param cliente Objeto cliente a registrar.
    */
    
   public void RegistroCliente(cliente cliente) {
       // Definir la consulta SQL para insertar un nuevo cliente
       String sql = "INSERT INTO cliente (nombre, correo, numero, identificacion, direccion) VALUES (?, ?, ?, ?, ?)";

       // Establecer conexión y preparar la declaración SQL
       try (Connection conn = getConnection();
            PreparedStatement ps = conn.prepareStatement(sql)) {

           // Asignar los parámetros del PreparedStatement
           ps.setString(1, cliente.getNombre());
           ps.setString(2, cliente.getCorreo());
           ps.setString(3, cliente.getTelefono());
           ps.setInt(4, cliente.getIdentificacion());
           ps.setString(5, cliente.getDireccion());

           // Ejecutar la inserción en la base de datos
           ps.executeUpdate();
           System.out.println("Cliente registrado exitosamente.");

       } catch (SQLException e) {
           // Imprimir mensaje de error en caso de excepción
           Logger.getLogger(venta_cbd.class.getName()).log(Level.SEVERE, "Error al registrar el cliente", e);
       }
   }


    /**
    * Lista todos los clientes registrados en la base de datos.
    * 
    * @return Lista de clientes.
    */
   
   public ArrayList<cliente> ListarCliente() {
       ArrayList<cliente> clientes = new ArrayList<>(); // Lista para almacenar los clientes
       String sql = "SELECT * FROM cliente";

       // Establecer conexión y preparar la declaración SQL
       try (Connection conn = getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery()) {

           // Recorrer el ResultSet y agregar cada cliente a la lista
           while (rs.next()) {
               cliente c = new cliente();
               c.setNombre(rs.getString("nombre"));
               c.setCorreo(rs.getString("correo"));
               c.setTelefono(rs.getString("numero"));
               c.setIdentificacion(rs.getInt("identificacion"));
               c.setDireccion(rs.getString("direccion"));
               clientes.add(c); // Agregar cliente a la lista
           }

       } catch (SQLException ex) {
           // Registrar el error si ocurre una excepción SQL
           Logger.getLogger(venta_cbd.class.getName()).log(Level.SEVERE, "Error al listar clientes", ex);
       }

       return clientes; // Devolver la lista de clientes
   }


    /**
    * Obtiene un cliente por su nombre.
    * 
    * @param nombre Nombre del cliente.
    * @return Objeto cliente correspondiente al nombre.
    */
   
   public cliente ListarCliente(String nombre) {
       String sql = "SELECT * FROM cliente WHERE nombre = ?;";
       cliente c = null; // Iniciar con null para manejar correctamente si no se encuentra el cliente

       // Establecer conexión y preparar la declaración SQL
       try (Connection conn = getConnection();
            PreparedStatement ps = conn.prepareStatement(sql)) {

           ps.setString(1, nombre); // Asignar el parámetro nombre a la declaración SQL

           // Ejecutar la consulta y procesar el resultado
           try (ResultSet rs = ps.executeQuery()) {
               if (rs.next()) {
                   c = new cliente(); // Inicializar objeto cliente solo si se encuentra en la base de datos
                   c.setNombre(rs.getString("nombre"));
                   c.setTelefono(rs.getString("numero"));
                   c.setCorreo(rs.getString("correo"));
                   c.setIdentificacion(rs.getInt("identificacion"));
                   c.setDireccion(rs.getString("direccion"));
                   c.setCompras(ListadoVentas(c.getNombre())); // Obtener compras del cliente
               }
           }

       } catch (SQLException ex) {
           // Registrar el error si ocurre una excepción SQL
           Logger.getLogger(venta_cbd.class.getName()).log(Level.SEVERE, "Error al obtener cliente por nombre", ex);
       }

       return c; // Devolver el cliente o null si no se encuentra
   }

    
   /**
    * Obtiene una lista de clientes que coinciden con un nombre o parte del nombre.
    * 
    * @param nombre Nombre o parte del nombre del cliente a buscar.
    * @return Lista de objetos cliente que coinciden con el nombre proporcionado.
    */
   
   public ArrayList<cliente> ListarClientes(String nombre) {
       ArrayList<cliente> clientes = new ArrayList<>(); // Lista para almacenar los clientes coincidentes
       String sql = "SELECT * FROM cliente WHERE nombre LIKE ?;"; // Consulta SQL con coincidencia parcial

       // Establecer conexión y preparar la declaración SQL
       try (Connection conn = getConnection();
            PreparedStatement ps = conn.prepareStatement(sql)) {

           ps.setString(1, "%" + nombre + "%"); // Asignar parámetro para coincidencia parcial utilizando '%'

           // Ejecutar la consulta y procesar los resultados
           try (ResultSet rs = ps.executeQuery()) {
               while (rs.next()) {
                   cliente c = new cliente();
                   c.setNombre(rs.getString("nombre"));
                   c.setTelefono(rs.getString("numero"));
                   c.setCorreo(rs.getString("correo"));
                   c.setIdentificacion(rs.getInt("identificacion"));
                   c.setDireccion(rs.getString("direccion"));

                   clientes.add(c); // Añadir el cliente a la lista
               }
           }

       } catch (SQLException ex) {
           // Registrar el error si ocurre una excepción SQL
           Logger.getLogger(venta_cbd.class.getName()).log(Level.SEVERE, "Error al listar clientes por nombre parcial", ex);
       }

       return clientes; // Devolver la lista de clientes coincidentes
   }

   
   /**
    * Obtiene un cliente por su ID.
    * 
    * @param id ID del cliente.
    * @return Objeto cliente correspondiente al ID, o null si no se encuentra.
    */
   
   public cliente ListarCliente(Integer id) {
       String sql = "SELECT * FROM cliente WHERE id = ?;"; // Consulta SQL para buscar cliente por ID
       cliente c = null; // Inicializar cliente como null

       // Establecer conexión y preparar la declaración SQL
       try (Connection conn = getConnection();
            PreparedStatement ps = conn.prepareStatement(sql)) {

           ps.setInt(1, id); // Asignar el parámetro ID

           // Ejecutar la consulta y procesar el resultado
           try (ResultSet rs = ps.executeQuery()) {
               if (rs.next()) {
                   c = new cliente(); // Crear objeto cliente solo si se encuentra en la base de datos
                   c.setNombre(rs.getString("nombre"));
                   c.setTelefono(rs.getString("numero"));
                   c.setCorreo(rs.getString("correo"));
                   c.setIdentificacion(rs.getInt("identificacion"));
                   c.setDireccion(rs.getString("direccion"));
               }
           }

       } catch (SQLException ex) {
           // Registrar el error si ocurre una excepción SQL
           Logger.getLogger(venta_cbd.class.getName()).log(Level.SEVERE, "Error al obtener cliente por ID", ex);
       }

       return c; // Devolver el cliente o null si no se encuentra
   }

   
   /**
    * Obtiene el ID de un cliente por su nombre.
    * 
    * @param nombre Nombre del cliente.
    * @return ID del cliente, o null si no se encuentra.
    */
   
   public Integer obtenerIdCliente(String nombre) {
       Integer id = null; // Inicializar ID como null para manejar la ausencia de resultados
       String sql = "SELECT id FROM cliente WHERE nombre = ?"; // Consulta SQL para obtener ID del cliente por nombre

       // Establecer conexión y preparar la declaración SQL
       try (Connection conn = getConnection();
            PreparedStatement ps = conn.prepareStatement(sql)) {

           ps.setString(1, nombre); // Asignar el parámetro nombre

           // Ejecutar la consulta y procesar el resultado
           try (ResultSet rs = ps.executeQuery()) {
               if (rs.next()) {
                   id = rs.getInt("id"); // Asignar el ID del cliente encontrado
               }
           }

       } catch (SQLException ex) {
           // Registrar el error si ocurre una excepción SQL
           Logger.getLogger(venta_cbd.class.getName()).log(Level.SEVERE, "Error al obtener ID del cliente por nombre", ex);
       }

       return id; // Devolver el ID o null si no se encuentra
   }


   /**
    * Registra una venta o pedido en la base de datos.
    * 
    * @param venta Objeto Ventas o Pedido que se desea registrar.
    */
   
   public void registrarVenta(Ventas venta) {
       // Consultas SQL para registrar la venta/pedido, los productos asociados y actualizar las cantidades
       String sqlVenta = "INSERT INTO venta (id_cliente, valor, fecha_realizacion, fecha_entrega, detalles, id_tipo, estado, codigo) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
       String sqlProductoVenta = "INSERT INTO producto_venta (id_producto, cantidad_producto, id_venta) VALUES (?, ?, ?)";
       String sqlActualizacion = "UPDATE producto SET cantidad = ? WHERE id = ?";

       // Utilizar try-with-resources para asegurar el cierre de conexiones y recursos
       try (Connection conn = getConnection();
            PreparedStatement psVenta = conn.prepareStatement(sqlVenta, PreparedStatement.RETURN_GENERATED_KEYS);
            PreparedStatement psActualizar = conn.prepareStatement(sqlActualizacion);
            PreparedStatement psProductoVenta = conn.prepareStatement(sqlProductoVenta)) {

           // Configurar parámetros de la consulta para insertar la venta/pedido
           psVenta.setInt(1, obtenerIdCliente(venta.getCliente().getNombre()));
           psVenta.setDouble(2, venta.getValor());
           psVenta.setDate(3, Date.valueOf(venta.getFecha_realizado()));
           psVenta.setString(8, venta.getCodigo());

           if (venta instanceof pedido ped) {
               // Configurar parámetros específicos para pedidos
               psVenta.setDate(4, Date.valueOf(ped.getFecha_entrega()));
               psVenta.setString(5, ped.getDetalles());
               psVenta.setInt(6, 1);  // ID tipo pedido
               psVenta.setBoolean(7, false);  // Estado pendiente
           } else {
               // Configurar parámetros específicos para ventas
               psVenta.setDate(4, null);
               psVenta.setString(5, null);
               psVenta.setInt(6, 2);  // ID tipo venta
               psVenta.setBoolean(7, true);  // Estado completado
           }

           // Ejecutar la consulta para insertar la venta/pedido
           psVenta.executeUpdate();

           // Obtener el ID de la venta recién insertada
           try (ResultSet generatedKeys = psVenta.getGeneratedKeys()) {
               if (generatedKeys.next()) {
                   int idVenta = generatedKeys.getInt(1);

                   // Insertar los productos asociados a la venta/pedido
                   int i = 0;
                   for (producto p : venta.getProductos()) {
                       psProductoVenta.setInt(1, prcbd.obtenerIdProducto(p.getCodigo()));
                       psProductoVenta.setInt(2, venta.getCantidades().get(i));
                       psProductoVenta.setInt(3, idVenta);
                       psActualizar.setInt(1, p.getCantidad() - venta.getCantidades().get(i));
                       psActualizar.setInt(2, prcbd.obtenerIdProducto(p.getCodigo()));

                       // Ejecutar actualización y inserción de producto
                       psActualizar.executeUpdate();
                       psProductoVenta.executeUpdate();
                       i++;
                   }
               }
           }

           System.out.println("Venta registrada exitosamente.");

       } catch (SQLException e) {
           // Registrar y mostrar el error si ocurre una excepción SQL
           e.printStackTrace();
           System.out.println("Error al registrar la venta: " + e.getMessage());
       }
   }


   /**
    * Obtiene una lista de todos los pedidos registrados en la base de datos.
    * 
    * @return Lista de pedidos.
    */
   
   public ArrayList<pedido> ListadoPedidos() {
       ArrayList<pedido> pedidos = new ArrayList<>(); // Lista para almacenar los pedidos
       String sqlPedido = "SELECT * FROM venta WHERE id_tipo = 1"; // Consulta SQL para obtener pedidos
       String sqlProducto = "SELECT * FROM producto_venta WHERE id_venta = ?"; // Consulta SQL para obtener productos de un pedido

       // Utilizar try-with-resources para asegurar el cierre de conexiones y recursos
       try (Connection conn = getConnection();
            PreparedStatement psPedido = conn.prepareStatement(sqlPedido);
            ResultSet rsPedido = psPedido.executeQuery()) {

           while (rsPedido.next()) {
               pedido ped = new pedido();

               // Recuperar y establecer datos del pedido
               ped.setDetalles(rsPedido.getString("detalles"));
               ped.setValor(rsPedido.getDouble("valor"));
               ped.setFecha_entrega(rsPedido.getDate("fecha_entrega").toLocalDate());
               ped.setFecha_realizado(rsPedido.getDate("fecha_realizacion").toLocalDate());
               ped.setEstado(rsPedido.getBoolean("estado"));
               ped.setCliente(ListarCliente(rsPedido.getInt("id_cliente")));
               ped.setCodigo(rsPedido.getString("codigo"));

               // Recuperar productos y cantidades asociadas al pedido
               try (PreparedStatement psProducto = conn.prepareStatement(sqlProducto)) {
                   psProducto.setInt(1, rsPedido.getInt("id"));
                   try (ResultSet rsProducto = psProducto.executeQuery()) {
                       while (rsProducto.next()) {
                           producto prod = prcbd.buscarProductoPorId(rsProducto.getInt("id_producto"));
                           int cantidad = rsProducto.getInt("cantidad_producto");

                           // Añadir producto y cantidad a la lista del pedido
                           ped.getProductos().add(prod);
                           ped.getCantidades().add(cantidad);
                       }
                   }
               }

               // Añadir el pedido completo a la lista
               pedidos.add(ped);
           }

       } catch (SQLException ex) {
           // Registrar el error si ocurre una excepción SQL
           Logger.getLogger(venta_cbd.class.getName()).log(Level.SEVERE, "Error al listar pedidos", ex);
       }

       return pedidos; // Devolver la lista de pedidos
   }

   
   /**
    * Obtiene una lista de todas las ventas registradas en la base de datos.
    * 
    * @return Lista de ventas.
    */
   
   public ArrayList<Ventas> ListadoVentas() {
       ArrayList<Ventas> ventas = new ArrayList<>(); // Lista para almacenar las ventas
       String sqlVenta = "SELECT * FROM venta WHERE estado = 1"; // Consulta SQL para obtener ventas
       String sqlProducto = "SELECT * FROM producto_venta WHERE id_venta = ?"; // Consulta SQL para obtener productos de una venta

       // Utilizar try-with-resources para asegurar el cierre de conexiones y recursos
       try (Connection conn = getConnection();
            PreparedStatement psVenta = conn.prepareStatement(sqlVenta);
            ResultSet rsVenta = psVenta.executeQuery()) {

           while (rsVenta.next()) {
               Ventas venta = new Ventas();

               // Recuperar y establecer datos de la venta
               venta.setValor(rsVenta.getDouble("valor"));
               venta.setFecha_realizado(rsVenta.getDate("fecha_realizacion").toLocalDate());
               venta.setCliente(ListarCliente(rsVenta.getInt("id_cliente")));
               venta.setTipo_venta(rsVenta.getInt("id_tipo"));
               venta.setCodigo(rsVenta.getString("codigo"));

               // Recuperar productos y cantidades asociadas a la venta
               try (PreparedStatement psProducto = conn.prepareStatement(sqlProducto)) {
                   psProducto.setInt(1, rsVenta.getInt("id"));
                   try (ResultSet rsProducto = psProducto.executeQuery()) {
                       while (rsProducto.next()) {
                           producto prod = prcbd.buscarProductoPorId(rsProducto.getInt("id_producto"));
                           int cantidad = rsProducto.getInt("cantidad_producto");

                           // Añadir producto y cantidad a la lista de la venta
                           venta.getProductos().add(prod);
                           venta.getCantidades().add(cantidad);
                       }
                   }
               }

               // Añadir la venta completa a la lista
               ventas.add(venta);
           }

       } catch (SQLException ex) {
           // Registrar el error si ocurre una excepción SQL
           Logger.getLogger(venta_cbd.class.getName()).log(Level.SEVERE, "Error al listar ventas", ex);
       }

       return ventas; // Devolver la lista de ventas
   }
   
   
   /**
    * Método para listar todas las ventas basadas en el nombre del cliente.
    * 
    * @param nombreCliente Nombre del cliente.
    * @return Lista de ventas asociadas al cliente.
    */
   
   public ArrayList<Ventas> ListadoVentas(String nombreCliente) {
       ArrayList<Ventas> ventas = new ArrayList<>();
       String sqlVenta = "SELECT * FROM venta WHERE id_tipo = 2 AND id_cliente = ?";
       String sqlProducto = "SELECT * FROM producto_venta WHERE id_venta = ?";

       try (Connection conn = getConnection();
            PreparedStatement psVenta = conn.prepareStatement(sqlVenta)) {

           // Obtener el ID del cliente basado en su nombre
           Integer idCliente = obtenerIdCliente(nombreCliente);
           if (idCliente == null) {
               System.out.println("Cliente no encontrado.");
               return ventas;
           }

           // Establecer el parámetro del PreparedStatement
           psVenta.setInt(1, idCliente);

           try (ResultSet rsVenta = psVenta.executeQuery()) {
               while (rsVenta.next()) {
                   Ventas venta = new Ventas();
                   // Establecer datos de la venta
                   llenarDatosVenta(rsVenta, venta);

                   // Recuperar productos y cantidades asociadas a la venta
                   recuperarProductosVenta(conn, rsVenta.getInt("id"), venta);

                   // Añadir la venta completa a la lista
                   ventas.add(venta);
               }
           }

       } catch (SQLException ex) {
           Logger.getLogger(venta_cbd.class.getName()).log(Level.SEVERE, "Error al listar ventas", ex);
       }

       return ventas;
   }

   
   /**
    * Método para llenar los datos de una venta desde un ResultSet.
    * 
    * @param rsVenta ResultSet con datos de la venta.
    * @param venta Objeto Ventas a llenar.
    */
   
   private void llenarDatosVenta(ResultSet rsVenta, Ventas venta) throws SQLException {
       venta.setValor(rsVenta.getDouble("valor"));
       venta.setFecha_realizado(rsVenta.getDate("fecha_realizacion").toLocalDate());
       venta.setCliente(ListarCliente(rsVenta.getInt("id_cliente")));
       venta.setTipo_venta(rsVenta.getInt("id_tipo"));
       venta.setCodigo(rsVenta.getString("codigo"));
   }

   
   /**
    * Método para recuperar los productos asociados a una venta.
    * 
    * @param conn Conexión a la base de datos.
    * @param idVenta ID de la venta.
    * @param venta Objeto Ventas a completar.
    */
   
   private Ventas  recuperarProductosVenta(Connection conn, int idVenta, Ventas venta) throws SQLException {
       String sqlProducto = "SELECT * FROM producto_venta WHERE id_venta = ? ";
       try (PreparedStatement psProducto = conn.prepareStatement(sqlProducto)) {
           psProducto.setInt(1, idVenta);
           try (ResultSet rsProducto = psProducto.executeQuery()) {
               while (rsProducto.next()) {
                   producto prod = prcbd.buscarProductoPorId(rsProducto.getInt("id_producto"));
                   int cantidad = rsProducto.getInt("cantidad_producto");

                   // Añadir producto y cantidad a la lista de la venta
                   venta.setProductos(prod, cantidad);
               }
           }
       }
       return venta;
   }

   
   /**
    * Método para listar todos los pedidos basados en el nombre del cliente.
    * 
    * @param nombreCliente Nombre del cliente.
    * @return Lista de pedidos asociados al cliente.
    */
   
   public ArrayList<pedido> ListadoPedidos(String nombreCliente) {
       ArrayList<pedido> pedidos = new ArrayList<>();
       String sqlPedido = "SELECT * FROM venta WHERE id_tipo = 1 AND id_cliente = ?";
       String sqlProducto = "SELECT * FROM producto_venta WHERE id_venta = ?";

       try (Connection conn = getConnection();
            PreparedStatement psPedido = conn.prepareStatement(sqlPedido)) {

           // Obtener el ID del cliente basado en su nombre
           Integer idCliente = obtenerIdCliente(nombreCliente);
           if (idCliente == null) {
               System.out.println("Cliente no encontrado.");
               return pedidos;
           }

           // Establecer el parámetro del PreparedStatement
           psPedido.setInt(1, idCliente);

           try (ResultSet rsPedido = psPedido.executeQuery()) {
               while (rsPedido.next()) {
                   pedido pedido = new pedido();
                   // Establecer datos del pedido
                   llenarDatosPedido(rsPedido, pedido);

                   // Recuperar productos y cantidades asociadas al pedido
                   recuperarProductosPedido(conn, rsPedido.getInt("id"), pedido);

                   // Añadir el pedido completo a la lista
                   pedidos.add(pedido);
               }
           }

       } catch (SQLException ex) {
           Logger.getLogger(venta_cbd.class.getName()).log(Level.SEVERE, "Error al listar pedidos", ex);
       }

       return pedidos;
   }

   
   /**
    * Método para llenar los datos de un pedido desde un ResultSet.
    * 
    * @param rsPedido ResultSet con datos del pedido.
    * @param pedido Objeto pedido a llenar.
    */
   
   private void llenarDatosPedido(ResultSet rsPedido, pedido pedido) throws SQLException {
       pedido.setDetalles(rsPedido.getString("detalles"));
       pedido.setValor(rsPedido.getDouble("valor"));
       pedido.setFecha_entrega(rsPedido.getDate("fecha_entrega").toLocalDate());
       pedido.setFecha_realizado(rsPedido.getDate("fecha_realizacion").toLocalDate());
       pedido.setEstado(rsPedido.getBoolean("estado"));
       pedido.setCliente(ListarCliente(rsPedido.getInt("id_cliente")));
       pedido.setCodigo(rsPedido.getString("codigo"));
   }

   
   /**
    * Método para recuperar los productos asociados a un pedido.
    * 
    * @param conn Conexión a la base de datos.
    * @param idPedido ID del pedido.
    * @param pedido Objeto pedido a completar.
    */
   
   private void recuperarProductosPedido(Connection conn, int idPedido, pedido pedido) throws SQLException {
       String sqlProducto = "SELECT * FROM producto_venta WHERE id_venta = ?";
       try (PreparedStatement psProducto = conn.prepareStatement(sqlProducto)) {
           psProducto.setInt(1, idPedido);
           try (ResultSet rsProducto = psProducto.executeQuery()) {
               while (rsProducto.next()) {
                   producto prod = prcbd.buscarProductoPorId(rsProducto.getInt("id_producto"));
                   int cantidad = rsProducto.getInt("cantidad_producto");

                   // Añadir producto y cantidad a la lista del pedido
                   pedido.getProductos().add(prod);
                   pedido.getCantidades().add(cantidad);
               }
           }
       }
   }

   
   /**
    * Método para listar todos los pedidos cuya fecha de entrega esté dentro de los próximos 7 días.
    * 
    * @param fecha Fecha de referencia para el filtro.
    * @return Lista de pedidos.
    */
   
   public ArrayList<pedido> ListadoPedidos(LocalDate fecha) {
       ArrayList<pedido> pedidos = new ArrayList<>();
       // SQL para filtrar pedidos con fecha de entrega en los próximos 7 días
       String sqlPedido = "SELECT * FROM venta WHERE id_tipo = 1 AND DATEDIFF(fecha_entrega, ?) BETWEEN 0 AND 7";
       String sqlProducto = "SELECT * FROM producto_venta WHERE id_venta = ?";

       try (Connection conn = getConnection();
            PreparedStatement psPedido = conn.prepareStatement(sqlPedido)) {

           // Establecer la fecha para el filtro en la consulta SQL
           psPedido.setDate(1, java.sql.Date.valueOf(fecha));

           try (ResultSet rsPedido = psPedido.executeQuery()) {
               while (rsPedido.next()) {
                   pedido pedido = new pedido();
                   // Establecer datos del pedido
                   llenarDatosPedido(rsPedido, pedido);

                   // Recuperar productos y cantidades asociadas al pedido
                   recuperarProductosPedido(conn, rsPedido.getInt("id"), pedido);

                   // Añadir el pedido completo a la lista
                   pedidos.add(pedido);
               }
           }

       } catch (SQLException ex) {
           Logger.getLogger(venta_cbd.class.getName()).log(Level.SEVERE, "Error al listar pedidos por fecha", ex);
       }

       return pedidos;
   }
   
   
   /**
    * Actualiza un pedido en la base de datos.
    * 
    * @param pedido Objeto pedido con los datos actualizados.
    */
   
   public void actualizarpedido(pedido pedido) {
       String pedidosql = "UPDATE venta SET detalles = ?, fecha_entrega = ?, valor = ?, estado = ? WHERE id_tipo = ? AND id = ?";
       String productosql = "DELETE FROM producto_venta WHERE id_venta = ? AND id_producto = ?";

       try (Connection conn = getConnection();
            PreparedStatement pspedidos = conn.prepareStatement(pedidosql);
            PreparedStatement psproductos = conn.prepareStatement(productosql)) {

           // Obtener el ID del pedido basado en el código
           Integer id_pedido = obtenerIdPedidoPorCodigo(pedido.getCodigo());
           if (id_pedido == null) {
               throw new SQLException("No se encontró el pedido con el código: " + pedido.getCodigo());
           }

           // Eliminar productos que ya no están en la lista del pedido
           List<producto> productosActuales = obtenerProductosDePedido(id_pedido);
           eliminarProductosNoActualizados(pedido, id_pedido, psproductos, productosActuales);

           // Actualizar detalles del pedido
           pspedidos.setString(1, pedido.getDetalles());
           pspedidos.setDate(2, Date.valueOf(pedido.getFecha_entrega()));
           pspedidos.setDouble(3, pedido.getValor());
           pspedidos.setBoolean(4, pedido.getEstado());
           pspedidos.setInt(5, 1); // Tipo de pedido
           pspedidos.setInt(6, id_pedido);
           pspedidos.executeUpdate();

       } catch (SQLException e) {
           Logger.getLogger(proveedor_cbd.class.getName()).log(Level.SEVERE, "Error al actualizar el pedido", e);
       }
   }

   
   /**
    * Elimina los productos que ya no están en la lista del pedido.
    * 
    * @param pedido Objeto pedido con los productos actualizados.
    * @param id_pedido ID del pedido en la base de datos.
    * @param psproductos PreparedStatement para eliminar productos.
    * @param productosActuales Lista de productos actualmente en el pedido.
    * @throws SQLException Si ocurre un error en la base de datos.
    */
   
   private void eliminarProductosNoActualizados(pedido pedido, Integer id_pedido, PreparedStatement psproductos, List<producto> productosActuales) throws SQLException {
       for (producto productoActual : productosActuales) {
           boolean productoEnPedido = pedido.getProductos().stream()
               .anyMatch(prod -> prod.getCodigo().equals(productoActual.getCodigo()));

           if (!productoEnPedido) {
               Integer id_producto = prcbd.obtenerIdProducto(productoActual.getCodigo());
               if (id_producto != null) {
                   psproductos.setInt(1, id_pedido);
                   psproductos.setInt(2, id_producto);
                   psproductos.executeUpdate();
               }
           }
       }
   }
   
   
   /**
    * Obtiene un pedido basado en su código.
    * 
    * @param codigo Código del pedido.
    * @return El pedido asociado al código proporcionado, o null si no se encuentra.
    */
   
   public pedido obtenerPedidoPorCodigo(String codigo) {
       pedido pedido = null;
       String sqlPedido = "SELECT * FROM venta WHERE codigo = ?";
       String sqlProducto = "SELECT * FROM producto_venta WHERE id_venta = ?";

       try (Connection conn = getConnection();
            PreparedStatement psPedido = conn.prepareStatement(sqlPedido)) {

           psPedido.setString(1, codigo);

           try (ResultSet rsPedido = psPedido.executeQuery()) {
               if (rsPedido.next()) {
                   pedido = new pedido();
                   llenarDatosPedido(rsPedido, pedido); // Uso del método auxiliar
                   recuperarProductosPedido(conn, rsPedido.getInt("id"), pedido); // Uso del método auxiliar
               } else {
                   System.out.println("Pedido no encontrado.");
               }
           }

       } catch (SQLException ex) {
           Logger.getLogger(venta_cbd.class.getName()).log(Level.SEVERE, "Error al obtener el pedido por código", ex);
       }

       return pedido;
   }

   
   /**
    * Obtiene una venta o un pedido basado en su código.
    * 
    * @param codigo Código de la venta o pedido.
    * @return El objeto venta o pedido asociado al código proporcionado, o null si no se encuentra.
    */
   
   public Object obtenerVentaPorCodigo(String codigo) {
       Object resultado = null;
       String sqlPedido = "SELECT * FROM venta WHERE codigo = ?";
       String sqlProducto = "SELECT * FROM producto_venta WHERE id_venta = ?";

       try (Connection conn = getConnection();
            PreparedStatement psPedido = conn.prepareStatement(sqlPedido)) {

           psPedido.setString(1, codigo);

           try (ResultSet rsPedido = psPedido.executeQuery()) {
               if (rsPedido.next()) {
                   int tipo = rsPedido.getInt("id_tipo");
                   if (tipo == 1) {
                       pedido pedido = new pedido();
                       llenarDatosPedido(rsPedido, pedido); // Uso del método auxiliar
                       recuperarProductosPedido(conn, rsPedido.getInt("id"), pedido); // Uso del método auxiliar
                       resultado = pedido;
                   } else {
                       Ventas venta = new Ventas();
                       llenarDatosVenta(rsPedido, venta); // Uso del método auxiliar
                       recuperarProductosVenta(conn, rsPedido.getInt("id"), venta); // Uso del método auxiliar
                       resultado = venta;
                   }
               } else {
                   System.out.println("Venta o pedido no encontrado.");
               }
           }

       } catch (SQLException ex) {
           Logger.getLogger(venta_cbd.class.getName()).log(Level.SEVERE, "Error al obtener la venta o pedido por código", ex);
       }

       return resultado;
   }

   
   /**
    * Obtiene el ID del pedido basado en su código.
    * 
    * @param codigo Código del pedido.
    * @return El ID del pedido, o null si no se encuentra.
    */
   
   private Integer obtenerIdPedidoPorCodigo(String codigo) {
       String sql = "SELECT id FROM venta WHERE codigo = ?";

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
    * Obtiene la lista de productos asociados a un pedido.
    * 
    * @param id_pedido ID del pedido.
    * @return Lista de productos asociados al pedido.
    */
   
   private List<producto> obtenerProductosDePedido(int id_pedido) {
       List<producto> productos = new ArrayList<>();
       String sql = "SELECT id_producto, cantidad_producto FROM producto_venta WHERE id_venta = ?";

       try (Connection conn = getConnection();
            PreparedStatement ps = conn.prepareStatement(sql)) {

           ps.setInt(1, id_pedido);

           try (ResultSet rs = ps.executeQuery()) {
               while (rs.next()) {
                   // Obtener el producto usando el ID recuperado
                   producto prod = prcbd.buscarProductoPorId(rs.getInt("id_producto"));
                   if (prod != null) {
                       prod.setCantidad(rs.getInt("cantidad_producto")); // Establecer la cantidad del producto
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

