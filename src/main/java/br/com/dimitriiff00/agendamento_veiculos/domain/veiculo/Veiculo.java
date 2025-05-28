package br.com.dimitriiff00.agendamento_veiculos.domain.veiculo;

import br.com.dimitriiff00.agendamento_veiculos.domain.veiculo.dto.CreateVeiculoDTO;
import br.com.dimitriiff00.agendamento_veiculos.domain.veiculo.dto.UpdateVeiculoDTO;
import jakarta.persistence.*;

@Table(name="veiculo")
@Entity(name="veiculo")
public class Veiculo {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String veiculo;
    private String modelo;
    private String placa;
    private int ano;

    
    public Veiculo(Long id, String veiculo, String modelo, String placa, int ano) {
		super();
		this.veiculo = veiculo;
		this.modelo = modelo;
		this.placa = placa;
		this.ano = ano;
	}
    
    public Veiculo(String veiculo, String modelo, String placa, int ano) {
        this.veiculo = veiculo;
        this.modelo = modelo;
        this.placa = placa;
        this.ano = ano;
    }

	public Veiculo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public static Veiculo fromCreateDTO(CreateVeiculoDTO dto) {
		return new Veiculo(dto.veiculo(), dto.modelo(), dto.placa(), dto.ano());
	}
	
	public static Veiculo fromUpdateDTO(UpdateVeiculoDTO dto) {
		Veiculo newVeiculo = new  Veiculo(dto.veiculo(), dto.modelo(), dto.placa(), dto.ano());
		newVeiculo.setId(dto.id());
		return newVeiculo;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(String veiculo) {
		this.veiculo = veiculo;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	@Override
	public String toString() {
		return "Veiculo [id=" + id + ", veiculo=" + veiculo + ", modelo=" + modelo + ", placa=" + placa + ", ano=" + ano
				+ "]";
	}

    


}
