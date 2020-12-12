package com.cenfotec.examen3.GRAPHQL.repositories;


import com.cenfotec.examen3.RESTFUL.domain.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepositoryQL extends JpaRepository<Cliente, Integer> {

   /* public Cliente getClienteId(int id);*/
}
