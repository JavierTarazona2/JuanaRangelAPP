/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app.datos;

import java.time.LocalDate;

/**
 *
 * @author javie
 */
public class pedido extends Ventas{
    private LocalDate fecha_entrega;
    private String detalles;
    private Boolean estado;

    public pedido(LocalDate fecha_entrega, String detalles, app.datos.cliente cliente, Double valor, LocalDate fecha_realizado, Integer tipo_venta, Boolean estado,String codigo) {
        super(cliente, valor, fecha_realizado, tipo_venta, codigo);
        this.fecha_entrega = fecha_entrega;
        this.detalles = detalles;
        this.estado = estado;
    }
    public pedido (){
        
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }
    
    public LocalDate getFecha_entrega() {
        return fecha_entrega;
    }

    public void setFecha_entrega(LocalDate fecha_entrega) {
        this.fecha_entrega = fecha_entrega;
    }

    public String getDetalles() {
        return detalles;
    }

    public void setDetalles(String detalles) {
        this.detalles = detalles;
    }

    
    
}

