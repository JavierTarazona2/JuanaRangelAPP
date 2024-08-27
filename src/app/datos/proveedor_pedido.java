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
public class proveedor_pedido {
    private proveedor proveedor;
    private String codigo;
    private Double valor_total;
    private ArrayList<producto> productos = new ArrayList<>();
    private ArrayList<Integer> cantidad = new ArrayList<>();
    private LocalDate fecha_entrega;
    private LocalDate fecha_realizacion;
    private Boolean estado;
    

    public proveedor_pedido(proveedor proveedor,String codigo, Double valor_total, LocalDate fecha_entrega, LocalDate fecha_realizacion, Boolean estado) {
        this.proveedor = proveedor;
        this.codigo = codigo;
        this.valor_total = valor_total;
        this.fecha_entrega = fecha_entrega;
        this.fecha_realizacion = fecha_realizacion;
        this.estado = estado;
    }
    public proveedor_pedido(){
        
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }
    

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    
    public proveedor getproveedor() {
        return proveedor;
    }

    public void setProveedor(proveedor nombre) {
        this.proveedor = nombre;
    }

    public Double getValor_total() {
        return valor_total;
    }

    public void setValor_total(Double valor_total) {
        this.valor_total = valor_total;
    }

    public ArrayList<producto>getProductos() {
        return productos;
    }

     public void setProductos(producto producto, Integer cantidades) {
        this.productos.add(producto);
        this.cantidad.add(cantidades);
    }
    public ArrayList<Integer> getCantidades(){
        return cantidad;
    }

    public LocalDate getFecha_entrega() {
        return fecha_entrega;
    }

    public void setFecha_entrega(LocalDate fecha_entrega) {
        this.fecha_entrega = fecha_entrega;
    }

    public LocalDate getFecha_realizacion() {
        return fecha_realizacion;
    }

    public void setFecha_realizacion(LocalDate fecha_realizacion) {
        this.fecha_realizacion = fecha_realizacion;
    }
    
    
}
