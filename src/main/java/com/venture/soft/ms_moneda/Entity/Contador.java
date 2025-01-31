package com.venture.soft.ms_moneda.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "contador")
public class Contador {
	@Id
	private Integer id;
	private Integer contadorNumCia;
}