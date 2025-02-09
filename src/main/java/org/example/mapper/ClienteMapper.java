package org.example.mapper;

import org.example.Entities.Cliente;
import org.example.dto.ClienteDTO;

public class ClienteMapper {
    public static ClienteDTO toDTO(Cliente cliente) {
        return new ClienteDTO(
                cliente.getId(),
                cliente.getNombre(),
                cliente.getEmail(),
                cliente.getTelefono(),
                cliente.getDireccion()
        );
    }

    public static Cliente toEntity(ClienteDTO dto) {
        return new Cliente(
                dto.getId(),
                dto.getNombre(),
                dto.getEmail(),
                dto.getTelefono(),
                dto.getDireccion()
        );
    }
}
