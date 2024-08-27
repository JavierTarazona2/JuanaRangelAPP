/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app.datos;

import app.datos.producto;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author javie
 */
public class Ventas {
    private String codigo;
    private cliente cliente;
    private Double valor;
    private LocalDate fecha_realizado;
    private Integer tipo_venta;
    private final ArrayList<producto>productos;
    private final ArrayList<Integer>cantidades;

    public Ventas(cliente cliente, Double valor, LocalDate fecha_realizado, Integer tipo_venta,String codigo) {
        this.cliente = cliente;
        this.codigo = codigo;
        this.valor = valor;
        this.fecha_realizado = fecha_realizado;
        this.tipo_venta = tipo_venta;
        this.productos = new ArrayList<>();
        this.cantidades = new ArrayList<>();
    }
    public Ventas (){
        this.productos = new ArrayList<>();
        this.cantidades = new ArrayList<>();
    }   

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    

    public cliente getCliente() {
        return cliente;
    }

    public void setCliente(cliente cliente) {
        this.cliente = cliente;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public LocalDate getFecha_realizado() {
        return fecha_realizado;
    }

    public void setFecha_realizado(LocalDate fecha_realizado) {
        this.fecha_realizado = fecha_realizado;
    }

    public Integer getTipo_venta() {
        return tipo_venta;
    }

    public void setTipo_venta(Integer tipo_venta) {
        this.tipo_venta = tipo_venta;
    }

    public ArrayList<producto> getProductos() {
        return productos;
    }

    public void setProductos(producto producto , Integer cantidad) {
        productos.add(producto);
        cantidades.add(cantidad);
    }
    public ArrayList<Integer> getCantidades (){
        return cantidades;
    }
    
}