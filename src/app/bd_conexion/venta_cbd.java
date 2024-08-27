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
     * Método para registrar un nuevo cliente en la base de datos.
     * 
     * @param cliente Objeto cliente a registrar.
     */
    public void RegistroCliente(cliente cliente) {
        String sql = "INSERT INTO cliente (nombre, correo, numero, identificacion, direccion) VALUES (?, ?, ?, ?, ?);";

        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            // Establecer los parámetros del PreparedStatement
            ps.setString(1, cliente.getNombre());
            ps.setString(3, cliente.getTelefono());
            ps.setString(2, cliente.getCorreo());
            ps.setInt(4, cliente.getIdentificacion());
            ps.setString(5, cliente.getDireccion());

            // Ejecutar la actualización
            ps.executeUpdate();
            System.out.println("Cliente registrado exitosamente.");

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error al registrar el cliente: " + e.getMessage());
        }
    }

    /**
     * Método para listar todos los clientes en la base de datos.
     * 
     * @return Lista de clientes.
     */
    public ArrayList<cliente> ListarCliente() {
        ArrayList<cliente> clientes = new ArrayList<>();
        String sql = "SELECT * FROM cliente";

        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            // Recorrer el ResultSet y añadir los clientes a la lista
            while (rs.next()) {
                cliente c = new cliente();
                c.setNombre(rs.getString("nombre"));
                c.setTelefono(rs.getString("numero"));
                c.setCorreo(rs.getString("correo"));
                c.setIdentificacion(rs.getInt("identificacion"));
                c.setDireccion(rs.getString("direccion"));
                clientes.add(c);
            }

        } catch (SQLException ex) {
            Logger.getLogger(venta_cbd.class.getName()).log(Level.SEVERE, null, ex);
        }

        return clientes;
    }
    
    /**
     * Método para obtener un cliente por su nombre.
     * 
     * @param nombre Nombre del cliente.
     * @return Objeto cliente correspondiente al nombre.
     */
    public cliente ListarCliente(String nombre) {
        String sql = "SELECT * FROM cliente WHERE nombre = ?;";
        cliente c = new cliente();

        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, nombre);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    c.setNombre(rs.getString("nombre"));
                    c.setTelefono(rs.getString("numero"));
                    c.setCorreo(rs.getString("correo"));
                    c.setIdentificacion(rs.getInt("identificacion"));
                    c.setDireccion(rs.getString("direccion"));
                    c.setCompras(ListadoVentas(c.getNombre()));
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(venta_cbd.class.getName()).log(Level.SEVERE, null, ex);
        }

        return c;
    }
    /**
        * Método para obtener clientes por su nombre o coincidencia parcial.
        * 
        * @param nombre Nombre o parte del nombre del cliente.
        * @return Lista de objetos cliente que coinciden con el nombre.
        */
    public ArrayList<cliente> ListarClientes(String nombre) {
           ArrayList<cliente> clientes = new ArrayList<>();
           String sql = "SELECT * FROM cliente WHERE nombre LIKE ?;";

           try (Connection conn = getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)) {

               // Utilizar % para buscar coincidencias parciales
               ps.setString(1, "%" + nombre + "%");

               try (ResultSet rs = ps.executeQuery()) {
                   // Iterar sobre todos los resultados del ResultSet
                   while (rs.next()) {
                       cliente c = new cliente();
                       c.setNombre(rs.getString("nombre"));
                       c.setTelefono(rs.getString("numero"));
                       c.setCorreo(rs.getString("correo"));
                       c.setIdentificacion(rs.getInt("identificacion"));
                       c.setDireccion(rs.getString("direccion"));

                       // Añadir el cliente a la lista
                       clientes.add(c);
                   }
               }

           } catch (SQLException ex) {
               Logger.getLogger(venta_cbd.class.getName()).log(Level.SEVERE, null, ex);
           }

           return clientes;
       }


    /**
     * Método para obtener un cliente por su ID.
     * 
     * @param id ID del cliente.
     * @return Objeto cliente correspondiente al ID.
     */
    public cliente ListarCliente(Integer id) {
        String sql = "SELECT * FROM cliente WHERE id = ?;";
        cliente c = new cliente();

        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    c.setNombre(rs.getString("nombre"));
                    c.setTelefono(rs.getString("numero"));
                    c.setCorreo(rs.getString("correo"));
                    c.setIdentificacion(rs.getInt("identificacion"));
                    c.setDireccion(rs.getString("direccion"));
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(venta_cbd.class.getName()).log(Level.SEVERE, null, ex);
        }

        return c;
    }

    /**
     * Método para obtener el ID de un cliente por su nombre.
     * 
     * @param nombre Nombre del cliente.
     * @return ID del cliente, o null si no se encuentra.
     */
    public Integer obtenerIdCliente(String nombre) {
        Integer id = null;
        String sql = "SELECT id FROM cliente WHERE nombre = ?";

        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, nombre);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    id = rs.getInt("id");
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(venta_cbd.class.getName()).log(Level.SEVERE, null, ex);
        }

        return id;
    }

    /**
     * Método para registrar una venta en la base de datos.
     * 
     * @param venta Objeto Venta o Pedido a registrar.
     */
    public void registrarVenta(Ventas venta) {
        String sqlVenta = "INSERT INTO venta (id_cliente, valor, fecha_realizacion, fecha_entrega, detalles, id_tipo, estado,codigo) VALUES (?, ?, ?, ?, ?, ?, ?,?)";
        String sqlProductoVenta = "INSERT INTO producto_venta (id_producto, cantidad_producto, id_venta) VALUES (?, ?, ?)";
        String sqlActualizacion = "UPDATE producto set cantidad = ? WHERE id = ?";
        try (Connection conn = getConnection();
             PreparedStatement psVenta = conn.prepareStatement(sqlVenta, PreparedStatement.RETURN_GENERATED_KEYS);
             PreparedStatement psActualizar = conn.prepareStatement(sqlActualizacion);
             PreparedStatement psProductoVenta = conn.prepareStatement(sqlProductoVenta)) {

            // Insertar la venta/pedido
            psVenta.setInt(1, obtenerIdCliente(venta.getCliente().getNombre()));
            psVenta.setDouble(2, venta.getValor());
            psVenta.setDate(3, Date.valueOf(venta.getFecha_realizado()));
            psVenta.setString(8, venta.getCodigo());

            if (venta instanceof pedido ped) {
                psVenta.setDate(4, Date.valueOf(ped.getFecha_entrega()));
                psVenta.setString(5, ped.getDetalles());
                psVenta.setInt(6, 1);  // ID tipo pedido
                psVenta.setBoolean(7, false);  // Estado pendiente
            } else {
                psVenta.setDate(4, null);
                psVenta.setString(5, null);
                psVenta.setInt(6, 2);  // ID tipo venta
                psVenta.setBoolean(7, true);  // Estado completado
            }

            psVenta.executeUpdate();

            // Obtener el ID de la venta generada
            try (ResultSet generatedKeys = psVenta.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    int idVenta = generatedKeys.getInt(1);
                    
                    // Insertar los productos asociados a la venta/pedido
                    int i = 0;
                    for (producto p : venta.getProductos()) {
                        psProductoVenta.setInt(1, prcbd.obtenerIdProducto(p.getNombre(), p.getCodigo()));
                        psProductoVenta.setInt(2, venta.getCantidades().get(i));
                        psProductoVenta.setInt(3, idVenta);
                        psActualizar.setInt(1,p.getCantidad() -  venta.getCantidades().get(i));
                        psActualizar.setInt(2,prcbd.obtenerIdProducto(p.getNombre(), p.getCodigo()));
                        psActualizar.executeUpdate();
                        psProductoVenta.executeUpdate();
                        i++;
                    }
                }
            }

            System.out.println("Venta registrada exitosamente.");

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error al registrar la venta: " + e.getMessage());
        }
    }

    /**
     * Método para listar todos los pedidos en la base de datos.
     * 
     * @return Lista de pedidos.
     */
    public ArrayList<pedido> ListadoPedidos() {
        ArrayList<pedido> pedidos = new ArrayList<>();
        String sqlPedido = "SELECT * FROM venta WHERE id_tipo = 1";
        String sqlProducto = "SELECT * FROM producto_venta WHERE id_venta = ?";

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
                            producto prod = prcbd.obtenerProductoPorId(rsProducto.getInt("id_producto"));
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
            Logger.getLogger(venta_cbd.class.getName()).log(Level.SEVERE, null, ex);
        }

        return pedidos;
    }

    /**
     * Método para listar todas las ventas en la base de datos.
     * 
     * @return Lista de ventas.
     */
    public ArrayList<Ventas> ListadoVentas() {
        ArrayList<Ventas> ventas = new ArrayList<>();
        String sqlVenta = "SELECT * FROM venta WHERE estado = 1";
        String sqlProducto = "SELECT * FROM producto_venta WHERE id_venta = ?";

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
                            producto prod = prcbd.obtenerProductoPorId(rsProducto.getInt("id_producto"));
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
            Logger.getLogger(venta_cbd.class.getName()).log(Level.SEVERE, null, ex);
        }

        return ventas;
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
                                producto prod = prcbd.obtenerProductoPorId(rsProducto.getInt("id_producto"));
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
            }

        } catch (SQLException ex) {
            Logger.getLogger(venta_cbd.class.getName()).log(Level.SEVERE, null, ex);
        }

        return ventas;
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

                    // Recuperar y establecer datos del pedido
                    pedido.setDetalles(rsPedido.getString("detalles"));
                    pedido.setValor(rsPedido.getDouble("valor"));
                    pedido.setFecha_entrega(rsPedido.getDate("fecha_entrega").toLocalDate());
                    pedido.setFecha_realizado(rsPedido.getDate("fecha_realizacion").toLocalDate());
                    pedido.setEstado(rsPedido.getBoolean("estado"));
                    pedido.setCliente(ListarCliente(rsPedido.getInt("id_cliente")));
                    pedido.setCodigo(rsPedido.getString("codigo"));

                    // Recuperar productos y cantidades asociadas al pedido
                    try (PreparedStatement psProducto = conn.prepareStatement(sqlProducto)) {
                        psProducto.setInt(1, rsPedido.getInt("id"));
                        try (ResultSet rsProducto = psProducto.executeQuery()) {
                            while (rsProducto.next()) {
                                producto prod = prcbd.obtenerProductoPorId(rsProducto.getInt("id_producto"));
                                int cantidad = rsProducto.getInt("cantidad_producto");

                                // Añadir producto y cantidad a la lista del pedido
                                pedido.getProductos().add(prod);
                                pedido.getCantidades().add(cantidad);
                            }
                        }
                    }

                    // Añadir el pedido completo a la lista
                    pedidos.add(pedido);
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(venta_cbd.class.getName()).log(Level.SEVERE, null, ex);
        }

        return pedidos;
    }
    
    public ArrayList<pedido> ListadoPedidos(LocalDate fecha) {
    ArrayList<pedido> pedidos = new ArrayList<>();
    // Filtrar los pedidos que sean de tipo 1 (pedido) y cuya fecha de entrega esté dentro de los próximos 7 días
    String sqlPedido = "SELECT * FROM venta WHERE id_tipo = 1 AND DATEDIFF(fecha_entrega, ?) BETWEEN 0 AND 7";
    String sqlProducto = "SELECT * FROM producto_venta WHERE id_venta = ?";

    try (Connection conn = getConnection();
         PreparedStatement psPedido = conn.prepareStatement(sqlPedido)) {
        
        // Establecer la fecha para el filtro en la consulta SQL
        psPedido.setDate(1, java.sql.Date.valueOf(fecha));

        try (ResultSet rsPedido = psPedido.executeQuery()) {
            while (rsPedido.next()) {
                pedido pedido = new pedido();

                // Recuperar y establecer datos del pedido
                pedido.setDetalles(rsPedido.getString("detalles"));
                pedido.setValor(rsPedido.getDouble("valor"));
                pedido.setFecha_entrega(rsPedido.getDate("fecha_entrega").toLocalDate());
                pedido.setFecha_realizado(rsPedido.getDate("fecha_realizacion").toLocalDate());
                pedido.setEstado(rsPedido.getBoolean("estado"));
                pedido.setCliente(ListarCliente(rsPedido.getInt("id_cliente")));
                pedido.setCodigo(rsPedido.getString("codigo"));

                // Recuperar productos y cantidades asociadas al pedido
                try (PreparedStatement psProducto = conn.prepareStatement(sqlProducto)) {
                    psProducto.setInt(1, rsPedido.getInt("id"));
                    try (ResultSet rsProducto = psProducto.executeQuery()) {
                        while (rsProducto.next()) {
                            producto prod = prcbd.obtenerProductoPorId(rsProducto.getInt("id_producto"));
                            int cantidad = rsProducto.getInt("cantidad_producto");

                            // Añadir producto y cantidad a la lista del pedido
                            pedido.getProductos().add(prod);
                            pedido.getCantidades().add(cantidad);
                        }
                    }
                }

                // Añadir el pedido completo a la lista
                pedidos.add(pedido);
            }
        }

    } catch (SQLException ex) {
        Logger.getLogger(venta_cbd.class.getName()).log(Level.SEVERE, null, ex);
    }

    return pedidos;
}

    public void actualizarpedido(pedido pedido){
        String pedidosql = "UPDATE venta set detalles = ?, fecha_entrega = ?, valor = ?, estado = ? WHERE id_tipo = ? AND id = ?";
        String productosql = "DELETE FROM producto_venta WHERE id_venta = ? AND id_producto = ?";
        try(Connection conn = getConnection();
                PreparedStatement pspedidos = conn.prepareStatement(pedidosql);
                PreparedStatement psproductos = conn.prepareStatement(productosql)) {
            Integer id_pedido = obtenerIdPedidoPorCodigo(pedido.getCodigo());
            
             if (id_pedido == null) {
                throw new SQLException("No se encontró el pedido con el código: " + pedido.getCodigo());
            }

            // Verificar productos para eliminar
            List<producto> productosActuales = obtenerProductosDePedido(id_pedido);
            for (producto productoActual : productosActuales) {
                boolean productoEnPedido = false;

                // Verificar si el producto aún está en la lista de productos del pedido
                for (producto prod : pedido.getProductos()) {
                    if (prod.getCodigo().equals(productoActual.getCodigo())) {
                        productoEnPedido = true;
                        break;
                    }
                }

                // Si el producto no está en la lista actualizada, se elimina
                if (!productoEnPedido) {
                    Integer id_producto = prcbd.obtenerIdProducto(productoActual.getNombre(), productoActual.getCodigo());

                    if (id_producto != null) {
                        psproductos.setInt(1, id_pedido);
                        psproductos.setInt(2, id_producto);
                        psproductos.executeUpdate();


                    }
                }
            }

            // Actualizar el valor total, la fecha de entrega y el estado del pedido
            pspedidos.setString(1, pedido.getDetalles());
            pspedidos.setDate(2, Date.valueOf(pedido.getFecha_entrega())); // Asegúrate de que p.getFecha_entrega() devuelve LocalDate
            pspedidos.setDouble(3, pedido.getValor());
            pspedidos.setBoolean(4, pedido.getEstado()); // Solo si el estado puede cambiar
            pspedidos.setInt(5, 1);
            pspedidos.setInt(6, id_pedido);
            

            pspedidos.executeUpdate();

        } catch (SQLException e) {
            Logger.getLogger(proveedor_cbd.class.getName()).log(Level.SEVERE, "Error al actualizar el pedido", e);
        
        }
    }
    /**
 * Método para obtener un pedido basado en su código.
 * 
 * @param codigo Codigo del pedido.
 * @return El pedido asociado al código proporcionado, o null si no se encuentra.
 */
