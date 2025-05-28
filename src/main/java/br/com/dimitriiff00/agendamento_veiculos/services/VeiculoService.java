package br.com.dimitriiff00.agendamento_veiculos.services;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.dimitriiff00.agendamento_veiculos.domain.veiculo.Veiculo;
import br.com.dimitriiff00.agendamento_veiculos.domain.veiculo.VeiculoRepository;
import br.com.dimitriiff00.agendamento_veiculos.domain.veiculo.dto.CreateVeiculoDTO;
import br.com.dimitriiff00.agendamento_veiculos.domain.veiculo.dto.UpdateVeiculoDTO;
import jakarta.persistence.EntityNotFoundException;

@Service
public class VeiculoService {

	private final VeiculoRepository repository;

	public VeiculoService(VeiculoRepository repository) {
		this.repository = repository;
	}

	public Veiculo register(CreateVeiculoDTO dto) {
		Veiculo newVeiculo = Veiculo.fromCreateDTO(dto);
		return repository.save(newVeiculo);

	}

	public List<Veiculo> findAll() {
		return repository.findAll();
	}

	public Veiculo update(Long id, UpdateVeiculoDTO dto) {
		Veiculo veiculo = repository.findById(id).orElseThrow(() -> new RuntimeException("Veículo não encontrado"));

		veiculo.setVeiculo(dto.veiculo());
		veiculo.setModelo(dto.modelo());
		veiculo.setPlaca(dto.placa());
		veiculo.setAno(dto.ano());

		return repository.save(veiculo);
	}

	public Veiculo findById(Long id) {
		return repository.findById(id).orElseThrow(() -> new RuntimeException("Veículo não encontrado"));
	}

	public void delete(Long id) {
		if (!repository.existsById(id)) {
			throw new EntityNotFoundException("Veículo com ID " + id + " não encontrado");
		}

		repository.deleteById(id);

	}

}
