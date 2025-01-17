package com.venture.soft.ms_moneda.Utils;

import org.mapstruct.Mapper;
import org.springframework.data.domain.Page;

import com.venture.soft.ms_moneda.Dto.DtoPaginacion;
import com.venture.soft.ms_moneda.Entity.HU_CAT_MONEDA;

@Mapper(componentModel = "spring")
public interface PageMapper {

	DtoPaginacion toDtoPaginacion(Page<HU_CAT_MONEDA> dto);
}