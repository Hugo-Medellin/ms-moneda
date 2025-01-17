package com.venture.soft.ms_moneda.Service.Db;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.venture.soft.ms_moneda.Dto.DtoPaginacion;
import com.venture.soft.ms_moneda.Dto.DtoResponse;
import com.venture.soft.ms_moneda.Dto.Request.MonedaSaveRequest;
import com.venture.soft.ms_moneda.Dto.Request.MonedaSearchRequest;
import com.venture.soft.ms_moneda.Dto.Request.MonedaUpdateRequest;
import com.venture.soft.ms_moneda.Dto.Request.PaginacionRequest;
import com.venture.soft.ms_moneda.Dto.Response.MonedaResponse;
import com.venture.soft.ms_moneda.Entity.HU_CAT_MONEDA;
import com.venture.soft.ms_moneda.Repository.MonedaRepository;
import com.venture.soft.ms_moneda.Service.IContadorService;
import com.venture.soft.ms_moneda.Service.IMonedaService;
import com.venture.soft.ms_moneda.Utils.MonedaMapper;
import com.venture.soft.ms_moneda.Utils.PageMapper;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;

@Service
@Transactional
@AllArgsConstructor
public class MonedaService implements IMonedaService {

	private final MonedaRepository monedaRepo;
	private final MonedaMapper monedaMapper;
	private final PageMapper pageMapper;

	private final IContadorService contadorServ;

	private void save(HU_CAT_MONEDA entity) {
		entity.getId().setClaveMoneda(entity.getId().getClaveMoneda().toUpperCase());
		monedaRepo.save(entity);
	}

	private HU_CAT_MONEDA findById_NumCia(Integer numCia) {
		return monedaRepo.findById_NumCia(numCia).orElseThrow( () -> {
			throw new EntityNotFoundException("No se encontró el registro con ID: " + numCia);
		});
	}

	private HU_CAT_MONEDA findById_ClaveMoneda(String claveMoneda) {
		return monedaRepo.findById_ClaveMoneda(claveMoneda.toUpperCase()).orElseThrow( () -> {
			throw new EntityNotFoundException("No se encontró el registro con CLAVE: " + claveMoneda.toUpperCase());
		});
	}

	private HU_CAT_MONEDA findById_NumCiaAndId_ClaveMoneda(Integer numCia, String claveMoneda) {
		return monedaRepo.findById_NumCiaAndId_ClaveMoneda(numCia, claveMoneda.toUpperCase()).orElseThrow( () -> {
			throw new EntityNotFoundException(String.format("No se encontró el registro con ID: %d y CLAVE: %s", numCia, claveMoneda.toUpperCase()));
		});
	}


	//CREATE
	@Override
	public void saveMoneda(MonedaSaveRequest monedaRequest) {
		Integer ultimoNumCia = contadorServ.ultimoNumCia();

		if(ultimoNumCia > 9999) {
			// AGREGAR EXCEPCION
		}

		HU_CAT_MONEDA moneda = monedaMapper.toHuCatMoneda(monedaRequest);
		moneda.getId().setNumCia(ultimoNumCia);
		save(moneda);
		contadorServ.save(ultimoNumCia + 1);
	}


	//READ
	@Override
	public MonedaResponse findById_NumCiaResponse(Integer numCia) {
		return monedaMapper.toMonedaResponse(findById_NumCia(numCia));
	}

	@Override
	public MonedaResponse findById_ClaveMonedaResponse(String claveMoneda) {
		return monedaMapper.toMonedaResponse(findById_ClaveMoneda(claveMoneda));
	}

	@Override
	public MonedaResponse findById_NumCiaAndId_ClaveMonedaResponse(Integer numCia, String claveMoneda) {
		return monedaMapper.toMonedaResponse(findById_NumCiaAndId_ClaveMoneda(numCia, claveMoneda));
	}

	@Override
	public DtoResponse<List<MonedaResponse>> findAllMonedasByDto(MonedaSearchRequest monedaSearchRequest, PaginacionRequest paginacionRequest) {
		Pageable pageable = PageRequest.of(paginacionRequest.getPage(), paginacionRequest.getSize(), paginacionRequest.getSort());

		Page<HU_CAT_MONEDA> pageMoneda = monedaRepo.findAllMonedasByDto(monedaSearchRequest.getNumCia(), monedaSearchRequest.getClaveMoneda(),
				monedaSearchRequest.getDescripcion(), monedaSearchRequest.getSimbolo(), monedaSearchRequest.getAbreviacion(),
				monedaSearchRequest.getMonedaCorriente(), monedaSearchRequest.getStatus(), pageable);

		DtoPaginacion paginacion = pageMapper.toDtoPaginacion(pageMoneda);
		return new DtoResponse<List<MonedaResponse>>(monedaMapper.toMonedasResponse(pageMoneda.getContent()), paginacion);
	}


	//UPDATE
	@Override
	public String updateById_NumCia(Integer numCia, MonedaUpdateRequest monedaUpdateRequest) {
		HU_CAT_MONEDA monedaDb = findById_NumCia(numCia);
		monedaMapper.updateMonedaFromDto(monedaUpdateRequest, monedaDb);
		save(monedaDb);
		return "El registro se a guardado con exitó";
	}

	@Override
	public void updateById_ClaveMoneda(String claveMoneda, MonedaUpdateRequest monedaUpdateRequest) {
		HU_CAT_MONEDA monedaDb = findById_ClaveMoneda(claveMoneda);
		monedaMapper.updateMonedaFromDto(monedaUpdateRequest, monedaDb);
		save(monedaDb);
	}

	@Override
	public String updateById_NumCiaAndId_ClaveMoneda(Integer numCia, String claveMoneda, MonedaUpdateRequest monedaUpdateRequest) {
		HU_CAT_MONEDA monedaDb = findById_NumCiaAndId_ClaveMoneda(numCia, claveMoneda);
		monedaMapper.updateMonedaFromDto(monedaUpdateRequest, monedaDb);
		save(monedaDb);
		return "Se actualizó correctamente el registro.";
	}


	//DELETE
	@Override
	public String deleteById_NumCia(Integer numCia) {
		monedaRepo.delete(findById_NumCia(numCia));
		return "El registro se a eliminado con éxito.";
	}

	@Override
	public void deleteById_ClaveMoneda(String claveMoneda) {
		monedaRepo.delete(findById_ClaveMoneda(claveMoneda));
	}

	@Override
	public String deleteById_NumCiaAndId_ClaveMoneda(Integer numCia, String claveMoneda) {
		monedaRepo.delete(findById_NumCiaAndId_ClaveMoneda(numCia, claveMoneda));
		return "Se eliminó correctamente el registro.";
	}
}