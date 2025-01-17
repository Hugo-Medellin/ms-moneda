package com.venture.soft.ms_moneda.Dto;

import java.time.ZonedDateTime;
import java.util.Collections;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DtoResponse<T> {
	private Integer codigo_estatus = 0;
	private List<String> mensajes;
	private List<String> errores;
	private ZonedDateTime fecha_peticion = ZonedDateTime.now();
	private T contenido;
	private DtoPaginacion paginacion;

	public DtoResponse(List<String> mensajes) {
		this.mensajes = mensajes;
	}

	public DtoResponse(String mensaje) {
		this.mensajes = Collections.singletonList(mensaje);
	}

	public DtoResponse(Integer codigo_estatus, List<String> errores) {
		this.codigo_estatus = codigo_estatus;
		this.errores = errores;
	}

	public DtoResponse(Integer codigo_estatus, String error) {
		this.codigo_estatus = codigo_estatus;
		this.errores = Collections.singletonList(error);
	}

	public DtoResponse(T contenido) {
		this.contenido = contenido;
	}

	public DtoResponse(T contenido, DtoPaginacion paginacion) {
		this.contenido = contenido;
		this.paginacion = paginacion;
	}
}
