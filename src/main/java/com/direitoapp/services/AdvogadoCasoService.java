package com.direitoapp.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.direitoapp.domain.Advogado;
import com.direitoapp.domain.AdvogadoCaso;
import com.direitoapp.domain.Caso;
import com.direitoapp.domain.Cliente;
import com.direitoapp.domain.dtos.AdvogadoCasoDTO;
import com.direitoapp.domain.dtos.AdvogadoCasoRequest;
import com.direitoapp.domain.dtos.AdvogadoDTO;
import com.direitoapp.domain.enums.Status;
import com.direitoapp.repositories.AdvogadoCasoRepository;
import com.direitoapp.services.exceptions.ObjectNotFoundException;

@Service
public class AdvogadoCasoService {

	@Autowired
	private AdvogadoCasoRepository advogadoCasoRepository; 
	
	@Autowired
	private CasoService casoService; 
	
	@Autowired
	private AdvogadoService advogadoService;
	
	@Autowired
	private ClienteService clienteService;
	
	public List<AdvogadoCaso> findByCaso(Integer id) {
		
		List<AdvogadoCaso> result = new ArrayList<AdvogadoCaso>();
		
		Caso caso = casoService.findById(id);
		Optional<List<AdvogadoCaso>> advogadosCaso = advogadoCasoRepository.findByCaso(caso);
		
		result.addAll(advogadosCaso.get());
		
		return result;
	}
	
	public List<AdvogadoCaso> findByAdvogado(Integer id) {
		
		List<AdvogadoCaso> result = new ArrayList<AdvogadoCaso>();
		
		Advogado advogado = advogadoService.findById(id);
		Optional<List<AdvogadoCaso>> advogadosCaso = advogadoCasoRepository.findByAdvogadoAtendimento(advogado);
		
		result.addAll(advogadosCaso.get());
		
		return result;
	}

	public void create(AdvogadoCasoRequest request) {
		Caso caso = casoService.findById(request.getCasoId());
		Advogado advogado = advogadoService.findById(request.getAdvogadoId());
		Cliente cliente = clienteService.findById(request.getClienteId());
		AdvogadoCaso advogadoCaso = new AdvogadoCaso(caso, advogado, cliente);
		advogadoCasoRepository.save(advogadoCaso);
		
	}

	public AdvogadoCaso findById(Integer id) {
		Optional<AdvogadoCaso> advCaso = advogadoCasoRepository.findById(id);
		return advCaso.orElseThrow(() -> new ObjectNotFoundException("Não encontrado id: " + id));
	}

	public AdvogadoCasoDTO aceitarAdvogado(Integer id) {
		AdvogadoCaso advCaso = findById(id);
		advCaso.setStatus(Status.ACEITO.getCodigo());
		Advogado adv = advCaso.getAdvogado();
		adv.setQuantidadeCasosAtendidos(adv.getQuantidadeCasosAtendidos() + 1);
		
		advogadoCasoRepository.save(advCaso);
		AdvogadoCasoDTO advCasoDTO = new AdvogadoCasoDTO(advCaso);
		advogadoService.update(adv.getId(), new AdvogadoDTO(adv));
		
		return advCasoDTO;
		
	}
	
}
