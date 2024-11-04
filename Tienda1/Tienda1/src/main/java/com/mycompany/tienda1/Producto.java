package com.mycompany.tienda1;

public class Producto {
    public int id;
    public String codigo;
    public String descripción;
    public int cantidad;
    public float valor_unitario;

    public Producto() {
    }

    public Producto(int id, String codigo, String descripción, int cantidad, float valor_unitario) {
        this.id = id;
        this.codigo = codigo;
        this.descripción = descripción;
        this.cantidad = cantidad;
        this.valor_unitario = valor_unitario;
    }

    public int getId() {
        return id;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getDescripción() {
        return descripción;
    }

    public int getCantidad() {
        return cantidad;
    }

    public float getValor_unitario() {
        return valor_unitario;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public void setDescripción(String descripción) {
        this.descripción = descripción;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public void setValor_unitario(float valor_unitario) {
        this.valor_unitario = valor_unitario;
    }

}