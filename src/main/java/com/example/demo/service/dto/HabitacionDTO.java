package com.example.demo.service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HabitacionDTO {
	private Long numero;
	private Long planta;
	private String hotel;
	private Long capacidad;
	private String tipo;
	private Boolean estado;
}
