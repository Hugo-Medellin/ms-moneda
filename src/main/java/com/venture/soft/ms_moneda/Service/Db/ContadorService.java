package com.venture.soft.ms_moneda.Service.Db;

import org.springframework.stereotype.Service;

import com.venture.soft.ms_moneda.Entity.Contador;
import com.venture.soft.ms_moneda.Repository.ContadorRepository;
import com.venture.soft.ms_moneda.Service.IContadorService;

import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
@Transactional
public class ContadorService implements IContadorService {

	private final ContadorRepository contadorRepo;

	@PostConstruct
	public void initContador() {
		if(!contadorRepo.existsById(1)) {
			save(1);
		}
	}

	@Override
	public void save(Integer contadorNumCia) {
		contadorRepo.save(new Contador(1, contadorNumCia));
	}

	@Override
	public Integer ultimoNumCia() {
		return contadorRepo.findById(1).get().getContadorNumCia();
	}
}