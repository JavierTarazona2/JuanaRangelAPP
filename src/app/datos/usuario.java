/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app.datos;


public class usuario {
    private String user;
    protected String contraseña;
    private String correo;
    private empleado empleado;
    private Boolean administrador;

    public usuario(String user, String contraseña, String correo, empleado empleado, Boolean administrador) {
        this.user = user;
        this.contraseña = contraseña;
        this.correo = correo;
        this.empleado = empleado;
        this.administrador = administrador;
    }

    public usuario() {
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(empleado empleado) {
        this.empleado = empleado;
    }

    public Boolean getAdministrador() {
        return administrador;
    }

    public void setAdministrador(Boolean administrador) {
        this.administrador = administrador;
    }
    
    
}
