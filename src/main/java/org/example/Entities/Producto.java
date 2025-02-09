package org.example.Entities;

import jakarta.persistence.*;

import java.util.Objects;

@Entity()
@Table(name = "productos")
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(length = 100, nullable = false)
    private String nombre;
    @Column(nullable = false)
    private float precio_compra;
    @Column(nullable = false)
    private float precio_venta;
    @Column()
    private int stock;

    public Producto() {}

    public Producto(int id, String nombre, float precio_compra, float precio_venta, int stock) {
        this.id = id;
        this.nombre = nombre;
        this.precio_compra = precio_compra;
        this.precio_venta = precio_venta;
        this.stock = stock;
    }
    public Producto(String nombre, float precio_compra, float precio_venta, int stock) {
        this.nombre = nombre;
        this.precio_compra = precio_compra;
        this.precio_venta = precio_venta;
        this.stock = stock;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Producto producto)) return false;
        return getId() == producto.getId() && Float.compare(getPrecio_compra(), producto.getPrecio_compra()) == 0 && Float.compare(getPrecio_venta(), producto.getPrecio_venta()) == 0 && getStock() == producto.getStock() && Objects.equals(getNombre(), producto.getNombre());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getNombre(), getPrecio_compra(), getPrecio_venta(), getStock());
    }

    @Override
    public String toString() {
        return "Producto{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", precio_compra=" + precio_compra +
                ", precio_venta=" + precio_venta +
                ", stock=" + stock +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public float getPrecio_compra() {
        return precio_compra;
    }

    public void setPrecio_compra(float precio_compra) {
        this.precio_compra = precio_compra;
    }

    public float getPrecio_venta() {
        return precio_venta;
    }

    public void setPrecio_venta(float precio_venta) {
        this.precio_venta = precio_venta;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
}
