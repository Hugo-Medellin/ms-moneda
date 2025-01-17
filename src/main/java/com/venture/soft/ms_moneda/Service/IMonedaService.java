package com.venture.soft.ms_moneda.Service;

import java.util.List;

import com.venture.soft.ms_moneda.Dto.DtoResponse;
import com.venture.soft.ms_moneda.Dto.Request.MonedaSaveRequest;
import com.venture.soft.ms_moneda.Dto.Request.MonedaSearchRequest;
import com.venture.soft.ms_moneda.Dto.Request.MonedaUpdateRequest;
import com.venture.soft.ms_moneda.Dto.Request.PaginacionRequest;
import com.venture.soft.ms_moneda.Dto.Response.MonedaResponse;

public interface IMonedaService {

	void saveMoneda(MonedaSaveRequest monedaRequest);


	MonedaResponse findById_NumCiaResponse(Integer numCia);
	MonedaResponse findById_ClaveMonedaResponse(String claveMoneda);
	MonedaResponse findById_NumCiaAndId_ClaveMonedaResponse(Integer numCia, String claveMoneda);
	DtoResponse<List<MonedaResponse>> findAllMonedasByDto(MonedaSearchRequest monedaSearchRequest, PaginacionRequest paginacionRequest);


	String updateById_NumCia(Integer numCia, MonedaUpdateRequest monedaUpdateRequest);
	void updateById_ClaveMoneda(String claveMoneda, MonedaUpdateRequest monedaUpdateRequest );
	String updateById_NumCiaAndId_ClaveMoneda(Integer numCia, String claveMoneda, MonedaUpdateRequest monedaUpdateRequest );


	String deleteById_NumCia(Integer numCia);
	void deleteById_ClaveMoneda(String claveMoneda);
	String deleteById_NumCiaAndId_ClaveMoneda(Integer numCia, String claveMoneda);
}
