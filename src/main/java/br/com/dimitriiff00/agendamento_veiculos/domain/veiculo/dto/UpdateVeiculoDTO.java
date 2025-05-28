package br.com.dimitriiff00.agendamento_veiculos.domain.veiculo.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record UpdateVeiculoDTO(
	    @NotNull Long id,
	    @NotBlank String veiculo,
	    @NotBlank String modelo,
	    @NotBlank @Size(max = 7) String placa,
	    @Min(1886) @Max(2025) int ano
	) {}