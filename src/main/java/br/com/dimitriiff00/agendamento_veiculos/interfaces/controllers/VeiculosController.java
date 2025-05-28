package br.com.dimitriiff00.agendamento_veiculos.interfaces.controllers;

import java.util.List;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.dimitriiff00.agendamento_veiculos.domain.veiculo.Veiculo;
import br.com.dimitriiff00.agendamento_veiculos.domain.veiculo.dto.CreateVeiculoDTO;
import br.com.dimitriiff00.agendamento_veiculos.domain.veiculo.dto.UpdateVeiculoDTO;
import br.com.dimitriiff00.agendamento_veiculos.services.VeiculoService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/veiculos")
@CrossOrigin("http://localhost:3000")

public class VeiculosController {
	
	private final VeiculoService service;

    public VeiculosController(VeiculoService service) {
        this.service = service;
    }

    
	@GetMapping
	public ResponseEntity<List<Veiculo>> listVeiculo() {
		return ResponseEntity.ok(service.findAll());
	}

	@PostMapping
	public ResponseEntity<Veiculo> registerVeiculo(@RequestBody @Valid CreateVeiculoDTO data) {
        return ResponseEntity.ok(service.register(data));
	}

	@PutMapping("/{id}")
	public ResponseEntity<Veiculo> updateVeiculo(@PathVariable Long id, @RequestBody @Valid UpdateVeiculoDTO data) {
	    return ResponseEntity.ok(service.update(id, data));
	}


	
	@DeleteMapping("/{id}")
    public ResponseEntity<String> deleteVeiculo(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.ok("Veículo deletado com sucesso");

    }
}
