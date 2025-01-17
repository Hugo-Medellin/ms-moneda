package com.venture.soft.ms_moneda.Dto.Request;

import lombok.Data;

@Data
public class MonedaUpdateRequest {
	private String descripcion;
	private String simbolo;
	private String abreviacion;
	private String monedaCorriente;
	private String status;
}