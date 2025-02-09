package org.example.Entities;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "clientes")
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(length = 100, nullable = false)
    private String nombre;
    @Column(nullable = false, length = 150)
    private String email;
    @Column(length = 15)
    private String telefono;
    @Column()
    private String direccion;

    public Cliente(int id, String nombre, String email, String telefono, String direccion) {
        this.id = id;
        this.direccion = direccion;
        this.email = email;
        this.nombre = nombre;
        this.telefono = telefono;
    }

    public Cliente(String nombre, String email, String telefono, String direccion) {

        this.direccion = direccion;
        this.email = email;
        this.nombre = nombre;
        this.telefono = telefono;
    }

    public Cliente() {

    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Cliente cliente)) return false;
        return getId() == cliente.getId() && Objects.equals(getNombre(), cliente.getNombre()) && Objects.equals(getEmail(), cliente.getEmail()) && Objects.equals(getTelefono(), cliente.getTelefono()) && Objects.equals(getDireccion(), cliente.getDireccion());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getNombre(), getEmail(), getTelefono(), getDireccion());
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "id='" + id + '\'' +
                ", nombre=" + nombre +
                ", email='" + email + '\'' +
                ", telefono='" + telefono + '\'' +
                ", direccion='" + direccion + '\'' +
                '}';
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
}
