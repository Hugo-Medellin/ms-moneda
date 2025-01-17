package com.venture.soft.ms_moneda.Dto.Request;

import org.springframework.data.domain.Sort;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaginacionRequest {
	private int page = 0;
	private int size = 10;
	private String sort = "id.numCia,asc";

	public Sort getSort() {
		String[] sortParams = sort.split(",");
		return Sort.by(Sort.Direction.fromString(sortParams[1]), sortParams[0]);
	}
}