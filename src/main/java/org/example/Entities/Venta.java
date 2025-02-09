package org.example.Entities;

import jakarta.persistence.*;
import org.hibernate.annotations.ColumnDefault;

import java.util.Date;
import java.util.Objects;

@Entity()
@Table(name = "ventas")
public class Venta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false)
    private Date fecha;
    @Column(length = 3)
    private float total;

    public Venta(int id, float total) {
        this.id = id;
        this.fecha = new java.sql.Date(System.currentTimeMillis());
        this.total = total;
    }

    public Venta(float total) {
        this.fecha = new java.sql.Date(System.currentTimeMillis());
        this.total = total;
    }

    public Venta(int id, Date fecha, float total) {
        this.id = id;
        this.fecha = fecha;
        this.total = total;
    }

    public Venta() {

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Venta venta)) return false;
        return getId() == venta.getId() && Float.compare(getTotal(), venta.getTotal()) == 0 && Objects.equals(getFecha(), venta.getFecha());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getFecha(), getTotal());
    }

    @Override
    public String toString() {
        return "Venta{" +
                "fecha=" + fecha +
                ", id=" + id +
                ", total=" + total +
                '}';
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }
}
