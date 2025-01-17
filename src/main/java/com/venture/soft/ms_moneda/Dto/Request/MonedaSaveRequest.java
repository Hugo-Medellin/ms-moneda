package com.venture.soft.ms_moneda.Dto.Request;

import lombok.Data;

@Data
public class MonedaSaveRequest {
	private String claveMoneda;
	private String descripcion;
	private String simbolo;
	private String abreviacion;
	private String monedaCorriente;
	private String status;
}