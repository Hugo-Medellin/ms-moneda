package com.venture.soft.ms_moneda.Dto.Request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MonedaSearchRequest {
	private Integer numCia;
	private String claveMoneda;
	private String descripcion;
	private String simbolo;
	private String abreviacion;
	private String monedaCorriente;
	private String status;
}
