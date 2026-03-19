package com.paqueteria.servicio;

import com.paqueteria.modelo.Cliente;
import com.paqueteria.repositorio.ClienteRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    private final ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    // Métodos JPA
    public List<Cliente> obtenerTodosLosClientes() { return this.clienteRepository.findAll(); }

    public Optional<Cliente> buscarPorId(Long id) { return this.clienteRepository.findById(id); }

    // Métodos CrUD - Transactional Jakarta
    @Transactional
    public Cliente crearCliente(Cliente cliente) { return this.clienteRepository.save(cliente); }

    @Transactional
    public Cliente actualizarCliente(Cliente cliente) { return this.clienteRepository.save(cliente); }

    @Transactional
    public Cliente actualizarCliente(Long id, Cliente datosNuevos) {
        Cliente existente = clienteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException(
                        "Cliente no encontrado con id: " + id));

        existente.setNombre(datosNuevos.getNombre());
        existente.setApellidos(datosNuevos.getApellidos());
        existente.setDni(datosNuevos.getDni());
        existente.setDireccion(datosNuevos.getDireccion());
        existente.setTelefono(datosNuevos.getTelefono());
        existente.setEmail(datosNuevos.getEmail());
        existente.setCiudad(datosNuevos.getCiudad());

        return clienteRepository.save(existente);
    }

    @Transactional
    public void eliminarCliente(Long id) { this.clienteRepository.deleteById(id); }

    // Métodos de interfaz
    public List<Cliente> buscarPorDni(String dni) { return this.clienteRepository.findByDni(dni); }
    public List<Cliente> buscarPorEmail(String email) { return this.clienteRepository.findByEmail(email); }
    public List<Cliente> buscarPorNombre(String nombre) { return this.clienteRepository.findByNombreContainingIgnoreCase(nombre); }
}
