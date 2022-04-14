package com.example.demo.service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReservasDTO {
	private Long id;
	private String nif;
	private String hotel;
	private String destino;
	private Long huespedes;
	private Long habitaciones;
	private LocalDate fechaEntrada;
	private LocalDate fechaSalida;
}
