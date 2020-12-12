package com.cenfotec.examen3.GRAPHQL.services;


import com.cenfotec.examen3.GRAPHQL.repositories.ClienteRepositoryQL;

import com.cenfotec.examen3.RESTFUL.domain.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {


    @Autowired
    private ClienteRepositoryQL repository;

    public List<Cliente> listaClientes(){
        return this.repository.findAll();
    }

    public Cliente createCliente (int id,String nombre,String apellido1, String apellido2, String direccionVivienda, String direccionCobro, String numeroTarjeta,
                                  String vencimiento) {
        Cliente cliente = new Cliente();
        cliente.setId(id);
        cliente.setNombre(nombre);
        cliente.setApellido1(apellido1);
        cliente.setApellido2(apellido2);
        cliente.setDireccionVivienda(direccionVivienda);
        cliente.setDireccionCobro(direccionCobro);
        cliente.setNumeroTarjeta(numeroTarjeta);
        cliente.setVencimiento(vencimiento);
        return this.repository.save(cliente);
    }

    public Optional<Cliente> getClienteById(int id){
        return this.repository.findById(id);
    }

    public Cliente updateCliente(int id,String nombre,String apellido1, String apellido2, String direccionVivienda, String direccionCobro, String numeroTarjeta,
                                 String vencimiento) {
        Cliente cliente =this.repository.findById(id).get();

        cliente.setNombre(nombre);
        cliente.setApellido1(apellido1);
        cliente.setApellido2(apellido2);
        cliente.setDireccionVivienda(direccionVivienda);
        cliente.setDireccionCobro(direccionCobro);
        cliente.setNumeroTarjeta(numeroTarjeta);
        cliente.setVencimiento(vencimiento);
        return this.repository.save(cliente);
    }

    public boolean deleteCliente(int id) {
        Cliente cliente =this.repository.findById(id).get();
        this.repository.delete(cliente);
        return true;
    }
}
