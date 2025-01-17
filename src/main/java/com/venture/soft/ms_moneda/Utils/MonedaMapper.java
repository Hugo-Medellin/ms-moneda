package com.venture.soft.ms_moneda.Utils;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import com.venture.soft.ms_moneda.Dto.Request.MonedaSaveRequest;
import com.venture.soft.ms_moneda.Dto.Request.MonedaUpdateRequest;
import com.venture.soft.ms_moneda.Dto.Response.MonedaResponse;
import com.venture.soft.ms_moneda.Entity.HU_CAT_MONEDA;

@Mapper(componentModel = "spring")
public interface MonedaMapper {

	@Mapping(source = "claveMoneda", target = "id.claveMoneda")
	HU_CAT_MONEDA toHuCatMoneda(MonedaSaveRequest dto);

	@Mapping(source = "id.claveMoneda", target = "claveMoneda")
	MonedaSaveRequest toMonedaRequest(HU_CAT_MONEDA entity);


	@Mapping(source = "id.claveMoneda", target = "claveMoneda")
	@Mapping(source = "id.numCia", target = "numCia")
	MonedaResponse toMonedaResponse(HU_CAT_MONEDA entity);


	@Mapping(target = "id", ignore = true)
	void updateMonedaFromDto(MonedaUpdateRequest dto, @MappingTarget HU_CAT_MONEDA entity);

	List<MonedaResponse> toMonedasResponse(List<HU_CAT_MONEDA> entitys);
}