/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app.datos;

import java.util.ArrayList;

public class cliente {
    private String nombre;
    private String telefono;
    private String correo;
    private Integer identificacion;
    private String direccion;
    private ArrayList compras;

    public cliente(String nombre, String telefono, String correo, Integer identificacion, String direccion) {
        this.identificacion = identificacion;
        this.direccion = direccion;
        this.nombre = nombre;
        this.telefono = telefono;
        this.correo = correo;
        this.compras = new ArrayList<Ventas>();
    }
    public cliente(){
        this.compras = new ArrayList<Ventas>();
    }
    public ArrayList getCompras() {
        return compras;
    }

    public void setCompras(ArrayList<Ventas> compra) {
        this.compras = compra;
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
    
}
