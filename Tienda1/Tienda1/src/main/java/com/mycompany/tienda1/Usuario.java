/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tienda1;

/**
 *
 * @author MAFE
 */
public class Usuario {
    public String ID;
    public String Nombre;
    public String Clave;

    public Usuario(String ID, String Nombre, String Clave) {
        this.ID = ID;
        this.Nombre = Nombre;
        this.Clave = Clave;
    }

    public String getID() {
        return ID;
    }

    public String getNombre() {
        return Nombre;
    }

    public String getClave() {
        return Clave;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public void setClave(String Clave) {
        this.Clave = Clave;
    }
}
