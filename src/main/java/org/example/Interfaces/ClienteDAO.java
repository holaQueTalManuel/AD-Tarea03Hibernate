package org.example.Interfaces;

import org.example.Entities.Cliente;
import org.example.dto.ClienteDTO;

import java.util.List;

public interface ClienteDAO {
    List<ClienteDTO> getAllClientes();
    void saveCliente(Cliente c);
    void deleteCliente(int id);
}
