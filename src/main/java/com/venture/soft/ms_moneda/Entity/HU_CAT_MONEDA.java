package com.venture.soft.ms_moneda.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "HU_CAT_MONEDA")
public class HU_CAT_MONEDA {

	@EmbeddedId
	private IdsMoneda id;

	@Column(name = "DESCRIPCION", length = 30)
	private String descripcion;

	@Column(name = "SIMBOLO", length = 5)
	private String simbolo;

	@Column(name = "ABREVIACION", length = 5)
	private String abreviacion;

	@Column(name = "MONEDA_CORRIENTE", length = 1)
	private String monedaCorriente;

	@Column(name = "STATUS", length = 1)
	private String status;
}