package com.krakedev.productos.entidad;

public class Producto {

    private String codigo;
    private String nombre;
    private double precio;
    private int stock;

    // Constructor vacío
    public Producto() {

    }

    // Constructor con parámetros
    public Producto(String codigo, String nombre, double precio,int stock) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
    }

    // Getters y Setters
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

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
    

    public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	@Override
    public String toString() {
        return "Producto [codigo=" + codigo +
                ", nombre=" + nombre +
                ", precio=" + precio +
                ", stock=" + stock +  "]";
    }
}
