package com.direitoapp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.direitoapp.domain.Cliente;
import com.direitoapp.domain.Pessoa;
import com.direitoapp.domain.dtos.ClienteDTO;
import com.direitoapp.repositories.ClienteRepository;
import com.direitoapp.repositories.PessoaRepository;
import com.direitoapp.services.exceptions.DataIntegrityViolationException;
import com.direitoapp.services.exceptions.ObjectNotFoundException;

@Service
public class ClienteService {
	@Autowired private ClienteRepository ClienteRepository;
	@Autowired private PessoaRepository pessoaRepository;
//	@Autowired private BCryptPasswordEncoder encoder;
	
	public Cliente findById(Integer id) {
		Optional<Cliente> cli = ClienteRepository.findById(id);
		return cli.orElseThrow(() -> new ObjectNotFoundException("Cliente não encontrado id: " + id));
	}

	public List<Cliente> findAll() {
		return ClienteRepository.findAll();
	}

	public Cliente create(ClienteDTO clienteDTO) {
		clienteDTO.setId(null);
		clienteDTO.setSenha(clienteDTO.getSenha());
		validaClienteExistente(clienteDTO);
		Cliente newCli= new Cliente(clienteDTO);
		return ClienteRepository.save(newCli );
	}

	public Cliente update(Integer id, ClienteDTO ClienteDTO) {
		ClienteDTO.setId(id);
		Cliente oldCliente = findById(id);
		
		validaClienteExistente(ClienteDTO);
		oldCliente = new Cliente(ClienteDTO);
		
		return ClienteRepository.save(oldCliente);
	}
	
	public void delete(Integer id) {
		Cliente cli = findById(id);
		
		if(cli.getCasos().size() > 0) {
			throw  new DataIntegrityViolationException("Este Cliente possui casos e não pode ser deletado!");
		}

		ClienteRepository.deleteById(id);
 		
	}
	
	private void validaClienteExistente(ClienteDTO ClienteDTO) {
		Optional<Pessoa> pessoa = pessoaRepository.findByCelular(ClienteDTO.getCelular());
		
		if (pessoa.isPresent() && !(pessoa.get().getCelular().equals(ClienteDTO.getCelular())) ) {
			throw new DataIntegrityViolationException("Celular já cadastrado");
		}
	}

}
