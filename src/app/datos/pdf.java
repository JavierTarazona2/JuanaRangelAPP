/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app.datos;

import app.datos.Ventas;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.draw.LineSeparator;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class pdf {

    public pdf() {
    }
    private LineSeparator linea (){
        LineSeparator ll =  new LineSeparator();
        ll.setPercentage(90);
        return ll;
    }
    
    public void CrearPdf(Object ventas) {
    Document documento = new Document();
    String ruta = System.getProperty("user.home");
    String direccionpdf;

    if (ventas instanceof pedido) {
        pedido venta = (pedido) ventas;
        direccionpdf = ruta + "\\OneDrive\\Documentos\\Facturas\\Pedidos\\factura-" + venta.getCodigo() + ".pdf";

        try {
            PdfWriter.getInstance(documento, new FileOutputStream(direccionpdf));
            documento.open();

            // Configurar color personalizado
            BaseColor colorPersonalizado = new BaseColor(145, 0, 0);

            // Crear encabezado
            addEncabezado(documento, colorPersonalizado);

            // Crear tabla de información de la factura
            addInfoFactura(documento, venta);

            // Agregar detalles específicos de pedido
            addDetallesPedido(documento, venta);

            // Crear tabla de productos
            addTablaProductos(documento, venta.getProductos(), venta.getCantidades(), colorPersonalizado);

            // Crear sección de totales y firma
            addTotalesYFirma(documento, venta.getValor(), colorPersonalizado);

        } catch (DocumentException | IOException e) {
            e.printStackTrace(); // Manejo de excepciones
        } finally {
            documento.close();
             EnviarCorreo(direccionpdf, venta);
        }

    } else if (ventas instanceof Ventas) {
        Ventas venta = (Ventas) ventas;
        direccionpdf = ruta + "\\OneDrive\\Documentos\\Facturas\\Ventas\\factura-" + venta.getCodigo() + ".pdf";

        try {
            PdfWriter.getInstance(documento, new FileOutputStream(direccionpdf));
            documento.open();

            // Configurar color personalizado
            BaseColor colorPersonalizado = new BaseColor(145, 0, 0);

            // Crear encabezado
            addEncabezado(documento, colorPersonalizado);

            // Crear tabla de información de la factura
            addInfoFactura(documento, venta);

            // Crear tabla de productos
            addTablaProductos(documento, venta.getProductos(), venta.getCantidades(), colorPersonalizado);

            // Crear sección de totales y firma
            addTotalesYFirma(documento, venta.getValor(), colorPersonalizado);

        } catch (DocumentException | IOException e) {
            e.printStackTrace(); // Manejo de excepciones
        } finally {
            documento.close();
             EnviarCorreo(direccionpdf, venta);
        }
    }
    }

    
    private void addEncabezado(Document documento, BaseColor colorPersonalizado) throws DocumentException, IOException {
        PdfPTable tablaEncabezado = new PdfPTable(3);
        tablaEncabezado.setWidthPercentage(100);
        tablaEncabezado.setWidths(new float[]{1, 3, 3});

        // Añadir logo
        Image logo = Image.getInstance("C:\\Users\\javie\\OneDrive\\Documentos\\JuanaRangelapp\\JuanaRangelapp\\src\\imagenes\\GALLETAFONDOJAVIEE.png");
        logo.scaleToFit(80, 80);
        PdfPCell celdaLogo = new PdfPCell(logo);
        celdaLogo.setBorder(Rectangle.NO_BORDER);
        celdaLogo.setHorizontalAlignment(Element.ALIGN_CENTER);
        tablaEncabezado.addCell(celdaLogo);

        // Añadir nombre y detalles
        PdfPCell celdaNombre = new PdfPCell(new Phrase("Panadería Juana Rangel", FontFactory.getFont(FontFactory.HELVETICA_BOLD, 24)));
        celdaNombre.setBorder(Rectangle.NO_BORDER);
        celdaNombre.setVerticalAlignment(Element.ALIGN_MIDDLE);
        celdaNombre.setHorizontalAlignment(Element.ALIGN_LEFT);
        tablaEncabezado.addCell(celdaNombre);

        PdfPCell celdaDetalles = new PdfPCell(new Phrase("29384751R\nCalle Llacuna, 132\nBarcelona (08022), España\ntomas.vinas@tuffers.com\n678644309", FontFactory.getFont(FontFactory.HELVETICA, 10)));
        celdaDetalles.setBorder(Rectangle.NO_BORDER);
        celdaDetalles.setHorizontalAlignment(Element.ALIGN_RIGHT);
        celdaDetalles.setVerticalAlignment(Element.ALIGN_TOP);
        tablaEncabezado.addCell(celdaDetalles);

        documento.add(tablaEncabezado);
        documento.add(new Paragraph("\n"));
        documento.add(linea());
        documento.add(new Paragraph("\n"));
    }

    
    private void addInfoFactura(Document documento, Ventas venta) throws DocumentException {
        PdfPTable tablaInfo = new PdfPTable(2);
        tablaInfo.setWidthPercentage(100);
        tablaInfo.setWidths(new float[]{2, 2});

        PdfPCell celdaFactura = new PdfPCell(new Phrase("FACTURA #" + venta.getCodigo(), FontFactory.getFont(FontFactory.HELVETICA_BOLD, 12)));
        celdaFactura.setBorder(Rectangle.NO_BORDER);
        tablaInfo.addCell(celdaFactura);

        PdfPCell celdaEspacio = new PdfPCell(new Phrase(" "));
        celdaEspacio.setBorder(Rectangle.NO_BORDER);
        tablaInfo.addCell(celdaEspacio);

        PdfPCell celdaCliente = new PdfPCell(new Phrase(
            "Cliente: " + venta.getCliente().getNombre() + "\n" +
            "Identificación: " + venta.getCliente().getIdentificacion() + "\n" +
            "Teléfono: " + venta.getCliente().getTelefono() + "\n" +
            "Correo: " + venta.getCliente().getCorreo(), FontFactory.getFont(FontFactory.HELVETICA, 12)));
        celdaCliente.setBorder(Rectangle.NO_BORDER);
        celdaCliente.setHorizontalAlignment(Element.ALIGN_LEFT);
        tablaInfo.addCell(celdaCliente);

        PdfPCell celdaFacturaInfo = new PdfPCell(new Phrase(
            "Fecha: " + venta.getFecha_realizado() + "\n" +
            "Total: " + venta.getValor() + "€\n", FontFactory.getFont(FontFactory.HELVETICA, 12)));
        celdaFacturaInfo.setBorder(Rectangle.NO_BORDER);
        celdaFacturaInfo.setHorizontalAlignment(Element.ALIGN_RIGHT);
        tablaInfo.addCell(celdaFacturaInfo);

        documento.add(tablaInfo);
        documento.add(new Paragraph("\n"));
        documento.add(linea());
        documento.add(new Paragraph("\n"));
    }

    
    private void addTablaProductos(Document documento, ArrayList<producto> productos, 
           ArrayList<Integer> cantidades, BaseColor colorPersonalizado) throws DocumentException {
    PdfPTable tablaProductos = new PdfPTable(5);
    tablaProductos.setWidthPercentage(100);
    tablaProductos.setWidths(new float[]{2, 2, 2, 2, 2});

    // Encabezados
    String[] columnas = {"Codigo", "Nombre", "Precio", "Unidades", "Total"};
    for (String columna : columnas) {
        PdfPCell celda = new PdfPCell(new Phrase(columna, FontFactory.getFont(FontFactory.HELVETICA_BOLD, 10, colorPersonalizado)));
        celda.setHorizontalAlignment(Element.ALIGN_CENTER); // Alinear texto horizontalmente al centro
        celda.setVerticalAlignment(Element.ALIGN_MIDDLE);   // Alinear texto verticalmente al centro
        celda.setBorder(Rectangle.NO_BORDER); // Quitar borde
        tablaProductos.addCell(celda);
    }

    int id = 0;
    for (producto producto : productos) {
        PdfPCell celdaCodigo = new PdfPCell(new Phrase(producto.getCodigo(), FontFactory.getFont(FontFactory.HELVETICA, 10)));
        celdaCodigo.setHorizontalAlignment(Element.ALIGN_CENTER); // Alinear texto horizontalmente al centro
        celdaCodigo.setVerticalAlignment(Element.ALIGN_MIDDLE);   // Alinear texto verticalmente al centro
        celdaCodigo.setBorder(Rectangle.NO_BORDER); // Quitar borde
        tablaProductos.addCell(celdaCodigo);

        PdfPCell celdaNombre = new PdfPCell(new Phrase(producto.getNombre(), FontFactory.getFont(FontFactory.HELVETICA, 10)));
        celdaNombre.setHorizontalAlignment(Element.ALIGN_CENTER); // Alinear texto horizontalmente al centro
        celdaNombre.setVerticalAlignment(Element.ALIGN_MIDDLE);   // Alinear texto verticalmente al centro
        celdaNombre.setBorder(Rectangle.NO_BORDER); // Quitar borde
        tablaProductos.addCell(celdaNombre);

        PdfPCell celdaPrecio = new PdfPCell(new Phrase(String.valueOf(producto.getPrecio_salida()), FontFactory.getFont(FontFactory.HELVETICA, 10)));
        celdaPrecio.setHorizontalAlignment(Element.ALIGN_CENTER); // Alinear texto horizontalmente al centro
        celdaPrecio.setVerticalAlignment(Element.ALIGN_MIDDLE);   // Alinear texto verticalmente al centro
        celdaPrecio.setBorder(Rectangle.NO_BORDER); // Quitar borde
        tablaProductos.addCell(celdaPrecio);

        PdfPCell celdaCantidad = new PdfPCell(new Phrase(String.valueOf(cantidades.get(id)), FontFactory.getFont(FontFactory.HELVETICA, 10)));
        celdaCantidad.setHorizontalAlignment(Element.ALIGN_CENTER); // Alinear texto horizontalmente al centro
        celdaCantidad.setVerticalAlignment(Element.ALIGN_MIDDLE);   // Alinear texto verticalmente al centro
        celdaCantidad.setBorder(Rectangle.NO_BORDER); // Quitar borde
        tablaProductos.addCell(celdaCantidad);

        PdfPCell celdaTotal = new PdfPCell(new Phrase(String.format("%.2f€", producto.getPrecio_salida() * cantidades.get(id)), FontFactory.getFont(FontFactory.HELVETICA, 10)));
        celdaTotal.setHorizontalAlignment(Element.ALIGN_CENTER); // Alinear texto horizontalmente al centro
        celdaTotal.setVerticalAlignment(Element.ALIGN_MIDDLE);   // Alinear texto verticalmente al centro
        celdaTotal.setBorder(Rectangle.NO_BORDER); // Quitar borde
        tablaProductos.addCell(celdaTotal);

        id++;
    }

    // Configurar la tabla para no mostrar bordes
    tablaProductos.getDefaultCell().setBorder(Rectangle.NO_BORDER); // Quitar borde de la tabla

    documento.add(tablaProductos);
    documento.add(new Paragraph("\n"));
    documento.add(linea());
    documento.add(new Paragraph("\n"));
    }

   
    private void addTotalesYFirma(Document documento, double valor, BaseColor colorPersonalizado) throws DocumentException {
        Paragraph totalPagar = new Paragraph("Total a Pagar:", FontFactory.getFont(FontFactory.HELVETICA_BOLD, 12, colorPersonalizado));
        totalPagar.setAlignment(Element.ALIGN_CENTER);
        documento.add(totalPagar);

        Paragraph totalValor = new Paragraph(String.format("%.2f€", valor), FontFactory.getFont(FontFactory.HELVETICA, 12));
        totalValor.setAlignment(Element.ALIGN_CENTER);
        documento.add(totalValor);

        Paragraph pp = new Paragraph("\nCancelación y Firma\n", FontFactory.getFont(FontFactory.HELVETICA, 12));
        pp.setAlignment(Element.ALIGN_CENTER);
        Paragraph p2 = new Paragraph("\n_______________________________\n", FontFactory.getFont(FontFactory.HELVETICA, 12));
        p2.setAlignment(Element.ALIGN_CENTER);
        Paragraph p3 = new Paragraph("\nGracias por su compra", FontFactory.getFont(FontFactory.HELVETICA, 12));
        p3.setAlignment(Element.ALIGN_CENTER);

        documento.add(pp);
        documento.add(p2);
        documento.add(p3);
        documento.add(new Paragraph("\n"));
    }
    
    
    private void addDetallesPedido(Document documento, pedido venta) throws DocumentException {
    // Crear una sección para detalles específicos del pedido
    Paragraph detalles = new Paragraph();
    detalles.setFont(new Font(Font.FontFamily.HELVETICA, 12, Font.NORMAL));
    detalles.add("Fecha de Entrega: " + venta.getFecha_entrega() + "\n");
    detalles.add("Detalles del pedido: " + venta.getDetalles() + "\n");
    
    // Agregar detalles al documento
    documento.add(detalles);
    documento.add(new Paragraph("\n"));
    documento.add(linea());
    documento.add(new Paragraph("\n"));
    }
    
    
    public void EnviarCorreo(String pdfs, Ventas venta) {
    // Configuración del servidor SMTP
    String host = "smtp.gmail.com";
    final String user = "dariotarazona10@gmail.com"; // Tu correo electrónico
    final String password = "lxmxqqgtobrqeceo"; // Tu contraseña de Gmail o contraseña de aplicación

    // Configuración de propiedades
    Properties properties = new Properties();
    properties.put("mail.smtp.host", host);
    properties.put("mail.smtp.port", "587");
    properties.put("mail.smtp.starttls.enable", "true"); // Habilita STARTTLS
    properties.put("mail.smtp.auth", "true"); // Requiere autenticación


    // Obtener la sesión
    Session session;
        session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(user, password);
            }
        });

    try {
        // Crear un mensaje
        MimeMessage message = new MimeMessage(session);

        // De: dirección
        message.setFrom(new InternetAddress(user));

        // A: dirección
        message.addRecipient(Message.RecipientType.TO, new InternetAddress(venta.getCliente().getCorreo()));

        // Asunto
        message.setSubject("¡Gracias por tu compra en Panadería Juana Rangel!");

        // Crear el contenido del mensaje
        MimeBodyPart mensajeCuerpo = new MimeBodyPart();
        String contenido = "Estimado/a " + venta.getCliente().getNombre() + ",\n\n" +
                "¡Gracias por confiar en Panadería Juana Rangel! Adjuntamos a este correo la factura correspondiente a tu reciente compra.\n\n" +
                "Si tienes alguna pregunta o necesitas asistencia adicional, no dudes en contactarnos.\n\n" +
                "¡Esperamos verte pronto en nuestra panadería!\n\n" +
                "Atentamente,\n" +
                "El equipo de Panadería Juana Rangel";
        mensajeCuerpo.setText(contenido);

        // Crear el archivo adjunto
        MimeBodyPart archivoAdjunto = new MimeBodyPart();
        DataSource source = new FileDataSource(pdfs);
        archivoAdjunto.setDataHandler(new DataHandler(source));
        archivoAdjunto.setFileName("Factura.pdf");

        // Crear el contenedor del mensaje
        Multipart multipart = new MimeMultipart();
        multipart.addBodyPart(mensajeCuerpo);
        multipart.addBodyPart(archivoAdjunto);

        // Configurar el mensaje
        message.setContent(multipart);

        // Enviar el mensaje
        Transport.send(message);
        System.out.println("Correo enviado exitosamente.");
    } catch (MessagingException e) {
        e.printStackTrace();
    }
    }
    
    
    public void EnviarCorreo(usuario nuevoUsuario) {
    // Configuración del servidor SMTP
    String host = "smtp.gmail.com";
    final String user = "dariotarazona10@gmail.com"; // Tu correo electrónico
    final String password = "lxmxqqgtobrqeceo"; // Tu contraseña de Gmail o contraseña de aplicación

    // Configuración de propiedades
    Properties properties = new Properties();
    properties.put("mail.smtp.host", host);
    properties.put("mail.smtp.port", "587");
    properties.put("mail.smtp.starttls.enable", "true"); // Habilita STARTTLS
    properties.put("mail.smtp.auth", "true"); // Requiere autenticación

    // Obtener la sesión
    Session session = Session.getInstance(properties, new Authenticator() {
        @Override
        protected PasswordAuthentication getPasswordAuthentication() {
            return new PasswordAuthentication(user, password);
        }
    });

    try {
        // Crear un mensaje
        MimeMessage message = new MimeMessage(session);

        // De: dirección
        message.setFrom(new InternetAddress(user));

        // A: dirección
        message.addRecipient(Message.RecipientType.TO, new InternetAddress(nuevoUsuario.getCorreo()));

        // Asunto
        message.setSubject("Bienvenido a la Panadería Juana Rangel");

        // Crear el contenido del mensaje
        MimeBodyPart mensajeCuerpo = new MimeBodyPart();
        String contenidoMensaje = String.format("""
                                                Hola %s,
                                                
                                                Bienvenido a la Panader\u00eda Juana Rangel.
                                                
                                                Tus credenciales de acceso son:
                                                Usuario: %s
                                                Contrase\u00f1a: %s
                                                
                                                Por favor, cambia tu contrase\u00f1a despu\u00e9s de iniciar sesi\u00f3n por primera vez.
                                                
                                                Saludos,
                                                Equipo de la Panader\u00eda Juana Rangel""",
            nuevoUsuario.getEmpleado().getNombre(), // Obtiene el nombre del empleado
            nuevoUsuario.getUser(),
            nuevoUsuario.getContraseña()
        );
        mensajeCuerpo.setText(contenidoMensaje);

        // Crear el contenedor del mensaje
        Multipart multipart = new MimeMultipart();
        multipart.addBodyPart(mensajeCuerpo);

        // Configurar el mensaje
        message.setContent(multipart);

        // Enviar el mensaje
        Transport.send(message);
        System.out.println("Correo de bienvenida enviado exitosamente.");
    } catch (MessagingException e) {
        e.printStackTrace();
    }
    }

    
}
