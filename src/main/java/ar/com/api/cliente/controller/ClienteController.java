package ar.com.api.cliente.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ar.com.api.cliente.entity.Cliente;
import ar.com.api.cliente.model.ClienteDTO;
import ar.com.api.cliente.service.ClienteService;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.tags.Tag;

@OpenAPIDefinition(
info = @Info(
    title="Cliente API",
    version = "1.0.0"))

@Tag(name="Cliente Api", description="Cliente Spring Doc API Rest.")

@RestController
@RequestMapping("/api")
public class ClienteController {
	
	private int totalClientes;
	float promedioEdades = 0;
	double varianza = 0.0;
	private float sumaEdad;
	
	
	@Autowired
	private ClienteService clineteService;
	
	@PostMapping("/cliente/crearcliente")
	public ResponseEntity<?> save(@RequestBody Cliente cliente){
		return new ResponseEntity<Cliente>(clineteService.save(cliente), HttpStatus.CREATED);
	}

	@GetMapping("/listclientes")
	public ResponseEntity<?> findAll(){
		List<ClienteDTO> clientesDto = new ArrayList<ClienteDTO>();
		clineteService.findAll().stream().forEach(c -> {
			ClienteDTO clienteDto = new ClienteDTO();
			clienteDto.setId(c.getId());
			clienteDto.setNombre(c.getNombre());
			clienteDto.setApellido(c.getApellido());
			clienteDto.setEdad(c.getEdad());
			clienteDto.setFecha_nacimiento(c.getFecha_nacimiento());
			clientesDto.add(clienteDto);
		});
		
		return new ResponseEntity<List<ClienteDTO>>(clientesDto, HttpStatus.OK);
	}
	
	@GetMapping("/kpideclientes")
	public ResponseEntity<?> infoClientes(){

		String PrommedioEdad = "El promedio de edad de todos lo clientes es: " + CalcularPromedio() + " y la desviacion: " + CalcularDesviacionEstandar();
		return new ResponseEntity<String>(PrommedioEdad, HttpStatus.OK);
	}
	
	private float CalcularPromedio() {
		sumaEdad = 0;
		promedioEdades = 0;
		setTotalClientes(clineteService.findAll().size());
		clineteService.findAll().stream().forEach(c -> {
			sumaEdad+= c.getEdad();
		});
		promedioEdades = sumaEdad/totalClientes;
		return promedioEdades;
	}
	
	private double CalcularDesviacionEstandar() {
		double desviacion= 0.0;
		
		clineteService.findAll().stream().forEach(c -> {
			double rangoEdad = 0.0;
			rangoEdad += Math.pow(c.getEdad() - promedioEdades, 2f);
			varianza += rangoEdad;
		});
		
		varianza = varianza / totalClientes;
		desviacion = Math.sqrt(varianza);
		
		return desviacion;
	}

	public float getSumaEdad() {
		return sumaEdad;
	}

	public void setSumaEdad(float sumaEdad) {
		this.sumaEdad = sumaEdad;
	}

	public int getTotalClientes() {
		return totalClientes;
	}

	public void setTotalClientes(int totalClientes) {
		this.totalClientes = totalClientes;
	}

}
