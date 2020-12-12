package com.cenfotec.examen3.GRAPHQL.mutation;


import com.cenfotec.examen3.GRAPHQL.services.ClienteService;
import com.cenfotec.examen3.RESTFUL.domain.Cliente;
import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ClienteMutation implements GraphQLMutationResolver {

    @Autowired
    private ClienteService service;

    public Cliente crearCliente(int id, String nombre, String apellido1, String apellido2, String direccionVivienda, String direccionCobro,
                                  String numeroTarjeta, String vencimiento){
        return this.service.createCliente(id,nombre, apellido1, apellido2, direccionVivienda, direccionCobro, numeroTarjeta, vencimiento);
    }

    public Cliente modificarCliente(int id, String nombre, String apellido1,String apellido2,String direccionVivienda, String direccionCobro,
                                String numeroTarjeta, String vencimiento){
        return this.service.updateCliente(id,nombre, apellido1, apellido2, direccionVivienda, direccionCobro, numeroTarjeta, vencimiento);
    }

    public Boolean borrarCliente(int id){
        return this.service.deleteCliente(id);
    }


}
