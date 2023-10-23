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

import com.direitoapp.domain.Cliente;
import com.direitoapp.domain.dtos.ClienteDTO;
import com.direitoapp.services.ClienteService;

import jakarta.validation.Valid;



@RestController
@RequestMapping(value = "/clientes" ,produces = "application/json;charset=UTF-8")
public class ClienteResource {
	
	@Autowired
	private ClienteService ClienteService;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<ClienteDTO> findById(@PathVariable Integer id) {
		Cliente cli = ClienteService.findById(id);
		return ResponseEntity.ok().body(new ClienteDTO(cli));
	}
	
	@GetMapping
	public ResponseEntity<List<ClienteDTO>> findAll(){
		List<Cliente> ClienteList = ClienteService.findAll();
		List<ClienteDTO> ClienteDTOList = ClienteList.stream().map(cli -> new ClienteDTO(cli)).collect(Collectors.toList());
		return ResponseEntity.ok(ClienteDTOList);
	}
	
	@PostMapping
	public ResponseEntity<ClienteDTO> create(@Valid @RequestBody ClienteDTO clienteDTO) {
		Cliente newcli = ClienteService.create(clienteDTO);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newcli.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<ClienteDTO> update(@PathVariable Integer id, @RequestBody ClienteDTO ClienteDTO) {
		Cliente Cliente = ClienteService.update(id,ClienteDTO);
		return ResponseEntity.ok().body(new ClienteDTO(Cliente));
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<ClienteDTO> delete(@PathVariable Integer id) {
		ClienteService.delete(id);
		return ResponseEntity.noContent().build();
	}
}