public pedido obtenerPedidoPorCodigo(String codigo) {
    pedido pedido = null;
    String sqlPedido = "SELECT * FROM venta WHERE codigo = ?";
    String sqlProducto = "SELECT * FROM producto_venta WHERE id_venta = ?";

    try (Connection conn = getConnection();
         PreparedStatement psPedido = conn.prepareStatement(sqlPedido)) {

        // Establecer el parámetro del PreparedStatement
        psPedido.setString(1, codigo);

        try (ResultSet rsPedido = psPedido.executeQuery()) {
            if (rsPedido.next()) {
                pedido = new pedido();

                // Recuperar y establecer datos del pedido
                pedido.setDetalles(rsPedido.getString("detalles"));
                pedido.setValor(rsPedido.getDouble("valor"));
                pedido.setFecha_entrega(rsPedido.getDate("fecha_entrega").toLocalDate());
                pedido.setFecha_realizado(rsPedido.getDate("fecha_realizacion").toLocalDate());
                pedido.setEstado(rsPedido.getBoolean("estado"));
                pedido.setCliente(ListarCliente(rsPedido.getInt("id_cliente")));
                pedido.setCodigo(rsPedido.getString("codigo"));

                // Recuperar productos y cantidades asociadas al pedido
                try (PreparedStatement psProducto = conn.prepareStatement(sqlProducto)) {
                    psProducto.setInt(1, rsPedido.getInt("id"));
                    try (ResultSet rsProducto = psProducto.executeQuery()) {
                        while (rsProducto.next()) {
                            producto prod = prcbd.obtenerProductoPorId(rsProducto.getInt("id_producto"));
                            int cantidad = rsProducto.getInt("cantidad_producto");

                            // Añadir producto y cantidad a la lista del pedido
                            pedido.getProductos().add(prod);
                            pedido.getCantidades().add(cantidad);
                        }
                    }
                }
            } else {
                System.out.println("Pedido no encontrado.");
            }
        }

    } catch (SQLException ex) {
        Logger.getLogger(venta_cbd.class.getName()).log(Level.SEVERE, null, ex);
    }

    return pedido;
}

