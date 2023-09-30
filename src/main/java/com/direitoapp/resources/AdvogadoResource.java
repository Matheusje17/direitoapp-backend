package com.direitoapp.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.direitoapp.domain.Advogado;
import com.direitoapp.domain.dtos.AdvogadoDTO;
import com.direitoapp.services.AdvogadoService;

import jakarta.validation.Valid;



@RestController
@RequestMapping(value = "/advogados")
public class AdvogadoResource {
	@Autowired
	private AdvogadoService advogadoService;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<AdvogadoDTO> findById(@PathVariable Integer id) {
		Advogado adv = advogadoService.findById(id);
		return ResponseEntity.ok().body(new AdvogadoDTO(adv));
	}
	
	@GetMapping
	public ResponseEntity<List<AdvogadoDTO>> findAll(){
		List<Advogado> advogadoList = advogadoService.findAll();
		List<AdvogadoDTO> advogadoDTOList = advogadoList.stream().map(adv -> new AdvogadoDTO(adv)).collect(Collectors.toList());
		return ResponseEntity.ok(advogadoDTOList);
	}
	
	@PostMapping
	public ResponseEntity<AdvogadoDTO> create(@Valid @RequestBody AdvogadoDTO advogadoDTO) {
		Advogado newAdv = advogadoService.create(advogadoDTO);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newAdv.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<AdvogadoDTO> update(@PathVariable Integer id, @RequestBody AdvogadoDTO advogadoDTO) {
		Advogado advogado = advogadoService.update(id,advogadoDTO);
		return ResponseEntity.ok().body(new AdvogadoDTO(advogado));
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<AdvogadoDTO> delete(@PathVariable Integer id) {
		advogadoService.delete(id);
		return ResponseEntity.noContent().build();
	}
}
