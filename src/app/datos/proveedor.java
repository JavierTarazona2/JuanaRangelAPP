/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app.datos;

import java.util.ArrayList;

/**
 *
 * @author javie
 */
public class proveedor {
    private String nombre;
    private String telefono;
    private String correo;
    private ArrayList<proveedor_pedido> pedido;

    public proveedor(String nombre, String telefono, String correo) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.correo = correo;
        this.pedido = new ArrayList<>();
    }
    public proveedor(){
        
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

    public ArrayList<proveedor_pedido> getPedido() {
        return pedido;
    }

    public void setPedido(proveedor_pedido pedidos) {
        pedido.add(pedidos);
    }
    
}
