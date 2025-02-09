package org.example.Interfaces;

import org.example.Entities.Venta;

import java.util.ArrayList;

public interface VentaDAO {
    ArrayList<Venta> getAllVentas();
    void saveVenta(Venta v);
}
