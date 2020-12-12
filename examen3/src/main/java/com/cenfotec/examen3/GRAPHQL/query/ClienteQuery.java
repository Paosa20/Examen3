package com.cenfotec.examen3.GRAPHQL.query;




import com.cenfotec.examen3.GRAPHQL.services.ClienteService;
import com.cenfotec.examen3.RESTFUL.domain.Cliente;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class ClienteQuery implements GraphQLQueryResolver {

    @Autowired
    private ClienteService service;


    public List<Cliente> getClientes(int count){return this.service.listaClientes(); }
    public Optional<Cliente> getCliente(int id){return this.service.getClienteById(id); }
    /*public boolean borrarCliente(int id){return this.service.deleteCliente(id);}
    public Cliente crearCliente(String nombre, String apellido1,String apellido2,
                                String direccionVivienda, String direccionCobro, String numeroTarjeta, String vencimiento){
        return this.service.createCliente(nombre, apellido1, apellido2, direccionVivienda, direccionCobro, numeroTarjeta, vencimiento); }

    public Cliente modificarCliente(String nombre, String apellido1,String apellido2,
                                String direccionVivienda, String direccionCobro, String numeroTarjeta, String vencimiento){
        return this.service.createCliente(nombre, apellido1, apellido2, direccionVivienda, direccionCobro, numeroTarjeta, vencimiento); }*/
}
