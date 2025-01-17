package com.venture.soft.ms_moneda.Entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Embeddable
public class IdsMoneda implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "NUM_CIA", length = 4, nullable = false)
	private Integer numCia;

	@Column(name = "CLAVE_MONEDA", length = 3, nullable = false, unique = true)
	private String claveMoneda;
}