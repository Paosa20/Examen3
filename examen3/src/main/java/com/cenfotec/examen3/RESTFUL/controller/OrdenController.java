package com.cenfotec.examen3.RESTFUL.controller;

import com.cenfotec.examen3.RESTFUL.domain.Orden;
import com.cenfotec.examen3.RESTFUL.repository.OrdenRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping({"/ordenes"})
public class OrdenController {

    private OrdenRepository repository;

    public OrdenController(OrdenRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List findAll(){return this.repository.findAll(); }

    @PostMapping
    public Orden create(@RequestBody Orden orden){return this.repository.save(orden); }

    @GetMapping(path = { "/tipo" })
    public List<Orden> findByTipo(@RequestParam String tipo) {
        List<Orden> listOrdenes = this.repository.findAll();
        List<Orden>ordenesTipo = new ArrayList<>();
        for(Orden o: listOrdenes) {
            if(o.getTipo().equals(tipo)) {
                ordenesTipo.add(o);
            }
        }
        return ordenesTipo;
    }

    @PutMapping(value = "/cantidadItem")
    public ResponseEntity<Orden> updateCantidad(@RequestParam("id") long id, @RequestBody Orden orden) {
        return repository.findById(id).map(record -> {

            record.setCantidad(orden.getCantidad());

            Orden nuevo = repository.save(record);
            return ResponseEntity.ok().body(nuevo);
        }).orElse(ResponseEntity.notFound().build());
    }

    @PutMapping(value = "/tipoItem/")
    public ResponseEntity<Orden> updateTipo(@RequestParam("id") long id, @RequestBody Orden orden) {
        return repository.findById(id).map(record -> {

            record.setTipo(orden.getTipo());

            Orden nuevo = repository.save(record);
            return ResponseEntity.ok().body(nuevo);
        }).orElse(ResponseEntity.notFound().build());
    }
}
