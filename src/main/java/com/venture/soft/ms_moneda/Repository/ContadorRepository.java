package com.venture.soft.ms_moneda.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.venture.soft.ms_moneda.Entity.Contador;

@Repository
public interface ContadorRepository extends JpaRepository<Contador, Integer> {

}
