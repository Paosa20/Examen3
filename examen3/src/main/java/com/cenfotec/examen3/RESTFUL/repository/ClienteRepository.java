package com.cenfotec.examen3.RESTFUL.repository;

import com.cenfotec.examen3.RESTFUL.domain.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
}
