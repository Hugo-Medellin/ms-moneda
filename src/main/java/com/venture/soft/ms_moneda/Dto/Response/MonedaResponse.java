package com.venture.soft.ms_moneda.Dto.Response;

import lombok.Data;

@Data
public class MonedaResponse {
	private Integer numCia;
	private String claveMoneda;
	private String descripcion;
	private String simbolo;
	private String abreviacion;
	private String monedaCorriente;
	private String status;
}