public Object obtenerVentaPorCodigo(String codigo) {
    Ventas venta = null;
    pedido pedido = null;
    String sqlPedido = "SELECT * FROM venta WHERE codigo = ?";
    String sqlProducto = "SELECT * FROM producto_venta WHERE id_venta = ?";
    Integer i = 0;
    try (Connection conn = getConnection();
         PreparedStatement psPedido = conn.prepareStatement(sqlPedido)) {

        // Establecer el parámetro del PreparedStatement
        psPedido.setString(1, codigo);

        try (ResultSet rsPedido = psPedido.executeQuery()) {
            if (rsPedido.next()) {
                if( 1 == rsPedido.getInt("id_tipo")){
                pedido = new pedido();

                // Recuperar y establecer datos del pedido
                pedido.setDetalles(rsPedido.getString("detalles"));
                pedido.setValor(rsPedido.getDouble("valor"));
                pedido.setFecha_entrega(rsPedido.getDate("fecha_entrega").toLocalDate());
                pedido.setFecha_realizado(rsPedido.getDate("fecha_realizacion").toLocalDate());
                pedido.setEstado(rsPedido.getBoolean("estado"));
                pedido.setCliente(ListarCliente(rsPedido.getInt("id_cliente")));
                pedido.setCodigo(rsPedido.getString("codigo"));
                i = 1;
                }else{
                    venta = new Ventas();

                // Recuperar y establecer datos del pedido
                venta.setValor(rsPedido.getDouble("valor"));
                venta.setFecha_realizado(rsPedido.getDate("fecha_realizacion").toLocalDate());
                venta.setCliente(ListarCliente(rsPedido.getInt("id_cliente")));
                venta.setCodigo(rsPedido.getString("codigo"));
                i = 2;
                }
                // Recuperar productos y cantidades asociadas al pedido
                try (PreparedStatement psProducto = conn.prepareStatement(sqlProducto)) {
                    psProducto.setInt(1, rsPedido.getInt("id"));
                    try (ResultSet rsProducto = psProducto.executeQuery()) {
                        while (rsProducto.next()) {
                            producto prod = prcbd.obtenerProductoPorId(rsProducto.getInt("id_producto"));
                            int cantidad = rsProducto.getInt("cantidad_producto");
                            if( 1 == rsPedido.getInt("id_tipo")){
                            // Añadir producto y cantidad a la lista del pedido
                            pedido.getProductos().add(prod);
                            pedido.getCantidades().add(cantidad);
                            
                            }else{
                                venta.getProductos().add(prod);
                                venta.getCantidades().add(cantidad);
                            }
                        }
                    }
                }
            } else {
                System.out.println("Pedido no encontrado.");
            }
        }

    } catch (SQLException ex) {
        Logger.getLogger(venta_cbd.class.getName()).log(Level.SEVERE, null, ex);
    }
    if(i == 1){
    return pedido;
    }else if (i == 2){
        return venta;
    }
    return null;
}
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
 private List<producto> obtenerProductosDePedido(int id_pedido) {
        List<producto> productos = new ArrayList<>();
        String sql = "SELECT id_producto, cantidad_producto FROM producto_venta WHERE id_venta = ?";
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

