/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app.datos;

import java.awt.Desktop;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.ClientAnchor;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Drawing;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Picture;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.util.IOUtils;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author javie
 */
public class Excel {
    public  void reporte(ArrayList<producto> listaProductos) {
    Workbook book = new XSSFWorkbook();
        org.apache.poi.ss.usermodel.Sheet sheet = book.createSheet("Productos");

    try {
        // Ruta del logo
        String logoPath = new File("C:\\Users\\javie\\Downloads\\JuanaRangelapp\\JuanaRangelapp\\src\\imagenes\\GALLETAFONDOJAVIEE.png").getAbsolutePath();
        File logoFile = new File(logoPath);
        if (!logoFile.exists()) {
            throw new FileNotFoundException("El archivo no se encuentra: " + logoPath);
        }

        // Leer el logo
        InputStream is = new FileInputStream(logoPath);
        byte[] bytes = IOUtils.toByteArray(is);
        int imgIndex = book.addPicture(bytes, Workbook.PICTURE_TYPE_PNG);
        is.close();

        CreationHelper help = book.getCreationHelper();
        Drawing draw = sheet.createDrawingPatriarch();

        ClientAnchor anchor = help.createClientAnchor();
        anchor.setCol1(0);
        anchor.setRow1(1);
        Picture pict = draw.createPicture(anchor, imgIndex);
        pict.resize(1, 3);

        // Estilo para el título del reporte
        CellStyle tituloEstilo = book.createCellStyle();
        tituloEstilo.setAlignment(HorizontalAlignment.CENTER);
        tituloEstilo.setVerticalAlignment(VerticalAlignment.CENTER);
        org.apache.poi.ss.usermodel.Font fuenteTitulo = book.createFont();
        fuenteTitulo.setFontName("Arial");
        fuenteTitulo.setBold(true);
        fuenteTitulo.setFontHeightInPoints((short) 14);
        tituloEstilo.setFont(fuenteTitulo);

        Row filaTitulo = sheet.createRow(1);
        Cell celdaTitulo = filaTitulo.createCell(1);
        celdaTitulo.setCellStyle(tituloEstilo);
        celdaTitulo.setCellValue("Reporte de Productos Vendidos");

        sheet.addMergedRegion(new CellRangeAddress(1, 2, 1, 3));

        String[] cabecera = new String[]{"Código", "Nombre", "Cantidad Vendida"};

        // Estilo para la cabecera
        CellStyle headerStyle = book.createCellStyle();
        headerStyle.setFillForegroundColor(IndexedColors.LIGHT_BLUE.getIndex());
        headerStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        headerStyle.setBorderBottom(BorderStyle.THIN);
        headerStyle.setBorderLeft(BorderStyle.THIN);
        headerStyle.setBorderRight(BorderStyle.THIN);
        headerStyle.setBorderTop(BorderStyle.THIN);

        org.apache.poi.ss.usermodel.Font font = book.createFont();
        font.setFontName("Arial");
        font.setBold(true);
        font.setColor(IndexedColors.WHITE.getIndex());
        font.setFontHeightInPoints((short) 12);
        headerStyle.setFont(font);

        Row filaEncabezados = sheet.createRow(4);

        for (int i = 0; i < cabecera.length; i++) {
            Cell celdaEncabezado = filaEncabezados.createCell(i);
            celdaEncabezado.setCellStyle(headerStyle);
            celdaEncabezado.setCellValue(cabecera[i]);
        }

        // Estilo para los datos
        CellStyle datosEstilo = book.createCellStyle();
        datosEstilo.setBorderBottom(BorderStyle.THIN);
        datosEstilo.setBorderLeft(BorderStyle.THIN);
        datosEstilo.setBorderRight(BorderStyle.THIN);
        datosEstilo.setBorderTop(BorderStyle.THIN);

        // Llenar los datos desde la lista de productos
        int numFilaDatos = 5;
        for (producto producto : listaProductos) {
            Row filaDatos = sheet.createRow(numFilaDatos);

            Cell celdaCodigo = filaDatos.createCell(0);
            celdaCodigo.setCellStyle(datosEstilo);
            celdaCodigo.setCellValue(producto.getCodigo());

            Cell celdaNombre = filaDatos.createCell(1);
            celdaNombre.setCellStyle(datosEstilo);
            celdaNombre.setCellValue(producto.getNombre());

            Cell celdaCantidad = filaDatos.createCell(2);
            celdaCantidad.setCellStyle(datosEstilo);
            celdaCantidad.setCellValue(producto.getCantidad()); // Suponiendo que el método `getCantidadVendida()` existe

            numFilaDatos++;
        }

        // Ajustar tamaño de las columnas
        for (int i = 0; i < cabecera.length; i++) {
            sheet.autoSizeColumn(i);
        }

        sheet.setZoom(150);

        // Ruta de descarga personalizada
         String ruta = System.getProperty("user.home");
        String fileName = "productos_vendidos.xlsx";
        String downloadPath =ruta + File.separator + "Downloads" + File.separator + "JuanaRangelapp" + File.separator + "JuanaRangelapp" + File.separator + "src" + File.separator + "Facturas" + File.separator + "Reportes";
        File downloadsDir = new File(downloadPath);
        if (!downloadsDir.exists()) {
            downloadsDir.mkdirs();
        }

        File outFile = new File(downloadsDir, fileName);

        // Guardar el archivo
        FileOutputStream fileOut = new FileOutputStream(outFile);
        book.write(fileOut);
        fileOut.close();

        // Abrir el archivo
        Desktop.getDesktop().open(outFile);
        System.out.println("Reporte Generado");

    } catch (FileNotFoundException ex) {
        Logger.getLogger(pdf.class.getName()).log(Level.SEVERE, null, ex);
    } catch (IOException ex) {
        Logger.getLogger(pdf.class.getName()).log(Level.SEVERE, null, ex);
    }
}
}
