package com.direitoapp.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.direitoapp.domain.AdvogadoCaso;
import com.direitoapp.domain.dtos.AdvogadoCasoDTO;
import com.direitoapp.domain.dtos.AdvogadoCasoRequest;
import com.direitoapp.services.AdvogadoCasoService;

@RestController
@RequestMapping(value = "/advogadocasos" )

public class AdvogadoCasoResource {

	@Autowired
	private AdvogadoCasoService advogadoCasoService;
	
	@GetMapping(value = "caso/{idCaso}")
	public ResponseEntity<List<AdvogadoCasoDTO>> findByCaso(@PathVariable Integer idCaso) {
		List<AdvogadoCaso> advogadoCasos = advogadoCasoService.findByCaso(idCaso);
		List<AdvogadoCasoDTO> advogadoCasosDTO = advogadoCasos.stream().map(ac -> new AdvogadoCasoDTO(ac)).collect(Collectors.toList());
		return ResponseEntity.ok().body(advogadoCasosDTO);
	}
	
	@GetMapping(value = "advogado/{idAdvogado}")
	public ResponseEntity<List<AdvogadoCasoDTO>> findByAdvogado(@PathVariable Integer idAdvogado) {
		List<AdvogadoCaso> advogadoCasos = advogadoCasoService.findByAdvogado(idAdvogado);
		List<AdvogadoCasoDTO> advogadoCasosDTO = advogadoCasos.stream().map(ac -> new AdvogadoCasoDTO(ac)).collect(Collectors.toList());
		return ResponseEntity.ok().body(advogadoCasosDTO);
	}
	
	@PostMapping
	public ResponseEntity<AdvogadoCasoDTO> create(@RequestBody AdvogadoCasoRequest request) {
		advogadoCasoService.create(request);
		//URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand().toUri();
		return ResponseEntity.ok().body(null);
	}
	
	@GetMapping(value = "aceitaradvogado/{id}")
	public ResponseEntity<AdvogadoCasoDTO> aceitarAdvogado(@PathVariable Integer id) {
		AdvogadoCasoDTO advCasoDTO =  advogadoCasoService.aceitarAdvogado(id);
		
		return ResponseEntity.ok().body(advCasoDTO);
	}
	
	@GetMapping(value = "recusar/{id}")
	public ResponseEntity<AdvogadoCasoDTO> recusarAdvogado(@PathVariable Integer id) {
		AdvogadoCasoDTO advCasoDTO =  advogadoCasoService.recusarAdvogado(id);
		
		return ResponseEntity.ok().body(advCasoDTO);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<AdvogadoCasoDTO> delete(@PathVariable Integer id) {
		advogadoCasoService.delete(id);
		return ResponseEntity.noContent().build();
	}

	
}



