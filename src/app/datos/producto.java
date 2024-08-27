/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app.datos;

import java.time.LocalDate;

public class producto {
    private String codigo;
    private String nombre;
    private String medida;
    private String categoria;
    private Double precio_entrada;
    private Double precio_salida;
    private LocalDate feche_vencimiento;
    private LocalDate fecha_ingreso;
    private Integer cantidad;

    public producto( String codigo, String nombre, String medida, String categoria, Double precio_entrada, Double precio_salida, LocalDate feche_vencimiento, LocalDate fecha_ingreso) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.medida = medida;
        this.categoria = categoria;
        this.precio_entrada = precio_entrada;
        this.precio_salida = precio_salida;
        this.feche_vencimiento = feche_vencimiento;
        this.fecha_ingreso = fecha_ingreso;
    }

    public producto(){
        
    }
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getMedida() {
        return medida;
    }

    public void setMedida(String medida) {
        this.medida = medida;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public Double getPrecio_entrada() {
        return precio_entrada;
    }

    public void setPrecio_entrada(Double precio_entrada) {
        this.precio_entrada = precio_entrada;
    }

    public Double getPrecio_salida() {
        return precio_salida;
    }

    public void setPrecio_salida(Double precio_salida) {
        this.precio_salida = precio_salida;
    }

    public LocalDate getFeche_vencimiento() {
        return feche_vencimiento;
    }

    public void setFeche_vencimiento(LocalDate feche_vencimiento) {
        this.feche_vencimiento = feche_vencimiento;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public LocalDate getFecha_ingreso() {
        return fecha_ingreso;
    }

    public void setFecha_ingreso(LocalDate fecha_ingreso) {
        this.fecha_ingreso = fecha_ingreso;
    }
   
    
}
