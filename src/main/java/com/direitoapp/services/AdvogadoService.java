package com.direitoapp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.direitoapp.domain.Advogado;
import com.direitoapp.domain.Pessoa;
import com.direitoapp.domain.dtos.AdvogadoDTO;
import com.direitoapp.repositories.AdvogadoRepository;
import com.direitoapp.repositories.PessoaRepository;
import com.direitoapp.services.exceptions.DataIntegrityViolationException;
import com.direitoapp.services.exceptions.ObjectNotFoundException;

@Service
public class AdvogadoService {
	@Autowired private AdvogadoRepository advogadoRepository;
	@Autowired private PessoaRepository pessoaRepository;
	//@Autowired private BCryptPasswordEncoder encoder;
	
	public Advogado findById(Integer id) {
		Optional<Advogado> adv = advogadoRepository.findById(id);
		return adv.orElseThrow(() -> new ObjectNotFoundException("Advogado não encontrado id: " + id));
	}

	public List<Advogado> findAll() {
		return advogadoRepository.findAll();
	}

	public Advogado create(AdvogadoDTO advogadoDTO) {
		advogadoDTO.setId(null);
		advogadoDTO.setSenha(advogadoDTO.getSenha());
		validaAdvogadoExistente(advogadoDTO);
		advogadoDTO.setQuantidadeCasosAtendidos(0);
		
		Advogado newAdv = new Advogado(advogadoDTO);
		return advogadoRepository.save(newAdv );
	}

	public Advogado update(Integer id, AdvogadoDTO advogadoDTO) {
		advogadoDTO.setId(id);
		Advogado oldAdvogado = findById(id);
		advogadoDTO.setQuantidadeCasosAtendidos(oldAdvogado.getQuantidadeCasosAtendidos());
		validaAdvogadoExistente(advogadoDTO);
		
		oldAdvogado = new Advogado(advogadoDTO);
		
		
		return advogadoRepository.save(oldAdvogado);
	}
	
	public void delete(Integer id) {
		Advogado adv = findById(id);
		
		if(adv.getCasos().size() > 0) {
			throw  new DataIntegrityViolationException("Este advogado possui casos e não pode ser deletado!");
		}

		advogadoRepository.deleteById(id);
 		
	}
	
	private void validaAdvogadoExistente(AdvogadoDTO advogadoDTO) {
		Optional<Pessoa> pessoa = pessoaRepository.findByCelular(advogadoDTO.getCelular());
		
		if (pessoa.isPresent() && !(pessoa.get().getCelular().equals(advogadoDTO.getCelular()))) {
			throw new DataIntegrityViolationException("Celular já cadastrado");
		}
		
	}




}
