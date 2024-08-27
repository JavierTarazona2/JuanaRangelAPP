/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app.datos;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author javie
 */
public class reportes {
    private ArrayList<producto> productos;
    private ArrayList<Integer> cantidad;
    private String detalles;
        private Integer codigo;
    private LocalDate fecha;

    public reportes(String detalles,Integer codigo, LocalDate fecha) {
        this.detalles = detalles;
        this.codigo = codigo;
        this.productos = new ArrayList<>();
        this.cantidad = new ArrayList<>();
        this.fecha = fecha;
    }
    
    public reportes() {
        this.productos = new ArrayList<>();
        this.cantidad = new ArrayList<>();
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }
    
    
    public ArrayList<producto> getProductos() {
        return productos;
    }

    public void setProductos(producto producto, Integer cant) {
        productos.add(producto);
        cantidad.add(cant);
    }

    public Integer getCantidad (Integer i){
        return cantidad.get(i);
    }

    public String getDetalles() {
        return detalles;
    }

    public void setDetalles(String detalles) {
        this.detalles = detalles;
    }


    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }
    
    
}