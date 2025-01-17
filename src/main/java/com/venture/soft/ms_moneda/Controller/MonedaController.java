package com.venture.soft.ms_moneda.Controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.venture.soft.ms_moneda.Dto.DtoResponse;
import com.venture.soft.ms_moneda.Dto.Request.MonedaSaveRequest;
import com.venture.soft.ms_moneda.Dto.Request.MonedaSearchRequest;
import com.venture.soft.ms_moneda.Dto.Request.MonedaUpdateRequest;
import com.venture.soft.ms_moneda.Dto.Request.PaginacionRequest;
import com.venture.soft.ms_moneda.Dto.Response.MonedaResponse;
import com.venture.soft.ms_moneda.Service.IMonedaService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/moneda")
@CrossOrigin(origins = "http://localhost:4200")
@AllArgsConstructor
public class MonedaController {

	private final IMonedaService monedaServ;

	// CREATE
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public void save(@RequestBody MonedaSaveRequest monedaRequest) {
		 monedaServ.saveMoneda(monedaRequest);
	}


	// READ
	@GetMapping("/num-cia/{numCia}")
	@ResponseStatus(code = HttpStatus.OK)
	public MonedaResponse findByIdNumCia(@PathVariable(required = true) Integer numCia) {
		return monedaServ.findById_NumCiaResponse(numCia);
	}

	@GetMapping("/clave-moneda/{claveMoneda}")
	@ResponseStatus(code = HttpStatus.OK)
	public MonedaResponse findById_ClaveMoneda(@PathVariable(required = true) String claveMoneda) {
		return monedaServ.findById_ClaveMonedaResponse(claveMoneda);
	}

	@GetMapping("/num-cia/{numCia}/clave-moneda/{claveMoneda}")
	@ResponseStatus(code = HttpStatus.OK)
	public DtoResponse<MonedaResponse> findById_NumCiaAndId_ClaveMonedaResponse(@PathVariable(required = true) Integer numCia, @PathVariable(required = true) String claveMoneda) {
		return new DtoResponse<MonedaResponse>(monedaServ.findById_NumCiaAndId_ClaveMonedaResponse(numCia, claveMoneda));
	}

	@GetMapping
	public DtoResponse<List<MonedaResponse>> findAllMonedasByDto(@ModelAttribute MonedaSearchRequest monedaSearchRequest, @ModelAttribute PaginacionRequest paginacionRequest) {
		return monedaServ.findAllMonedasByDto(monedaSearchRequest, paginacionRequest);
	}


	//UPDATE
	@PutMapping("/num-cia/{numCia}")
	@ResponseStatus(code = HttpStatus.OK)
	public DtoResponse<String> updateById_NumCiaAndId_ClaveMoneda(@PathVariable(required = true) Integer numCia, @RequestBody MonedaUpdateRequest monedaUpdate) {
		return new DtoResponse<>(monedaServ.updateById_NumCia(numCia, monedaUpdate));
	}

	@PutMapping("/clave-moneda/{claveMoneda}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void updateById_ClaveMoneda(@PathVariable(required = true) String claveMoneda, @RequestBody MonedaUpdateRequest monedaUpdate) {
		monedaServ.updateById_ClaveMoneda(claveMoneda, monedaUpdate);
	}

	@PutMapping("/num-cia/{numCia}/clave-moneda/{claveMoneda}")
	@ResponseStatus(code = HttpStatus.OK)
	public DtoResponse<String> updateById_NumCiaAndId_ClaveMoneda(@PathVariable(required = true) Integer numCia, @PathVariable(required = true) String claveMoneda, @RequestBody MonedaUpdateRequest monedaUpdate) {
		return new DtoResponse<>(monedaServ.updateById_NumCiaAndId_ClaveMoneda(numCia, claveMoneda, monedaUpdate));
	}


	//DELETE
	@DeleteMapping("/num-cia/{numCia}")
	@ResponseStatus(code = HttpStatus.OK)
	public DtoResponse<String> deleteById_NumCia(@PathVariable(required = true) Integer numCia) {
		return new DtoResponse<>(monedaServ.deleteById_NumCia(numCia));
	}

	@DeleteMapping("/clave-moneda/{claveMoneda}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void deleteById_ClaveMoneda(@PathVariable(required = true) String claveMoneda) {
		monedaServ.deleteById_ClaveMoneda(claveMoneda);
	}

	@DeleteMapping("/num-cia/{numCia}/clave-moneda/{claveMoneda}")
	@ResponseStatus(code = HttpStatus.OK)
	public DtoResponse<String> deleteById_NumCiaAndId_ClaveMoneda(@PathVariable(required = true) Integer numCia, @PathVariable(required = true) String claveMoneda) {
		return new DtoResponse<>(monedaServ.deleteById_NumCiaAndId_ClaveMoneda(numCia, claveMoneda));
	}
}