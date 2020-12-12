package com.cenfotec.examen3.RESTFUL.repository;


import com.cenfotec.examen3.RESTFUL.domain.Orden;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrdenRepository extends JpaRepository<Orden, Long> {
}
