package com.cenfotec.examen3.RESTFUL.controller;


import com.cenfotec.examen3.RESTFUL.domain.Cliente;
import com.cenfotec.examen3.RESTFUL.domain.Orden;
import com.cenfotec.examen3.RESTFUL.repository.ClienteRepository;
import com.cenfotec.examen3.RESTFUL.repository.OrdenRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping({"/clientes"})
public class ClienteController {


    private ClienteRepository repository;

    private OrdenRepository ordenRepository;

    public ClienteController(ClienteRepository repository,OrdenRepository ordenRepository) {
        this.repository = repository;
        this.ordenRepository = ordenRepository;
    }

    @GetMapping
    public List findAll(){return repository.findAll();}

    @PostMapping
    public Cliente create(@RequestBody Cliente cliente){return repository.save(cliente); }

    @PutMapping
    public ResponseEntity<Cliente> update(@PathVariable("id") long id, @RequestBody Cliente cliente){
        return repository.findById(id).map(record -> {record.setNombre(cliente.getNombre());
            record.setApellido1(cliente.getApellido1());
            record.setApellido2(cliente.getApellido2());
            record.setDireccionVivienda(cliente.getDireccionVivienda());
            record.setDireccionCobro(cliente.getDireccionCobro());
            record.setNumeroTarjeta(cliente.getNumeroTarjeta());
            record.setVencimiento(cliente.getVencimiento());
            Cliente updated = repository.save(record);
            return ResponseEntity.ok().body(updated);
        }).orElse(ResponseEntity.notFound().build());
    }

    @GetMapping(path ={"/{id}"})
    public ResponseEntity<Cliente> findById(@PathVariable long id){
        return repository.findById(id).map(record ->ResponseEntity.ok().body(record)).orElse(ResponseEntity.notFound().build());
    }

    @GetMapping(path="/dato_cliente")
    public List<Cliente>  findByParametro(@RequestParam String dato) {
        List<Cliente> clientes = repository.findAll();
        List<Cliente> listaDatos = new ArrayList<>();
        for(Cliente cliente: clientes) {
            if(cliente.getApellido1().contains(dato) || cliente.getApellido2().contains(dato) || cliente.getDireccionCobro().contains(dato)) {
                listaDatos.add(cliente);
            }
        }
        return listaDatos;
    }

    @DeleteMapping(path ={"/{id}"})
    public ResponseEntity<?> delete(@PathVariable("id") long id) {

        List<Orden> listaOrden = this.ordenRepository.findAll();

        for (Orden dato: listaOrden){
            if (dato.getIdCliente()==id){
                return ResponseEntity.notFound().build(); //no se puede eliminar
            }
        }

            return repository.findById(id).map(record -> {
            repository.deleteById(id);
            return ResponseEntity.ok().build();
        }).orElse(ResponseEntity.notFound().build());
    }
}
