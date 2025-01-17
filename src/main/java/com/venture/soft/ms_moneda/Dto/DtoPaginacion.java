package com.venture.soft.ms_moneda.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DtoPaginacion {
	private boolean last;
	private Long totalElements;
	private int totalPages;
	private int size;
	private int number;
	private boolean first;
	private int numberOfElements;
	private boolean empty;
}