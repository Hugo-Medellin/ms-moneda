package com.venture.soft.ms_moneda.Repository;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.venture.soft.ms_moneda.Entity.HU_CAT_MONEDA;
import com.venture.soft.ms_moneda.Entity.IdsMoneda;

@Repository
public interface MonedaRepository extends JpaRepository<HU_CAT_MONEDA, IdsMoneda> {

	Optional<HU_CAT_MONEDA> findById_NumCia(Integer numCia);
	Optional<HU_CAT_MONEDA> findById_ClaveMoneda(String claveMoneda);

	Optional<HU_CAT_MONEDA> findById_NumCiaAndId_ClaveMoneda(Integer numCia, String claveMoneda);

	@Query("SELECT m FROM HU_CAT_MONEDA m WHERE "
			+ "(:numCia IS NULL OR m.id.numCia = :numCia) AND "
			+ "(:claveMoneda IS NULL OR m.id.claveMoneda = :claveMoneda) AND "
			+ "(:descripcion IS NULL OR m.descripcion LIKE %:descripcion%) AND "
			+ "(:simbolo IS NULL OR m.simbolo = :simbolo) AND "
			+ "(:abreviacion IS NULL OR m.abreviacion = :abreviacion) AND "
			+ "(:monedaCorriente IS NULL OR m.monedaCorriente = :monedaCorriente) AND "
			+ "(:status IS NULL OR m.status = :status) ")
	Page<HU_CAT_MONEDA> findAllMonedasByDto(
			@Param("numCia") Integer numCia,
			@Param("claveMoneda") String claveMoneda,
			@Param("descripcion") String descripcion,
			@Param("simbolo") String simbolo,
			@Param("abreviacion") String abreviacion,
			@Param("monedaCorriente") String monedaCorriente,
			@Param("status") String status,
			Pageable pageable);
}