/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app.datos;

import app.bd_conexion.usuario_cbd;
import java.time.LocalDate;
import java.time.Period;

/**
 *
 * @author javie
 */
public class empleado {
    private String nombre;
    private String telefono;
    private String correo;
    private Integer identificacion;
    private String direccion;
    private LocalDate fecha_ingreso;
    private LocalDate fecha_nacimiento;
    private Integer edad;
    private Boolean estado;
    private Double sueldo;

    public empleado(String nombre, String telefono, String correo, Integer identificacion, String direccion, LocalDate fecha_ingreso, LocalDate fecha_nacimiento, Integer edad, Boolean estado, Double sueldo) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.correo = correo;
        this.identificacion = identificacion;
        this.direccion = direccion;
        this.fecha_ingreso = fecha_ingreso;
        this.fecha_nacimiento = fecha_nacimiento;
        this.edad = edad;
        this.estado = estado;
        this.sueldo = sueldo;
    }

    public empleado() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public Integer getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(Integer identificacion) {
        this.identificacion = identificacion;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public LocalDate getFecha_ingreso() {
        return fecha_ingreso;
    }

    public void setFecha_ingreso(LocalDate fecha_ingreso) {
        this.fecha_ingreso = fecha_ingreso;
    }

    public LocalDate getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(LocalDate fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad() {
        LocalDate hoy = LocalDate.now();
        Period periodo = Period.between(fecha_nacimiento, hoy);
        int edades = periodo.getYears();
        this.edad = edades;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public Double getSueldo() {
        return sueldo;
    }

    public void setSueldo(Double sueldo) {
        this.sueldo = sueldo;
    }
    
    
    
}
