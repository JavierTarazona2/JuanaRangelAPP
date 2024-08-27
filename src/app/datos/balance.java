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
public class balance {
    private LocalDate fecha;
    private String detalles;
    private Double valor;
    private String tipo;

    public balance(LocalDate fecha, String detalles, Double valor, String tipo) {
        this.fecha = fecha;
        this.detalles = detalles;
        this.valor = valor;
        this.tipo = tipo;
    }

    public balance() {
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public String getDetalles() {
        return detalles;
    }

    public void setDetalles(String detalles) {
        this.detalles = detalles;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    
}
