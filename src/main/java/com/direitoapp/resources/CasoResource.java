package com.direitoapp.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.direitoapp.domain.Caso;
import com.direitoapp.domain.dtos.CasoDTO;
import com.direitoapp.services.CasoService;

import jakarta.validation.Valid;



@RestController
@RequestMapping(value = "/casos", produces = "application/json;charset=UTF-8")
public class CasoResource {
	
	@Autowired
	private CasoService casoService;
		
	@GetMapping(value = "/{id}")
	public ResponseEntity<CasoDTO> findById(@PathVariable Integer id) {
		Caso caso = casoService.findById(id);
		return ResponseEntity.ok().body(new CasoDTO(caso));
	}
	
	@GetMapping
	public ResponseEntity<List<CasoDTO>> findAll() {
		List<Caso> casos = casoService.findAll();
		List<CasoDTO> casosDTO =  casos.stream().map(caso -> new CasoDTO(caso)).collect(Collectors.toList());
		return ResponseEntity.ok().body(casosDTO);
	}
	
	@PostMapping
	public ResponseEntity<CasoDTO> create(@Valid @RequestBody CasoDTO casoDTO) {
		Caso caso = casoService.create(casoDTO);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(caso.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<CasoDTO> update(@PathVariable Integer id,  @Valid @RequestBody CasoDTO casoDTO) {
		Caso caso = casoService.update(id, casoDTO);
		return ResponseEntity.ok().body(new CasoDTO(caso));
	}
	
	@GetMapping(value = "/{tipoCaso}/{estado}/{cidade}")
	public ResponseEntity<List<CasoDTO>> findByTipoERegiao(@PathVariable String tipoCaso, @PathVariable String estado, @PathVariable String cidade) {
		List<Caso> casos = casoService.findByTipoERegiao(tipoCaso, estado, cidade);
		List<CasoDTO> casosDTO =  casos.stream().map(caso -> new CasoDTO(caso)).collect(Collectors.toList());
		return ResponseEntity.ok().body(casosDTO);
	}
	
	@GetMapping(value = "cliente/{idCliente}")
	public ResponseEntity<List<CasoDTO>> findByCliente(@PathVariable Integer idCliente) {		
		List<Caso> casos = casoService.findByCliente(idCliente);
		List<CasoDTO> casosDTO =  casos.stream().map(caso -> new CasoDTO(caso)).collect(Collectors.toList());
		return ResponseEntity.ok().body(casosDTO);
	}
	
	
	
}
